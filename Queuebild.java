import java.util.LinkedList;
import java.util.List;
public class Queuebild {
    public static java.util.Queue<Integer> buildQueue(List<Integer> intersection) {
        java.util.Queue<Integer> queue = new LinkedList<>();
        for (Integer element : intersection) {
            queue.add(element);
        }
        for (int i = intersection.size() - 1; i >= 0; i--) {
            queue.add(intersection.get(i));
        }
        return queue;
    }
}
