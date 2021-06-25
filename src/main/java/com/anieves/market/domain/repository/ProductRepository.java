package com.anieves.market.domain.repository;

import com.anieves.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //retorna una lista de productos
    List<Product> getAll();

    //retorna un optional, lista de productos por categoria
    Optional<List<Product>> getByCategory(int categoryId);

    //retorna un optional, lista de productos escasos
    Optional<List<Product>> getScarseProducts(int quantity);

    //retornar un optional, un product en particular
    Optional<Product> getProduct(int productId);

    //guardar un product
    Product save(Product product);

    //delete un product
    void delete (int productId);
}
