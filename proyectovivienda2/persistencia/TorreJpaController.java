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
import com.mycompany.proyectovivienda2.logica.Proyecto;
import com.mycompany.proyectovivienda2.logica.Inmueble;
import com.mycompany.proyectovivienda2.logica.Torre;
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
public class TorreJpaController implements Serializable {

    public TorreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TorreJpaController(){
        emf = Persistence.createEntityManagerFactory("ProyectoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torre torre) {
        if (torre.getInmuebles() == null) {
            torre.setInmuebles(new ArrayList<Inmueble>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto proyecto = torre.getProyecto();
            if (proyecto != null) {
                proyecto = em.getReference(proyecto.getClass(), proyecto.getId());
                torre.setProyecto(proyecto);
            }
            List<Inmueble> attachedInmuebles = new ArrayList<Inmueble>();
            for (Inmueble inmueblesInmuebleToAttach : torre.getInmuebles()) {
                inmueblesInmuebleToAttach = em.getReference(inmueblesInmuebleToAttach.getClass(), inmueblesInmuebleToAttach.getId());
                attachedInmuebles.add(inmueblesInmuebleToAttach);
            }
            torre.setInmuebles(attachedInmuebles);
            em.persist(torre);
            if (proyecto != null) {
                proyecto.getTorres().add(torre);
                proyecto = em.merge(proyecto);
            }
            for (Inmueble inmueblesInmueble : torre.getInmuebles()) {
                Torre oldTorreOfInmueblesInmueble = inmueblesInmueble.getTorre();
                inmueblesInmueble.setTorre(torre);
                inmueblesInmueble = em.merge(inmueblesInmueble);
                if (oldTorreOfInmueblesInmueble != null) {
                    oldTorreOfInmueblesInmueble.getInmuebles().remove(inmueblesInmueble);
                    oldTorreOfInmueblesInmueble = em.merge(oldTorreOfInmueblesInmueble);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torre torre) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torre persistentTorre = em.find(Torre.class, torre.getId());
            Proyecto proyectoOld = persistentTorre.getProyecto();
            Proyecto proyectoNew = torre.getProyecto();
            List<Inmueble> inmueblesOld = persistentTorre.getInmuebles();
            List<Inmueble> inmueblesNew = torre.getInmuebles();
            List<String> illegalOrphanMessages = null;
            for (Inmueble inmueblesOldInmueble : inmueblesOld) {
                if (!inmueblesNew.contains(inmueblesOldInmueble)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inmueble " + inmueblesOldInmueble + " since its torre field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proyectoNew != null) {
                proyectoNew = em.getReference(proyectoNew.getClass(), proyectoNew.getId());
                torre.setProyecto(proyectoNew);
            }
            List<Inmueble> attachedInmueblesNew = new ArrayList<Inmueble>();
            for (Inmueble inmueblesNewInmuebleToAttach : inmueblesNew) {
                inmueblesNewInmuebleToAttach = em.getReference(inmueblesNewInmuebleToAttach.getClass(), inmueblesNewInmuebleToAttach.getId());
                attachedInmueblesNew.add(inmueblesNewInmuebleToAttach);
            }
            inmueblesNew = attachedInmueblesNew;
            torre.setInmuebles(inmueblesNew);
            torre = em.merge(torre);
            if (proyectoOld != null && !proyectoOld.equals(proyectoNew)) {
                proyectoOld.getTorres().remove(torre);
                proyectoOld = em.merge(proyectoOld);
            }
            if (proyectoNew != null && !proyectoNew.equals(proyectoOld)) {
                proyectoNew.getTorres().add(torre);
                proyectoNew = em.merge(proyectoNew);
            }
            for (Inmueble inmueblesNewInmueble : inmueblesNew) {
                if (!inmueblesOld.contains(inmueblesNewInmueble)) {
                    Torre oldTorreOfInmueblesNewInmueble = inmueblesNewInmueble.getTorre();
                    inmueblesNewInmueble.setTorre(torre);
                    inmueblesNewInmueble = em.merge(inmueblesNewInmueble);
                    if (oldTorreOfInmueblesNewInmueble != null && !oldTorreOfInmueblesNewInmueble.equals(torre)) {
                        oldTorreOfInmueblesNewInmueble.getInmuebles().remove(inmueblesNewInmueble);
                        oldTorreOfInmueblesNewInmueble = em.merge(oldTorreOfInmueblesNewInmueble);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = torre.getId();
                if (findTorre(id) == null) {
                    throw new NonexistentEntityException("The torre with id " + id + " no longer exists.");
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
            Torre torre;
            try {
                torre = em.getReference(Torre.class, id);
                torre.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torre with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Inmueble> inmueblesOrphanCheck = torre.getInmuebles();
            for (Inmueble inmueblesOrphanCheckInmueble : inmueblesOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torre (" + torre + ") cannot be destroyed since the Inmueble " + inmueblesOrphanCheckInmueble + " in its inmuebles field has a non-nullable torre field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proyecto proyecto = torre.getProyecto();
            if (proyecto != null) {
                proyecto.getTorres().remove(torre);
                proyecto = em.merge(proyecto);
            }
            em.remove(torre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torre> findTorreEntities() {
        return findTorreEntities(true, -1, -1);
    }

    public List<Torre> findTorreEntities(int maxResults, int firstResult) {
        return findTorreEntities(false, maxResults, firstResult);
    }

    private List<Torre> findTorreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torre.class));
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

    public Torre findTorre(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torre.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torre> rt = cq.from(Torre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
