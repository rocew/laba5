import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.Scanner;
public class Main {
    public static <QueueFromList> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числитель и знаменатель для первой дроби:");
        int numerator1 = scanner.nextInt();
        int denominator1 = scanner.nextInt();
        scanner.nextLine();
        fraction f1 = new fraction(numerator1, denominator1);

        System.out.println("Введите числитель и знаменатель для второй дроби:");
        int numerator2 = scanner.nextInt();
        int denominator2 = scanner.nextInt();
        scanner.nextLine();
        fraction f2 = new fraction(numerator2, denominator2);

        System.out.println("Введите числитель и знаменатель для третьей дроби:");
        int numerator3 = scanner.nextInt();
        int denominator3 = scanner.nextInt();
        scanner.nextLine();
        fraction f3 = new fraction(numerator3, denominator3);

        System.out.println("\nВещественное значение первой дроби: " + f1.getDoubleValue());
        System.out.println("Вещественное значение второй дроби: " + f2.getDoubleValue());
        System.out.println("Вещественное значение третьей дроби: " + f3.getDoubleValue());

        fraction sumResult = f1.add(f2);
        fraction subtractResult = f1.subtract(f2);
        fraction multiplyResult = f1.multiply(f2);
        fraction divideResult = f1.divide(f2);

        System.out.println("\nПримеры операций с дробями:");
        System.out.println(f1 + " + " + f2 + " = " + sumResult);
        System.out.println(f1 + " - " + f2 + " = " + subtractResult);
        System.out.println(f1 + " * " + f2 + " = " + multiplyResult);
        System.out.println(f1 + " / " + f2 + " = " + divideResult);

        fraction complexResult = f1.add(f2).divide(f3).subtract(5);
        System.out.println("\nРезультат выражения f1.add(f2).divide(f3).subtract(5): " + complexResult);

        System.out.println("\nВведите новый числитель для первой дроби:");
        int newNumerator1 = scanner.nextInt();
        f1.setNumerator(newNumerator1);
        System.out.println("Введите новый знаменатель для первой дроби:");
        int newDenominator1 = scanner.nextInt();
        f1.setDenominator(newDenominator1);

        System.out.println("\nИзмененная первая дробь: " + f1);
        System.out.println("Вещественное значение измененной первой дроби: " + f1.getDoubleValue());
        sumResult = f1.add(f2);
        subtractResult = f1.subtract(f2);
        multiplyResult = f1.multiply(f2);
        divideResult = f1.divide(f2);
        System.out.println("\nПримеры операций с измененной первой дробью:");
        System.out.println(f1 + " + " + f2 + " = " + sumResult);
        System.out.println(f1 + " - " + f2 + " = " + subtractResult);
        System.out.println(f1 + " * " + f2 + " = " + multiplyResult);
        System.out.println(f1 + " / " + f2 + " = " + divideResult);
        complexResult = f1.add(f2).divide(f3).subtract(5);
        System.out.println("\nРезультат выражения f1.add(f2).divide(f3).subtract(5) с измененной первой дробью: " + complexResult);

        List<Cat> cats = new ArrayList<>();
        int numCats;
        System.out.print("Сколько котов вы хотите добавить? ");
        numCats = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numCats; i++) {
            System.out.print("Введите имя кота " + (i + 1) + ": ");
            String catName = scanner.nextLine();
            cats.add(new Cat(catName));
        }
        Funs.meowsCare(cats.toArray(new Meowable[0]));
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " мяукал: " + cat.getMeowCount() + " раз");

            Listintersection li = new Listintersection();
            List<Integer> l1 = li.readList(scanner, "L1");
            List<Integer> l2 = li.readList(scanner, "L2");
            List<Integer> l = li.intersect(l1, l2);
            System.out.println("Список пересечения: " + l);

            String filePath = "C:\\Users\\kokes\\Desktop\\ben2z.txt";
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                int n = Integer.parseInt(fileScanner.nextLine());
                System.out.println("Количество данных о стоимости бензина: " + n);
                Map<Integer, List<Integer>> brandPrices = new HashMap<>();
                brandPrices.put(92, new ArrayList<>());
                brandPrices.put(95, new ArrayList<>());
                brandPrices.put(98, new ArrayList<>());
                for (int i = 0; i < n; i++) {
                    String line = fileScanner.nextLine();
                    System.out.println("Считанные данные: " + line);
                    String[] parts = line.split(" ");
                    if (parts.length != 4) {
                        System.out.println("Неверный формат ввода. Пропустите эту запись.");
                        i--;
                        continue;
                    }
                    int brand = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    if (brand == 92 || brand == 95 || brand == 98)
                        brandPrices.get(brand).add(price);
                    else
                        System.out.println("Неверная марка бензина. Пропустите эту запись.");
                }
                Gas analyzer = new Gas(brandPrices);
                int[] result = analyzer.analyze();
                System.out.println("Количество АЗС, продающих дешевле всего:");
                System.out.println("92-й: " + result[0]);
                System.out.println("95-й: " + result[1]);
                System.out.println("98-й: " + result[2]);
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + e.getMessage());
            }

            String filePath2 = "C:\\Users\\kokes\\Desktop\\laba.txt";
            StringBuilder fileContent = new StringBuilder();
            try (Scanner fileScanner = new Scanner(new File(filePath2))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    fileContent.append(line).append("\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + e.getMessage());
                return;
            }
            System.out.println("Считанные данные:\n" + fileContent.toString());
            int uniqueLetterCount = Textt.countUniqueLetters(filePath2);
            if (uniqueLetterCount != -1) {
                System.out.println("Количество уникальных букв: " + uniqueLetterCount);

                if (!l.isEmpty()) {
                    Queue<Integer> queue = Queuebild.buildQueue(l);
                    System.out.println("Очередь, построенная по списку пересечения: " + queue);
                } else {
                    System.out.println("Список пересечения пуст. Очередь не построена.");
                }

                System.out.println("Введите количество точек:");
                int numPoints = scanner.nextInt();
                scanner.nextLine();
                List<point> points = new ArrayList<>();
                for (int i = 0; i < numPoints; i++) {
                    System.out.println("Введите координаты точки " + (i + 1) + " (x y):");
                    double x = scanner.nextDouble();
                    double y = scanner.nextDouble();
                    scanner.nextLine();
                    points.add(new point(x, y));
                }

                List<point> processedPoints = points.stream()
                        .distinct()
                        .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                        .map(p -> new point(p.getX(), Math.abs(p.getY())))
                        .collect(Collectors.toList());
                Polyline polyline = new Polyline();
                for (point point : processedPoints) {
                    polyline.addPoint(point);
                }
                System.out.println(polyline);

                String filePath4 = "C:\\Users\\kokes\\Desktop\\persons.txt";
                try {
                    List<Person> persons = people.readPersonsFromFile(filePath4);
                    System.out.println("Считанные данные:");
                    Files.lines(Paths.get(filePath4)).forEach(System.out::println);
                    Map<Integer, List<String>> groupedPersons = people.processPersons(persons);
                    System.out.println("\nРезультат группировки:");
                    groupedPersons.forEach((number, names) -> {
                        System.out.println(number + ": " + names);
                    });
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                }
            }
        }
    }
}