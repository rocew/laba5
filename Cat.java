public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public String getName() {
        return name;
    }
}
