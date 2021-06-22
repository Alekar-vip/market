package com.anieves.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
    para esta clase usamos la anotación @Embeddable, ya que esta clase luego la vamos a embeder dentro de
    nuestra clase ComprasProducto.
    Implementamos tambien una interfaz de java la cual es @Serializable
 */
@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
