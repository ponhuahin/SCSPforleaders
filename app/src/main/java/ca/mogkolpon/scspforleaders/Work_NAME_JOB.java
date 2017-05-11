package ca.mogkolpon.scspforleaders;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Work_NAME_JOB extends AppCompatActivity {
    private EditText Workoff_Wor, Withdraw_Wor, W_Idcard_Wor, W_Name_Wor;
//    private Button button;
    private String Workoff_WorString, Withdraw_WorString, W_Idcard, s2, W_Name, s4, s5, s6;
//    private TextView w_Name, d2, d3, d4, d5, d6;
    String Sex_Emp0 = "ชาย";
//    DatePickerDialog datePickerDialog;
    private Button editBtn, editBtn1;
    ListView workListView, workListView2;
    private String MoneyString;
    private String W_1, name1, W_2, workListView22;
//    private String r11, r22, r33;

    private SQLiteDatabase database;
    private MyData myData;

    private ArrayList<String> stafid = new ArrayList<String>();
    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> jbt = new ArrayList<String>();
    private ArrayList<String> ID_Wor = new ArrayList<String>();

    private ListView userList;
    private AlertDialog.Builder build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_name_job);
        bindWidget();

        workListView = (ListView) findViewById(R.id.work_ListView);
        userList = (ListView) findViewById(R.id.work_ListView2);
        myData = new MyData(this);

        //  ดึงค่า มา แสดง {
        final Name_ToList name_toList = (Name_ToList) getIntent().getSerializableExtra("eait");
        final TextView B1 = (TextView) findViewById(R.id.W_Name);
        final TextView B2 = (TextView) findViewById(R.id.W_Nickname);
        final TextView B3 = (TextView) findViewById(R.id.W_Idcard);
        final TextView B4 = (TextView) findViewById(R.id.W_Position);
        final TextView B5 = (TextView) findViewById(R.id.W_Salary);
        B1.setText(name_toList.getName_Emp());
        B2.setText(name_toList.getNickname_Emp());
        B3.setText(name_toList.getIdcard_Emp());
        B4.setText(name_toList.getPosition_Emp());
        B5.setText(name_toList.getSalary_Emp());   //เงินเดือน
        W_1 = name_toList.getSalary_Emp();
        W_2 = name_toList.getIdcard_Emp();
        // จบ ดึงค่า มา แสดง }

        // ปุ้ม เพิ่ม วันทำงาน   //
        final Button editBtn = (Button) findViewById(R.id.W_But_Save);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                // ดึงวัน เวลา มาจากเครื่องคอม
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy (HH:mm:ss)");
                String formattedDate = df.format(c.getTime());
                //
                Name_ToList name_toList1 = new Name_ToList();
                name_toList1.setID_Emp(name_toList.getID_Emp());
                name_toList1.setPosition_Emp(String.valueOf(B1.getText()));

                Workoff_WorString = Workoff_Wor.getText().toString().trim();
                Withdraw_WorString = Withdraw_Wor.getText().toString().trim();
                W_Idcard = W_Idcard_Wor.getText().toString().trim();
                W_Name = W_Name_Wor.getText().toString().trim();

                MyWork myWork = new MyWork(Work_NAME_JOB.this);
                myWork.addNewValue(Workoff_WorString,   //ทำงาน / หยุด
                        W_Name,             //งาน
                        formattedDate,                   //เวลาทำงาน
                        formattedDate,                  //เวลาเลิกงาน
                        Withdraw_WorString,             // เบิก
                        W_Idcard,                       // รหัสบัตรประชาชน
                        formattedDate);                 // วันที่ บันทึก
                finish();
