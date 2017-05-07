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

public class Admin_ListDAO {
    private SQLiteDatabase database;
    private MyData myData;

    public Admin_ListDAO(Context context) {
        myData = new MyData(context);
    } // จบ Admin_ListDAO

    public void open() {  //เปิด ฐานข้อมูล
        database = myData.getWritableDatabase();
    } // จบ open

    public void close() { // ปิด ฐานข้อมูล
        myData.close();
    } // จบ close

    public ArrayList<Admin_ToList> getAllAdminToList() {
        ArrayList<Admin_ToList> toListArrayList = new ArrayList<Admin_ToList>();
        Cursor cursor = database.rawQuery("SELECT * FROM admin_db;", null);
        cursor.moveToFirst();
        Admin_ToList r;
        while (!cursor.isAfterLast()) {
            r = new Admin_ToList();
            r.setID_admin(cursor.getInt(0));
            r.setName_admin(cursor.getString(1));
            r.setUsername_admin(cursor.getString(2));
            r.setPassword_admin(cursor.getString(3));

            toListArrayList.add(r);
            cursor.moveToNext();
        } // จบ while
        cursor.close();
        return toListArrayList;
    }


    // แก้ไข
    public void update(Admin_ToList admin_toList) {
        Admin_ToList updmin = admin_toList;
        ContentValues values = new ContentValues();
        values.put("Name_admin", updmin.getName_admin());
        values.put("Username_admin", updmin.getUsername_admin());
        values.put("Password_admin", updmin.getPassword_admin());
        values.put("ID_admin", updmin.getID_admin());

        String where = "ID_admin=" + updmin.getID_admin();
        this.database.update("admin_db", values, where, null);
        Log.d("Admin_ToList update", "เรียบร้อย");
    } // จบ แก้ไข

    // ลบ
    public void delete(Admin_ToList admin_toList) {
        Admin_ToList deleadmin = admin_toList;
        String sqlText = "DELETE FROM admin_db WHERE ID_admin=" + deleadmin.getID_admin();
        this.database.execSQL(sqlText);
    }// จบ ลบ
}//จบ class Admin_ListDAO












