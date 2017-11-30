import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Refer: https://github.com/junit-team/junit4/wiki/exception-testing
 */
public class DepartmentTest {

    private Department d1;

    @Before
    public void setUp() {
        d1 = new Department("HR");
    }

    @Test
    public void getName() {
        assertEquals("Test to get the Department name", "HR", d1.getName());
    }

    @Test
    public void addEmployee() {
        d1.AddEmployee(1);
        assertTrue("Test to add an Employee",d1.hasEmployee(1));
    }

    @Test
    public void removeEmployee() {
        d1.AddEmployee(2);
        d1.RemoveEmployee(2);
        assertFalse("Test to remove and Employee",d1.hasEmployee(2));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    /**
     * This test method expects an exception. It checks the exception type and message
     * This is part of JUnit 4
     */
    public void addEmployeeException() throws MyCustomException {
        thrown.expect(MyCustomException.class);
        thrown.expectMessage("AddEmployee - Failure");

        d1.AddEmployee(3);
        d1.AddEmployee(3);
    }

    @Test(expected = MyCustomException.class)
    /**
     * This test method expects an exception (i.e. the test method will pass if the MyCustomException is thrown).
     * This is part of JUnit 4
     */
    public void removeEmployeeException02() {
        d1.RemoveEmployee(5);
    }

    @Test
    /**
     * This test method expects an exception. A try/catch block can be used to test for the thrown exception.
     * Using a try/catch block increases the size of the method (i.e. LOC).
     */
    public void removeEmployeeException01() {
        try {
            d1.RemoveEmployee(5);
        } catch (Exception error) {
            assertEquals("Test to verify that removing an employee throws MyCustomException",error.getClass(), MyCustomException.class);
        }
    }

}