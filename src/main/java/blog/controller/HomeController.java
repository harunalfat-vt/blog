package blog.controller;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.mongo.initiator.MongoOperationsInitiator;
import blog.mongo.model.Person;

@Controller
public class HomeController {
    public static final String PERSON_COLLECTION = "Person";
	
    private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
    
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelMap map) throws UnknownHostException{
		
		mongoOperations.dropCollection(PERSON_COLLECTION);
		Person p = new Person(null, "Alfat", "Jkt pertama");
		mongoOperations.insert(p, PERSON_COLLECTION);
		
		Person p2 = mongoOperations.findOne(new Query(Criteria.where("name").is("Alfat")), Person.class, PERSON_COLLECTION);
		
		map.addAttribute("message", p2.getAddress());
		
		ModelAndView mav = new ModelAndView("index", map);
		
		return mav;
	}
	
}
