/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectovivienda2.persistencia;

import com.mycompany.proyectovivienda2.logica.Proyecto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.proyectovivienda2.logica.Torre;
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
public class ProyectoJpaController implements Serializable {

    public ProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ProyectoJpaController(){
        emf = Persistence.createEntityManagerFactory("ProyectoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyecto proyecto) {
        if (proyecto.getTorres() == null) {
            proyecto.setTorres(new ArrayList<Torre>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Torre> attachedTorres = new ArrayList<Torre>();
            for (Torre torresTorreToAttach : proyecto.getTorres()) {
                torresTorreToAttach = em.getReference(torresTorreToAttach.getClass(), torresTorreToAttach.getId());
                attachedTorres.add(torresTorreToAttach);
            }
            proyecto.setTorres(attachedTorres);
            em.persist(proyecto);
            for (Torre torresTorre : proyecto.getTorres()) {
                Proyecto oldProyectoOfTorresTorre = torresTorre.getProyecto();
                torresTorre.setProyecto(proyecto);
                torresTorre = em.merge(torresTorre);
                if (oldProyectoOfTorresTorre != null) {
                    oldProyectoOfTorresTorre.getTorres().remove(torresTorre);
                    oldProyectoOfTorresTorre = em.merge(oldProyectoOfTorresTorre);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proyecto proyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto persistentProyecto = em.find(Proyecto.class, proyecto.getId());
            List<Torre> torresOld = persistentProyecto.getTorres();
            List<Torre> torresNew = proyecto.getTorres();
            List<Torre> attachedTorresNew = new ArrayList<Torre>();
            for (Torre torresNewTorreToAttach : torresNew) {
                torresNewTorreToAttach = em.getReference(torresNewTorreToAttach.getClass(), torresNewTorreToAttach.getId());
                attachedTorresNew.add(torresNewTorreToAttach);
            }
            torresNew = attachedTorresNew;
            proyecto.setTorres(torresNew);
            proyecto = em.merge(proyecto);
            for (Torre torresOldTorre : torresOld) {
                if (!torresNew.contains(torresOldTorre)) {
                    torresOldTorre.setProyecto(null);
                    torresOldTorre = em.merge(torresOldTorre);
                }
            }
            for (Torre torresNewTorre : torresNew) {
                if (!torresOld.contains(torresNewTorre)) {
                    Proyecto oldProyectoOfTorresNewTorre = torresNewTorre.getProyecto();
                    torresNewTorre.setProyecto(proyecto);
                    torresNewTorre = em.merge(torresNewTorre);
                    if (oldProyectoOfTorresNewTorre != null && !oldProyectoOfTorresNewTorre.equals(proyecto)) {
                        oldProyectoOfTorresNewTorre.getTorres().remove(torresNewTorre);
                        oldProyectoOfTorresNewTorre = em.merge(oldProyectoOfTorresNewTorre);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyecto.getId();
                if (findProyecto(id) == null) {
                    throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto proyecto;
            try {
                proyecto = em.getReference(Proyecto.class, id);
                proyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.", enfe);
            }
            List<Torre> torres = proyecto.getTorres();
            for (Torre torresTorre : torres) {
                torresTorre.setProyecto(null);
                torresTorre = em.merge(torresTorre);
            }
            em.remove(proyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proyecto> findProyectoEntities() {
        return findProyectoEntities(true, -1, -1);
    }

    public List<Proyecto> findProyectoEntities(int maxResults, int firstResult) {
        return findProyectoEntities(false, maxResults, firstResult);
    }

    private List<Proyecto> findProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proyecto.class));
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

    public Proyecto findProyecto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proyecto> rt = cq.from(Proyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
