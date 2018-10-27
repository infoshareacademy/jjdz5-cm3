package com.isa.cm3.dao;

import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.delegations.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeDao {

        @PersistenceContext
        private EntityManager entityManager;

        public Long save(Employee employee) {

            entityManager.persist(employee);
            return employee.getId();
        }

        public Employee update(Employee employee) {
            return entityManager.merge(employee);
        }

        public void delete(Long id) {
            final Employee employee = entityManager.find(Employee.class, id);
            if (employee != null) {
                entityManager.remove(employee);
            }
        }

        public Employee findById(Long id) {
            return entityManager.find(Employee.class, id);
        }

        public List<Employee> findAll() {
            final Query query = entityManager.createQuery("SELECT e FROM Employee e ");

            return query.getResultList();
        }


    }

