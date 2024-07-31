package DSAExercise4;
public class EmployeeManagementSystem {

    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getEmployeeId() { return employeeId; }
        public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        @Override
        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
        }
    }

    public static class ManagementSystem {
        private Employee[] employeeArray;
        private int count;
        private static final int INITIAL_SIZE = 10;

        public ManagementSystem() {
            this.employeeArray = new Employee[INITIAL_SIZE];
            this.count = 0;
        }

        public void addEmployeeToSystem(Employee employee) {
            if (count == employeeArray.length) {
                expandCapacity();
            }
            employeeArray[count++] = employee;
        }

        public Employee findEmployee(String employeeId) {
            for (int i = 0; i < count; i++) {
                if (employeeArray[i].getEmployeeId().equals(employeeId)) {
                    return employeeArray[i];
                }
            }
            return null;
        }

        public void listAllEmployees() {
            for (int i = 0; i < count; i++) {
                System.out.println(employeeArray[i]);
            }
        }

        public void removeEmployee(String employeeId) {
            int index = -1;
            for (int i = 0; i < count; i++) {
                if (employeeArray[i].getEmployeeId().equals(employeeId)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < count - 1; i++) {
                    employeeArray[i] = employeeArray[i + 1];
                }
                employeeArray[count - 1] = null;
                count--;
            }
        }

        private void expandCapacity() {
            int newCapacity = employeeArray.length * 2;
            Employee[] expandedArray = new Employee[newCapacity];
            System.arraycopy(employeeArray, 0, expandedArray, 0, count);
            employeeArray = expandedArray;
        }
    }

    public static void main(String[] args) {
        ManagementSystem ms = new ManagementSystem();

        ms.addEmployeeToSystem(new Employee("E101", "Ravi Kumar", "Team Lead", 80000));
        ms.addEmployeeToSystem(new Employee("E102", "Sita Patel", "Software Engineer", 70000));
        ms.addEmployeeToSystem(new Employee("E103", "Arjun Sharma", "Business Analyst", 60000));

        System.out.println("Employee Records:");
        ms.listAllEmployees();

        System.out.println("\nLooking up employee with ID E102:");
        Employee employee = ms.findEmployee("E102");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nRemoving employee with ID E103.");
        ms.removeEmployee("E103");

        System.out.println("\nUpdated Employee Records:");
        ms.listAllEmployees();
    }
}
