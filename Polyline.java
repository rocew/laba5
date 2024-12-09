import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public void addPoint(point point) {
        points.add(point);
    }

    public List<point> getPoints() {
        return points;
    }

    public String toString() {
        return "Линия " + points;
    }
}
