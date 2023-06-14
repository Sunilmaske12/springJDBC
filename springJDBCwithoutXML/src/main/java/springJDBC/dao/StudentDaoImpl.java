package springJDBC.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springJDBC.entity.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	
	public StudentDaoImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String insert="insert into StudentDetails (Name, Clg, Village) values (?,?,?)";
		int result = this.jdbcTemplate.update(insert, student.getName(), student.getClg(), student.getVillage() );
		return result;
	}

	public int delete(int id) {
		String delete="delete from StudentDetails where id=?";
		int result = this.jdbcTemplate.update(delete, id);
		return result;
	}

	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Student getStudentById(int id) {
		String select1 = "select * from StudentDetails where id=?";
		RowMapper<Student> rm=new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(select1, rm, id);
		return student;
	}

	public List<Student> getAllStudent() {
        String selectAll = "select * from StudentDetails";
        RowMapper<Student> rm=new RowMapperImpl();
		List<Student> student = this.jdbcTemplate.query(selectAll, rm );
		return student;
	}

}
