import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void AddEmployee(Employee employee){
        if (employeeList==null)
            employeeList = new ArrayList();

        employeeList.add(employee);
    }

    public void RemoveEmployee(Employee employee){
        employeeList.remove(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
