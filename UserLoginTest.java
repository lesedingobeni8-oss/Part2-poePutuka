/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserLoginTest {

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(UserLogin.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Invalid() {
        assertFalse(UserLogin.checkUserName("kyle"));
    }

    // ---------- CHECK PASSWORD ----------
    @Test
    public void testCheckPassword_Valid() {
        assertTrue(UserLogin.checkPasswordComplexity("Murjan@1"));
    }

    @Test
    public void testCheckPassword_Invalid() {
        assertFalse(UserLogin.checkPasswordComplexity("abc"));
    }

    // ---------- CHECK PHONE ----------
    @Test
    public void testCheckPhone_Valid() {
        assertTrue(UserLogin.checkPhoneNumberComplexity("+27825062274"));
    }

    @Test
    public void testCheckPhone_Invalid() {
        assertFalse(UserLogin.checkPhoneNumberComplexity("0825062274"));
    }

    // ---------- REGISTER USER ----------
    @Test
    public void testRegisterUser_Success() {
        UserLogin instance = new UserLogin();

        String result = instance.registerUser("kyl_1", "Murjan@1", "Lesedi", "Putuka");

        assertEquals("User successfully registered.", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        UserLogin instance = new UserLogin();

        String result = instance.registerUser("kyle", "Murjan@1", "Lesedi", "Putuka");

        assertEquals("Username is incorrectly formatted.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        UserLogin instance = new UserLogin();

        String result = instance.registerUser("kyl_1", "abc", "Lesedi", "Putuka");

        assertEquals("Password does not meet the required conditions. ", result);
    }

    // ---------- LOGIN ----------
    @Test
    public void testLogin_Success() {
        UserLogin instance = new UserLogin();

        instance.registerUser("kyl_1", "Murjan@1", "Lesedi", "Putuka");

        assertTrue(instance.loginUser("kyl_1", "Murjan@1"));
    }

    @Test
    public void testLogin_Fail() {
        UserLogin instance = new UserLogin();

        instance.registerUser("kyl_1", "Murjan@1", "Lesedi", "Putuka");

        assertFalse(instance.loginUser("wrong", "wrong"));
    }

    // ---------- RETURN LOGIN STATUS ----------
    @Test
    public void testReturnLoginStatus_Success() {
        UserLogin instance = new UserLogin();

        instance.registerUser("kyl_1", "Murjan@1", "Lesedi", "Putuka");

        String result = instance.returnLoginStatus(true);

        assertTrue(result.contains("Welcome"));
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        UserLogin instance = new UserLogin();

        String result = instance.returnLoginStatus(false);

        assertEquals(" Username or Password is incorrect ", result);
    }

    // ---------- EXCEPTION ----------
    @Test
    public void testUserRegistered_Exception() {
        UserLogin instance = new UserLogin();

        UnsupportedOperationException assertThrows = assertThrows(UnsupportedOperationException.class, () -> {
            instance.userRegistered("kyl_1", "Murjan@1", "Lesedi", "Putuka");
        });
    }
}
  