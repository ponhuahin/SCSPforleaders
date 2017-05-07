package ca.mogkolpon.scspforleaders;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Job_Add extends AppCompatActivity {
    private EditText Name_Job, Address_Job, Money_Job, DateGet_Job, DateDue_Job, Specs_Job,
            Name_Com_Job, Address_Com_Job, Tele_Job, Line_Job, Facebook_Job, Email_Job;
    private Button job_But_Save,job_But_cancel;
    private String name_job, address_job, money_job, dateget_job, datedue_job, specs_job,
            name_com_job, address_com_job, tele_job, line_job, facebook_job, email_job;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_add);
        bindWidget();
        buttonController();

        //  ปุ่ม ยกเลิก เริ่ม
        Button cancel1 = (Button)findViewById(R.id.job_But_cancel);
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });    //  ปุ่ม ยกเลิก จบ
        // วัน เดือน ปี เริ่ม
        DateGet_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // ปีนี้
                int mMonth = c.get(Calendar.MONTH); // เดือนนี้
                int mDay = c.get(Calendar.DAY_OF_MONTH); // วันที่ปัจจุบัน
                // โต้ตอบตัวเลือกวันที่
                datePickerDialog = new DatePickerDialog(Job_Add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        DateGet_Job.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        }); // วัน เดือน ปี จบ
        DateDue_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // ปีนี้
                int mMonth = c.get(Calendar.MONTH); // เดือนนี้
                int mDay = c.get(Calendar.DAY_OF_MONTH); // วันที่ปัจจุบัน
                // โต้ตอบตัวเลือกวันที่
                datePickerDialog = new DatePickerDialog(Job_Add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        DateDue_Job.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
//                DateApp_Job=(mDay + "/" + mMonth + "/" + mYear);
            }
        }); // วัน เดือน ปี จบ
    }
    private void buttonController() {
        job_But_Save.setOnClickListener(new View.OnClickListener() {  // ปุ่ม บันทึก job_But_Save
            @Override
            public void onClick(View view) {
                // ดึงวัน เวลา มาจากเครื่องคอม
                final Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String DateApp_Job = df.format(c.getTime());
                //
                name_job = Name_Job.getText().toString().trim();                //ชื่องาน           1
                address_job = Address_Job.getText().toString().trim();          //ที่อยุ่             2
                money_job = Money_Job.getText().toString().trim();              //จำนวนเงิน         3
                dateget_job = DateGet_Job.getText().toString().trim();          //วันที่รับงาน         4
                datedue_job = DateDue_Job.getText().toString().trim();          //วันกำหนดส่งงาน     5
                specs_job = Specs_Job.getText().toString().trim();              //รายละเอียด        6
                name_com_job = Name_Com_Job.getText().toString().trim();        //ชื่อบริษัท          7
                address_com_job = Address_Com_Job.getText().toString().trim();  //ที่อยุ่บริษัท         8
                tele_job = Tele_Job.getText().toString().trim();                //เบอร์โทร          9
                line_job = Line_Job.getText().toString().trim();                //ไลน์             10
                facebook_job = Facebook_Job.getText().toString().trim();        //เฟส             11
                email_job = Email_Job.getText().toString().trim();              //อีเมล            12

                if (name_job.equals("") ||              //ชื่องาน
                        address_job.equals("") ||       //ที่อยุ่
                        money_job.equals("") ||         //เงิน
                        dateget_job.equals("") ||       //วันที่รับ
                        datedue_job.equals("") ||       //วันที่ส่ง
                        name_com_job.equals("") ||      //ชื่อบริษัท
                        address_com_job.equals("") ||   //ที่อยุ่บริษัท
                        tele_job.equals("") ||          //เบอร์โทร
                        email_job.equals("")) {         //อีเมล
                    Toast.makeText(Job_Add.this, getResources().getString(R.string.haveSpace), Toast.LENGTH_SHORT).show();
                } else {
                    MyJob myJob = new MyJob(Job_Add.this);
                    myJob.addNewValue(name_job,
                            address_job,
                            money_job,
                            dateget_job,
                            datedue_job,
                            specs_job,
                            name_com_job,
                            address_com_job,
                            tele_job,
                            line_job,
                            facebook_job,
                            email_job,
                            DateApp_Job
                    );
                    finish();
                }   // if
            }   // onClick

        });
    }   // buttonController

    private void bindWidget() {                 //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity  เชื่อมต่อ  หน้าออกแบบ admin_singn_up
        Name_Job = (EditText) findViewById(R.id.Name_Job);                  //ชื่องาน           1
        Address_Job = (EditText) findViewById(R.id.Address_Job);            //ที่อยุ่             2
        Money_Job = (EditText) findViewById(R.id.Money_Job);                //จำนวนเงิน         3
        DateGet_Job = (EditText) findViewById(R.id.DateGet_Job);            //วันที่รับงาน         4
        DateDue_Job = (EditText) findViewById(R.id.DateDue_Job);            //วันกำหนดส่งงาน     5
        Specs_Job = (EditText) findViewById(R.id.Specs_Job);                //รายละเอียด        6
        Name_Com_Job = (EditText) findViewById(R.id.Name_Com_Job);          //ชื่อบริษัท          7
        Address_Com_Job = (EditText) findViewById(R.id.Address_Com_Job);    //ที่อยุ่บริษัท         8
        Tele_Job = (EditText) findViewById(R.id.Tele_Job);                  //เบอร์โทร          9
        Line_Job = (EditText) findViewById(R.id.Line_Job);                  //ไลน์             10
        Facebook_Job = (EditText) findViewById(R.id.Facebook_Job);          //เฟส             11
        Email_Job = (EditText) findViewById(R.id.Email_Job);                //อีเมล            12

        job_But_Save = (Button) findViewById(R.id.job_But_Save);            //เชื่อม button หน้าออกแบบ   id.SignInbut2
//        Name_Reg_But_cancel = (Button) findViewById(R.id.Name_Reg_But_cancel);

    }
}