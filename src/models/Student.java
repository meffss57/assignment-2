package models;

public class Student extends Person {

    private double gpa;
    private static final double STIPEND = 36660.00;

    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.setGpa(gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public double getPaymentAmount() {
        if (gpa > 2.67) {
            return STIPEND;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
