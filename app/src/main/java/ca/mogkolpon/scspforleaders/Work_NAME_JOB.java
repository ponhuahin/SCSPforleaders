package ca.mogkolpon.scspforleaders;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Work_NAME_JOB extends AppCompatActivity {
    private EditText Workoff_Wor, Withdraw_Wor, W_Idcard_Wor;
    private Button button;
    private String Workoff_WorString, Withdraw_WorString, W_Idcard, s2, s3, s4, s5, s6;
    private TextView a1, d2, d3, d4, d5, d6;
    String Sex_Emp0 = "ชาย";
    DatePickerDialog datePickerDialog;
    private Button editBtn, editBtn1;
    ListView workListView, workListView2;
    private String MoneyString;

    private SQLiteDatabase database;
    private MyData myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_name_job);
        bindWidget();

        workListView = (ListView) findViewById(R.id.work_ListView);

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
        B5.setText(name_toList.getSalary_Emp());
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

                MyWork myWork = new MyWork(Work_NAME_JOB.this);
                myWork.addNewValue(Workoff_WorString,   //ทำงาน / หยุด
                        Withdraw_WorString,             //งาน
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

        /// เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด
//        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
////        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Job_db", null);
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(Money_Job) FROM Job_db", null);
//        cursor.moveToFirst();
//        workListView2 = (ListView) findViewById(R.id.work_ListView2);

        /// เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด จบ

    } // จบ onCreate

    protected void onResume() {
        super.onResume();
        Work_ListDAO work_listDAO = new Work_ListDAO(getApplicationContext());
        work_listDAO.open();
        ArrayList<Work_ToList> myList = work_listDAO.getAllListDAO();

        final ListView_Work adapter = new ListView_Work(this, myList);
        workListView.setAdapter(adapter);
        work_listDAO.close();
    }

    private void bindWidget() {
        W_Idcard_Wor = (EditText) findViewById(R.id.W_Idcard);
        Workoff_Wor = (EditText) findViewById(R.id.W_1);
        Withdraw_Wor = (EditText) findViewById(R.id.W_W);
        editBtn = (Button) findViewById(R.id.W_But_Save);
        editBtn1 = (Button) findViewById(R.id.W_but_cancel);
//        passEditText= (EditText)findViewById(R.id.admin_Pass);
    } // จบ bindWidget
} // จบ class Work_NAME_JOB
