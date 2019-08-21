package service;

import domain.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PeopleApp {
    List<Person> people;

    public List<Person> readFile(String fileName) {
        List<Person> people = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Person person = createPerson(attributes);
                people.add(person);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        return people;
    }

    public static Person createPerson(String[] metadata) {
        String firstName = metadata[0];
        String lastName = metadata[1];
        String dateOfBirth = metadata[2];

        return new Person(firstName, lastName, dateOfBirth);
    }


    public boolean findMonth(Person person, int month) {

        String[] tokens = person.getDateOfBirth().split("-");

        int m = Integer.parseInt(tokens[1]);

        return m == month;

    }

}
