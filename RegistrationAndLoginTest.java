/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
   package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationAndLoginTest {

    
    @Test
    public void testCheckUserName_Valid() {assertTrue(RegistrationAndLogin.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_NoUnderscore() {assertFalse(RegistrationAndLogin.checkUserName("kyle"));
    }

    @Test
    public void testCheckUserName_TooLong() {assertFalse(RegistrationAndLogin.checkUserName("kyl_123"));
    }

    @Test
    public void testPassword_Valid() {assertTrue(RegistrationAndLogin.checkPasswordComplexity("CH&&sec@ke99!"));
    }

    @Test
    public void testPassword_NoCapital() {assertFalse(RegistrationAndLogin.checkPasswordComplexity("ch&&sec@ke99!"));
    }

    @Test
    public void testPassword_NoNumber() {assertFalse(RegistrationAndLogin.checkPasswordComplexity("CH&&sec@ke!!"));
    }

    @Test
    public void testPassword_NoSpecialChar() {assertFalse(RegistrationAndLogin.checkPasswordComplexity("CHsecake99"));
    }

    @Test
    public void testPassword_TooShort() {assertFalse(RegistrationAndLogin.checkPasswordComplexity("Ab1!"));
    }

    @Test
    public void testPhone_Valid() {assertTrue(RegistrationAndLogin.checkPhoneNumberComplexity("+27805062274"));
    }

    @Test
    public void testPhone_NoPlus() {assertFalse(RegistrationAndLogin.checkPhoneNumberComplexity("27805062274"));
    }

    @Test
    public void testPhone_WrongLength() {assertFalse(RegistrationAndLogin.checkPhoneNumberComplexity("+2780506227"));
    }
}