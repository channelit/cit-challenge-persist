package biz.cit.challenge.persist.web;

import biz.cit.challenge.persist.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.ExposesResourceFor;

@Controller
@RequestMapping("/person/{id}")
@ExposesResourceFor(Person.class)

public class PersonController {

}
