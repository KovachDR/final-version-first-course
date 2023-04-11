import java.util.Objects;

public class Employee {
    private String name;
    private int department;
    private double salary;
    private int id;
    private static int counter = 0;

    public Employee(String name, int department, double salary) {
        counter++;
        this.id = counter;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Сотрудник по имени " + name + " из отдела № " + department +
                ", получает зарплату = " + salary +
                ", табельный номер - " + id;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public static int getCounter() {
        return counter;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
