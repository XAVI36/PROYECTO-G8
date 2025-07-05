/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Santiago
 */
@Entity
public class Inmueble implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inmueble_seq")
    @SequenceGenerator(name = "inmueble_seq", sequenceName = "INMUEBLE_SEQ", allocationSize = 1)
    private int id;
    
    @Column(nullable = false)
    private String valor;
    
    @Column(nullable = false)
    private String tipoUnidad;
    
    @Column(nullable = false)
    private String area;
    
    @ManyToOne
    @JoinColumn(name = "torre_id", nullable = true)
    private Torre torre;
    
    @OneToOne(mappedBy = "inmueble", cascade = CascadeType.ALL, orphanRemoval = true)
    private Venta ventas;
     
    public Inmueble() {
    }

    public Inmueble(int id, String valor, String tipoUnidad, String area, Torre torre, Venta ventas) {
        this.id = id;
        this.valor = valor;
        this.tipoUnidad = tipoUnidad;
        this.area = area;
        this.torre = torre;
        this.ventas = ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Torre getTorre() {
        return torre;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    public Venta getVentas() {
        return ventas;
    }

    public void setVentas(Venta ventas) {
        this.ventas = ventas;
    }

    
    
    
    
}
