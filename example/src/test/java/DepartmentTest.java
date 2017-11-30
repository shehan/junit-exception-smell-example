import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    Employee e1, e2, e3, e4, e5;
    Department d1, d2;

    @Before
    public void setUp() {
        e1 = new Employee(1);
        e2 = new Employee(2);
        e3 = new Employee(3);
        e4 = new Employee(4);
        e5 = new Employee(5);

        d1 = new Department("HR");
        d2 = new Department("IT");
    }

    @Test
    public void getName() {
        assertEquals("Gets the department name", "HR", d1.getName());
    }

    @Test
    public void addEmployee() {
        d1.AddEmployee(e1);
        assertTrue(d1.getEmployeeList().contains(e1));
    }

    @Test
    public void removeEmployee() {
        d1.AddEmployee(e2);
        d1.RemoveEmployee(e2);
        assertFalse(d1.getEmployeeList().contains(e2));
    }

    @Test(expected = NullPointerException.class)
    public void removeEmployeeException() {
        d1.RemoveEmployee(e2);
    }

    @Test
    public void removeEmployeeException2() {
        try {
            d1.RemoveEmployee(e2);
        } catch (Exception error) {
            assertEquals(error.getClass(), NullPointerException.class);
        }
    }

    @Test
    public void getEmployeeList() {
    }

}