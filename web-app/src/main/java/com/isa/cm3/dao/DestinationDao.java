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

    public List<String> cityList(){
        final Query query = entityManager.createQuery("SELECT d.destinationCity FROM Destination d ");
        return query.getResultList();
    }

    public Destination findIfExist(Destination destination) {
        final Query query = entityManager.createQuery(
                "SELECT id FROM Destination WHERE destination_country = :country and destination_city = :city and destination_company = :company and destination_company_adress = :adress");
        query.setParameter("country", destination.getDestinationCountry());
        query.setParameter("city", destination.getDestinationCity());
        query.setParameter("company", destination.getDestinationCompany());
        query.setParameter("adress", destination.getDestinationCompanyAddress());
        List<Long> idList = query.getResultList();
        if (idList.size() == 1) {
            Long id = idList.get(0);
            Destination destination1 = findById(id);
            return destination1;
        } else {
            return destination;
        }
    }
}