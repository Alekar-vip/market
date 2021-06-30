package com.anieves.market.web.controller;

import com.anieves.market.domain.Product;
import com.anieves.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAll(){
        //creamos una nueva instancia de ResponseEntity
        //HttpStatus.OK) significa que respondio de manera de adecuada cuando fue llamado
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //recuperar un prooducto dado su Id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        //getProduct() responde a un Optional, podemos utilizar operador map
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //este como es para guardar usamos @PostMapping
    //como product no viaja sino que hace parte del cuerpo de la peticion le añadimos la anotacion @RequestBody
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
