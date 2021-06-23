package com.anieves.market.persistence.entity;

import javax.persistence.*;

/*
    la anotación @Entity le dara entender a Java, de que esta clase se comportara como una clase que mapea
    una tabla de la base de datos

    Como la clase se llama diferente a como se llama la tabla que estamos mapeando, añadimos la anotación @Table importado de javax.persistence

 */
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    /*
    Si la columna se llama diferente en la base de datos usamos la anotación @Column
    colocamos @Id porque el idProducto es la clave primaria de nuestra tabla productos
    como esta clave primaria se va a generar automaticamente cuando creemos un nuevo producto le añadimos la anotacion @GeneratedValue
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto; //es importante usar Integer y no int

    //aqui mi variable se llama igual que la columna en la entidad producto, la dejamos tal cual sin anotaciones
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /*
        Mapeando las relaciones entre los Entity
        Pruducto esta relacionado con Categoria
        insertable y update igual a false es para a travez de esta relacion no poder borrar, actualizar,insertar
        una nueva Categoria.
        Esto simplemente nos servira para recuperar a que Categoria pertenece un Producto
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
