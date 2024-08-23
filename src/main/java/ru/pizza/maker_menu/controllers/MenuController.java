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
import ru.pizza.maker_menu.entities.IngredientEntity;
import ru.pizza.maker_menu.models.ImageModel;
import ru.pizza.maker_menu.models.ProductModel;
import ru.pizza.maker_menu.entities.ProductTypeEntity;
import ru.pizza.maker_menu.services.IngredientService;
import ru.pizza.maker_menu.services.RestService;
import ru.pizza.maker_menu.services.ProductTypeService;

import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("createProduct")
@RequestMapping("/maker")
public class MenuController {
    private final RestService restService;
    private final IngredientService ingredientService;
    private final RestTemplate restTemplate;
    private final ProductTypeService productTypeService;

    @Autowired
    public MenuController(RestService restService, IngredientService ingredientService, RestTemplate restTemplate, ProductTypeService productTypeService) {
        this.restService = restService;
        this.ingredientService = ingredientService;
        this.restTemplate = restTemplate;
        this.productTypeService = productTypeService;
    }

    @ModelAttribute(name = "createProduct")
    public ProductModel product() {
        return new ProductModel();
    }

    @ModelAttribute(name = "newIngredient")
    public IngredientEntity ingredient() {
        return new IngredientEntity();
    }

    @ModelAttribute(name = "ingredientList")
    public List<IngredientEntity> ingredientList() {
        return ingredientService.index();
    }

    @ModelAttribute(name = "productTypeList")
    public List<ProductTypeEntity> productType() {
        return productTypeService.index();
    }

    @PostMapping("/ingredient/save")
    public String save(@ModelAttribute IngredientEntity ingredientEntity) {
        ingredientService.save(ingredientEntity);
        return "redirect:/maker";
    }

    @DeleteMapping("/ingredient/{id}/delete")
    public String delete(@PathVariable int id) {
        ingredientService.delete(id);
        return "redirect:/maker";
    }

    @PostMapping
    public String add(IngredientEntity ingredientEntity, @ModelAttribute("createProduct") ProductModel productModel) {
        productModel.addIngredient(ingredientEntity);
        return "redirect:/maker";
    }

    @PostMapping("/create")
    public String createProduct(SessionStatus sessionStatus,
                                @ModelAttribute("createProduct") ProductModel productModel) {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("content-type", "application/json");
        HttpEntity<ProductModel> entity = new HttpEntity<>(productModel, header);
        restTemplate.exchange("http://localhost:8082/products",
                HttpMethod.POST, entity, ProductModel.class);
        sessionStatus.setComplete();
        return "redirect:/maker";
    }

    @PostMapping("/create/addFile")
    public String addFile(@RequestParam("file") MultipartFile file, @ModelAttribute("createProduct") ProductModel productModel) {
        try {
            productModel.setImageModel(new ImageModel(file.getContentType(), file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/maker";
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("productsList", restService.getProducts());
        return "index";
    }
}