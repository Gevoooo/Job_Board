package com.group.job_board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginMenuController {
    
    // tempory variable to hold the password
    private String password;
    @FXML
    private TextField userName;
    @FXML
    private TextField hidePassword;
    @FXML
    private TextField showPassword;
    @FXML
    private ImageView eyeCloseIcon;
    @FXML
    private ImageView eyeOpenIcon;

    Vector<Poster> posters;
    ArrayList<Applicant> applicants; 
    DatabaseLoad dbl;
    Vector<Applicant> newApplicants; 
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    int numAtt = 0;
    
    @FXML
    private void initialize() {
        showPassword.setVisible(false);
        eyeOpenIcon.setVisible(false);
        dbl = new DatabaseLoad();
    }

    private void loadPosters() {
        //create the variables for each field in the file
        String id = "";
        String companyName = "";
        String username = "";
        String phone ="";
        String email = "";
        String address = "";
        String password = "";
        int totalrows = 0, index = 0;
        
        try {
            //Get the total rows in the table to loop through the result set
            resultSet = statement.executeQuery("SELECT * FROM POSTER"); 
            //resultSet.first();

            totalrows = resultSet.getRow();
            while (resultSet.next()) //tests for the eof
            {   
                totalrows = resultSet.getRow();
                id = resultSet.getString("ID");
                companyName = resultSet.getString("companyName");
                username = resultSet.getString("username");
                phone = resultSet.getString("phone");
                email = resultSet.getString("email");
                address = resultSet.getString("address");
                password = resultSet.getString("password");
                posters.add(new Poster(Integer.parseInt(id), companyName, username, password));
                index++;
            }//end of loading to array
        }
        catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
    
    //Login button
    @FXML
    private void switchJobPostingMenu() throws IOException {
        posters = new Vector<Poster>();
        applicants = dbl.loadApplicants();
        boolean userLoggedIn = false;
        numAtt++;
        
        
        for (int i = 0; i < applicants.size(); i++) {
            if (userName.getText().equals(applicants.get(i).getUsername()) && showPassword.getText().equals(applicants.get(i).getPassword())) {
                System.out.println("Login successful.");
                userLoggedIn = true;
                App.setRoot("JobPostingMenu");
            }
        }
        for (int i = 0; i < posters.size(); i++) {
            if(userName.getText().equals(posters.get(i).getUsername()) && showPassword.getText().equals(posters.get(i).getPassword())) {
                System.out.println("Login successful.");
                userLoggedIn = true;
                App.setRoot("JobPostingMenu");
            }
        }
        if(userLoggedIn == false) {
            System.out.println("Login Unsuccessful");
            if(numAtt > 3)
                System.out.println("Attempt limit reached!"); //Possibly do more, maybe a better error message?
        }
    }

    @FXML
    private void switchToSignUpMenu() throws IOException{
        App.setRoot("SignUpMenu");
    }
    
    /**
     * Set both hidepassword textField and showpassword textField connect together, so they both have same text.
     */
    @FXML
    private void HidePasswordOnAction() {
        password = hidePassword.getText();
        showPassword.setText(password);
    }

    /**
     * 
     */
    @FXML
    private void ShowPasswordOnAction() {
        password = showPassword.getText();
        hidePassword.setText(password);
    }
    
    /**
     * When user click close eye icon the on action will be switch to the other.
     */
    @FXML
    private void closeEyeOnAction() {
        showPassword.setVisible(true);
        eyeCloseIcon.setVisible(false);
        eyeOpenIcon.setVisible(true);
        hidePassword.setVisible(false);
    }

    /**
     * When user clock open eye icon the on action will switch to the other.
     */
    @FXML
    private void openEyeOnAction() {
        showPassword.setVisible(false);
        eyeCloseIcon.setVisible(true);
        eyeOpenIcon.setVisible(false);
        hidePassword.setVisible(true);
    }
}
