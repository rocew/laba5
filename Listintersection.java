import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Listintersection {
    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);
        List<T> intersection = new ArrayList<>();
        for (T item : set1) {
            if (set2.contains(item)) {
                intersection.add(item);
            }
        }
        return intersection;
    }
    public static <T> List<T> readList(Scanner scanner, String listName) {
        List<T> list = new ArrayList<>();
        System.out.println("Введите элементы списка " + listName + " (введите 'end' для завершения):");
        String input;
        do {
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("end")) {
                try {
                    list.add((T) Integer.valueOf(input));
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода. Введите число или 'end'.");
                }
            }
        } while (!input.equalsIgnoreCase("end"));
        return list;
    }
    }
