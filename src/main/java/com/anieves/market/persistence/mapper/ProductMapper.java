package com.anieves.market.persistence.mapper;

import com.anieves.market.domain.Product;
import com.anieves.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })

    Product toProduct(Producto producto);

    /*
    * Recibe una lista de Product, y le dimos de nombre toProducts
     */
    List<Product> toProducts(List<Producto> productos);


    /*Haciendo la conversion contraria*/
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarra", ignore = true)
    Producto toProducto(Product product);
}
