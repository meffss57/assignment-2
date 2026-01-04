package models;

import java.util.List;

public class PaymentReport {

    public static double calculateTotal(List<Person> people) {
        double total = 0;
        for (Person p : people) {
            total += p.getPaymentAmount(); // polymorphic call
        }
        return total;
    }

    public static Person findTopEarner(List<Person> people) {
        if (people.isEmpty()) return null;

        Person top = people.get(0);
        for (Person p : people) {
            if (p.getPaymentAmount() > top.getPaymentAmount()) {
                top = p;
            }
        }
        return top;
    }

    public static double calculateAverage(List<Person> people) {
        if (people.isEmpty()) return 0;
        return calculateTotal(people) / people.size();
    }
}
