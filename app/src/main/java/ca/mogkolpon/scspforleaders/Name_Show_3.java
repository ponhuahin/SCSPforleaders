package ca.mogkolpon.scspforleaders;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Name_Show_3 extends AppCompatActivity {
    ListView nameListView;
    private SQLiteDatabase database;
    private MyData myData;
    Cursor cursor;
    ListView listView;
    ArrayList<Z_MyDataList> list;
    ListView_Name_3 adapter = null;
    private int ID_Emp;
    private String Position_Emp, Salary_Emp, Name_Emp, Nickname_Emp, Age_Emp, ID_Emp_Wor;
    private String wor1, wor2, wor3, wor4, wor0;
    private String AddDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_show_3);
        listView = (ListView) findViewById(R.id.name_ListView_3);


    } // จบ onCreate

    protected void onResume() {
        super.onResume();
        list = new ArrayList<Z_MyDataList>();
        adapter = new ListView_Name_3(this, R.layout.listview_name_3, list);
        listView.setAdapter(adapter);

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM Employee_db  ", null);
        list.clear();
        while (cursor.moveToNext()) {
            ID_Emp = cursor.getInt(0);
            Position_Emp = cursor.getString(1);
            Salary_Emp = cursor.getString(2);
            Name_Emp = cursor.getString(4);
            Nickname_Emp = cursor.getString(5);
            Age_Emp = cursor.getString(8);
            byte[] image = cursor.getBlob(15);
            list.add(new Z_MyDataList(ID_Emp, Position_Emp, Salary_Emp, Name_Emp, Nickname_Emp, Age_Emp, image));
        }
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                try {
                    // ดึงวัน เวลา มาจากเครื่องคอม
                    final Calendar c = Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat ff = new SimpleDateFormat("HH:mm:ss");
                    SimpleDateFormat gg = new SimpleDateFormat("dd/MM/yyyy (HH:mm:ss)");
                    AddDate = df.format(c.getTime());
                    String AddV = ff.format(c.getTime());
                    String Addate_V = gg.format(c.getTime());
                    //
                    cursor.moveToPosition(position);
                    String name = cursor.getString(cursor.getColumnIndex(MyData.ID_Emp));

                    SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
                    Cursor cursor8 = sqLiteDatabase.rawQuery("SELECT * FROM Employee_db  WHERE ID_Emp='" + name + "'", null);
                    cursor8.moveToFirst();
                    String t1 = cursor8.getString(4);
                    String t2 = cursor8.getString(3);
//
                    Cursor cursor56 = sqLiteDatabase.rawQuery("SELECT * FROM Workoff_db  WHERE " +
                            "ID_Emp_Wor='" + t2 + "'" +
                            "AND DateWork_Wor='" + AddDate + "'" +
                            "AND Workoff_Wor='1'; ", null);
                    cursor56.moveToFirst();
                    wor1 = cursor56.getString(1);   // วันทำงาน
                    wor2 = cursor56.getString(3);  //วันที่ ทำงาน
                    wor3 = cursor56.getString(6);   // รหัสบัตรประชาชน
                    wor4 = cursor56.getString(2);   // ชื่อ คนงาน
//                    Toast.makeText(getApplicationContext(), wor1 + " " + wor2 +" " + wor3+" เพิ่มวันทำงาน เรียบร้อย ", Toast.LENGTH_SHORT).show();

//                    if (!wor2.equals(AddDate)) {
////                        sqLiteDatabase.execSQL("INSERT INTO Workoff_db ( "
////                                + " Workoff_Wor , "                 //ทำงาน / หยุด
////                                + " ID_Job_Wor , "                  //ชื่อ คนงาน
////                                + " DateWork_Wor , "                //เวลาทำงาน
////                                + " DateOut_Wor , "                 //เวลาเลิกงาน
////                                + " Withdraw_Wor , "                // เบิก
////                                + " ID_Emp_Wor , "                  // รหัสบัตรประชาชน
////                                + " DateApp_Wor ) VALUES (" +       // วันที่ บันทึก
////                                "'1', " +
////                                "'" + t1 + "', " +
////                                "'" + AddDate + "', " +
////                                "'" + AddV + "', " +
////                                "' ', " +
////                                "'" + t2 + "', " +
////                                "'" + Addate_V + "' " +
////                                ");");
//                        Toast.makeText(getApplicationContext(), wor4 + " บันทึก วันทำงาน เรียบร้อย ", Toast.LENGTH_SHORT).show();
//                    } else {
//
//                        Toast.makeText(getApplicationContext(), wor4 + " บันทึกไปแล้ว", Toast.LENGTH_SHORT).show();
//                    }

//                    if (!wor2.equals(AddDate)) {
//                        Toast.makeText(getApplicationContext(), wor4 + " บันทึก วันทำงาน เรียบร้อย 2 ", Toast.LENGTH_SHORT).show();
//                    }else {
//                        Toast.makeText(getApplicationContext(), wor4 + " บันทึกไปแล้ว 2 ", Toast.LENGTH_SHORT).show();
//                    }
                    if (AddDate == wor2) {
                        Toast.makeText(getApplicationContext(), wor4 + " บันทึก วันทำงาน เรียบร้อย 2 ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), wor4 + " บันทึกไปแล้ว 2 ", Toast.LENGTH_SHORT).show();
                    }
//                        Toast.makeText(getApplicationContext(), t1 + " เพิ่มวันทำงาน เรียบร้อย ", Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//  จบ กด ปกติ

    } // จบ onResume
}// จบ class Name_Show