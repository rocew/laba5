import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Listintersection {

    public static List<String> intersect(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        List<String> intersection = new ArrayList<>();
        for (String item : set1) {
            if (set2.contains(item)) {
                intersection.add(item);
            }
        }
        return intersection;
    }

    public static List<String> readList(Scanner scanner, String listName) {
        List<String> list = new ArrayList<>();
        System.out.println("Введите элементы списка " + listName + " (введите пустую строку для завершения):");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            list.add(input);
        }
        return list;
    }
}
