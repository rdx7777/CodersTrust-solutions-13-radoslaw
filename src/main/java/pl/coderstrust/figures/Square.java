package pl.coderstrust.figures;

public class Square implements Figure {

    private double a;

    public Square(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a * a;
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
}
