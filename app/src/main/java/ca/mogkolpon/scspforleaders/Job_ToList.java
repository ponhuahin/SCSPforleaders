package ca.mogkolpon.scspforleaders;

import java.io.Serializable;

/**
 * Created by User-Gamer on 3/23/2017.
 */

public class Job_ToList implements Serializable {
    private int ID_Job;
    private String Name_Job, Address_Job, Money_Job,
            DateGet_Job, DateDue_Job, Specs_Job,
            Name_Com_Job, Address_Com_Job, Tele_Job, Line_Job, Facebook_Job, Email_Job, DateApp_Job;

    public int getID_Job() {
        return ID_Job;
    }

    public void setID_Job(int ID_Job) {
        this.ID_Job = ID_Job;
    }

    public String getName_Job() {
        return Name_Job;
    }

    public void setName_Job(String name_Job) {
        Name_Job = name_Job;
    }

    public String getAddress_Job() {
        return Address_Job;
    }

    public void setAddress_Job(String address_Job) {
        Address_Job = address_Job;
    }

    public String getMoney_Job() {
        return Money_Job;
    }

    public void setMoney_Job(String money_Job) {
        Money_Job = money_Job;
    }

    public String getDateGet_Job() {
        return DateGet_Job;
    }

    public void setDateGet_Job(String dateGet_Job) {
        DateGet_Job = dateGet_Job;
    }

    public String getDateDue_Job() {
        return DateDue_Job;
    }

    public void setDateDue_Job(String dateDue_Job) {
        DateDue_Job = dateDue_Job;
    }

    public String getSpecs_Job() {
        return Specs_Job;
    }

    public void setSpecs_Job(String specs_Job) {
        Specs_Job = specs_Job;
    }

    public String getName_Com_Job() {
        return Name_Com_Job;
    }

    public void setName_Com_Job(String name_Com_Job) {
        Name_Com_Job = name_Com_Job;
    }

    public String getAddress_Com_Job() {
        return Address_Com_Job;
    }

    public void setAddress_Com_Job(String address_Com_Job) {
        Address_Com_Job = address_Com_Job;
    }

    public String getTele_Job() {
        return Tele_Job;
    }

    public void setTele_Job(String tele_Job) {
        Tele_Job = tele_Job;
    }

    public String getLine_Job() {
        return Line_Job;
    }

    public void setLine_Job(String line_Job) {
        Line_Job = line_Job;
    }

    public String getFacebook_Job() {
        return Facebook_Job;
    }

    public void setFacebook_Job(String facebook_Job) {
        Facebook_Job = facebook_Job;
    }

    public String getEmail_Job() {
        return Email_Job;
    }

    public void setEmail_Job(String email_Job) {
        Email_Job = email_Job;
    }

    public String getDateApp_Job() {
        return DateApp_Job;
    }

    public void setDateApp_Job(String dateApp_Job) {
        DateApp_Job = dateApp_Job;
    }


// มี 1-14  หรือ 0-13
//    public Job_ToList(int ID_Job, String name_Job, String address_Job, String money_Job, String dateGet_Job, String dateDue_Job, String specs_Job, String name_Com_Job, String address_Com_Job, String tele_Job, String line_Job, String facebook_Job, String email_Job, String dateApp_Job) {
//        this.ID_Job = ID_Job;
//        Name_Job = name_Job;
//        Address_Job = address_Job;
//        Money_Job = money_Job;
//        DateGet_Job = dateGet_Job;
//        DateDue_Job = dateDue_Job;
//        Specs_Job = specs_Job;
//        Name_Com_Job = name_Com_Job;
//        Address_Com_Job = address_Com_Job;
//        Tele_Job = tele_Job;
//        Line_Job = line_Job;
//        Facebook_Job = facebook_Job;
//        Email_Job = email_Job;
//        DateApp_Job = dateApp_Job;
//    }
}
