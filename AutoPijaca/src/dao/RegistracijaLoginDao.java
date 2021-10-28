package dao;

import javax.persistence.Query;

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

	public User vratiUseraPoUserNameiPassword(String userName, String password) {
		
		User user = null;
		Session session = sf.openSession();
		session.beginTransaction();		
		try {
			String hql = "from User where userName = :name and password = :pass";
			Query query = session.createQuery(hql);
				query.setParameter("name", userName);
				query.setParameter("pass", password);
			
			user = (User) query.getSingleResult();

			session.getTransaction().commit();
			System.out.println("Pronadjen user...");
			return user;
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije nasao usera...");
			return null;
		}finally {
			session.close();
		}
		
	}

}
