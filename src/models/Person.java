package models;

public abstract class Person implements Payable, Comparable<Person> {

    private static int id_gen = 1;

    protected int id;
    protected String name;
    protected String surname;

    public Person() {
        this.id = id_gen++;
    }

    public Person(String name, String surname) {
        this.id = id_gen++;
        this.setName(name);
        this.setSurname(surname);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }

    @Override
    public abstract double getPaymentAmount();

}
