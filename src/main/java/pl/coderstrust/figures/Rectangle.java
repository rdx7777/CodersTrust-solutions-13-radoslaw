package pl.coderstrust.figures;

public class Rectangle implements Figures {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("All values must be positive.");
        }
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a * b;
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
}
