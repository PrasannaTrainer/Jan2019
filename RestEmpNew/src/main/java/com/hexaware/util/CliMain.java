package com.hexaware.util;
import com.hexaware.factory.EmployFactory;
import com.hexaware.model.Employ;
import java.util.List;
import java.util.Scanner;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
 public class CliMain {
     public static void main(String[] args) {
         Employ[] lstEmploy=EmployFactory.showEmploy();
         for(Employ e : lstEmploy) {
             System.out.println(e);
         }
         //Runtime.getRuntime().halt(0);
     
     Employ employ = new Employ();
     Scanner option = new Scanner(System.in);
     System.out.println("Enter Employ No  ");
     employ.setEmpno(option.nextInt());
     System.out.println("Enter Name  ");
     employ.setName(option.next());
     System.out.println("Enter Department  ");
     employ.setDept(option.next());
     System.out.println("Enter Designation ");
     employ.setDesig(option.next());
     System.out.println("Enter Salary  ");
     employ.setBasic(option.nextInt());
     System.out.println(EmployFactory.addEmploy(employ));
     Runtime.getRuntime().halt(0);
 }
 }