package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/23/2017.
 */

public class Job_ListDAO {
    private SQLiteDatabase database;
    private MyData myData;

    public Job_ListDAO(Context context){        //เพื่อเรียกใช้ Job_ListView_DAO จะเอา Context มาใช้ต่อ แล้ว ส่งต่อไปที่ MyData
        myData = new MyData(context);       //ส่งต่อ
    }
    public  void open(){            //เปิดฐานข้อมูล
        database = myData.getWritableDatabase();  //เปิดมาเพื่อแก้ไข getWritableDatabase  หรือ เปิดอ่านอย่างเดียว getReadableDatabase
    }
    public void close(){            //ปิดฐานข้อมูล
        myData.close();
    }
    public ArrayList<Job_ToList> getAllTodoList(){
        ArrayList<Job_ToList>job_toLists =new ArrayList<Job_ToList>();
        Cursor cursor = database.rawQuery("SELECT * FROM Job_db;",null);  //ดึงข้อมูลมาแสดงListView
        cursor.moveToFirst();       //ให้อยุ่ในเลกคอดเซด แรก
        Job_ToList job_toList1;
        while (!cursor.isAfterLast()){  //วนลูบ เลกคอดแรก ถึง เลกคอดสุดท้าย
            job_toList1 = new Job_ToList();
            job_toList1.setID_Job(cursor.getInt(0));                  //id
            job_toList1.setName_Job(cursor.getString(1));             //ชื่องาน
            job_toList1.setAddress_Job(cursor.getString(2));          //ที่อยุ่งาน
            job_toList1.setMoney_Job(cursor.getString(3));            //เงิน
            job_toList1.setDateGet_Job(cursor.getString(4));          //วันที่รับงาน
            job_toList1.setDateDue_Job(cursor.getString(5));          //วันที่บันทึก
            job_toList1.setSpecs_Job(cursor.getString(6));            //รายละเอียดงาน
            job_toList1.setName_Com_Job(cursor.getString(7));         //ชื่อบริษัท
            job_toList1.setAddress_Com_Job(cursor.getString(8));      //ที่อยู่บริษััท
            job_toList1.setTele_Job(cursor.getString(9));             //เบอร์โทร
            job_toList1.setLine_Job(cursor.getString(10));            //ไลน์
            job_toList1.setFacebook_Job(cursor.getString(11));        //เฟส
            job_toList1.setEmail_Job(cursor.getString(12));           //อีเมล
            job_toList1.setDateApp_Job(cursor.getString(13));         //วันที่ บันทึก

            job_toLists.add(job_toList1);
            cursor.moveToNext();
        }
        cursor.close();     //ปิด
        return job_toLists;    //รีเทอนกับ
    }
    //      เริ่ม   แก้ไข ข้อมูล
    public void update(Job_ToList job_toList){
        Job_ToList updateJob_ToList = job_toList;
        ContentValues values = new ContentValues();
        values.put("Name_Job",updateJob_ToList.getName_Job());
        values.put("Address_Job",updateJob_ToList.getAddress_Job());
        values.put("Money_Job",updateJob_ToList.getMoney_Job());

        values.put("DateGet_Job",updateJob_ToList.getDateGet_Job());
        values.put("DateDue_Job",updateJob_ToList.getDateDue_Job());
        values.put("Specs_Job",updateJob_ToList.getSpecs_Job());

        values.put("Name_Com_Job",updateJob_ToList.getName_Com_Job());
        values.put("Address_Com_Job",updateJob_ToList.getAddress_Com_Job());
        values.put("Tele_Job",updateJob_ToList.getTele_Job());
        values.put("Line_Job",updateJob_ToList.getLine_Job());
        values.put("Facebook_Job",updateJob_ToList.getFacebook_Job());
        values.put("Email_Job",updateJob_ToList.getEmail_Job());

        values.put("ID_Job",updateJob_ToList.getID_Job());

        String where = "ID_Job=" + updateJob_ToList.getID_Job();
        this.database.update("Job_db",values, where,null);
        Log.d("Todo updateTodoList","okokokokokok");        //เมื่อกดแล้ว ให้ขึ้น โชว์บอก
    }//  จบ แก้ไข ข้อมูล
    //
    //  เริ่ม   ลบ ข้อมูล
    public void delete(Job_ToList job_toList){
        Job_ToList delTodo_JOB = job_toList;
        String sqlText = "DELETE FROM Job_db WHERE ID_Job=" + delTodo_JOB.getID_Job();
        this.database.execSQL(sqlText);
    }//  จบ ลบ ข้อมูล
}// จบ  class Job_ListDAO
