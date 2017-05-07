package ca.mogkolpon.scspforleaders;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
    private String Salary_Emp1;
    private int a11, a12,b11;
    private int Salary_Emp2,Workoff_Wor2,Withdraw_Wor2;
    private String admindb2;
//    private EditText JobText;
//    private String passwordTrusString;
//    private int JobTextint = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scsp);

        try {
        /// เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
// โชว์ ชื่อคนล็อกอิน
//        Cursor cursor3 = sqLiteDatabase.rawQuery("SELECT * FROM admin_db", null);
//        cursor3.moveToFirst();
//        TextView admin_db1 = (TextView) findViewById(R.id.admin_db1);
//        admin_db1.setText(admindb2 = cursor3.getString(1)); // ชื่อแอดมิน

//        Cursor cursoro = sqLiteDatabase.rawQuery("SELECT * FROM admin_db", null);
//        cursoro.moveToFirst();
//        TextView admin_db1 = (TextView) findViewById(R.id.admin_db1);
//        admin_db1.setText(admindb2 = cursoro.getString(1));

// จบ โชว์ ชื่อคนล็อกอิน
// รายรับ
        Cursor cursor2 = sqLiteDatabase.rawQuery("SELECT SUM(Salary_Emp) FROM Employee_db", null);
        cursor2.moveToFirst();
        Salary_Emp1 = cursor2.getString(0);     //เงินรายวัน
// จบ รายรับ
// รายจ่าย
        Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT SUM(Withdraw_Wor),SUM(Workoff_Wor) FROM Workoff_db", null);
        cursor1.moveToFirst();
        TextView JobText2 = (TextView) findViewById(R.id.job_Text2);
        Withdraw_Wor1= cursor1.getString(0);    // เบิก
        Workoff_Wor1 = cursor1.getString(1);  //ทำงาน

        Salary_Emp2 = Integer.parseInt(Salary_Emp1);
        Withdraw_Wor2 = Integer.parseInt(Withdraw_Wor1);
        Workoff_Wor2 = Integer.parseInt(Workoff_Wor1);

        a11 = Integer.parseInt(String.valueOf(Salary_Emp2 * Workoff_Wor2));
        b11 = Integer.parseInt(String.valueOf(a11 - Withdraw_Wor2));
//        JobText2.setText(JobString = cursor1.getString(0));
        JobText2.setText(JobString = String.valueOf(b11));
// จบ รายจ่าย
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(Money_Job) FROM Job_db", null);
        cursor.moveToFirst();
        TextView JobText = (TextView) findViewById(R.id.job_Text);
        JobText.setText(MoneyString = cursor.getString(0));

        /// เรียกฐานข้อมูล มาใช้แล้ว รวมรายจ่าย ทั้งหมด จบ

//        int JobText22 = MoneyString.toInt();
        int JobText22 = Integer.parseInt(JobString);
        int JobText11 = Integer.parseInt(MoneyString);
        a12 = Integer.parseInt(String.valueOf(JobText11 - JobText22));

        TextView JobText3 = (TextView) findViewById(R.id.job_Text3);
//        JobText3.setText(JobText11 -JobText22);
//        JobText3.setText(textString = String.valueOf(JobText11 - JobText22));
        JobText3.setText(textString = String.valueOf(a12 - a11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // จบ onCreate


    public void p1(View view) { // เพิ่มคนงาน
        Button p1 = (Button) findViewById(R.id.p1);
        Intent intent = new Intent(SCSP.this, Name_Add.class);
        startActivity(intent);
    }// จบ p1

    public void p2(View view) { // เบิกเงิน
        Button p2 = (Button) findViewById(R.id.p2);
        Intent intent = new Intent(SCSP.this, Name_Show.class);
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
    }// จบ p4

    //
    public void p5(View view) { //บริษัท
        Button p5 = (Button) findViewById(R.id.p5);
        Intent intent = new Intent(SCSP.this, Report_Show.class);
        startActivity(intent);
    }// จบ p5

}// จบ class SCSP
