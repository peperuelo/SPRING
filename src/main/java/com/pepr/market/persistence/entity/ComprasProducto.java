package com.pepr.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="compras_producto")

public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_compra", insertable=false, updatable=false )
    private Compra compra;

    @ManyToOne
    @JoinColumn(name="id_producto", insertable=false, updatable=false )
    private Producto producto;


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
