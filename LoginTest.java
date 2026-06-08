/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aavuz
 */
public class LoginTest {
    
    Login login = new Login();
        
    @Test
    public void testValidUsername(){
        assertTrue(login.checkUsername("kyl_1"));
    }
  
    @Test
    public void testInvalidUsername_NoUnderscore(){
        assertFalse(login.checkUsername("Kyle!!!!!!!!!"));
    }
  
    @Test
    public void testInvalidUsername_TooLong(){
        assertFalse(login.checkUsername("kyleeeee_1"));
    }
  
    @Test
    public void testValidPassword(){
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
  
    @Test
    public void testInvalidPassword(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
  
    @Test
    public void testValidCellNumber(){
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
  
    @Test
    public void testInvalidCellNumber(){
        assertFalse(login.checkCellPhoneNumber("0838968976"));
    }
  
    @Test 
    public void testLoginSuccess(){
        login.registerUser("kyl_1", "Ch&&sec@ke99!","+27838968976" );
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
  
    @Test
    public void testLoginFail(){
        // FIX: Use valid phone number so registration succeeds
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertFalse(login.loginUser("kyle!!!!!!!!", "password"));
    }
    
    @Test
    public void testValidRegisterUser(){
   // boolean result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
    //assertTrue(result);
    
    login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
    
    boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
    assertTrue(result);
    }
}
