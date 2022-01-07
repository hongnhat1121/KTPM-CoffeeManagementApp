/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nthn.testcontroller;

import com.nthn.check.LoginChecker;
import com.nthn.coffeemanagementapp.LoginController;
import com.nthn.login.PasswordTester;
import com.nthn.login.UsernameTester;
import com.nthn.pojo.Account;
import com.nthn.services.AccountService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author HONGNHAT
 */
public class LoginTester {

//    @BeforeAll
//    public void beforeAll(){
//        
//    }
    @Test
    public void testGetAccountByInvalidID() {
        try {
            AccountService accountService = new AccountService();
            Account a = accountService.getAccountByID("1");

            Assertions.assertNull(a);
        } catch (SQLException ex) {
            Logger.getLogger(LoginTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetAccountByValidID() {
        try {
            AccountService accountService = new AccountService();
            Account a = accountService.getAccountByID("c6672ebe-6b57-42d4-8c8d-a4a2f3a19c11");

            Assertions.assertEquals("admin", a.getUsername());
            Assertions.assertEquals("c6672ebe-6b57-42d4-8c8d-a4a2f3a19c11", a.getAccountID());
        } catch (SQLException ex) {
            Logger.getLogger(LoginTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Test username hợp lệ
    @ParameterizedTest(name = "{index} => username={0}, password={1}")
    @CsvSource({"user, 1121", "admin, 1121", "user1, User2022"})
    public void testLoginSuccess(String username, String password) throws SQLException {
        try {
            Assertions.assertTrue(LoginChecker.isSuccessLogin(username, password));
        } catch (SQLException ex) {
            Logger.getLogger(LoginTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Test đăng nhập không thành công
    @ParameterizedTest(name = "{index} => username={0}, password={1}")
    @CsvSource({"usernam=e, ?username2022", "username, username2022", "UserName, USERNAME2022", "username, username"})
    public void testLoginFailed(String username, String password) {
        try {
            Assertions.assertFalse(LoginChecker.isSuccessLogin(username, password));
        } catch (SQLException ex) {
            Logger.getLogger(LoginTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
