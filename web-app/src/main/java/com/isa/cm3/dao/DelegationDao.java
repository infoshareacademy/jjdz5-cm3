package com.isa.cm3.dao;


import com.isa.cm3.delegations.Delegation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DelegationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Delegation d) {
        entityManager.persist(d);
        return d.getId();
    }

    public Delegation update(Delegation d) {
        return entityManager.merge(d);
    }

    public void delete(Long id) {
        final Delegation d = entityManager.find(Delegation.class, id);
        if (d != null) {
            entityManager.remove(d);
        }
    }

    public Delegation findById(Long id) {
        return entityManager.find(Delegation.class, id);
    }

    public List<Delegation> findAll() {
        final Query query = entityManager.createQuery("SELECT d FROM Delegation d ");

        return query.getResultList();
    }
}