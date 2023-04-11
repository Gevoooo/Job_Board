/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This method will load database information into an arraylist of the chosen type
 * for more readable use within the program. Since the first ID is always 1 for each type,
 * a dummy listing has been included for reach so that the id will coorrespond to the
 * position within the arraylist
 * @author jimko
 */
public class DatabaseLoad {

    public DatabaseLoad() {
    }
    public ArrayList<Applicant> loadApplicants() {
        ArrayList<Applicant> alApplicant = new ArrayList();
        alApplicant.add(new Applicant());
        
        String databaseURL = "";
        Connection conn = null;

        // establishing connection
        try {
            databaseURL = "jdbc:ucanaccess://.//CodeAngels.accdb";
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            Logger.getLogger(JobPostingMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // import 
            String tableName = "applicant";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName);
            conn.close();

            while (result.next()) {
                if (result.getBoolean("active") == true) {
                    Applicant listing = new Applicant();
                    listing.setUserID(result.getInt("ID"));
                    listing.setFirstName(result.getString("firstName"));
                    listing.setLastName(result.getString("lastName"));
                    listing.setEmail(result.getString("email"));
                    listing.setPhone(result.getLong("phone"));
                    listing.setAddress(result.getString("address"));
                    listing.setPassword(result.getString("password"));
                    listing.setUsername(result.getString("username"));

                    alApplicant.add(listing);
                    //items.add(listing.positionTitle + " at " + listing.);
                }
            }
        } catch (SQLException except) {
            System.out.println("BROKEN HANDLE LOAD");
            except.printStackTrace();
        }
        
        return alApplicant;
    }
    public ArrayList<Poster> loadPosters() {
        ArrayList<Poster> alPosters = new ArrayList();
        alPosters.add(new Poster());
        String databaseURL;
        Connection conn = null;
        
        
        // establishing connection
        try {
            databaseURL = "jdbc:ucanaccess://.//CodeAngels.accdb";
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            Logger.getLogger(JobPostingMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String employerTable = "employer";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + employerTable);
            while (result.next()) {
                Poster poster = new Poster();
                poster.setUserID(result.getInt("ID"));
                poster.setCompanyName(result.getString("employerName"));
                poster.setAddress(result.getString("employerAddress"));
                poster.setRecruiterName(result.getString("recruiterName"));
                poster.setEmail(result.getString("recruiterEmail"));
                poster.setPhone(result.getLong("recruiterPhone"));
                poster.setPassword(result.getString("password"));
                poster.setActive(result.getBoolean("active"));
                poster.setUsername(result.getString("username"));
            }
        } catch (SQLException except) {
            System.out.println("BROKEN HANDLE LOAD");
            except.printStackTrace();
        }
        
        return alPosters;
    }

    public ArrayList<Position> loadPositions() {
        ArrayList<Position> alPositions = new ArrayList();
        alPositions.add(new Position());
        
        String databaseURL = "";
        Connection conn = null;

        // establishing connection
        try {
            databaseURL = "jdbc:ucanaccess://.//CodeAngels.accdb";
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            Logger.getLogger(JobPostingMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // import 
            String tableName = "position";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName);
            conn.close();

            while (result.next()) {
                if (result.getBoolean("active") == true) {
                    Position listing = new Position();
                    listing.setPositionTitle(result.getString("positionTitle"));
                    listing.setPositionDescription(result.getString("positionDesc"));
                    listing.setPositionPay(result.getString("positionPay"));
                    listing.setPositionSponsor(result.getInt("positionSponsor"));
                    listing.setPositionAddress(result.getString("positionAddress"));
                    listing.setPositionRemote(result.getBoolean("remote"));
                    listing.setPositionActive(result.getBoolean("active"));
                    alPositions.add(listing);
                    //items.add(listing.positionTitle + " at " + listing.);
                }
            }
        } catch (SQLException except) {
            System.out.println("BROKEN HANDLE LOAD");
            except.printStackTrace();
        }
        
        return alPositions;
    }
}