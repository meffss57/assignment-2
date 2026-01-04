import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyApplication {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Person> people = new ArrayList<>();

        Scanner empScanner = new Scanner(new File("src/source_employee.txt"));
        while (empScanner.hasNextLine()) {
            String line = empScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\s+");
            people.add(new Employee(
                    p[0], p[1], p[2],
                    Double.parseDouble(p[3])
            ));
        }
        empScanner.close();

        Scanner studScanner = new Scanner(new File("src/source_student.txt"));
        while (studScanner.hasNextLine()) {
            String line = studScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\s+");
            people.add(new Student(
                    p[0], p[1],
                    Double.parseDouble(p[2])
            ));
        }
        studScanner.close();

        Collections.sort(people);
        printData(people);

        double total = PaymentReport.calculateTotal(people);
        double average = PaymentReport.calculateAverage(people);
        Person top = PaymentReport.findTopEarner(people);

        System.out.printf("Total paid: %.2f tenge%n", total);
        System.out.printf("Average income: %.2f tenge%n", average);

        if (top != null) {
            System.out.println(
                    "Top earner: " + top +
                            " earns " + String.format("%.2f", top.getPaymentAmount()) + " tenge"
            );
        }
    }

    public static void printData(Iterable<Person> people) {
        for (Person p : people) {

            double payment = p.getPaymentAmount();

            System.out.println(
                    p.getClass().getSimpleName() + " -> " +
                            p + " earns " + String.format("%.2f", payment) + " tenge"
            );
        }
    }
}
