import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        sc.nextLine();
        sc.next(

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine();

            int firstQuote = line.indexOf("\"");
            int lastQuote = line.lastIndexOf("\"");

            if (firstQuote != -1 && lastQuote != -1) {
                String typeCode = line.substring(0, firstQuote).trim();
                String name = line.substring(firstQuote + 1, lastQuote);
                String remain = line.substring(lastQuote + 1).trim();
                String[] values = remain.split("\\s+");

                if (typeCode.equals("F")) {
                    double base = Double.parseDouble(values[0]);
                    double bonus = Double.parseDouble(values[1]);
                    double penalty = Double.parseDouble(values[2]);
                    employees[i] = new FullTimeEmployee(name, "", "", base, bonus, penalty);
                } else if (typeCode.equals("P")) {
                    double hours = Double.parseDouble(values[0]);
                    double rate = Double.parseDouble(values[1]);
                    employees[i] = new PartTimeEmployee(name, "", "", hours, rate);
                }
            }
        }

        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.getName() + " - " + emp.getType() + " - " + emp.calculateSalary());
            }
        }

        sc.close();
    }
}
