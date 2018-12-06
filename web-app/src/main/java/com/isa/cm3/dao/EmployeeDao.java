package com.isa.cm3.dao;

import com.isa.cm3.delegations.Employee;
import com.isa.cm3.servlets.DelegationSaveServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeDao {

    private static final Logger LOG = LogManager.getLogger(DelegationSaveServlet.class);
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

    public Employee findIfExist(Employee employee) {
        final Query query = entityManager.createQuery(
                "SELECT id FROM Employee WHERE employee_name = :name and employee_surname = :surname ");
        query.setParameter("name", employee.getEmployeeName());
        query.setParameter("surname", employee.getEmployeeSurname());
        LOG.debug("Pobranie z bazy pracownika");
        List<Long> idList = query.getResultList();
        LOG.debug("Stworzenie listy w metodzie dao");
        if (idList.size() == 1) {
            LOG.debug("pracownik jest juz w bazie");
            Long id = idList.get(0);
            Employee employee11 = findById(id);
            return employee11;
        } else {
            return employee;
        }
    }

    public boolean findIfExistByEmail(String email) {

        final Query query = entityManager.createQuery(
                "SELECT email FROM Employee WHERE email = :email");
        query.setParameter("email", email);
        List<Long> idList = query.getResultList();
        if (idList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int isAdminOrManager(String email) {

        final Query query = entityManager.createQuery(
                "SELECT id FROM Employee WHERE email = :email");
        query.setParameter("email", email);
        LOG.debug("Pobranie z bazy pracownika");
        List<Long> idList = query.getResultList();
        LOG.debug("Stworzenie listy w metodzie dao");
        Long id = idList.get(0);
        Employee employee = findById(id);

        if (employee.isAdmininistrator()) {
            return 2;
        } else if (employee.isManager()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Employee findByEmail(String email) {
        final Query query = entityManager.createQuery("SELECT e from Employee e where email = :email");
        query.setParameter("email", email);
        List<Employee> employeeList = query.getResultList();
        Employee employee = employeeList.get(0);
        return employee;
    }
}