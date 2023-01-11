package pl.szymonjedrzejewski.springboot.projekt1.dao;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt1.entity.Student;

public interface StudentDAO {
	
	public List <Student> findAll();
	
	public Student findById (int theId);
	
	public void save (Student theStudent);
	
	public void deleteById (int theId);
}
