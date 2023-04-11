public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 50000));
        employeeBook.addEmployee(new Employee("Сергеев Сергей Сергеевич", 2, 55000));
        employeeBook.addEmployee(new Employee("Петров Пётр Петрович", 3, 60000));
        employeeBook.addEmployee(new Employee("Владимиров Владимир Владимирович", 4, 45000));
        employeeBook.addEmployee(new Employee("Николаев Николай Николаевич", 5, 65000));
        employeeBook.addEmployee(new Employee("Александров Александр Александрович", 1, 85000));
        employeeBook.addEmployee(new Employee("Семёнов Семён Семёнович", 2, 45000));
        employeeBook.addEmployee(new Employee("Алексеев Алексей Алексеевич", 3, 35000));
        employeeBook.addEmployee(new Employee("Максимов Максим Максимович", 4, 55000));
        employeeBook.addEmployee(new Employee("Антонов Антон Антонович", 5, 65000));
        employeeBook.removeEmployee(5);
        employeeBook.changeSalaryAndDepartmentEmployee("Иванов Иван Иванович", 77777, 3);
        employeeBook.printListEmployeesAllDepartments();
    }
}
