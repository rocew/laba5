public class Funs {
    public static int[] meowsCare(Meowable... meowables) {
        int[] meowCounts = new int[meowables.length];
        for (int i = 0; i < meowables.length; i++) {
            meowables[i].meow();
            meowCounts[i]++;
        }
        return meowCounts;
    }
}

