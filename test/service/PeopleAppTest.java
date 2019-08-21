package service;

import domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PeopleAppTest {
    private PeopleApp peopleApp;
    private Person person;
    private List<Person> people;

    @Test
    public void testReadFileIsOk() {
        PeopleApp peopleApp = new PeopleApp();
        List<Person> people = peopleApp.readFile("files\\in\\inputFile");
        assertEquals(people.size(), 7);
    }

    @Test
    public void testFindMonth() {
        PeopleApp peopleApp = new PeopleApp();
        List<Person> people = peopleApp.readFile("files\\in\\inputFile");
        boolean found = peopleApp.findMonth(people.get(2), 04);
        assertTrue(found);
    }

}