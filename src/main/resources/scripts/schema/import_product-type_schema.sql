create table if not exists product_type
(
    id   int generated by default as identity not null,
    type varchar not null,
    primary key (id)
);