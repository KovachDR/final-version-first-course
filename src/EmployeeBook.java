public class EmployeeBook {
    private Employee[] employees;
    private int capacity;
    private int count = 0;

    public int getCount() {
        return count;
    }
    public EmployeeBook(int capacity) {
        this.capacity = capacity;
        employees = new Employee[capacity];
    }
    public void addEmployee(Employee employee){
        for (int i = 0; i < employees.length; i++){
            if (employees[i] == null){
                employees[i] = employee;
                count++;
                break;
            }
        }
    }
    public void removeEmployee(int id){
        for (int i = 0; i < employees.length; i++){
            if (employees[i] != null) {
                if (employees[i].getId() == id) {
                    employees[i] = null;
                    count--;
                }
            }
        }
    }
    public void changeSalaryAndDepartmentEmployee(String name, double changedSalary, int changedNumberDepartment){
        int falseCounter = 0;
        if (changedNumberDepartment < 1 || changedNumberDepartment > 5) {
            throw new IllegalArgumentException("Некорректно введён номер нового отдела. Введите значение от 1 до 5");
        }
        for (Employee employee : employees){
            if (employee != null){
                if (employee.getName().equals(name)){
                    employee.setSalary(changedSalary);
                    employee.setDepartment(changedNumberDepartment);
                }else {
                    falseCounter++;
                }
            }
        }
        if (falseCounter == getCount()){
            System.out.println("Сотрудник не найден. Проверьте корректность ввода данных.");
        }
    }
    public void printListEmployeesInDepartment (int numberDepartment){
        System.out.println("В отделе №" + numberDepartment + " трудятся: ");
        for (Employee employee : employees){
            if (employee != null){
                if (numberDepartment == employee.getDepartment()){
                    System.out.println(employee.getName());
                }
            }
        }
    }
    public void printListEmployeesAllDepartments(){
        for (int i = 1; i <= 5; i++){
            printListEmployeesInDepartment(i);
        }
    }
    public void printInfo(){
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public double calculationTotalSalary() {
        double totalSalaryInMonth = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaryInMonth = totalSalaryInMonth + employee.getSalary();
            }
        }
        return totalSalaryInMonth;
    }
    public double calculationAverageSalary(){
        return calculationTotalSalary() / getCount();

    }
    public Employee checkMinSalary () {
        Employee employeeWithMinSalary = null;
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }
    public Employee checkMaxSalary () {
        Employee employeeWithMaxSalary = null;
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }
    public void getNamesOfEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }
    public void delimiter() {
        System.out.println("///////////////////////////////////////////////////////");
    }
    public void indexSalary(double indexPercentage) {
        if (indexPercentage <= 0){
            throw new IllegalArgumentException("Введите в параметр значение больше нуля");
        }
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                newSalary = employee.getSalary() / 100 * indexPercentage + employee.getSalary();
                employee.setSalary(newSalary);
                System.out.println("Индексация зарплаты на " + indexPercentage + " % проведена. Теперь " + employee);
            }
        }
    }
    public Employee findMinSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        Employee employeeWithMinSalaryInDepartment = null;
        double minSalaryInDepartment = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null) {
                if (numberDepartment == employee.getDepartment() && minSalaryInDepartment > employee.getSalary()) {
                    minSalaryInDepartment = employee.getSalary();
                    employeeWithMinSalaryInDepartment = employee;
                }
            }
        }
        return employeeWithMinSalaryInDepartment;
    }
    public Employee findMaxSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        Employee employeeWithMaxSalaryInDepartment = null;
        double maxSalaryInDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (numberDepartment == employee.getDepartment() && maxSalaryInDepartment < employee.getSalary()) {
                    maxSalaryInDepartment = employee.getSalary();
                }
                employeeWithMaxSalaryInDepartment = employee;
            }
        }
        return employeeWithMaxSalaryInDepartment;
    }
    public double findTotalSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double totalSalaryInDepartment = 0;
        for (Employee employee : employees){
            if(employee != null) {
                if (numberDepartment == employee.getDepartment()) {
                    totalSalaryInDepartment = totalSalaryInDepartment + employee.getSalary();
                }
            }
        }
        return totalSalaryInDepartment;
    }
    public double findAverageSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double totalSalaryInDepartment = 0;
        double averageSalaryInDepartment;
        int quantityEmployeesInDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (numberDepartment == employee.getDepartment()) {
                    totalSalaryInDepartment = totalSalaryInDepartment + employee.getSalary();
                    quantityEmployeesInDepartment++;
                }
            }
        }
        if (quantityEmployeesInDepartment == 0) {
            return 0;
        }
        averageSalaryInDepartment = totalSalaryInDepartment / quantityEmployeesInDepartment;
        return averageSalaryInDepartment;
    }
    public void indexSalaryInDepartment (int numberDepartment , double indexPercentage){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён номер отдела. Введите значение от 1 до 5");
        }
        if (indexPercentage <= 0){
            throw new IllegalArgumentException("Введите в параметр процента индексации значение больше нуля");
        }
        double newSalary;
        for (Employee employee : employees){
            if (employee != null) {
                if (numberDepartment == employee.getDepartment()) {
                    newSalary = employee.getSalary() / 100 * indexPercentage + employee.getSalary();
                    employee.setSalary(newSalary);
                    System.out.println("Индексация зарплаты на " + indexPercentage + " % в отделе № "
                            + numberDepartment + " проведена. Теперь " + employee);
                }
            }
        }
    }
    public void printInfoEmployeesWithoutNumberDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён номер отдела. Введите значение от 1 до 5");
        }
        for (Employee employee : employees){
            if (employee != null) {
                if (numberDepartment == employee.getDepartment()) {
                    System.out.println("Сотрудник - " + employee.getName() + " с зарплатой " + employee.getSalary()
                            + ". Табельный номер - " + employee.getId());
                }
            }
        }
    }
    public void searchLowerPaidEmployees (int number){
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        }
        for (Employee employee : employees){
            if (employee != null) {
                if (number > employee.getSalary()) {
                    System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                            + employee.getName() + ". Зарплата " + employee.getSalary());
                }
            }
        }
    }
    public void searchBetterPaidEmployees (int number){
        if (number <= 0){
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        }
        for (Employee employee : employees){
            if (employee != null) {
                if (number <= employee.getSalary()) {
                    System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                            + employee.getName() + ". Зарплата " + employee.getSalary());
                }
            }
        }
    }
}
