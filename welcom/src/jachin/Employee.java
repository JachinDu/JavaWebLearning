//package jachin;
package jachin;
import java.time.*;

public class Employee extends Person{
    //private String name;
    private double salary;
    private LocalDate hireDay;
    //private static int nextId = 1;
    //private int id;

    public Employee(String n,double s, int year, int month, int day)
    {
        //name = n;
        super(n);
        //salary = s;
        salary = s;
        hireDay = LocalDate.of(year,month,day);
        //id = 0;
    }

//    public String getName()
//    {
//        return name;
//    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

//    public static int getNextId()
//    {
//        return nextId;
//    }
//
//    public int getId()
//    {
//        return id;
//    }
//
//    public void setId()
//    {
//        id = nextId;
//        nextId++;
//    }

    public static void main(String[] args)
    {
        Employee e = new Employee("Harry",20000,11,4,4);
        System.out.println(e.getName() + " " + e.getSalary());
    }

    public int compareTo(Employee other)
    {
        return Double.compare(salary,other.salary);
    }

    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f",salary);
    }

}
