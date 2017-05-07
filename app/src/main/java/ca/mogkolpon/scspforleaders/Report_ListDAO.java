package ca.mogkolpon.scspforleaders;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 5/7/2017.
 */

public class Report_ListDAO {
    private SQLiteDatabase database;
    private MyData myData;

    public Report_ListDAO(Context context) {
        myData = new MyData(context);
    }

    public void open() {
        database = myData.getWritableDatabase();
    }

    public void close(){
        myData.close();
    }
    public ArrayList<Work_ToList> getAllListDAO() {
        ArrayList<Work_ToList> workToListst = new ArrayList<Work_ToList>();
//        Cursor cursor = database.rawQuery("SELECT * FROM Workoff_db ;", null);
//        Cursor cursor = database.rawQuery("SELECT COUNT(ID_Job_Wor) AS icount " +
//                "FROM Workoff_db GROUP BY ID_Job_Wor Having COUNT(ID_Job_Wor)>1", null);
        Cursor cursor = database.rawQuery("SELECT ID_Job_Wor, Workoff_Wor " +
                "FROM Workoff_db " +
                "GROUP BY ID_Job_Wor " +
                "Having COUNT(ID_Job_Wor) , COUNT(Workoff_Wor) ", null);

//        SELECT     Name, COUNT(Name) AS icount,Addr1
//        FROM         Customer
//        GROUP BY Name,Addr1
//        HAVING      (COUNT(Name > 1)

//        Select ชื่อ, นามสกุล
//        From Tableพนง
//        Group By ชื่อ, นามสกุล
//        Having count(ชื่อ)>1

//        SUM(Workoff_Wor)

        cursor.moveToFirst();
        Work_ToList work_toList1;
        while (!cursor.isAfterLast()) {
            work_toList1 = new Work_ToList();
//            work_toList1.setID_Wor(cursor.getInt(0));                   //id
//            work_toList1.setWorkoff_Wor(cursor.getString(1));           //ทำงาน / หยุด
//            work_toList1.setID_Job_Wor(cursor.getString(2));          //ID งาน
//            work_toList1.setDateWork_Wor(cursor.getString(3));          //เวลาทำงาน
//            work_toList1.setDateOut_Wor(cursor.getString(4));           //เวลาเลิกงาน
//            work_toList1.setWithdraw_Wor(cursor.getString(5));          // เบิกเงิน
//            work_toList1.setID_Emp_Wor(cursor.getString(6));          //ID พนักงาน
//            work_toList1.setDateApp_Wor(cursor.getString(7));           //วันที่บันทึก

            work_toList1.setID_Job_Wor(cursor.getString(0));
            work_toList1.setWorkoff_Wor(cursor.getString(1));
//            work_toList1.setWithdraw_Wor(cursor.getString(2));
//            work_toList1.setDateApp_Wor(cursor.getString(3));
            workToListst.add(work_toList1);
            cursor.moveToNext();
        }// จบ while
        cursor.close();
        return workToListst;
    } // จบ  ArrayList
}
