package com.anieves.market.persistence;

import com.anieves.market.domain.Product;
import com.anieves.market.domain.repository.ProductRepository;
import com.anieves.market.persistence.crud.ProductoCrudRepository;
import com.anieves.market.persistence.entity.Producto;
import com.anieves.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Como esta es una clase que esta interactuando directamente con la base de datos, la decoramos con @Repository
@Repository
public class ProductoRepository implements ProductRepository {
    // Dentro de esta clase puedo colocar apenas un atributo privado que sea de tipo:
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    /*Convetir Producto a Product*/
    @Autowired
    private ProductMapper mapper;

    /*
        Creando un Metodo que recupere una lista de productos, todos los productos que tenemos en la BD
     */
    @Override //como este metodo lo estamos usando de la interfaz le ponemos el override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    /*
        Metodo que retorna una lista de productos de una categoria en especifico
     */
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    /*
    No tengo ningun mapeador que me convierta una lista de opcionales,
    entonces a los productos le hacemos un map, con esto mapeamos todos los productos
     */
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> (mapper.toProduct(producto)));
    }

    @Override
    public Product save(Product product) {
        //como el save espera un producto hacemos la conversion inversa
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    /*
        Eliminar un producto
     */
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

    /*
        Metodo que retorna una lista de productos de una categoria en especifico

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }


    /*
        Metodo que retorna los productos escasos, el estado se lo colocamos true por default porque quise xD
        sino tambien podriamos pasar el estado como parametro y preguntalo al user

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLeesThanAndEstado(cantidad, true);
    }

    /*
        Consultar un producto en particular
        Para este caso no tenemos que crear un query methos, usamos un metodo ya de CrudRepository

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    /*
        Guardar un producto

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    */

}
