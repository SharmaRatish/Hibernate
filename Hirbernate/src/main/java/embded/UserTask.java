package embded;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.HibernateUtil;

public class UserTask {
	
	public static void addRecord() {
		
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Jldi Apna Naam Daal");
		 String name=sc.nextLine();
		 
		 System.out.println("Ab Coutory Bta");
		 String contory=sc.nextLine();
		 
		 System.out.println("Ab State Bta");
		 String State =sc.nextLine();
		 
		 System.out.println("Ab City Bta");
		 String city=sc.nextLine();
		 
		 System.out.println("Ab Street Bta");
		 String street=sc.nextLine();
		 
		 
		 System.out.println("Ab PinCode Bta");
		 int pincode=Integer.parseInt(sc.nextLine()) ;
		 
		 System.out.println("Ab House no. Bta");
		 String house_no=sc.nextLine();
		 
		 
		 Address add=new Address();
		 
		 add.setContory(contory);
		 add.setState(State);
		 add.setCity(city);
		 add.setPincode(pincode);
		 add.setState(State);
		 add.setHouse_no(house_no);
		 
		 User u= new User();
		 
		 u.setName(name);
		 u.setAddress(add);
		 session.save(u);
		 
		 t.commit();		
	}
	
	public static void updateRecord() {
		
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your ID");
		int id=sc.nextInt();
		
		Query q=session.createQuery("form User u where u.uid=:id");
		
		q.setParameter("id", q);
		List<User> list=q.list();
		System.out.println(list.size());
		t.commit();
	}
	
	public static void getAll() {
		
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		List<User> l=session.getNamedNativeQuery("ALL_USER").list();
		
	}

	public static void main(String[] args) {
		addRecord();

	}

}
