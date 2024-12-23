public class CachedValue {
    private Double cachedValue;
    private final Calculator calculator;

    public CachedValue(Calculator calculator) {
        this.calculator = calculator;
        this.cachedValue = null;
    }

    public interface Calculator {
        double calculate();
    }

    public double getValue() {
        if (cachedValue == null) {
            cachedValue = calculator.calculate();
        }
        return cachedValue;
    }

    public void reset() {
        cachedValue = null;
    }
}

