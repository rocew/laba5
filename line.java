public class line {
    private point start;
    private point end;
    public line(point start, point end) {
        this.start = start;
        this.end = end;
    }

    public point getStart() {
        return start;
    }

    public void setStart(point start) {
        this.start = start;
    }

    public point getEnd() {
        return end;
    }

    public void setEnd(point end) {
        this.end = end;
    }

    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}

