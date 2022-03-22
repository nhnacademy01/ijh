//package comparable;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.function.Function;
//import java.util.function.ToDoubleFunction;
//import java.util.function.ToIntFunction;
//import java.util.function.ToLongFunction;
//
//public class CompareTest {
//    public static void main(String[] args) {
//        List<Employee> workers = new ArrayList<>();
//        workers.add(new Employee(1, "Kim"));
//        workers.add(new Employee(2, "Nah"));
//        workers.add(new Employee(3, "Pak"));
//        workers.add(new Employee(4, "Lee"));
//
//        System.out.println(workers);
//        workers.sort(new EmployeeNameComparator());
//        System.out.println(workers);
//    }
//}
//
//class Employee implements Comparable<Employee> {
//    private Integer empNo;
//    private String name;
//    // SKIP getter, toString
//    @Override
//    public int compareTo(Employee o) {
//        return this.empNo - o.empNo;
//    }
//}
//
//class EmployeeNameComparator implements Comparator<Employee> {
//
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        return 0;
//    }
//
//}