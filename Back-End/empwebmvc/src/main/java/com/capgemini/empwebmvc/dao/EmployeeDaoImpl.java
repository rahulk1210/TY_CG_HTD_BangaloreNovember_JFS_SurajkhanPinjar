package com.capgemini.empwebmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.empwebmvc.beans.EmployeeBean;

@Repository						//(It will create a Object For the Class)
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	
	@Override
	public EmployeeBean auth(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from EmployeeBean where email=:email ";//and password = :pass";
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql,EmployeeBean.class);
		
		query.setParameter("email", email);
//		query.setParameter("pass", password);
		try {
			EmployeeBean bean =  query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if(encoder.matches(password, bean.getPassword())) {
				return bean;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean register(EmployeeBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);   //To avoid Duplicate Values
			transaction.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		return true;
	}
//
//	@Override
//	public EmployeeBean getEmployee(String email) {
//		EntityManager manager = factory.createEntityManager();
//		String jpql = "from EployeeBean where email=:email";
//		TypedQuery<EmployeeBean> query = manager.createQuery(jpql,EmployeeBean.class);
//		query.setParameter("email", email);
//		try {
//			return query.getSingleResult();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 	null;
//		}
//	}

	@Override
	public List<EmployeeBean>  getEmployee(String key) {			//key means anything
		EntityManager manager = factory.createEntityManager();
		String jpql = "from EmployeeBean where name=:name or email=:email";
		
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("name", key);
		query.setParameter("email", key);
			return query.getResultList();
		
	}

	@Override
	public boolean changePassword(int id, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		bean.setPassword(password);
		transaction.commit();
		return true;
	}
	

}
