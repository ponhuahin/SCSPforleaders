package ca.mogkolpon.scspforleaders;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/24/2017.
 */

public class Work_ListDAO {
    String a1 = "1545464564654";
    String a2 = "3";
    private SQLiteDatabase database;
    private MyData myData;
    public Work_ListDAO(Context context) {
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
//        Cursor cursor = database.rawQuery("SELECT * FROM Workoff_db;", null);

        Cursor cursor = database.rawQuery("SELECT * FROM Workoff_db Order By DateApp_Wor DESC;", null);

//        Cursor cursor = database.rawQuery("SELECT * FROM Workoff_db WHERE ID_Emp_Wor='1545464564654';", null);
//        Cursor cursor = database.rawQuery("SELECT * FROM Workoff_db WHERE ID_Emp_Wor='"
//                +a2+
//                "' Order By DateApp_Wor DESC;", null);
//        Cursor cursor = database.rawQuery("SELECT ID_Job_Wor, SUM(Workoff_Wor), SUM(Withdraw_Wor) " +
//                "FROM Workoff_db " +
//                "GROUP BY ID_Job_Wor ", null);

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

            work_toList1.setID_Wor(cursor.getInt(0));                   //id
            work_toList1.setWorkoff_Wor(cursor.getString(1));           //ทำงาน / หยุด
            work_toList1.setID_Job_Wor(cursor.getString(2));          //ID งาน
            work_toList1.setDateWork_Wor(cursor.getString(3));          //เวลาทำงาน
            work_toList1.setDateOut_Wor(cursor.getString(4));           //เวลาเลิกงาน
            work_toList1.setWithdraw_Wor(cursor.getString(5));          // เบิกเงิน
            work_toList1.setID_Emp_Wor(cursor.getString(6));          //ID พนักงาน
            work_toList1.setDateApp_Wor(cursor.getString(7));           //วันที่บันทึก
            workToListst.add(work_toList1);
            cursor.moveToNext();
        }// จบ while
        cursor.close();
        return workToListst;
    } // จบ  ArrayList
} // จบ class Name_ListDAO

