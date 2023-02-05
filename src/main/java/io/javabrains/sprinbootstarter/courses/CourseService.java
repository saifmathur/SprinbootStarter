package io.javabrains.sprinbootstarter.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	public CourseRepository courseRepo;
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic(1,"saif","mathur"), new Topic(2,"Spring Framework","Description"), new
	 * Topic(3,"Spring Framework","Description"), new
	 * Topic(4,"Spring Framework","Description") ) );
	 */
	
	public List<Course> getAllCourses(int topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepo.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	
	public Optional<Course> getCourse(int id) {
		//return topics.stream().filter(t -> t.getId()==id).findFirst().get();
		return courseRepo.findById(id);
	}
	
	
	public void addNewcourse(Course course) {
		//topics.add(topic);
		courseRepo.save(course);
	}
	
	
	
	  public void addMultipleCourses(Course[] courseInstanceFromRequestBody) {
		  for(Course c : courseInstanceFromRequestBody) {
			  courseRepo.save(c);
		  }
	  }
	 
	  public void updateCourse(Course newCourse) {
			/*
			 * for(int i=0; i<topics.size(); i++) { Topic t = topics.get(i); if(t.getId() ==
			 * idOdTopic) { topics.set(i, newTopic); return; } }
			 */
		  courseRepo.save(newCourse);
	  }


	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0; i<topics.size();i++) { Topic t = topics.get(i); if(t.getId() ==
		 * id) { topics.remove(i); return "removed"; } } return null;
		 */
		//topics.removeIf(t -> t.getId()==id);
		courseRepo.deleteById(id);
	}
	
}
