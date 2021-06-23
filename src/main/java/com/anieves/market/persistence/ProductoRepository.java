package com.anieves.market.persistence;

import com.anieves.market.persistence.crud.ProductoCrudRepository;
import com.anieves.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Como esta es una clase que esta interactuando directamente con la base de datos, la decoramos con @Repository
@Repository
public class ProductoRepository {
    // Dentro de esta clase puedo colocar apenas un atributo privado que sea de tipo:
    private ProductoCrudRepository productoCrudRepository;

    /*
        Creando un Metodo que recupere una lista de productos, todos los productos que tenemos en la BD
     */
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    /*
        Metodo que retorna una lista de productos de una caegoria en especifico
     */
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    /*
        Metodo que retorna los productos escasos, el estado se lo colocamos true por default porque quise xD
        sino tambien podriamos pasar el estado como parametro y preguntalo al user
     */
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLeesThanAndEstado(cantidad, true);
    }

    /*
        Consultar un producto en particular
        Para este caso no tenemos que crear un query methos, usamos un metodo ya de CrudRepository
     */
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    /*
        Guardar un producto
     */
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    /*
        Eliminar un producto
     */
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
