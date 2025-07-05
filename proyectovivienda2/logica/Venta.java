/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Santiago
 */
@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "VENTA_SEQ", allocationSize = 1)
    private int id;
    
    @Column(nullable = false)
    private String precioTotal;
    
    @Column(nullable = false)
    private int cuotas;
    
    @Column(nullable = false)
    private double interes;
    
    @Column(nullable = false, unique = true)
    private String matricula;
    
    @Column(nullable = false)
    private String vendedor;
    
    @Column(nullable = false)    
    private Date fechaEscritura;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "inmueble_id", nullable = true, unique = true)
    private Inmueble inmueble;
    
    @ManyToOne
    @JoinColumn(name = "asesor_id", nullable = true)
    private Usuario asesor;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos = new ArrayList<>();

    public Venta() {
    }

    public Venta(int id, String precioTotal, int cuotas, double interes, String matricula, String vendedor, Date fechaEscritura, Cliente cliente, Inmueble inmueble, Usuario asesor, List<Pago> pagos) {
        this.id = id;
        this.precioTotal = precioTotal;
        this.cuotas = cuotas;
        this.interes = interes;
        this.matricula = matricula;
        this.vendedor = vendedor;
        this.fechaEscritura = fechaEscritura;
        this.cliente = cliente;
        this.inmueble = inmueble;
        this.asesor = asesor;
        this.pagos = pagos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFechaEscritura() {
        return fechaEscritura;
    }

    public void setFechaEscritura(Date fechaEscritura) {
        this.fechaEscritura = fechaEscritura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Usuario getAsesor() {
        return asesor;
    }

    public void setAsesor(Usuario asesor) {
        this.asesor = asesor;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
   
    
}
