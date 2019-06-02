package pl.coderstrust.figures;

public class Triangle implements Figures {

    private double a;
    private double h;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    public Triangle(double a) {
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
        this.a = a;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
