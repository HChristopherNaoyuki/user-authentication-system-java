package Solution; // Adjust if package names differ

import org.junit.*;
import static org.junit.Assert.*;

public class SolutionTest
{
    private Solution solution;

    @Before
    public void setUp()
    {
        solution = new Solution();
    }

    @Test
    public void testCheckUserName_ValidUsername()
    {
        assertTrue("Username '_user' should be valid", solution.checkUserName("_user"));
    }

    @Test
    public void testCheckUserName_InvalidUsername()
    {
        assertFalse("Username 'username' should be invalid", solution.checkUserName("username"));
        assertFalse("Username 'user' should be invalid", solution.checkUserName("user"));
    }

    @Test
    public void testCheckPasswordComplexity_ValidPassword()
    {
        assertTrue("Password 'Strong@123' should be valid", solution.checkPasswordComplexity("Strong@123"));
    }

    @Test
    public void testCheckPasswordComplexity_InvalidPassword()
    {
        assertFalse("Password 'weak' should be invalid", solution.checkPasswordComplexity("weak"));
        assertFalse("Password 'NoSpecialChar123' should be invalid", solution.checkPasswordComplexity("NoSpecialChar123"));
        assertFalse("Password 'NoNumber@!' should be invalid", solution.checkPasswordComplexity("NoNumber@!"));
    }

    @After
    public void tearDown()
    {
        solution = null;
    }
}
