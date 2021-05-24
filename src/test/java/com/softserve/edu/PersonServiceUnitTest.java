package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.softserve.edu.entity.Person;
import com.softserve.edu.repository.PersonRepository;
import com.softserve.edu.service.impl.PersonServiceImpl;

public class PersonServiceUnitTest {
    
    //@Test
    public void unitTestDB() {
        // Precondition
        List<Person> expectedPersons = new ArrayList<>();
        Person testPerson = new Person();
        testPerson.setPid(0);
        testPerson.setName("SuperStepan");
        testPerson.setCity("SuperCity");
        expectedPersons.add(testPerson);
        //
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        Mockito.when(personRepository.findByName("ivan")).thenReturn(expectedPersons);
        PersonServiceImpl personService = new PersonServiceImpl(personRepository);
        //
        // Steps
        List<Person> actualPersons = personService.findByName("ivan");
        System.out.println("***actualPersons.size() = " + actualPersons.size());
        Assertions.assertTrue(actualPersons.size() > 0);
        System.out.println("***actualPersons.get(0) = " + actualPersons.get(0));
        Assertions.assertEquals(actualPersons.size(), expectedPersons.size());
        Assertions.assertEquals(actualPersons.get(0).getName(),
                expectedPersons.get(0).getName());
    }
}
