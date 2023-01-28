package com.hib.cdac;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hib.cdac.Department;
import com.hib.cdac.HibernateUtil;
import com.hib.cdac.Person;

public class PersonTask {
	
public static void addrecord() {
	Session session=HibernateUtil.getSession();
	Transaction t=session.beginTransaction();
	Scanner sc= new Scanner(System.in);
	Person p=new Person();
	System.out.println("enter person name");
	String pname=sc.nextLine();
	System.out.println("enter Department name");
	String department=sc.nextLine();
	System.out.println("enter person age");
	int age=Integer.parseInt(sc.nextLine());
	
	Department d=new Department();
	d.setDepartment(department);
	session.save(d);
	
	p.setAge(age);
	p.setPname(pname);
	
	p.setDepartment(d);
	session.save(p);
	t.commit();
}

 	static public void getPersons() {
 		Session session=HibernateUtil.getSession();
 		Transaction t=session.beginTransaction();
 		Query q=session.createQuery("from person");
 		List<Person>persons =q.list(); 
	for (Person P: persons) {
		System.out.println(P.getPid()+":"+P.getPname()+":"+P.getDepartment().getDepartment());
					
	}
	t.commit();
	
}
public static void main(String[] args) {
	addrecord();
	getPersons();
}
}
