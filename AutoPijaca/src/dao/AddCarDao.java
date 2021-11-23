package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.User;
import model.UserDetails;

public class AddCarDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Boolean daLiJeRegistrovan(String isRegisterFromForm) {
		Boolean isRegister = false;
		
		if(isRegisterFromForm == null) {
			isRegister = false;
		}else {
			isRegister = true;
		}
		return isRegister;
	}

	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {
		
		Car car = new Car();
		car.setManufacturer(manufacturer);
		car.setModel(model);
		car.setPrice(price);
		car.setYear(year);
		car.setIsRegister(isRegister);
		car.setUserDetails(details);
		
		return car;
	}

	public boolean ubaciCar(Car car) {
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(car);
			session.getTransaction().commit();
			System.out.println("Ubacio car u bazu...");
			return true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u ubaciCar...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean spojiUserDetailsIcar(UserDetails details, Car car) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			// preuzimam perzistentan objekat iz baze tipa UserDetails
			UserDetails detailsFromDb = session.get(UserDetails.class, details.getIdUserDetails());
			// inicijalizujem listu cars jer je fetch type = LAZY
			Hibernate.initialize(detailsFromDb.getCars());
			// dodajem Car u listu (tj spojiUserDetailsIcar)
			detailsFromDb.getCars().add(car);
			session.saveOrUpdate(detailsFromDb);
			
			session.getTransaction().commit();
			System.out.println("Ubacio Car u UserDetails listu...");
			return true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u ubaciCar...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	
	

}
