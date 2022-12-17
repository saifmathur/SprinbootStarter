package io.javabrains.sprinbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1,"saif","mathur"),
			new Topic(2,"Spring Framework","Description"),
			new Topic(3,"Spring Framework","Description"),
			new Topic(4,"Spring Framework","Description")
			)
		);
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	
	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId()==id).findFirst().get();
	}
	
	
	public void addNewTopic(Topic topic) {
		topics.add(topic);
	}
	
	
	
	  public void addMultipleTopics(Topic[] topicInstanceFromRequestBody) {
		  for(Topic t : topicInstanceFromRequestBody) {
			  topics.add(t);
		  }
	  }
	 
	  public void update(int idOdTopic, Topic newTopic) {
		  for(int i=0; i<topics.size(); i++) {
			  Topic t = topics.get(i);
			  if(t.getId() == idOdTopic) {
				  topics.set(i, newTopic);
				  return;
			  }
		  }
	  }
	
}
