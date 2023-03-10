package io.javabrains.sprinbootstarter.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	public TopicRepository topicRepo;
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic(1,"saif","mathur"), new Topic(2,"Spring Framework","Description"), new
	 * Topic(3,"Spring Framework","Description"), new
	 * Topic(4,"Spring Framework","Description") ) );
	 */
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}
	
	
	public Optional<Topic> getTopic(int id) {
		//return topics.stream().filter(t -> t.getId()==id).findFirst().get();
		return topicRepo.findById(id);
	}
	
	
	public void addNewTopic(Topic topic) {
		//topics.add(topic);
		topicRepo.save(topic);
	}
	
	
	
	  public void addMultipleTopics(Topic[] topicInstanceFromRequestBody) {
		  for(Topic t : topicInstanceFromRequestBody) {
			  topicRepo.save(t);
		  }
	  }
	 
	  public void update(int idOdTopic, Topic newTopic) {
			/*
			 * for(int i=0; i<topics.size(); i++) { Topic t = topics.get(i); if(t.getId() ==
			 * idOdTopic) { topics.set(i, newTopic); return; } }
			 */
		  topicRepo.save(newTopic);
	  }


	public void delete(int id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0; i<topics.size();i++) { Topic t = topics.get(i); if(t.getId() ==
		 * id) { topics.remove(i); return "removed"; } } return null;
		 */
		//topics.removeIf(t -> t.getId()==id);
		topicRepo.deleteById(id);
	}
	
	
	public Topic getSpecific() {
		return topicRepo.getSpecific();
	}
	
	public List<Topic> search(String keyword) {    
        return topicRepo.searchString(keyword);
	}
}
