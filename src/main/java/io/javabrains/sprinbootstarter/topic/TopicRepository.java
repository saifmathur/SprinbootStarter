package io.javabrains.sprinbootstarter.topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer>{
	
	@Query(value="SELECT * FROM course_db.topic WHERE id=3",nativeQuery = true)
	public Topic getSpecific();
	
	
	@Query(value = "SELECT * FROM course_db.topic WHERE MATCH(name, description) "
            + "AGAINST (?1)", nativeQuery = true)
	public List<Topic> searchString(String keyword);
}