//                Workoff_Wor.setText("");
//                Withdraw_Wor.setText("");
//                refresh
            }
        });
        final Button fibutton = (Button) findViewById(R.id.W_but_cancel);
        fibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,  final int arg2, long arg3) {

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Work_NAME_JOB.this);
                builder.setIcon(R.drawable.garbage_full_48);
                builder.setTitle("ยืนยัน ลบข้อมูล วันที่ " + jbt.get(arg2));
                builder.setMessage("คุณต้องการ ลบข้อมูล นี้หรือไม่");

                builder.setPositiveButton("ลบ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            database.delete(MyData.TABLE_NAME,MyData.ID_Wor + "=" + ID_Wor.get(arg2), null);
                            Toast.makeText( getApplicationContext(), jbt.get(arg2) + " ลบข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                            displayData();
                            dialog.cancel();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(), "ยกเลิก การลบ แล้ว",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                builder.show();
                return true;
            }
        }); // จบ กด ค้าง

    } // จบ onCreate

    protected void onResume() {
        super.onResume();
        displayData();


//        / เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด

//        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
//        Cursor cursor22 = sqLiteDatabase.rawQuery("SELECT SUM(Withdraw_Wor),SUM(Workoff_Wor) FROM Workoff_db WHERE ID_Emp_Wor= '"+ W_2 +"'", null);
//        cursor22.moveToFirst();
//        workListView2 = (ListView) findViewById(R.id.work_ListView2);
//        workListView2.setAdapter(adapter);
        try {
            // เริ่ม
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(Withdraw_Wor),SUM(Workoff_Wor) FROM Workoff_db WHERE ID_Emp_Wor= '" + W_2 + "'", null);
            cursor.moveToFirst();
            TextView name_Text1 = (TextView) findViewById(R.id.name_Text);   //เชื่อมต่อTextView หน้าออกแบบกับ หน้าโค้ด
            TextView name_Text2 = (TextView) findViewById(R.id.name_Text2);  //เชื่อมต่อTextView หน้าออกแบบกับ หน้าโค้ด
            name_Text1.setText(MoneyString = cursor.getString(0));  //เชื่อมต่อTextView หน้าออกแบบกับ หน้าโค้ด
            name_Text2.setText(s2 = cursor.getString(1));

            TextView name_Text3 = (TextView) findViewById(R.id.name_Text3);
            int W_name1 = Integer.parseInt(s2);
            int W_name2 = Integer.parseInt(W_1);
            int ss = Integer.parseInt(String.valueOf(W_name2 * W_name1));
            int ss1 = Integer.parseInt(MoneyString);

            name_Text3.setText(name1 = String.valueOf(ss - ss1));

//        / เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด จบ
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void bindWidget() {
        W_Idcard_Wor = (EditText) findViewById(R.id.W_Idcard);
        W_Name_Wor = (EditText) findViewById(R.id.W_Name);
        Workoff_Wor = (EditText) findViewById(R.id.W_1);
        Withdraw_Wor = (EditText) findViewById(R.id.W_W);
        editBtn = (Button) findViewById(R.id.W_But_Save);
        editBtn1 = (Button) findViewById(R.id.W_but_cancel);
//        passEditText= (EditText)findViewById(R.id.admin_Pass);
    } // จบ bindWidget

    //    public void onBackPressed(){
//        Intent intent = new Intent(Work_NAME_JOB.this, SCSP.class);
//        startActivity(intent);
//        finish();
//    }

    private void displayData() {
        try {
            database = myData.getWritableDatabase();
            Cursor mCursor = database.rawQuery("SELECT * FROM  Workoff_db WHERE ID_Emp_Wor= '" + W_2 + "' Order By DateApp_Wor DESC;", null);
            stafid.clear();
            nama.clear();
            jbt.clear();
            ID_Wor.clear();
//    //fetch each record
            if (mCursor.moveToFirst()) {
                do {
                    //get data from field
                    stafid.add(mCursor.getString(mCursor.getColumnIndex(MyData.Withdraw_Wor)));
                    nama.add(mCursor.getString(mCursor.getColumnIndex(MyData.Workoff_Wor)));
                    jbt.add(mCursor.getString(mCursor.getColumnIndex(MyData.DateApp_Wor)));
                    ID_Wor.add(mCursor.getString(mCursor.getColumnIndex(MyData.ID_Wor)));

                } while (mCursor.moveToNext());
                //do above till data exhausted
            }

            //display to screen
            DisplayAdapter disadpt = new DisplayAdapter(Work_NAME_JOB.this, stafid, nama, jbt);
            userList.setAdapter(disadpt);
            mCursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end displayData

} // จบ class Work_NAME_JOB
