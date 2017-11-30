import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DepartmentTest {

    Department d1, d2;

    @Before
    public void setUp() {
        d1 = new Department("HR");
        d2 = new Department("IT");
    }

    @Test
    public void getName() {
        assertEquals("Gets the department name", "HR", d1.getName());
    }

    @Test
    public void addEmployee() {
        d1.AddEmployee(1);
        assertTrue(d1.hasEmployee(1));
    }

    @Test
    public void removeEmployee() {
        d1.AddEmployee(2);
        d1.RemoveEmployee(2);
        assertFalse(d1.hasEmployee(2));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() {
        thrown.expect(MyCustomException.class);
        thrown.expectMessage("AddEmployee - Failure");

        d1.AddEmployee(3);
        d1.AddEmployee(3);
        d1.AddEmployee(4);
    }

    @Test(expected = MyCustomException.class)
    /**
     * This test method expects an exception (i.e. the test method will pass if the NullPointerException is thrown).
     */
    public void removeEmployeeException() {
        d1.RemoveEmployee(5);
    }

    @Test
    /**
     * This test method expects an exception. A try/catch block can be used to test for the thrown exception.
     * Using a try/catch block increases the size of the method (i.e. LOC).
     */
    public void removeEmployeeException2() {
        try {
            d1.RemoveEmployee(5);
        } catch (Exception error) {
            assertEquals(error.getClass(), MyCustomException.class);
        }
    }

}