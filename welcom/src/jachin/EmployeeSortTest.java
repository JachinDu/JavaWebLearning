

package jachin;
import java.util.*;
public class EmployeeSortTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        Arrays.sort(staff);

        for (Employee e : staff)
            e.raiseSalary(5);

////        for (Employee e : staff) {
////            e.setId();
////            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
////        }
////        int n = Employee.getNextId();
//        System.out.println("Next available id= " + n);
    }



}
