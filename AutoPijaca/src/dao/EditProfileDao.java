package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Address;
import model.Contact;
import model.UserDetails;

public class EditProfileDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public boolean editujUserDetails(String firstName, String lastName, String phone, 
			String email, String country,String city, String street, UserDetails details) {
		
		boolean updateUserDetails = false;

		Session session = sf.openSession();
		session.beginTransaction();
		try {
			// vratio iz detached stanja u perzistentno stanje
			UserDetails persistedUserDetails = session.get(UserDetails.class, details.getIdUserDetails());
			System.out.println("U metodi editujUserDetails nasao sam userDeatails ciji je ID: " + persistedUserDetails.getIdUserDetails());
			persistedUserDetails.setFirstName(firstName);
			persistedUserDetails.setLastName(lastName);
			if(persistedUserDetails.getContact() == null) {
				Contact contact = new Contact();
				contact.setEmail("defaultMail");
				contact.setPhone("defaultPhone");
				persistedUserDetails.setContact(contact);
				
				persistedUserDetails.getContact().setPhone(phone);
				persistedUserDetails.getContact().setEmail(email);
			}else {
				persistedUserDetails.getContact().setPhone(phone);
				persistedUserDetails.getContact().setEmail(email);
			}
			
			if(persistedUserDetails.getAddress() == null) {
				Address a = new Address();
				a.setCity("x");
				a.setCountry("y");
				a.setStreet("z");
				
				persistedUserDetails.setAddress(a);
				
				persistedUserDetails.getAddress().setCountry(country);
				persistedUserDetails.getAddress().setCity(city);
				persistedUserDetails.getAddress().setStreet(street);
			}else {
				persistedUserDetails.getAddress().setCountry(country);
				persistedUserDetails.getAddress().setCity(city);
				persistedUserDetails.getAddress().setStreet(street);
			}
					
			session.update(persistedUserDetails);
			updateUserDetails = true;

			session.getTransaction().commit();
			System.out.println("Update UserDetails uspesan...");
			return updateUserDetails;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Update UserDetails NIJE uspesan! " + e);
			return false;
		} finally {
			session.close();
		}
	}
	
	

}
