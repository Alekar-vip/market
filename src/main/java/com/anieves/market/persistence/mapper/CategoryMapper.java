package com.anieves.market.persistence.mapper;

import com.anieves.market.domain.Category;
import com.anieves.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//utilizamos la anotación @Mapper para indicarle al proyecto de que es un mapeador
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //hacer el map, traducir los objetos, usamos la anotacion @Mappings()
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })

    /*
     * Vamos a convertir una Categoria en Category
     */
    Category toCategory(Categoria categoria);


    /*
    * Dado el caso donde querramos hacer la conversion externa
    * La anotacion @InheritInverseConfiguration le indica a MapStruct que la conversion que estamos realizando
    * es la inversa a la inversa de la que estamos haciendo arriba linea 14 a 25, entonces ya no tenemos que definir
    * de nuevo @Mappings
    *
    * Si nos fijamos dentro de Categoria tenemos una variable llamada productos, y dentro de Category no tenemos
    * esa variable productos, esto es algo que tenemos que tener en cuenta, como no lo vamos a mapear los vamos a
    * ignorar se lo decimos con @Mapping
     */
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
