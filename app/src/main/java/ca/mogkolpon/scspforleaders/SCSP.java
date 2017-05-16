package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SCSP extends AppCompatActivity {

    //    private MyJob myAdmin;
    private String MoneyString;
    private String JobString;
    private String textString;
    private String Workoff_Wor1;
    private String Withdraw_Wor1;
    private String Salary_Emp1,Withdraw;
    private int a11, a12, b11;
    private int W1, W2, Withdraw_Wor2;
    private String admindb2;
//    private EditText JobText;
//    private String passwordTrusString;
//    private int JobTextint = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scsp);


    }

    // จบ onCreate
    protected void onResume() {
        super.onResume();
        /// เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);

        try {
            Cursor cursor5 = sqLiteDatabase.rawQuery("SELECT  SUM(( b.Workoff_Wor* a.Salary_Emp )- b.Withdraw_Wor)\n" +
                    "            FROM Employee_db a, Workoff_db b\n" +
                    "            WHERE a.Idcard_Emp = b.ID_Emp_Wor", null);
            cursor5.moveToFirst();
            TextView Withdraw1 = (TextView) findViewById(R.id.job_Text2);
            Withdraw1.setText(Withdraw = cursor5.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
// ดึงข้อมูล จากตาราง งาน เวลากดเพิ่มงาน เงินจะขึ้นโชว์ทันที
        try {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(Money_Job) FROM Job_db", null);
            cursor.moveToFirst();
            TextView JobText = (TextView) findViewById(R.id.job_Text);
            JobText.setText(MoneyString = cursor.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
// จบ ดึงข้อมูล จากตาราง งาน เวลากดเพิ่มงาน เงินจะขึ้นโชว์ทันที
        try {
            W1 = Integer.parseInt(MoneyString);
            W2 = Integer.parseInt(Withdraw);

            TextView JobText3 = (TextView) findViewById(R.id.job_Text3);
            JobText3.setText(textString = String.valueOf(W1 - W2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void p1(View view) { // เพิ่มคนงาน
        Button p1 = (Button) findViewById(R.id.p1);
        Intent intent = new Intent(SCSP.this, Name_Add.class);
        startActivity(intent);
    }// จบ p1

    public void p2(View view) { // เบิกเงิน
        Button p2 = (Button) findViewById(R.id.p2);
        Intent intent = new Intent(SCSP.this, Name_Show_2.class);
        startActivity(intent);
    }// จบ p2

//
//    public void p3(View view) { // ทำงาน
//        Button p3 = (Button) findViewById(R.id.p3);
//        Intent intent = new Intent(SCSP.this, Name_Show.class);
//        startActivity(intent);
//    }// จบ p3

    public void p4(View view) { // เพิ่มงาน
        Button p4 = (Button) findViewById(R.id.p4);
        Intent intent = new Intent(SCSP.this, Job_Show.class);
        startActivity(intent);
//        finish();
    }// จบ p4

    //
    public void p5(View view) { //บริษัท
        Button p5 = (Button) findViewById(R.id.p5);
        Intent intent = new Intent(SCSP.this, Report_Show.class);
        startActivity(intent);
    }// จบ p5

    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SCSP.this);
        alertDialog.setTitle("SCSP forleaders");
        alertDialog.setMessage("คุณต้องการกับไปหาล็อกอินใหม่หรือไม่ ?");
        alertDialog.setIcon(R.drawable.ddd1112);
        alertDialog.setPositiveButton("ใช้", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                SCSP.super.onBackPressed();
            }
        });
        alertDialog.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

}// จบ class SCSP
