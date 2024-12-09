import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class people {
    public static List<Person> readPersonsFromFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .map(line -> {
                    String[] parts = line.split(":");
                    String name = parts[0].trim();
                    Integer number = parts.length > 1 ? Integer.parseInt(parts[1].trim()) : null;
                    return new Person(name, number);
                })
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<String>> processPersons(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getNumber() != null)
                .collect(Collectors.groupingBy(
                        Person::getNumber,
                        Collectors.mapping(
                                person -> capitalizeName(person.getName()),
                                Collectors.toList()
                        )
                ));
    }
    private static String capitalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}