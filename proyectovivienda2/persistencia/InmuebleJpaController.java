/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.persistencia;

import com.mycompany.proyectovivienda2.logica.Inmueble;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.proyectovivienda2.logica.Torre;
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
public class InmuebleJpaController implements Serializable {

    public InmuebleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public InmuebleJpaController(){
        emf = Persistence.createEntityManagerFactory("ProyectoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inmueble inmueble) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torre torre = inmueble.getTorre();
            if (torre != null) {
                torre = em.getReference(torre.getClass(), torre.getId());
                inmueble.setTorre(torre);
            }
            Venta ventas = inmueble.getVentas();
            if (ventas != null) {
                ventas = em.getReference(ventas.getClass(), ventas.getId());
                inmueble.setVentas(ventas);
            }
            em.persist(inmueble);
            if (torre != null) {
                torre.getInmuebles().add(inmueble);
                torre = em.merge(torre);
            }
            if (ventas != null) {
                Inmueble oldInmuebleOfVentas = ventas.getInmueble();
                if (oldInmuebleOfVentas != null) {
                    oldInmuebleOfVentas.setVentas(null);
                    oldInmuebleOfVentas = em.merge(oldInmuebleOfVentas);
                }
                ventas.setInmueble(inmueble);
                ventas = em.merge(ventas);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inmueble inmueble) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmueble persistentInmueble = em.find(Inmueble.class, inmueble.getId());
            Torre torreOld = persistentInmueble.getTorre();
            Torre torreNew = inmueble.getTorre();
            Venta ventasOld = persistentInmueble.getVentas();
            Venta ventasNew = inmueble.getVentas();
            List<String> illegalOrphanMessages = null;
            if (ventasOld != null && !ventasOld.equals(ventasNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Venta " + ventasOld + " since its inmueble field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (torreNew != null) {
                torreNew = em.getReference(torreNew.getClass(), torreNew.getId());
                inmueble.setTorre(torreNew);
            }
            if (ventasNew != null) {
                ventasNew = em.getReference(ventasNew.getClass(), ventasNew.getId());
                inmueble.setVentas(ventasNew);
            }
            inmueble = em.merge(inmueble);
            if (torreOld != null && !torreOld.equals(torreNew)) {
                torreOld.getInmuebles().remove(inmueble);
                torreOld = em.merge(torreOld);
            }
            if (torreNew != null && !torreNew.equals(torreOld)) {
                torreNew.getInmuebles().add(inmueble);
                torreNew = em.merge(torreNew);
            }
            if (ventasNew != null && !ventasNew.equals(ventasOld)) {
                Inmueble oldInmuebleOfVentas = ventasNew.getInmueble();
                if (oldInmuebleOfVentas != null) {
                    oldInmuebleOfVentas.setVentas(null);
                    oldInmuebleOfVentas = em.merge(oldInmuebleOfVentas);
                }
                ventasNew.setInmueble(inmueble);
                ventasNew = em.merge(ventasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inmueble.getId();
                if (findInmueble(id) == null) {
                    throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.");
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
            Inmueble inmueble;
            try {
                inmueble = em.getReference(Inmueble.class, id);
                inmueble.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Venta ventasOrphanCheck = inmueble.getVentas();
            if (ventasOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Inmueble (" + inmueble + ") cannot be destroyed since the Venta " + ventasOrphanCheck + " in its ventas field has a non-nullable inmueble field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Torre torre = inmueble.getTorre();
            if (torre != null) {
                torre.getInmuebles().remove(inmueble);
                torre = em.merge(torre);
            }
            em.remove(inmueble);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inmueble> findInmuebleEntities() {
        return findInmuebleEntities(true, -1, -1);
    }

    public List<Inmueble> findInmuebleEntities(int maxResults, int firstResult) {
        return findInmuebleEntities(false, maxResults, firstResult);
    }

    private List<Inmueble> findInmuebleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inmueble.class));
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

    public Inmueble findInmueble(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inmueble.class, id);
        } finally {
            em.close();
        }
    }

    public int getInmuebleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inmueble> rt = cq.from(Inmueble.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
