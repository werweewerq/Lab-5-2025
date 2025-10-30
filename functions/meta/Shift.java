package functions.meta;
import functions.Function;

public class Shift implements Function {
    private Function f;
    private double shiftX;
    private double shiftY;

    public Shift(Function f, double shiftX, double shiftY) {
        this.f = f;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
    }

    public double getLeftDomainBorder() {
        return f.getLeftDomainBorder() + shiftX;
    }

    public double getRightDomainBorder() {
        return f.getRightDomainBorder() + shiftX;
    }

    public double getFunctionValue(double x) {
        if (x < getLeftDomainBorder() || x > getRightDomainBorder())
            return Double.NaN;
        return f.getFunctionValue(x) + shiftY;
    }
}