package pl.coderstrust.figures;

public class Trapezoid implements Figure {

    private double a;
    private double b;
    private double h;

    public Trapezoid(double a, double b, double h) {
        if (a < 0 || b < 0 || h < 0) {
            throw new IllegalArgumentException("All values must be positive.");
        }
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return (a + b) * h / 2;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (b < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        if (h < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.h = h;
    }
}
