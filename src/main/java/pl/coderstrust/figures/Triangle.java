package pl.coderstrust.figures;

public class Triangle implements Figure {

    private double a;
    private double h;

    public Triangle(double a, double h) {
        if (a < 0 || h < 0) {
            throw new IllegalArgumentException("All values must be positive.");
        }
        this.a = a;
        this.h = h;
    }

    public Triangle(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.a = a;
    }

    @Override
    public double calculateArea() {
        if (h != 0) {
            return a * h / 2;
        }
        return 0.25 * Math.sqrt(3.0) * a * a;
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
