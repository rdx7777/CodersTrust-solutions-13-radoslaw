package pl.coderstrust.figures;

public class Circle implements Figure {

    private double r;

    public Circle(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.r = r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * r * r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.r = r;
    }
}
