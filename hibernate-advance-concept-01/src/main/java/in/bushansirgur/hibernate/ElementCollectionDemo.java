package in.bushansirgur.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.bushansirgur.hibernate.model.EmployeeModel;
/**
 * This is the main class
 * @author Bushan
 * */
public class ElementCollectionDemo {
	
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeModel.class).buildSessionFactory();
		
		//get the current session
		Session session = factory.getCurrentSession();
		
		EmployeeModel employee = null;
		try {
			//create hashset and add phone numbers
			Set<String> phoneNumbers = new HashSet<String>();
			phoneNumbers.add("9988776655");
			phoneNumbers.add("9876543210");
			phoneNumbers.add("8899776655");
			phoneNumbers.add("9876543210");
			
			//create employee object
			employee = new EmployeeModel("Bushan", "bushan@bushansirgur.in", phoneNumbers);
			
			//start transaction
			session.beginTransaction();
			
			//save object
			session.persist(employee);
			
			//commit the transactions
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close session and session factory
			session.close();
			factory.close();
		}
	}
}
