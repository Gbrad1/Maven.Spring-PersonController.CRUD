package io.zipcoder.crudapp.service;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository pr;

    @Autowired
    public PersonService(PersonRepository pr) {
        this.pr = pr;
    }

    public Person create(Person p) {
        return pr.save(p);
    }

    public Person show(Long id) {
        return pr.findOne(id);
    }

    public Iterable<Person> index() {
        return pr.findAll();
    }

    public Person update(Long id, Person p) {
        Person originalPerson = pr.findOne(id);
        originalPerson.setFirstName(p.getFirstName());
        originalPerson.setLastName(p.getLastName());
        originalPerson.setId(p.getId());
        return pr.save(p);
    }

    public boolean delete(Long id) {
        pr.delete(id);
        return true;
    }

}
