package dao;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.SaveTransaction;
import model.User;
import model.UserDetails;

public class BuyCarDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public UserDetails vratiUserDetailsPoId(String userId) {
		
		UserDetails userDetails = new UserDetails();
		
		int idUserDetails = Integer.parseInt(userId);
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			userDetails = session.get(UserDetails.class, idUserDetails);
			Hibernate.initialize(userDetails.getCars());
			session.getTransaction().commit();
			System.out.println("Postoji userDetails sa id " + idUserDetails);
			return userDetails;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u vratiUserDetailsPoId...");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public void prebaciAutomobilSaProdavcaNaKupca(Car car, UserDetails prodavac, UserDetails kupac) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			car.setUserDetails(kupac);
			kupac.getCars().add(car);
			
			for(Car c: prodavac.getCars()) {
				if(c.getIdCar() == car.getIdCar()) {
					prodavac.getCars().remove(c);
					System.out.println("Obrisan automobil: " + c.getManufacturer() + " " + c.getModel());
				}
			}
			
			prodavac.setBalance(prodavac.getBalance() + car.getPrice());
				System.out.println("Novi balance prodavca je: " + prodavac.getBalance());
			kupac.setBalance(kupac.getBalance() - car.getPrice());
				System.out.println("Novi balance kupca je: " + kupac.getBalance());
				
			session.update(car);
			session.update(prodavac);
			session.update(kupac);
			
			session.getTransaction().commit();
			System.out.println("Automobili prebaceni...");

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u prebaciAutomobilSaProdavcaNaKupca...");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	public void sacuvajTransakciju(Car car, UserDetails prodavac, UserDetails kupac) {
		
		SaveTransaction trx = new SaveTransaction();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			trx.setBuyer(kupac);
			trx.setSeller(prodavac);
			trx.setCar(car);
			trx.setDate(new Date());
			
			session.save(trx);
			
			session.getTransaction().commit();
			System.out.println("Transakcija uspesna...");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u sacuvajTransakciju...");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
