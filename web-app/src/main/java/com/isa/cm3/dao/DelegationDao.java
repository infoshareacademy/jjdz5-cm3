package com.isa.cm3.dao;


import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.servlets.DelegationSaveServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DelegationDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = LogManager.getLogger(DelegationSaveServlet.class);

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
        LOG.debug("Pobieranie wszystkich delegacji  ... ");
        final Query query = entityManager.createQuery("SELECT d FROM Delegation d");
        LOG.debug("Pobrano dlegacje. Nastąpi zwrócenie listy delegacji  ");
        List<Delegation> lista = new ArrayList<>();
        return query.getResultList();

    }

    public List<Delegation> findAllForCurentEmployee(String employeeId) {

        LOG.debug("Pobieranie wszystkich delegacji  ... ");
        final Query query = entityManager.createQuery("SELECT d FROM Delegation d where employee_id = :employeeId");
        query.setParameter("employeeId", Long.valueOf(employeeId));
        LOG.debug("Pobrano dlegacje. Nastąpi zwrócenie listy delegacji  ");
        return query.getResultList();

    }
}