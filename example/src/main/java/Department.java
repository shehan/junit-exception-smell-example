import java.util.*;

public class Department {
    private String name;
    private Set<Integer> employeeList;

    public Department(String name) {
        this.name = name;
        employeeList = new HashSet();
    }

    public String getName() {
        return name;
    }

    public void AddEmployee(int employeeId){
        if(!employeeList.add(employeeId))
            throw new MyCustomException("AddEmployee - Failure");
    }

    public void RemoveEmployee(int employeeId){
        if(!employeeList.remove(employeeId))
            throw new MyCustomException("RemoveEmployee - Failure");
    }

    public boolean hasEmployee(int employeeId) {
        return employeeList.contains(employeeId);
    }
}
