package com.cerveceria.cerveceria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CERVECERIA")
public class Cerveceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "Nomenclatura")
    private String nomenclatura;

    @Column(name = "Marca de Cerveza")
    private String marca_cerveza;

    @Column(name = "Cantidad en stock")
    private Integer stock;

    public Cerveceria(){}

    public Cerveceria(String nombre, String departamento, String municipio, String nomenclatura,
            String marca_cerveza, Integer stock) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipio = municipio;
        this.nomenclatura = nomenclatura;
        this.marca_cerveza = marca_cerveza;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getMarca_cerveza() {
        return marca_cerveza;
    }

    public void setMarca_cerveza(String marca_cerveza) {
        this.marca_cerveza = marca_cerveza;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "cerveceria [id=" + id + ", name=" + nombre + ", departamento=" + departamento + ", municipio=" + municipio
                + ", nomenclatura=" + nomenclatura + ", marca_cerveza=" + marca_cerveza + ", stock=" + stock + "]";
    }
}
