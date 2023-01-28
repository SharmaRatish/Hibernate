package onetomany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.catalina.tribes.io.BufferPool;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hib.cdac.Employee;
import com.hib.cdac.HibernateUtil;
import com.hib.cdac.Person;

public class CompanyTask {
	
	public static void addRecord() {
		
		Session session=HibernateUtil.getSession();
 		Transaction t=session.beginTransaction();
 		Company c=new Company();
 		c.setCompanyname("AIRTEL");
 		Set<Customer> s=new HashSet<Customer>();
 		
 		Customer su=new Customer();
 		su.setAddress("Mumbai");
 		su.setName("Ratish");
 		s.add(su);
 		
 		Customer r=new Customer();
 		r.setAddress("Indore");
 		r.setName("Vinod");
 		s.add(r);
 		
 		
 		Customer ss=new Customer();
 		ss.setAddress("Malanpur");
 		ss.setName("Akash");
 		s.add(ss);
 		
 		
 		Customer ro=new Customer();
 		ro.setAddress("Gwalior");
 		ro
 		.setName("Abdesh");
 		s.add(ro);
 		
 		
 		c.setCustomer(s);
 		session.save(c);
 		t.commit();
 			
	}
	
//	public static void getCompanyByCritaria() {
//		Session session=HibernateUtil.getSession();
//		Transaction t=session.beginTransaction();
//		Criteria criteria=session.createCriteria(Company.class);
//		criteria.add(Restrictions.like("Companyname", "_a%"));
//		List<Company>list=criteria.list();
//		for (Company e: list)
//		{
//		System.out.println(e.getId()+":"+e.getCompanyname());	
//		}
//			t.commit();
//	}
//	public static void main(String[] args) {
////		addRecord();
////		getCompanyByCritaria();
//		
//		while (true) 
//		{
//			Scanner sc= new Scanner(System.in);
//			System.out.println("1 for add Record");
//			System.out.println("2 for Show Record");
//			System.out.println("3 for Exit");
//			
//			System.out.println("Enter your choise");
//			
//			int ch = Integer.parseInt(sc.nextLine());
//			
//switch (ch){
//			
//			case 1: {
//				addRecord();
//				break;
//			}
//			
//            case 2:{
//            	getCompanyByCritaria();
//            	break;
//            }
//            case 3: {
//				System.exit(0);
//				break;
//			}
//            
//			default:
//				break;
//			}
//			
//			
//			
//		}
//
//	}
	
//	static public void getCustomers() {
//		
// 		Session session=HibernateUtil.getSession();
// 		Transaction t=session.beginTransaction();
// 		Query q=session.createQuery("from Customer");
// 				
// 		List<Customer>customers =q.list();
// 		
//	for (Customer C: customers) {
//		System.out.println(C.getAddress()+" : "+C.getCid()+" : "+C.getName());
//					
//	}
//	t.commit();
//	
//}
	
	static public void getCustomers() {
		
 		Session session=HibernateUtil.getSession();
 		Transaction t=session.beginTransaction();
 		Query q=session.createQuery("from Company");
 				
 		List<Company>company =q.list();
 		
	for (Company c: company) 
	{
		Set<Customer> set=c.getCustomer();
		System.out.println("Company:"+c.getCompanyname());
		System.out.println("Customers:");
		for(Customer cc :set) {
			System.out.println(cc.getName()+" : "+cc.getAddress()+" : "+cc.getCid());
			
		}
		
					
	}
	t.commit();
	
}

	public static void main(String[] args) {
		
		addRecord();
		getCustomers();
		
	}
	
}
