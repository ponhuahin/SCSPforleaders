package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class MyAdmin {
    private Context context;
//    private MyDataDB myDataDB;
    private MyData myData;
    private SQLiteDatabase sqLiteDatabase;
    private static final String user_table = "admin_db";

    private static final String admin_id = "ID_admin";
    private static final String admin_name = "Name_admin";
    private static final String admin_user = "Username_admin";
    private static final String admin_pass = "Password_admin";

    public MyAdmin(Context context) {
        this.context = context;
//        myDataDB = new MyDataDB(context);
//        sqLiteDatabase = myDataDB.getWritableDatabase();

        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    }// จบ public MyAdmin

    public long addNewValue(String strName, String strUser, String strPassword) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(admin_name, strName);
        contentValues.put(admin_user, strUser);
        contentValues.put(admin_pass, strPassword);
        return sqLiteDatabase.insert(user_table, null, contentValues);
    } // จบ long addNewValue

} // จบ class MyAdmin
