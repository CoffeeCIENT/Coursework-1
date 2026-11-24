public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    public double calcAverageSalary() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) break;
            sum = employees[i].getSalary() + sum;
            count++;
        }
        if (count == 0) return 0;
        return (double) sum / count;
    }

    public void printTaxes(String taxesType) {
        if (!taxesType.equals("PROPORTIONAL") && !taxesType.equals("PROGRESSIVE")) {
            System.out.println("Некорректный тип налога");
            return;
        }
        for (Employee emp : employees) {
            if (emp == null) break;
            int salary = emp.getSalary();
            double taxes = 0;
            switch (taxesType) {
                case "PROPORTIONAL":
                    taxes = salary * 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) {
                        taxes = salary * 0.13;
                    } else if (salary <= 350) {
                        taxes = salary * 0.17;
                    } else {
                        taxes = salary * 0.21;
                    }
                    break;
            }
            System.out.println("Налог сотрудника " + emp.getFullName() + " по системе " + taxesType + ", составляет: " + taxes);
        }
    }

    public void salaryIndexing(int dept, double percent) {
        if (dept < 1 || dept > 5) {
            System.out.println("Отдела не существует");
            return;
        }
        for (Employee emp : employees) {
            if (emp == null) break;
            if (dept != emp.getDepartment()) continue;
            double calcSalary = emp.getSalary() * (1 + percent / 100.0);
            int newSalary = (int) Math.round(calcSalary);
            emp.setSalary(newSalary);
        }
    }

    public void higherSalary(int dept, int sal) {
        if (dept < 1 || dept > 5) {
            System.out.println("Отдела не существует");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) break;
            if (dept != employees[i].getDepartment()) continue;
            if (employees[i].getSalary() > sal) {
                System.out.println("Порядковый номер: " + i);
                employees[i].printShortInfo();
                break;
            }
        }
    }

    public void firstScarceSalary(int wage, int employeeNumber) {
        int i = 0;
        int alreadyFound = 0;
        while (i < employees.length) {
            if (employees[i] == null) break;
            if (employeeNumber <= 0) return;
            if (employees[i].getSalary() < wage) {
                System.out.println(employees[i] + " имеет зарплату меньше заданной: " + wage);
                alreadyFound++;
                if (alreadyFound == employeeNumber) break;
            }
            i++;
        }
    }

    public boolean employeeAccounting(Employee targetEmployee) {
        if (targetEmployee == null) return false;
        for (Employee emp : employees) {
            if (emp == null) break;
            if (emp.equals(targetEmployee)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    public Employee findByID(int thisID) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == thisID) {
                return employee;
            }
        }
        return null;
    }
}
