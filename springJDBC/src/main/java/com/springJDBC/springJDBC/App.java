package com.springJDBC.springJDBC;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springJDBC.entity.Student;

import springJDBC.dao.StudentDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
      ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com/springJDBC/springJDBC/config.xml"); 
      StudentDaoImpl st = context.getBean("studentDao", StudentDaoImpl.class);
      
      Student student=new Student();
      student.setClg("IIT");
      student.setName("Sunil");
      student.setVillage("KHU");
      
      //insert
     int insert = st.insert(student);
     System.out.println("\n Data inserted :"+insert);
     
     //delete
     int delete = st.delete(1);
     System.out.println("\n Data deleted :"+delete);
     
     //get1row
     Student oneStudent = st.getStudentById(3);
     System.out.println("\n One Student :"+oneStudent +"\n");
     
     //getAllStudent
     List<Student> studentList = st.getAllStudent();
     for(Student stl:studentList) {
    	 System.out.println(stl);
     }
     
     
      context.close();
    }
}
