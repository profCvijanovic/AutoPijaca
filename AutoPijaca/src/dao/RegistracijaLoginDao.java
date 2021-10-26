package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class RegistracijaLoginDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public boolean upisiUsera(User user) {
			
		Session session = sf.openSession();
			session.beginTransaction();		
			try {
				session.save(user);		
				session.getTransaction().commit();
				System.out.println("User ciji je userName: " + user.getUserName() + " je upisan u bazu");
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Greska, user nije upisan u bazu...");
				return false;
			}finally {
				session.close();
			}
		
	}

}
