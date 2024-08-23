package ru.pizza.maker_menu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import ru.pizza.maker_menu.models.ImageProduct;
import ru.pizza.maker_menu.entities.Ingredient;
import ru.pizza.maker_menu.models.Product;
import ru.pizza.maker_menu.entities.ProductType;
import ru.pizza.maker_menu.services.IngredientService;
import ru.pizza.maker_menu.services.ProductService;
import ru.pizza.maker_menu.services.ProductTypeService;

import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("createProduct")
@RequestMapping("/maker")
public class MenuController {
    private final ProductService productService;
    private final IngredientService ingredientService;
    private final RestTemplate restTemplate;
    private final ProductTypeService productTypeService;
    private Product product;

    @Autowired
    public MenuController(ProductService productService, IngredientService ingredientService, RestTemplate restTemplate, ProductTypeService productTypeService) {
        this.productService = productService;
        this.ingredientService = ingredientService;
        this.restTemplate = restTemplate;
        this.productTypeService = productTypeService;
    }

    @ModelAttribute(name = "createProduct")
    public Product product() {
        return new Product();
    }

    @ModelAttribute(name = "newIngredient")
    public Ingredient ingredient() {
        return new Ingredient();
    }

    @ModelAttribute(name = "ingredientList")
    public List<Ingredient> ingredientList() {
        return ingredientService.index();
    }

    @ModelAttribute(name = "productTypeList")
    public List<ProductType> productType() {
        return productTypeService.index();
    }

    @PostMapping("/ingredient/save")
    public String save(@ModelAttribute Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/maker";
    }

    @DeleteMapping("/ingredient/{id}/delete")
    public String delete(@PathVariable int id) {
        ingredientService.delete(id);
        return "redirect:/maker";
    }

    @PostMapping
    public String add(Ingredient ingredient, @ModelAttribute("createProduct") Product product) {
        product.addIngredient(ingredient);
        return "redirect:/maker";
    }

    @PostMapping("/create")
    public String createProduct(SessionStatus sessionStatus,
                                @ModelAttribute("createProduct") Product product) {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("content-type", "application/json");
        HttpEntity<Product> entity = new HttpEntity<>(product, header);
        restTemplate.exchange("http://localhost:8082/products",
                HttpMethod.POST, entity, Product.class);
        sessionStatus.setComplete();
        return "redirect:/maker";
    }

    @PostMapping("/create/addFile")
    public String addFile(@RequestParam("file") MultipartFile file, @ModelAttribute("createProduct") Product product) {
        try {
            product.setImageProduct(new ImageProduct(file.getContentType(), file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/maker";
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("productsList", productService.getProducts());
        return "index";
    }
}