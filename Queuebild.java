import java.util.LinkedList;
import java.util.List;
public class Queuebild {
    public static java.util.Queue<String> buildQueue(List<String> intersection) {
        java.util.Queue<String> queue = new LinkedList<>();
        for (String element : intersection) {
            queue.add(element);
        }
        for (int i = intersection.size() - 1; i >= 0; i--) {
            queue.add(intersection.get(i));
        }
        return queue;
    }
}
