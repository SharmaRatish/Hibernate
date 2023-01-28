package com.hib.cdac;

import java.util.Scanner;
 import org.hibernate.query.*;

import net.bytebuddy.asm.Advice.Enter;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import java.util.List;



public class EmployeeTask {
	
	
	static void addrrcord() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Address");
		String add=sc.nextLine();
		
		System.out.println("Enter Mobile");
		String mobile=sc.nextLine();
		
		Employee e= new Employee();
		e.setEmpaddress(add);
		e.setEmpmobile(mobile);
		e.setEmpname(name);
		session.save(e);
		t.commit();
		System.out.println("Detail saved");
		
	}
	
	static public void getEmployee() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Query q=session.createQuery("from employee");
		List<Employee>emp =q.list(); 
		for (Employee e: emp) {
			System.out.println(e.getId()+":"+e.getEmpname()+":"+e.getEmpaddress());
						
		}
		t.commit();
		
	}

	static void getEmployeeById() 
	{
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the employee id you want to search");
		int eid=sc.nextInt();
		Query q=session.createQuery("from Employee where e.id=:id");
		q.setParameter("id", eid);
		List<Employee>list=q.list();
		for (Employee e: list)
		{
			System.out.println("Name ="+e.getEmpname());
			System.out.println("Address ="+e.getEmpaddress());
			System.out.println("Mobile ="+e.getEmpmobile());
		}
		
	}
	
	public static void deleteEmployeeById() {
		
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Employee Id that you want delete");
		int eid=scanner.nextInt();
		Query q=session.createQuery("from employee e where e.id=:id");
		q.setParameter("id", eid);
		List<Employee>list=q.list();
		if(list.size()>0) {
			Employee e=list.get(0);
			session.delete(e);
		}
		else {
			System.out.println("No Data Found");
		}
		t.commit();
		
	}
	
	public static void getEmployeeByCritaria() {
		Session session=HibernateUtil.getSession();
		Transaction t=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("empname", "_a%"));
		List<Employee>list=criteria.list();
		for (Employee e: list)
		{
		System.out.println(e.getId()+":"+e.getEmpname()+":"+e.getEmpaddress());	
		}
			t.commit();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				addrrcord();
				
				while (true) 
				{
					Scanner sc= new Scanner(System.in);
					System.out.println("1 for add Record");
					System.out.println("2 for Show Record");
					System.out.println("3 for Delete Record");
					System.out.println("4 for Search Record");
					System.out.println("5 for Exit");
					
					System.out.println("Enter your choise");
					
					int ch = Integer.parseInt(sc.nextLine());
					
switch (ch){
					
					case 1: {
						addrrcord();
						break;
					}
					case 2: {
						getEmployee();
						break;
					}
                    case 3: {
						
                    	deleteEmployeeById();
						break;
					}
                    case 4: {
						
                    	getEmployeeById();
						break;
					}
                    case 5:{
                    	getEmployeeByCritaria();
                    	break;
                    }
                    case 6: {
						System.exit(0);
						break;
					}
                    
					default:
						break;
					}
					
					
					
				}
	}
	
	
	

}
