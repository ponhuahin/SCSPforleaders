package ca.mogkolpon.scspforleaders;

import java.io.Serializable;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class Admin_ToList implements Serializable{
    private int ID_admin;
    private String Name_admin,Username_admin,Password_admin;

    public int getID_admin() {
        return ID_admin;
    }

    public void setID_admin(int ID_admin) {
        this.ID_admin = ID_admin;
    }

    public String getName_admin() {
        return Name_admin;
    }

    public void setName_admin(String name_admin) {
        Name_admin = name_admin;
    }

    public String getUsername_admin() {
        return Username_admin;
    }

    public void setUsername_admin(String username_admin) {
        Username_admin = username_admin;
    }

    public String getPassword_admin() {
        return Password_admin;
    }

    public void setPassword_admin(String password_admin) {
        Password_admin = password_admin;
    }
}
