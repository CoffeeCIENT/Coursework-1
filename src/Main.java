//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Проверка пустой и частично пустой книги:");

        EmployeeBook emptyBook = new EmployeeBook();
        int iEmpt = 1;
        System.out.println("Поиск по ID " + iEmpt + ": " + emptyBook.findByID(iEmpt));
        System.out.println("Средняя ЗП: " + emptyBook.calcAverageSalary());

        emptyBook.addEmployee("И", 1, 350);
        emptyBook.addEmployee("Шуань-шуань", 3, 150);
        System.out.println("Средняя ЗП (частично пустая книга): " + emptyBook.calcAverageSalary());
        emptyBook.printTaxes("PROGRESSIVE");

        System.out.println();
        System.out.println("Проверка полной книги:");

        EmployeeBook employeeBook1 = new EmployeeBook();

        System.out.println(employeeBook1.addEmployee("Бажен", 1, 110));
        System.out.println(employeeBook1.addEmployee("Милава", 1, 130));
        System.out.println(employeeBook1.addEmployee("Тит", 1, 120));
        System.out.println(employeeBook1.addEmployee("Октавий", 2, 60));
        System.out.println(employeeBook1.addEmployee("Ливия", 2, 54));
        System.out.println(employeeBook1.addEmployee("Астрид", 3, 250));
        System.out.println(employeeBook1.addEmployee("Сигрид", 2, 65));
        System.out.println(employeeBook1.addEmployee("Лира", 3, 240));
        System.out.println(employeeBook1.addEmployee("Рагнар", 2, 72));
        System.out.println(employeeBook1.addEmployee("Цицерон", 4, 188));
        System.out.println(employeeBook1.addEmployee("Юния", 2, 70));

        System.out.println("-- Список сотрудников:");
        employeeBook1.printAllEmployees();

        System.out.println("-- Поиск сотрудника по ID:");
        int id0 = 5;
        int idNull = 50;
        System.out.println("Поиск ID " + id0 + ": " + employeeBook1.findByID(id0));
        System.out.println("Поиск недействительного ID " + idNull + ": " + employeeBook1.findByID(idNull));

        System.out.println("-- Средняя зарплата по компании:");
        System.out.println(employeeBook1.calcAverageSalary());

        int d1 = 1;
        int s1 = 110;
        System.out.println("-- Первый сотрудник по зарплате - В отделе " + d1 + " с ЗП выше " + s1);
        employeeBook1.higherSalary(d1, s1);

        int q2 = 2;
        int s2 = 100;
        System.out.println("-- Первые " + q2 + " сотрудника с ЗП меньше " + s2 + ":");
        employeeBook1.firstScarceSalary(s2, q2);

        System.out.println("-- Бухгалтерский учёт:");
        Employee testEmp1 = new Employee("Тест №1", 2, 65);
        Employee testEmp2 = new Employee("Тест №2", 2, 10);
        System.out.println("- Имеется ли сотрудник с ЗП 65? - " + employeeBook1.employeeAccounting(testEmp1));
        System.out.println("- Имеется ли сотрудник с ЗП 10? - " + employeeBook1.employeeAccounting(testEmp2));

        int d3 = 4;
        int i3 = 13;
        System.out.println("-- Индексация зарплаты - отдела " + d3 + " на процент " + i3);
        employeeBook1.salaryIndexing(d3, i3);
        System.out.println("Обновлённые данные:");
        employeeBook1.printAllEmployees();

        System.out.println("-- Расчёт налогов - Прогрессивного:");
        employeeBook1.printTaxes("PROGRESSIVE");
        System.out.println("- Пропорционального:");
        employeeBook1.printTaxes("PROPORTIONAL");
    }
}