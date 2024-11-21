/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.logica;




import com.mycompany.proyectovivienda2.persistencia.ControladorPersistencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class Controlador {
    
    ControladorPersistencia controlPersis = new ControladorPersistencia();
    private Proyecto proyecto;
    private Torre torre;
    private Cliente cliente;
    private Inmueble inmueble;
    private Venta venta;
    
    

    public void registrarProyecto(String nombre, String descripcion) {
        
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        controlPersis.registrarProyecto(proyecto);
    }

    public void registrarTorre(String nombre, int numeroPisos) {
       
        Torre torre = new Torre();
        torre.setNombre(nombre);
        torre.setNumPisos(numeroPisos);
        torre.setProyecto(proyecto);// Relación con Proyecto
        controlPersis.registrarTorre(torre);
        
    }

    public void registrarInmueble(String valor, String tipoUnidad, String area) {
        
        Inmueble inmueble = new Inmueble();
        inmueble.setTipoUnidad(tipoUnidad);
        inmueble.setValor(valor);
        inmueble.setArea(area);
        inmueble.setTorre(torre); // Relación con Torre
        controlPersis.registrarInmueble(inmueble);
        
    }
    
    public void registrarVenta(String precioTotal, int cuotas, double intereses, String matricula, String vendedor, Date fechaEscritura) {
        
        Venta venta = new Venta();
        venta.setPrecioTotal(precioTotal);
        venta.setCuotas(cuotas);
        venta.setInteres(intereses);
        venta.setMatricula(matricula);
        venta.setVendedor(vendedor);
        venta.setFechaEscritura(fechaEscritura);
        venta.setCliente(cliente); // Relación con Cliente
        venta.setInmueble(inmueble); // Relación con Inmueble
        controlPersis.registrarVenta(venta);
    }

    public void registrarPago(String valor, Date fechaPago) {
        Pago pago = new Pago();
        pago.setValor(valor);
        pago.setFecha(fechaPago);
        pago.setVenta(venta);
        controlPersis.registrarPago(pago);
    }

    public void registrarCliente(String cedula, String nombre, String sisben, String subsidioMinisterio, String direccion, String telefono) {
        Cliente cliente = new Cliente();
        cliente.setCedula(cedula);
        cliente.setNombre(nombre);
        cliente.setSisben(sisben);
        cliente.setDireccion(direccion);
        cliente.setSubsidioMinisterio(subsidioMinisterio);
        cliente.setTelefono(telefono);
        controlPersis.registrarCliente(cliente);
    }

    public List<Inmueble> traerInmuebles() {
        
        return controlPersis.traerInmueble();
    }

    public List<Cliente> traerClientes(int id) {
        return controlPersis.traerCliente();
    }

    public List<Proyecto> traerProyectos() {
        return controlPersis.traerProyecto();
    }

    public List<Torre> listaTorres() {
        return controlPersis.traerTorre();
    }

    public List<Pago> listaPagos() {
        return controlPersis.traerPago();
    }

    public List<Venta> listaVentas() {
        return controlPersis.traerVenta();
    }

    public void eliminarProyecto(int id) {
        controlPersis.eliminarProyecto(id);
    }

    public void eliminarTorre(int id) {
        controlPersis.eliminarTorre(id);
    }

    public void eliminarInmueble(int id) {
        controlPersis.eliminarInmueble(id);
    }

    public void eliminarVenta(int id) {
        controlPersis.eliminarVenta(id);
    }

    public void eliminarPago(int id) {
        controlPersis.eliminarPago(id);
    }

    public void eliminarCliente(int id) {
        controlPersis.eliminarCliente(id);
    }

    public Torre traerTorre(int id) {
        return controlPersis.traerTorre(id);
    }

    public void modificarTorre(Torre tor, String nombre, String numeroPisosTexto) {
        tor.setNombre(nombre);
        tor.setNumPisos(0);
        
        controlPersis.modificarTorre(tor);
    }

    public List<Cliente> traerCliente() {
        return controlPersis.traerCliente();
    }

    public Proyecto traerProyec(int id) {
        controlPersis.traerproyect(id);
        return null;
    }

    public Inmueble traeInmuebles(int id) {
        controlPersis.traerInmueble(id);
        return null;
    }




}
