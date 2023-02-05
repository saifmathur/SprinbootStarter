package io.javabrains.sprinbootstarter.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.sprinbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	/* GET ALL */
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllTopics(@PathVariable int topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	
	
	/* GET BY ID */
	@RequestMapping("/getCourse/{id}")
	public Optional<Course> getTopic(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	
	/* ADD NEW TOPIC */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addNewcourse(course);
	}
	
	
	/* ADD MULTIPLE TOPICS */
	@RequestMapping(method=RequestMethod.POST, value="/addCourses")
	public void addMultipleTopics(@RequestBody Course[] courseArray) {
		courseService.addMultipleCourses(courseArray);
	}
	
	
	/* UPDATE TOPIC */
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	/* DELETE TOPIC */
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteCourse/{id}")
	public void deleteTopic(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
	
}
