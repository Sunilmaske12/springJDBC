package springJDBC.dao;

import java.util.List;

import com.springJDBC.entity.Student;

public interface StudentDao {
	
	 public int insert(Student student); 
	 
	 public int delete(int id);
	 
	 public int update(int id);
	 
	 public Student getStudentById(int id);
	 
	 public List<Student> getAllStudent();
}
