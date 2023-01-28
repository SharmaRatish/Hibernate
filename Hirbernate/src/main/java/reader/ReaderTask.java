package reader;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.cdac.HibernateUtil;

public class ReaderTask {

	public static void addRecord() {
		
		Session session=HibernateUtil.getSession();
		Transaction t= session.beginTransaction();
		
		Subscription s= new Subscription();
		 s.setSname("Horror Movies");
		 
			Subscription s1= new Subscription();
			 s1.setSname("Horror Series");
			 
				Subscription s2= new Subscription();
				 s2.setSname("Family Darama");
		
				 Reader r= new Reader();
				 r.setEmail("Sartish@gmail,com");
				 r.setName("Ratish");
				 
				 Reader r1= new Reader();
				 r1.setEmail("Nadeem@gmail,com");
				 r1.setName("nadeem");
				 
				 /* 
				 Reader r2= new Reader();
				 r2.setEmail("Sajid@gmail,com");
				 r2.setName("sajis");
				 
				
				 Reader r3= new Reader();
				 r3.setEmail("Niyaz@gmail,com");
				 r3.setName("niyaz");
				 */
				 
				 Set<Subscription> ss=new HashSet<Subscription>();
				 ss.add(s2);
				 ss.add(s1);
				 ss.add(s);
				 
				 
				 Set<Subscription> ss1=new HashSet<Subscription>();
				 ss1.add(s2);
				
				 Set<Reader> rr=new HashSet<Reader>();
				 rr.add(r);
				 rr.add(r1);
				// rr.add(r2);
				 //rr.add(r3);
				 
				 r.setSubscription(ss);
				 r1.setSubscription(ss1);
				 //r2.setSubscription(ss);
				// r3.setSubscription(ss);
				 
				 session.save(s);
				 session.save(s1);
				 session.save(s2);
				 
				 session.save(r);
				 //session.save(r1);
				 //session.save(r2);
				// session.save(r3);
				 
				 t.commit();
				 
	}
	
	public static void main(String[] args) {
		addRecord();
	}
}
