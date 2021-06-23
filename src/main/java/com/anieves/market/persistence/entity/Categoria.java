package com.anieves.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    /*
        Para cerrar la relacion entre Producto y Categoria, Creamos un atributo que corresponde a una Lista
        List<Producto> y le asignamos un nombre, queda asi: List<Producto> productos;
        Colocamos el tipo de relación en este caso @OneToMany, le añadimos un parametro el cual es @mappedBy
        mapeado por el atributo categoria creado en clase Producto
     */
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
