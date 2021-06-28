package com.anieves.market.web.controller;

import com.anieves.market.domain.Product;
import com.anieves.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    //inyectamos el servicio
    @Autowired
    private ProductService productService;

    //este servicio se encarga de obtener toda la lista de productos dentro del supermarket
    //usamos @GetMapping porque estamos obteniendo informacion
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(int productId){
        return productService.delete(productId);
    }
}
