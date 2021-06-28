package com.anieves.market.persistence.crud;

import com.anieves.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*
        Para trabajar con Query Methods dentro de nuestra aplicación creamos los metodos en esta interfaz
     */


    //Recuperar toda la lista de producto que pertenezcan a una categoria y ordenar los nombres de manera ASC

    /* usando la forma nativa de SQL - usamos la anotación @Query y decimos que es un query nativo - nativeQuery = true
    @Query(value = "SELECT * FROM PRODUCTOS WHERE id_categoria = ?", nativeQuery = true) */

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // de esta manera vamos a obtener una lista de productos que pertenecen a una categoria y ordenamos de manera ASC
    // Este metodo lo invocamos en CrudRepository



    //Recuperar los productos escasos, usamos el atributo cantidad stock, que el estado del producto sea activo
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
