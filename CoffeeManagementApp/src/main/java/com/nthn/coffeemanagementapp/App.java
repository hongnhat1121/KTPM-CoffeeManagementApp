package com.nthn.coffeemanagementapp;

import com.nthn.configs.JdbcUtils;
import com.nthn.pojo.Account;
import com.nthn.pojo.Active;
import com.nthn.pojo.Category;
import com.nthn.pojo.Gender;
import com.nthn.pojo.Role;
import com.nthn.pojo.State;
import com.nthn.pojo.Status;
import com.nthn.pojo.Table;
import com.nthn.services.AccountService;
import com.nthn.services.ActiveService;
import com.nthn.services.CategoryService;
import com.nthn.services.GenderService;
import com.nthn.services.RoleService;
import com.nthn.services.StateService;
import com.nthn.services.StatusService;
import com.nthn.services.TableService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXML_Login"), 640, 480);
//        stage.setOnHiding((t) -> {
//            try {
//                Connection c=JdbcUtils.getConnection();
//                if (c!=null)
//                    c.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        //launch();

//        Account account = new Account(UUID.randomUUID().toString(),"hongnhat1121", "10102001", 1);
//        AccountService as = new AccountService();
//        as.addAccount(account);
//        account.display();
//String name = "B%03d"+UUID.randomUUID();
//        Table t = new Table(UUID.randomUUID().toString(), name, 8, 1);
//        System.out.println(t.toString());
//        TableService ts = new TableService();
////        ts.addTable(t);
//        RoleService roleService = new RoleService();
//        roleService.addRole(Role.ADMIN);
//        roleService.addRole(Role.USER);
//        
//        List<Role> results = roleService.getRoles();
//        results.forEach(result -> {
//            System.out.println("com.nthn.coffeemanagementapp.App.main(): " + result.toString());
////        });
//        ActiveService activeService = new ActiveService();
//        activeService.addActive(Active.AVAILABLE);
//        activeService.addActive(Active.LOCK);
//////
//        StateService stateService = new StateService();
//        stateService.addState(State.SERVE);
//        stateService.addState(State.BARTENDER);
//        stateService.addState(State.RECEPTION);
//////
//        StatusService statusService = new StatusService();
//        statusService.addStatus(Status.EMPTY);
//        statusService.addStatus(Status.FULL);
//////
//        GenderService genderService = new GenderService();
//        genderService.addGender(Gender.OTHER);
//        genderService.addGender(Gender.FEMALE);
//        genderService.addGender(Gender.MALE);
//        CategoryService categoryService = new CategoryService();
//        categoryService.addCategory(new Category(1, "Đồ uống"));
//        categoryService.addCategory(new Category(2, "Thức ăn"));
    }

}
