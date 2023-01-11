package pl.szymonjedrzejewski.springboot.projekt1.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt1.entity.Student;

public interface StudentService {
	
	public List <Student> findAll();
	
	public Student findById (int theId);
	
	public void save (Student theStudent);
	
	public void deleteById (int theId);
}
