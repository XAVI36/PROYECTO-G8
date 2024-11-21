/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.proyectovivienda2.logica.Cliente;
import com.mycompany.proyectovivienda2.logica.Inmueble;
import com.mycompany.proyectovivienda2.logica.Pago;
import com.mycompany.proyectovivienda2.logica.Venta;
import com.mycompany.proyectovivienda2.persistencia.exceptions.IllegalOrphanException;
import com.mycompany.proyectovivienda2.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public VentaJpaController(){
        emf = Persistence.createEntityManagerFactory("ProyectoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) throws IllegalOrphanException {
        if (venta.getPagos() == null) {
            venta.setPagos(new ArrayList<Pago>());
        }
        List<String> illegalOrphanMessages = null;
        Inmueble inmuebleOrphanCheck = venta.getInmueble();
        if (inmuebleOrphanCheck != null) {
            Venta oldVentasOfInmueble = inmuebleOrphanCheck.getVentas();
            if (oldVentasOfInmueble != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Inmueble " + inmuebleOrphanCheck + " already has an item of type Venta whose inmueble column cannot be null. Please make another selection for the inmueble field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                venta.setCliente(cliente);
            }
            Inmueble inmueble = venta.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getId());
                venta.setInmueble(inmueble);
            }
            List<Pago> attachedPagos = new ArrayList<Pago>();
            for (Pago pagosPagoToAttach : venta.getPagos()) {
                pagosPagoToAttach = em.getReference(pagosPagoToAttach.getClass(), pagosPagoToAttach.getId());
                attachedPagos.add(pagosPagoToAttach);
            }
            venta.setPagos(attachedPagos);
            em.persist(venta);
            if (cliente != null) {
                cliente.getVentas().add(venta);
                cliente = em.merge(cliente);
            }
            if (inmueble != null) {
                inmueble.setVentas(venta);
                inmueble = em.merge(inmueble);
            }
            for (Pago pagosPago : venta.getPagos()) {
                Venta oldVentaOfPagosPago = pagosPago.getVenta();
                pagosPago.setVenta(venta);
                pagosPago = em.merge(pagosPago);
                if (oldVentaOfPagosPago != null) {
                    oldVentaOfPagosPago.getPagos().remove(pagosPago);
                    oldVentaOfPagosPago = em.merge(oldVentaOfPagosPago);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getId());
            Cliente clienteOld = persistentVenta.getCliente();
            Cliente clienteNew = venta.getCliente();
            Inmueble inmuebleOld = persistentVenta.getInmueble();
            Inmueble inmuebleNew = venta.getInmueble();
            List<Pago> pagosOld = persistentVenta.getPagos();
            List<Pago> pagosNew = venta.getPagos();
            List<String> illegalOrphanMessages = null;
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                Venta oldVentasOfInmueble = inmuebleNew.getVentas();
                if (oldVentasOfInmueble != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Inmueble " + inmuebleNew + " already has an item of type Venta whose inmueble column cannot be null. Please make another selection for the inmueble field.");
                }
            }
            for (Pago pagosOldPago : pagosOld) {
                if (!pagosNew.contains(pagosOldPago)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pago " + pagosOldPago + " since its venta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                venta.setCliente(clienteNew);
            }
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getId());
                venta.setInmueble(inmuebleNew);
            }
            List<Pago> attachedPagosNew = new ArrayList<Pago>();
            for (Pago pagosNewPagoToAttach : pagosNew) {
                pagosNewPagoToAttach = em.getReference(pagosNewPagoToAttach.getClass(), pagosNewPagoToAttach.getId());
                attachedPagosNew.add(pagosNewPagoToAttach);
            }
            pagosNew = attachedPagosNew;
            venta.setPagos(pagosNew);
            venta = em.merge(venta);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getVentas().remove(venta);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getVentas().add(venta);
                clienteNew = em.merge(clienteNew);
            }
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.setVentas(null);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                inmuebleNew.setVentas(venta);
                inmuebleNew = em.merge(inmuebleNew);
            }
            for (Pago pagosNewPago : pagosNew) {
                if (!pagosOld.contains(pagosNewPago)) {
                    Venta oldVentaOfPagosNewPago = pagosNewPago.getVenta();
                    pagosNewPago.setVenta(venta);
                    pagosNewPago = em.merge(pagosNewPago);
                    if (oldVentaOfPagosNewPago != null && !oldVentaOfPagosNewPago.equals(venta)) {
                        oldVentaOfPagosNewPago.getPagos().remove(pagosNewPago);
                        oldVentaOfPagosNewPago = em.merge(oldVentaOfPagosNewPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta.getId();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pago> pagosOrphanCheck = venta.getPagos();
            for (Pago pagosOrphanCheckPago : pagosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venta (" + venta + ") cannot be destroyed since the Pago " + pagosOrphanCheckPago + " in its pagos field has a non-nullable venta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente cliente = venta.getCliente();
            if (cliente != null) {
                cliente.getVentas().remove(venta);
                cliente = em.merge(cliente);
            }
            Inmueble inmueble = venta.getInmueble();
            if (inmueble != null) {
                inmueble.setVentas(null);
                inmueble = em.merge(inmueble);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Venta findVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
