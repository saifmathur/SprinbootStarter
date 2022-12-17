package io.javabrains.sprinbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	/* GET ALL */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	
	
	/* GET BY ID */
	@RequestMapping("/getTopic/{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	
	/* ADD NEW TOPIC */
	@RequestMapping(method=RequestMethod.POST, value="/addTopic")
	public void addTopic(@RequestBody Topic topicInstanceFromRequestBody) {
		topicService.addNewTopic(topicInstanceFromRequestBody);
	}
	
	
	/* ADD MULTIPLE TOPICS */
	@RequestMapping(method=RequestMethod.POST, value="/addTopics")
	public void addMultipleTopics(@RequestBody Topic[] topicArray) {
		topicService.addMultipleTopics(topicArray);
	}
	
	
	/* UPDATE TOPIC */
	@RequestMapping(method=RequestMethod.PUT, value="/updateTopic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
		topicService.update(id, topic);
	}
	
	
	
}
