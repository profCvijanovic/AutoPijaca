package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.User;

public class ChosenCarsDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	/*
	 * ako je odabran neregistrovan vraca false
	 * ako je odabran registrovan vraca true
	 * ako je odabran sve vraca null
	 */
	public Boolean pretvoriStringRegistracijuUBoolean(String registration) {
		
		Boolean povratniBoolean = null;
		
		if(registration.equals("0")) {
			povratniBoolean = false;
		}else if(registration.equals("1")) {
			povratniBoolean = true;
		}
			
		return povratniBoolean;
	}

	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, 
			String yearFrom, String yearTo, Boolean isRegister) {
		
		List<Car> listaAutomobila = new ArrayList<Car>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String hql = "from Car" + 
						 " where 1=1";
			
			if(manufacturer != null && !manufacturer.equals("")) {
				hql += " and manufacturer = :manufacturer";
			}
			
			if(model != null && !model.equals("")) {
				hql += " and model = :modell";
			}
			
			if(priceFrom != null) {
				hql += " and price >= :priceFrom";
			}
			
			if(priceTo != null) {
				hql += " and price <= :priceTo";
			}
			
			if(!yearFrom.equals("0")) {
				hql += " and year >= :yearFrom";
			}
			
			if(!yearTo.equals("0")) {
				hql += " and year <= :yearTo";
			}
			
			if(isRegister != null) {
				if(isRegister) {
					hql += " and isRegister = true";
				}else {
					hql += " and isRegister = false";
				}				
			}
			
			System.out.println(hql);
			
			Query query = session.createQuery(hql);
			
			if(manufacturer != null && !manufacturer.equals("")) {
				query.setParameter("manufacturer", manufacturer);
			}
			
			if(model != null && !model.equals("")) {
				query.setParameter("modell", model);
			}
			
			if(priceFrom != null) {
				query.setParameter("priceFrom", priceFrom);
			}
			
			if(priceTo != null) {
				query.setParameter("priceTo", priceTo);
			}
			
			if(!yearFrom.equals("0")) {
				query.setParameter("yearFrom", yearFrom);
			}
			
			if(!yearTo.equals("0")) {
				query.setParameter("yearTo", yearTo);
			}
			
			listaAutomobila = (List<Car>)query.getResultList();
			
			session.getTransaction().commit();
			System.out.println("Vracam listu automobila, koja ima " + listaAutomobila.size() + " redova");
			
			return listaAutomobila;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u getChosenCars...");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	
	}

	public Car vratiCarPoId(String idCar) {
		
			Car car = new Car();

			Session session = sf.openSession();
			session.beginTransaction();
			try {
				car = session.get(Car.class, Integer.parseInt(idCar));
				session.getTransaction().commit();
				return car;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Nesto je puklo u vratiCarPoId...");
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}
	}
	
	
	

}
