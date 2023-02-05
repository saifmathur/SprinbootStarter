package io.javabrains.sprinbootstarter.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	
	public List<Course> findByName(String topicName);
	public List<Course> findByDescription(String description);
	public List<Course> findByTopicId(int topicId);
	

	
	
}
