package com.group.job_board;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author juilliardwu
 */
public class PostingNewJobMenuController {

    @FXML
    private Button UploadJob;
    @FXML
    private TextField JobTitle;
    @FXML
    private TextField JobDescription;
    @FXML
    private TextField jobPay;
    @FXML
    private TextField spots;
    @FXML
    private ChoiceBox JobType;
    private ObservableList<String> jt;
    @FXML
    private ChoiceBox WorkPlaceType;
    private ObservableList<String> wpt;
    @FXML
    private TextField town;
    @FXML
    private TextField street;
    @FXML
    private TextField state;
    @FXML
    private TextField Home;
    @FXML
    private TextField setting;
    @FXML
    private Label PostJob;
    
    @FXML
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private HBox moderation;
    
    @FXML
    private void initialize() {
        jt = FXCollections.observableArrayList("Full Time", "Part Time", "Intern");
        JobType.setItems(jt);
        wpt = FXCollections.observableArrayList("On-site", "Remote", "Hybrid");
        WorkPlaceType.setItems(wpt);
        
        String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
        switch (s) {
            case "Applicant":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Employer":
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Moderator":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                break;
        }
    }
    
    @FXML
    private void UploadJobButtonHandler() {

    }

    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
    
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }
    
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}