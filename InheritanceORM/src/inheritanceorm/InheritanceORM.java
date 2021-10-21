/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
/**
 *
 * @author aomms
 */
public class InheritanceORM {
    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int m = 0;
        do{
        System.out.println("===== Employee Manager Menu =====");
        System.out.print("Press 1 for Add Employee\n      2 for Update Employee\n      3 fot Delete Employee\n      "
                + "or other to Exit Program\n: ");
        m = sc.nextInt();
        
        if(m == 1) AddMode();
        else if(m == 2) UpdateMode();
        else if(m == 3) DeleteMode();
        
        } while(m==1 || m==2 || m==3);

    }
    static void AddMode(){
        System.out.print("Press 1 for Fulltime Employee\n      2 for Part-Time Employee\n: ");
        int e = sc.nextInt();
        if(e == 1){
            System.out.print("Enter Employee's ID : ");
            long id = sc.nextLong();
            System.out.print("Enter Employee's Name : ");
            String name = sc.next();
            System.out.print("Enter Employee's Salary : ");
            int s = sc.nextInt();
            FulltimeEmployee emp = new FulltimeEmployee();
            emp.setId(id);
            emp.setName(name);
            emp.setSalary(s);
            persist(emp);
        }
        else if(e == 2){
            System.out.print("Enter Employee's ID : ");
            long id = sc.nextLong();
            System.out.print("Enter Employee's Name : ");
            String name = sc.next();
            System.out.print("Enter Employee's Hourswork : ");
            int h = sc.nextInt();
            
            ParttimeEmployee emp = new ParttimeEmployee();
            emp.setId(id);
            emp.setName(name);
            emp.setHourworks(h);
            persist(emp);
        }
    }
    
    static void UpdateMode(){
        System.out.print("Press 1 for Fulltime Employee\n      2 for Part-Time Employee\n: ");
        int e = sc.nextInt();

        if(e == 1){
            System.out.print("Enter Employee's ID : ");
            long id = sc.nextLong();
            FulltimeEmployee emp = FulltimeEmployeeTable.findEmployeeById(id);
            System.out.print("Press 1 for Update Name\n      2 for Salary\n: ");
            int m = sc.nextInt();
            if(m == 1){
                System.out.print("Enter Name for Update : ");
                String name = sc.next();
                if(emp != null) emp.setName(name);
                FulltimeEmployeeTable.updateEmployee(emp);   
            }
            if(m == 2){
                System.out.print("Enter Salary for Update : ");
                int s = sc.nextInt();
                if(emp != null) emp.setSalary(s);
                FulltimeEmployeeTable.updateEmployee(emp);
            }
        }
        if(e == 2){
            System.out.print("Enter Employee's ID : ");
            long id = sc.nextLong();
            ParttimeEmployee emp = ParttimeEmployeeTable.findEmployeeById(id);
            System.out.print("Press 1 for Update Name\n      2 for Hourswork\n: ");
            int m = sc.nextInt();
            if(m == 1){
                System.out.print("Enter Name for Update : ");
                String name = sc.next();
                if(emp != null) emp.setName(name);
                ParttimeEmployeeTable.updateEmployee(emp);   
            }
            if(m == 2){
                System.out.print("Enter Hourwokrs for Update : ");
                int h = sc.nextInt();
                if(emp != null) emp.setHourworks(h);
                ParttimeEmployeeTable.updateEmployee(emp);
            }
        }
        
    }
    
    static void DeleteMode(){
        System.out.print("Press 1 for Fulltime Employee\n      2 for Part-Time Employee\n: ");
        int e = sc.nextInt();
        System.out.print("Enter Employee's ID : ");
        long id = sc.nextLong();
        
        if(e == 1) {
            FulltimeEmployee emp = FulltimeEmployeeTable.findEmployeeById(id);
            if(emp != null) FulltimeEmployeeTable.removeEmployee(emp);
        }
        else if(e == 2){
            ParttimeEmployee emp = ParttimeEmployeeTable.findEmployeeById(id);
            if(emp != null) ParttimeEmployeeTable.removeEmployee(emp);
        }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
