package com.softserve.edu;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.entity.Person;
import com.softserve.edu.service.PersonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    //@Test
    public void integrationTestDB() {
        // Precondition
        Person expectedPerson = new Person();
        expectedPerson.setPid(0);
        expectedPerson.setName("ivan");
        expectedPerson.setCity("SuperCity");
        Assertions.assertTrue(personService.addPerson(expectedPerson));
        //
        // Steps
        List<Person> actualPersons = personService.findByName("ivan");
        System.out.println("+++actualPersons.size() = " + actualPersons.size());
        Assertions.assertTrue(actualPersons.size() > 0);
        System.out.println("+++actualPersons.get(0) = " + actualPersons.get(0));
        Assertions.assertEquals(actualPersons.get(0).getName(),
                expectedPerson.getName());
    }

}