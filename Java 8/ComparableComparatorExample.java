import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class to demonstrate the differences between Comparable and Comparator
 * interfaces.<br>
 * <b>Comparable</b> will modify the code of the class which at times is not
 * desirable.
 * <b>Comparable</b> is from java.lang package.
 * <br>
 * <b>Comparator</b> will allows us not to disturb the domain class<br>
 * <b>Comparator</b> will allows us to define multiple comparision
 * strategies.<br>
 * <b>Comparator</b> is from java.util package
 */
public class ComparableComparatorExample {

    public static void main(String[] args) {

        List<MyEmployee> empList = new ArrayList<>();
        empList.add(new MyEmployee(3, "emp3", 3000));
        empList.add(new MyEmployee(5, "emp1", 5000));
        empList.add(new MyEmployee(1, "emp1", 1000));
        empList.add(new MyEmployee(2, "emp2", 2000));
        empList.add(new MyEmployee(4, "emp4", 4000));

        Collections.sort(empList);

        empList.stream().forEach(System.out::println);

        // Comparator
        Comparator<MyEmployee> myEmployeeIdComparator = Comparator.comparing(MyEmployee::getSalary);
        // Sorts the given elements in the reverse order.
        Collections.sort(empList, myEmployeeIdComparator.reversed());
        // Sorts based on the employee id and then name and then salary
        Comparator<MyEmployee> myEmployeeComparator = Comparator.comparing(MyEmployee::getEmpId)
                .thenComparing(MyEmployee::getEmpName)
                .thenComparing(MyEmployee::getSalary).reversed();
        Collections.sort(empList, myEmployeeComparator);
        System.out.println("Using Comparator .................");
        empList.stream().forEach(System.out::println);
    }
}

class MyEmployee implements Comparable<MyEmployee> {

    private int empId;
    private String empName;
    private int salary;

    public MyEmployee(int empId, String empName, int salary) {

        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Overriding equals()
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MyEmployee employee = (MyEmployee) obj;
        return employee.getEmpName().equals(this.getEmpName()) && employee.getEmpId() == this.getEmpId()
                && employee.getSalary() == this.getSalary();
    }

    @Override
    public int hashCode() {

        if (null == this.empName) {
            return super.hashCode();
        }
        String hashString = this.getClass().getName() + ":" + this.getEmpId() + this.getEmpName().hashCode()
                + this.getSalary();
        return hashString.hashCode();
    }

    @Override
    public String toString() {

        return "[ ID: " + this.getEmpId() + ", Name: " + this.getEmpName() + ", Salary: " + this.getSalary() + "]";
    }

    @Override
    public int compareTo(MyEmployee employee) {

        return this.getEmpName().compareTo(employee.getEmpName()) == 0 ? this.getEmpId() - employee.getEmpId()
                : this.getEmpName().compareTo(employee.getEmpName());
    }
}
