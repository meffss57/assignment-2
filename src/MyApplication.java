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

            String[] parts = line.split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            String position = parts[2];
            double salary = Double.parseDouble(parts[3]);

            people.add(new Employee(name, surname, position, salary));
        }
        empScanner.close();

        Scanner studScanner = new Scanner(new File("src/source_student.txt"));
        while (studScanner.hasNextLine()) {
            String line = studScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            double gpa = Double.parseDouble(parts[2]);

            people.add(new Student(name, surname, gpa));
        }
        studScanner.close();

        Collections.sort(people);
        printData(people);
    }

    public static void printData(Iterable<Person> people) {
        for (Person p : people) {
            System.out.printf(
                    "%s earns %.2f tenge%n",
                    p,
                    p.getPaymentAmount()
            );
        }
    }
}
