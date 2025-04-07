package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.AppRole;
import se.lexicon.Model.AppUser;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    // --------------------------constructor
    @Test
    public void testConstructor_SentInCorrectData_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expectedUserName = "Dennis";
        String expectedPassword = "abc123";
        AppRole expectedRole = AppRole.ROLE_APP_USER;

        // Actual:
        String actualUsername = appUser.getUsername();
        String actualPassword = appUser.getPassword();
        AppRole actualRole = appUser.getRole();

        // Verify the result:
        Assertions.assertEquals(expectedUserName, actualUsername);
        Assertions.assertEquals(expectedPassword, actualPassword);
        Assertions.assertEquals(expectedRole, actualRole);
    }

    // --------------------------Username
    @Test
    public void testGetUsername_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Dennis";

        // Actual:
        String actual = appUser.getUsername();;

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetUsername_NewUserNameNull_ThrowException_Failure() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Username should not be null or empty";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUser.setUsername(null));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetUsername_NewUserNameEmpty_ThrowException_Failure() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Username should not be null or empty";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUser.setUsername(""));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetUsername_NewUserNameValid_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        String newUsername = "Erik";

        // Expected:
        String expected = newUsername;

        // Actual:
        appUser.setUsername(newUsername);
        String actual = appUser.getUsername();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------Password
    @Test
    public void testGetPassword_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "abc123";

        // Actual:
        String actual = appUser.getPassword();;

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPassword_NewPasswordNull_ThrowException_Failure() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Password should not be null or empty";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUser.setPassword(null));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPassword_NewPasswordEmpty_ThrowException_Failure() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Password should not be null or empty";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUser.setPassword(null));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPassword_NewPasswordValid_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        String newPassword = "lkf1453";

        // Expected:
        String expected = newPassword;

        // Actual:
        appUser.setPassword(newPassword);
        String actual = appUser.getPassword();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------Role
    @Test
    public void testGetRole_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        AppRole expected = AppRole.ROLE_APP_USER;

        // Actual:
        AppRole actual = appUser.getRole();;

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testSetRole_NewRoleNull_ThrowException_Failure() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Role should not be null";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUser.setRole(null));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetRole_NewRoleValid_Success() {
        // Scenario:
        AppUser appUser = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppRole newRole = AppRole.ROLE_APP_ADMIN;

        // Expected:
        AppRole expected = newRole;

        // Actual:
        appUser.setRole(newRole);
        AppRole actual = appUser.getRole();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------toString
    @Test
    public void testToString_Success() {
        // Scenario:
        AppUser person = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        String expected = "Username: Dennis\nRole: ROLE_APP_USER";

        // Actual:
        String actual = person.toString();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------equal password isn't checked
    @Test
    public void testEquals_SecondObjectIsNull_ReturnFalse(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = null;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = appUser1.equals(appUser2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is not null but not of the same class")
    public void testEquals_NotTheSameClass_ReturnFalse(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        int secondObject = 2;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = appUser1.equals(secondObject);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same id.")
    public void testEquals_UsernameNotTheSame_ReturnFalse(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Johan", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = appUser1.equals(appUser2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    public void testEquals_RoleNotTheSame_ReturnFalse(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_ADMIN);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = appUser1.equals(appUser2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is exactly the same.")
    public void testEquals_BothObjectsAreEqual_ReturnTrue(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        //boolean expected = true;

        // Actual:
        boolean actual = appUser1.equals(appUser2);

        // Verify the result
        assertTrue(actual);
    }

    // --------------------------hashCode password isn't used.

    @Test
    public void testHashCode_UsernameNotTheSame_NotEqual(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Erik", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        int expected = appUser1.hashCode();

        // Actual:
        int actual = appUser2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_RoleNotTheSame_NotEqual(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        int expected = appUser1.hashCode();

        // Actual:
        int actual = appUser2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_SameObjects_Equal(){
        AppUser appUser1 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Dennis", "abc123", AppRole.ROLE_APP_USER);

        // Expected:
        int expected = appUser1.hashCode();

        // Actual:
        int actual = appUser2.hashCode();

        // Verify the result
        Assertions.assertEquals(expected, actual);
    }
}
