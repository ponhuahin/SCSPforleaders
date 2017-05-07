package ca.mogkolpon.scspforleaders;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by User-Gamer on 3/24/2017.
 */

public class Z_SQLiteHelper extends SQLiteOpenHelper {

    public Z_SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(
                           String Idcard_Emp,
                           String Name_Emp,
                           String Nickname_Emp,
//                           String Sex_Emp,
//                           String DateBirth_Emp,
                           String Age_Emp,
                           String Address_Emp,
                           String Tele_Emp,
                           String Line_Emp,
                           String Facebook_Emp,
                           String Email_Emp,
                           String Position_Emp,
                           String Salary_Emp,
//                           String DateApp_Emp,
                           byte[] Image_Emp) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Employee_db VALUES (NULL,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

//        statement.bindString(0, ID_Emp);
        statement.bindString(1, Idcard_Emp);
        statement.bindString(2, Name_Emp);
        statement.bindString(3, Nickname_Emp);
        statement.bindString(4, Age_Emp);
        statement.bindString(5, Address_Emp);
        statement.bindString(6, Tele_Emp);
        statement.bindString(7, Line_Emp);
        statement.bindString(8, Facebook_Emp);
        statement.bindString(9, Email_Emp);
        statement.bindString(10, Position_Emp);
        statement.bindString(11, Salary_Emp);
        statement.bindBlob(12, Image_Emp);
      statement.executeInsert();
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

