public class Employee {

    private final String fullName;
    private int department;
    private int salary;
    private final int id;
    private static int count;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = count++;
    }

    public String getFullName() {return fullName;}

    public int getDepartment() {return department;}

    public void setDepartment(int department) {this.department = department;}

    public int getSalary() {return salary;}

    public void setSalary(int salary) {this.salary = salary;}

    public int getId() {return id;}

    public static int getCount() {return count;}

    public void printShortInfo() {
        System.out.println("ФИО-" + this.fullName + ", ЗП-" + this.salary);
    }

    @Override
    public String toString() {
        return "Сотрудник: ID-" + this.id + ", ФИО-" + this.fullName + ", ЗП-" + this.salary + ", отдел-" + this.department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        if (this.salary == employee.salary) return true;
        return false;
    }
}
