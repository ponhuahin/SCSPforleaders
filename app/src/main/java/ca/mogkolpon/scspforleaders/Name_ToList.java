package ca.mogkolpon.scspforleaders;

import java.io.Serializable;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class Name_ToList implements Serializable{
    private int ID_Emp;

//    public Name_ToList(int ID_Emp, String idcard_Emp, String name_Emp, String nickname_Emp, String sex_Emp, String dateBirth_Emp, String age_Emp, String address_Emp, String tele_Emp, String line_Emp, String facebook_Emp, String email_Emp, String position_Emp, String salary_Emp, String dateApp_Emp) {
//        this.ID_Emp = ID_Emp;
//        Idcard_Emp = idcard_Emp;
//        Name_Emp = name_Emp;
//        Nickname_Emp = nickname_Emp;
//        Sex_Emp = sex_Emp;
//        DateBirth_Emp = dateBirth_Emp;
//        Age_Emp = age_Emp;
//        Address_Emp = address_Emp;
//        Tele_Emp = tele_Emp;
//        Line_Emp = line_Emp;
//        Facebook_Emp = facebook_Emp;
//        Email_Emp = email_Emp;
//        Position_Emp = position_Emp;
//        Salary_Emp = salary_Emp;
//        DateApp_Emp = dateApp_Emp;
//    }

    private String Idcard_Emp;

    public int getID_Emp() {
        return ID_Emp;
    }

    public void setID_Emp(int ID_Emp) {
        this.ID_Emp = ID_Emp;
    }

    public String getIdcard_Emp() {
        return Idcard_Emp;
    }

    public void setIdcard_Emp(String idcard_Emp) {
        Idcard_Emp = idcard_Emp;
    }

    public String getName_Emp() {
        return Name_Emp;
    }

    public void setName_Emp(String name_Emp) {
        Name_Emp = name_Emp;
    }

    public String getNickname_Emp() {
        return Nickname_Emp;
    }

    public void setNickname_Emp(String nickname_Emp) {
        Nickname_Emp = nickname_Emp;
    }

    public String getSex_Emp() {
        return Sex_Emp;
    }

    public void setSex_Emp(String sex_Emp) {
        Sex_Emp = sex_Emp;
    }

    public String getDateBirth_Emp() {
        return DateBirth_Emp;
    }

    public void setDateBirth_Emp(String dateBirth_Emp) {
        DateBirth_Emp = dateBirth_Emp;
    }

    public String getAge_Emp() {
        return Age_Emp;
    }

    public void setAge_Emp(String age_Emp) {
        Age_Emp = age_Emp;
    }

    public String getAddress_Emp() {
        return Address_Emp;
    }

    public void setAddress_Emp(String address_Emp) {
        Address_Emp = address_Emp;
    }

    public String getTele_Emp() {
        return Tele_Emp;
    }

    public void setTele_Emp(String tele_Emp) {
        Tele_Emp = tele_Emp;
    }

    public String getLine_Emp() {
        return Line_Emp;
    }

    public void setLine_Emp(String line_Emp) {
        Line_Emp = line_Emp;
    }

    public String getFacebook_Emp() {
        return Facebook_Emp;
    }

    public void setFacebook_Emp(String facebook_Emp) {
        Facebook_Emp = facebook_Emp;
    }

    public String getEmail_Emp() {
        return Email_Emp;
    }

    public void setEmail_Emp(String email_Emp) {
        Email_Emp = email_Emp;
    }

    public String getPosition_Emp() {
        return Position_Emp;
    }

    public void setPosition_Emp(String position_Emp) {
        Position_Emp = position_Emp;
    }

    public String getSalary_Emp() {
        return Salary_Emp;
    }

    public void setSalary_Emp(String salary_Emp) {
        Salary_Emp = salary_Emp;
    }

    public String getDateApp_Emp() {
        return DateApp_Emp;
    }

    public void setDateApp_Emp(String dateApp_Emp) {
        DateApp_Emp = dateApp_Emp;
    }

    public static byte[] getImage_Emp() {
        return Image_Emp;
    }

    public static void setImage_Emp(byte[] image_Emp) {
        Image_Emp = image_Emp;
    }

    private String Name_Emp;
    private String Nickname_Emp;
    private String Sex_Emp;
    private String DateBirth_Emp;
    private String Age_Emp;
    private String Address_Emp;
    private String Tele_Emp;
    private String Line_Emp;
    private String Facebook_Emp;
    private String Email_Emp;
    private String Position_Emp;
    private String Salary_Emp;
    private String DateApp_Emp ;
    private static byte[] Image_Emp;

}
