/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import inheritanceorm.Employee;
import inheritanceorm.FulltimeEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class FulltimeEmployeeTable {
        
    public static void insertEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, emp.getId());
        fromDb.setName(emp.getName());
        fromDb.setSalary(emp.getSalary());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static FulltimeEmployee findEmployeeById(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee emp = em.find(FulltimeEmployee.class, id);
        em.close();
        return emp;
    }
    public static List<FulltimeEmployee> findAllFulltime() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        List<FulltimeEmployee> empList = (List<FulltimeEmployee>) em.createNamedQuery("FulltimeEmployee.findAll").getResultList();
        em.close();
        return empList;
    }
    public static void removeEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
    
    
}
