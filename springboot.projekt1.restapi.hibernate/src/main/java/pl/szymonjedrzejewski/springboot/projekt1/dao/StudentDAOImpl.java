package pl.szymonjedrzejewski.springboot.projekt1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt1.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	// define field for EntityManager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List <Student> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query <Student> theQuery = currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List <Student> students = theQuery.getResultList();
		
		// return the results
		return students;
	}

	@Override
	public Student findById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the student
		Student theStudent = currentSession.get(Student.class, theId);
		
		// return the student
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save the student
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query <?> theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();
	}
}
