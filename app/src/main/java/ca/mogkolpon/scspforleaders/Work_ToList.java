package ca.mogkolpon.scspforleaders;

import java.io.Serializable;

/**
 * Created by User-Gamer on 3/24/2017.
 */

public class Work_ToList implements Serializable {
    private int ID_Wor;

    public int getID_Wor() {
        return ID_Wor;
    }

    public void setID_Wor(int ID_Wor) {
        this.ID_Wor = ID_Wor;
    }

    public String getID_Job_Wor() {
        return ID_Job_Wor;
    }

    public void setID_Job_Wor(String id_Job_Wor) {
        ID_Job_Wor = id_Job_Wor;
    }

    public String getID_Emp_Wor() {
        return ID_Emp_Wor;
    }

    public void setID_Emp_Wor(String id_Emp_Wor) {
        ID_Emp_Wor = id_Emp_Wor;
    }

    public String getWorkoff_Wor() {
        return Workoff_Wor;
    }

    public void setWorkoff_Wor(String workoff_Wor) {
        Workoff_Wor = workoff_Wor;
    }

    public String getDateWork_Wor() {
        return DateWork_Wor;
    }

    public void setDateWork_Wor(String dateWork_Wor) {
        DateWork_Wor = dateWork_Wor;
    }

    public String getDateOut_Wor() {
        return DateOut_Wor;
    }

    public void setDateOut_Wor(String dateOut_Wor) {
        DateOut_Wor = dateOut_Wor;
    }

    public String getDateApp_Wor() {
        return DateApp_Wor;
    }

    public void setDateApp_Wor(String dateApp_Wor) {
        DateApp_Wor = dateApp_Wor;
    }

    public String getWithdraw_Wor() {
        return Withdraw_Wor;
    }

    public void setWithdraw_Wor(String withdraw_Wor) {
        Withdraw_Wor = withdraw_Wor;
    }

//    private int ID_Job_Wor;
//    private int ID_Emp_Wor;
    private String ID_Job_Wor,Workoff_Wor,DateWork_Wor,DateOut_Wor,DateApp_Wor,ID_Emp_Wor,Withdraw_Wor;
}
