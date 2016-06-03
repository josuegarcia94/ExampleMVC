/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.*;
import java.util.*;
import entidades.EstudianteEntity;

/**
 *
 * @author nacho
 */
public class EstudianteDAO {

    private EntityManager em;
    private EntityManagerFactory emf;

    public EstudianteDAO(String archivo) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/" + archivo);
        em = emf.createEntityManager();
    }

    public void create(EstudianteEntity ee) {
        em.getTransaction().begin();
        em.persist(ee);
        em.getTransaction().commit();
    }

    public EstudianteEntity read(long id) {
        TypedQuery<EstudianteEntity> query = em.createQuery(
                "SELECT e FROM EstudianteEntity e WHERE id=" + id,
                EstudianteEntity.class);
        return query.getSingleResult();
    }

    public List<EstudianteEntity> readAll() {
        TypedQuery<EstudianteEntity> query = em.createQuery(
                "SELECT e FROM EstudianteEntity e", EstudianteEntity.class);
        return query.getResultList();
    }

    public List<EstudianteEntity> readAll(String idg) {
        TypedQuery<EstudianteEntity> query = em.createQuery(
                "SELECT e FROM EstudianteEntity e WHERE idg=" + idg,
                EstudianteEntity.class);
        return query.getResultList();
    }

    public void update(long id, EstudianteEntity e) {
        EstudianteEntity ee = read(id);
        ee.setNombre(e.getNombre());
        ee.setEdad(e.getEdad());
        ee.setBoleta(e.getBoleta());
        create(ee);
    }

    public void delete(long id) {
        EstudianteEntity e = read(id);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public void delete(EstudianteEntity e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public void deleteAll(String idg) {
        List<EstudianteEntity> listae = readAll(idg);
        Iterator<EstudianteEntity> itera = listae.iterator();
        while (itera.hasNext()) {
            EstudianteEntity e = itera.next();
            delete(e);
        }
    }

    //???
    public void readGrupos() {
        List<EstudianteEntity> listae = readAll();
        Iterator<EstudianteEntity> itera = listae.iterator();
        LinkedList<String> ll = new LinkedList<>();
        while (itera.hasNext()) {
            EstudianteEntity e = itera.next();
            String idg = e.getIdG();
            if (!ll.contains(idg)) {
                ll.add(idg);
            }
        }
    }

    public void cerrar() {
        if (emf != null) {
            emf.close();
        }
        if (em != null) {
            em.close();
        }
    }
}
