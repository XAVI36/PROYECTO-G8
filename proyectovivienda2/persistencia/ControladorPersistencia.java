/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.persistencia;

import com.mycompany.proyectovivienda2.logica.Cliente;
import com.mycompany.proyectovivienda2.logica.Inmueble;
import com.mycompany.proyectovivienda2.logica.Pago;
import com.mycompany.proyectovivienda2.logica.Proyecto;
import com.mycompany.proyectovivienda2.logica.Torre;
import com.mycompany.proyectovivienda2.logica.Venta;
import com.mycompany.proyectovivienda2.persistencia.exceptions.IllegalOrphanException;
import com.mycompany.proyectovivienda2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Santiago
 */
public class ControladorPersistencia {
    
    ProyectoJpaController proJpa = new ProyectoJpaController();
    TorreJpaController torJpa = new TorreJpaController();
    InmuebleJpaController inmJpa = new InmuebleJpaController();
    VentaJpaController venJpa = new VentaJpaController();
    PagoJpaController pagJpa = new PagoJpaController();
    ClienteJpaController cliJpa = new ClienteJpaController();

    public void registrarProyecto(Proyecto proyecto) {
        proJpa.create(proyecto);
    }

    public void registrarTorre(Torre torre) {
        torJpa.create(torre);
    }

    public void registrarInmueble(Inmueble inmueble) {
        inmJpa.create(inmueble);
    }

    public void registrarVenta(Venta venta) {
        try {
            venJpa.create(venta);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public void registrarPago(Pago pago) {
        pagJpa.create(pago);
    }

    public void registrarCliente(Cliente cliente) {
        cliJpa.create(cliente);
    }

    public List<Inmueble> traerInmueble() {
        return inmJpa.findInmuebleEntities();
    }

    public List<Cliente> traerCliente() {
        return cliJpa.findClienteEntities();
    }

    public List<Proyecto> traerProyecto(int id) {
        return proJpa.findProyectoEntities();
    }

    public List<Torre> traerTorre() {
        return torJpa.findTorreEntities();
    }

    public List<Pago> traerPago() {
        return pagJpa.findPagoEntities();
    }

    public List<Venta> traerVenta() {
        return venJpa.findVentaEntities();
    }

    public void eliminarProyecto(int id) {
        try {
            proJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarTorre(int id) {
        try {
            torJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarInmueble(int id) {
        try {
            inmJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarVenta(int id) {
        try {
            venJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPago(int id) {
        try {
            pagJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCliente(int id) {
        try {
            cliJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Torre traerTorre(int id) {
        return torJpa.findTorre(id);
    }

    public void modificarTorre(Torre tor) {
        try {
            torJpa.edit(tor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Proyecto> traerProyecto() {
        return proJpa.findProyectoEntities();
    }

    public Proyecto traerproyect(int id) {
        return proJpa.findProyecto(id);
    }

    public void traerInmueble(int id) {
        inmJpa.findInmueble(id);
    }

   
}
    

