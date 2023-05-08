package com.group.job_board;

/**
 *
 * @author jimko / George
 */
public class Position {
    String company,
            title,
            description,
            street,
            town,
            state,
            type,
            remote;
    int spots, jobID;
    double pay;
    
    public Position() { 
    }

    public Position(String company, String title, String description, String street, String town, String state, String remote, String type, double pay, int spots, int jobID) {
        this.company = company;
        this.title = title;
        this.description = description;
        this.pay = pay;
        this.street = street;
        this.town = town;
        this.state = state;
        this.remote = remote;
        this.spots = spots;
        this.type = type;
        this.jobID = jobID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
