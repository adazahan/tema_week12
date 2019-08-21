import comparators.FirstNameComparator;
import comparators.LastNameComparator;
import domain.Person;
import service.PeopleApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        PeopleApp peopleApp = new PeopleApp();
        List<Person> people = peopleApp.readFile("files\\in\\inputFile");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\PROJECTS TEME SAU DE LA CURS\\tema_week12\\files\\out\\outputFile"));

        people.stream()
                .filter(s -> peopleApp.findMonth(s, 11))
                .sorted(new FirstNameComparator())
                .sorted(new LastNameComparator())
                .forEach(s -> {
                            String line = s.getFirstName() + " " + s.getLastName() + '\n';
                            try {
                                bufferedWriter.write(line);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
        bufferedWriter.close();

    }
}
