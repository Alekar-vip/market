package com.anieves.market.web.controller;

import com.anieves.market.domain.Product;
import com.anieves.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //recuperar un prooducto dado su Id
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    //este como es para guardar usamos @PostMapping
    //como product no viaja sino que hace parte del cuerpo de la peticion le añadimos la anotacion @RequestBody
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
