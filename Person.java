public class Person {
    private String name;
    private Integer number;

    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String toString() {
        return name + ":" + number;
    }
}