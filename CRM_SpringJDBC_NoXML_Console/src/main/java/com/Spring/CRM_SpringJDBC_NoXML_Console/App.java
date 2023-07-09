package com.Spring.CRM_SpringJDBC_NoXML_Console;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configuration.Config;
import dao.CustomerDao;
import entity.Customer;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CustomerDao cd = context.getBean("getCustomerDao", CustomerDao.class);
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Operation(type 1 or 2 or 3 ) : \n 1.insert \n 2.delete \n 3.get");
         int operation = sc.nextInt();
        switch(operation) {
        case 1: insert(sc, cd);
        	break;
        case 2: delete(sc, cd);
        	break;
        case 3: get(sc, cd);
        	break;
        default: error();
        }
        
        System.out.println("================================================================");
       List<Customer> allCustomer = cd.getAll();
       for(Customer c: allCustomer) {
    	   System.out.println(c);
       }
       System.out.println("================================================================");
      System.out.println("\nprogram end!");
        sc.close();
        ((AbstractApplicationContext) context).close();
    }

	private static void error() {
		System.out.println("invalid input");
		
	}

	private static void get(Scanner sc, CustomerDao cd) {
		System.out.println("Enter id:");
		int id = sc.nextInt();
		Customer r = cd.getCustomer(id);
		System.out.println(r);
	}

	private static void delete(Scanner sc, CustomerDao cd) {
		System.out.println("Enter id for delete row"); 
		int id=sc.nextInt();
	        int d = cd.delete(id);
	        System.out.println("deleted row : "+d);
		
	}

	private static void insert(Scanner sc, CustomerDao cd) {
		 System.out.println("Enter id :");
	        int id1=sc.nextInt();
	        System.out.println("Enter name :");
	        String name= sc.next();
	        System.out.println("Enter village :");
	        String village = sc.next();
	        
	        Customer c=new Customer(id1, name, village);
	        
	        int r = cd.insert(c);
	        System.out.println("row inserted :"+r);
		
	}
}
