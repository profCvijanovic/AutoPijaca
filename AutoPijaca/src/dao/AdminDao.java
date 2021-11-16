package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;
import model.UserType;

public class AdminDao {

	SessionFactory sf = HibernateUtil.createSessionFactory();

	public List<User> vratiUserePoTipu(UserType type) {

		List<User> users = new ArrayList<User>();

		Session session = sf.openSession();
		session.beginTransaction();
		try {

			String hql = "from User";

			if (type != null) {
				hql += " where userType = :type";
			}

			System.out.println("hql: " + hql);
			Query query = session.createQuery(hql);

			if (type != null) {
				query.setParameter("type", type);
			}

			users = (List<User>) query.getResultList();
			session.getTransaction().commit();
			return users;

		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}

	}

	public User vratiUseraPoUserName(String userName) {
		User user = new User();

		Session session = sf.openSession();
		session.beginTransaction();
		try {

			String hql = "from User where userName = :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", userName);

			user = (User) query.getSingleResult();

			session.getTransaction().commit();
			System.out.println("Postoji user sa userName-om " + userName);
			return user;

		} catch (NonUniqueResultException e) {
			System.out.println("Ima vise usera sa ovim user name-om...");
			return null;
		} catch (NoResultException e) {
			System.out.println("Ne postoji user sa ovim user name-om...");
			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u vartiUseraPoUserName...");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	public UserDetails vratiUserDetailsPoUser(User userFromDb) {
		UserDetails details = new UserDetails();

		Session session = sf.openSession();
		session.beginTransaction();
		try {

			String hql = "from UserDetails where user = :userFromDb";
			Query query = session.createQuery(hql);
			query.setParameter("userFromDb", userFromDb);

			details = (UserDetails) query.getSingleResult();

			session.getTransaction().commit();
			System.out.println("Postoji user details sa userName-om " + details.getIdUserDetails());
			return details;

		} catch (NonUniqueResultException e) {
			System.out.println("Ima vise usera sa ovim user name-om...");
			return null;
		} catch (NoResultException e) {
			System.out.println("Ne postoji user details sa ovim user name-om...");
			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u vratiUserDetailsPoUser...");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateBalance(UserDetails details, Double balance) {
		boolean updateBalance = false;

		Session session = sf.openSession();
		session.beginTransaction();
		try {
			// vratio iz detached stanja u perzistentno stanje
			UserDetails persistedUserDetails = session.get(UserDetails.class, details.getIdUserDetails());
			
			System.out.println("persistedUserDetails: " + persistedUserDetails.getIdUserDetails());
	
			if(persistedUserDetails.getBalance() != null) {
				persistedUserDetails.setBalance(balance + persistedUserDetails.getBalance());
			}else {
				persistedUserDetails.setBalance(balance);
			}
			
			session.update(persistedUserDetails);
			updateBalance = true;

			session.getTransaction().commit();
			System.out.println("Update UserDetails balance uspesan...");
			return updateBalance;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Update UserDetails balance NIJE uspesan!" + e);
			return false;
		} finally {
			session.close();
		}
	}

}
