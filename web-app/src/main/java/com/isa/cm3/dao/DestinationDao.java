package com.isa.cm3.dao;


import com.isa.cm3.delegations.Destination;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DestinationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Destination d) {

        entityManager.persist(d);
        return d.getId();
    }

    public Destination update(Destination d) {
        return entityManager.merge(d);
    }

    public void delete(Long id) {
        final Destination d = entityManager.find(Destination.class, id);
        if (d != null) {
            entityManager.remove(d);
        }
    }

    public Destination findById(Long id) {
        return entityManager.find(Destination.class, id);
    }

    public List<Destination> findAll() {
        final Query query = entityManager.createQuery("SELECT d FROM Destination d ");

        return query.getResultList();
    }
}
