import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Textt {
    public static int countUniqueLetters(String filePath) {
        Set<Character> uniqueLetters = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        uniqueLetters.add(c);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден: " + e.getMessage());
            return -1;
        }
        return uniqueLetters.size();
    }
}


