package com.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			sf = new Configuration().configure().buildSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();
			
			Cart cart1 = new Cart();
			cart1.setName("Seenu's cart");
			
			Item i1 = new Item("MC001","Shirt",700,3,cart1);
			Item i2 = new Item("MC002","Pant",900,2,cart1);
			
			Set<Item> items = new HashSet<Item>();
			
			items.add(i1);
			items.add(i2);
			
			cart1.setItem(items);
			cart1.setTotal(700*3+900*2);
			
			s.save(cart1);
			
		    s.save(i1);
		    s.save(i2);
		    
		   System.out.println("Cart Id : "+cart1.getId());
		   
		   
		}
		catch(HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tx != null)
				tx.rollback();	
			e.printStackTrace();
		}
		finally {
			if(s != null)
				s.close();
			if(sf != null)
				if(tx != null)
					tx.commit();
				sf.close();
			
		}

	}

}
