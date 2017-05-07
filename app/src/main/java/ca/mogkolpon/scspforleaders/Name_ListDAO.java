package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class Name_ListDAO {
    private SQLiteDatabase database;
    private MyData myData;

    public Name_ListDAO(Context context) {
        myData = new MyData(context);
    }

    public void open() {
        database = myData.getWritableDatabase();
    }

    public void close(){
        myData.close();
    }

    public ArrayList<Name_ToList> getAllListDAO() {
        ArrayList<Name_ToList> nameToListst = new ArrayList<Name_ToList>();
        Cursor cursor = database.rawQuery("SELECT * FROM Employee_db;", null);
        cursor.moveToFirst();
        Name_ToList name_toList1;
        while (!cursor.isAfterLast()) {
            name_toList1 = new Name_ToList();
            name_toList1.setID_Emp(cursor.getInt(0));                  //id

            name_toList1.setPosition_Emp(cursor.getString(1));    //ตำแหน่ง
            name_toList1.setSalary_Emp(cursor.getString(2));    //เงินเดือน

            name_toList1.setIdcard_Emp(cursor.getString(3));         //รหัสประชาชน
            name_toList1.setName_Emp(cursor.getString(4));         //ชื่อ-นามสกุล
            name_toList1.setNickname_Emp(cursor.getString(5));   //ชื่อเล่น
            name_toList1.setSex_Emp(cursor.getString(6));        //เพศ
            name_toList1.setDateBirth_Emp(cursor.getString(7));  //วัน เดือน ปี เกิด
            name_toList1.setAge_Emp(cursor.getString(8));        //อายุ

            name_toList1.setAddress_Emp(cursor.getString(9));    //ที่อยุ่
            name_toList1.setTele_Emp(cursor.getString(10));          //เบอร์โทร

            name_toList1.setLine_Emp(cursor.getString(11));       //ไลน์
            name_toList1.setFacebook_Emp(cursor.getString(12));   //เฟส
            name_toList1.setEmail_Emp(cursor.getString(13));     //อีเมล

            name_toList1.setDateApp_Emp(cursor.getString(14));   //วันที่บันทึก
            name_toList1.setImage_Emp(cursor.getBlob(15));         //ภาพ   ////  ทำให้ แสดงภาพหลายภาพไม่ได้

            nameToListst.add(name_toList1);
            cursor.moveToNext();
        }// จบ while
        cursor.close();
        return nameToListst;
    } // จบ  ArrayList


    //      เริ่ม   แก้ไข ข้อมูล
    public void update(Name_ToList name_toList){
        Name_ToList updateTodoList = name_toList;
        ContentValues values = new ContentValues();
        values.put("ID_Emp",updateTodoList.getID_Emp());

        values.put("Position_Emp",updateTodoList.getPosition_Emp());
        values.put("Salary_Emp",updateTodoList.getSalary_Emp());

        values.put("Idcard_Emp",updateTodoList.getIdcard_Emp());
        values.put("Name_Emp",updateTodoList.getName_Emp());
        values.put("Nickname_Emp",updateTodoList.getNickname_Emp());
        values.put("DateBirth_Emp",updateTodoList.getDateBirth_Emp());
        values.put("Age_Emp",updateTodoList.getAge_Emp());

        values.put("Address_Emp",updateTodoList.getAddress_Emp());
        values.put("Tele_Emp",updateTodoList.getTele_Emp());

        values.put("Line_Emp",updateTodoList.getLine_Emp());
        values.put("Facebook_Emp",updateTodoList.getFacebook_Emp());
        values.put("Email_Emp",updateTodoList.getEmail_Emp());

        String where = "ID_Emp=" + updateTodoList.getID_Emp();
        this.database.update("Employee_db",values, where,null);
        Log.d("Todo updateTodoList","okokokokokok");        //เมื่อกดแล้ว ให้ขึ้น โชว์บอก
    }//  จบ แก้ไข ข้อมูล

    //  เริ่ม   ลบ ข้อมูล
    public void delete(Name_ToList name_toList){
        Name_ToList delTodolist = name_toList;
        String sqlText = "DELETE FROM Employee_db WHERE ID_Emp=" + delTodolist.getID_Emp();
        this.database.execSQL(sqlText);
    }//  จบ ลบ ข้อมูล
} // จบ class Name_ListDAO
