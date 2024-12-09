public class Funs {
    public static void meowsCare(Meowable... meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}