/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jpajaxproject.dao.impl;

import com.leapfrog.jpajaxproject.dao.DepartmentDAO;
import com.leapfrog.jpajaxproject.entity.Department;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Surendra
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public DepartmentDAOImpl() {
        factory = Persistence.createEntityManagerFactory("JAXJPA_UNIT");
        manager = factory.createEntityManager();

    }

    @Override
    public List<Department> getAll() {
        Query query= manager.createQuery("SELECT d FROM Department d    ");
        return (List<Department>)query.getResultList();
        
    }

    @Override
    public int insert(Department d) {
        EntityTransaction trans= manager.getTransaction();
        if(!trans.isActive()){  
            trans.begin();
        }
        manager.persist(d);
        manager.flush();
        trans.commit();
        return d.getId();
    }

    @Override
    public Department getById(int id) {
      return  manager.find(Department.class, id);
    }

}
