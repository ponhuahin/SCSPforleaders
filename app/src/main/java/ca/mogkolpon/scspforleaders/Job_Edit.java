package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Job_Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_edit);

        final Job_ToList editTodoList = (Job_ToList) getIntent().getSerializableExtra("editTodoList");

        final EditText B1 = (EditText) findViewById(R.id.Name_Job_edit);        //รหัสบัตรประชาชน     1
        final EditText B2 = (EditText) findViewById(R.id.Address_Job_edit);            //ชื่อ               2
        final EditText B3 = (EditText) findViewById(R.id.Money_Job_edit);        //ชื่อเล่น             3

        final EditText B5 = (EditText) findViewById(R.id.DateGet_Job_edit);       //วัน เดือน ปี เกิด      5
        final EditText B6 = (EditText) findViewById(R.id.DateDue_Job_edit);             //อายุ               6
        final EditText B7 = (EditText) findViewById(R.id.Specs_Job_edit);         //ที่อยู่               7

        final EditText B8 = (EditText) findViewById(R.id.Name_Com_Job_edit);             //เบอร์โทร            8
        final EditText B9 = (EditText) findViewById(R.id.Address_Com_Job_edit);            //ไลน์               9
        final EditText B10 = (EditText) findViewById(R.id.Tele_Job_edit);       //เฟส               10
        final EditText B11 = (EditText) findViewById(R.id.Line_Job_edit);          //อีเมล              11
        final EditText B12 = (EditText) findViewById(R.id.Facebook_Job_edit);        //ตำแหน่ง           12
        final EditText B13 = (EditText) findViewById(R.id.Email_Job_edit);          //เงินเดือน           13

        B1.setText(editTodoList.getName_Job());
        B2.setText(editTodoList.getAddress_Job());
        B3.setText(editTodoList.getMoney_Job());

        B5.setText(editTodoList.getDateGet_Job());
        B6.setText(editTodoList.getDateDue_Job());
        B7.setText(editTodoList.getSpecs_Job());

        B8.setText(editTodoList.getName_Com_Job());
        B9.setText(editTodoList.getAddress_Com_Job());
        B10.setText(editTodoList.getTele_Job());
        B11.setText(editTodoList.getLine_Job());
        B12.setText(editTodoList.getFacebook_Job());
        B13.setText(editTodoList.getEmail_Job());

        // ปุ้ม แก้ไข ข้อมูล  //
        final Button editBtn = (Button)findViewById(R.id.job_But_Save_edit);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Job_ToList eTodo_JOB = new Job_ToList();                                  //สร้าง eTodoList ใหม่ เพื่มรับค่า editTodolist เดิม
                eTodo_JOB.setID_Job(editTodoList.getID_Job());                    // ใช้ eTodoList รับค่า editTodolist ที่ส่ง มา

                eTodo_JOB.setName_Job(String.valueOf(B1.getText()));              // แล้วเอา setTodoText ที่ได้มาจาก editText น่าออกแบบ
                eTodo_JOB.setAddress_Job(String.valueOf(B2.getText()));
                eTodo_JOB.setMoney_Job(String.valueOf(B3.getText()));

                eTodo_JOB.setDateGet_Job(String.valueOf(B5.getText()));
                eTodo_JOB.setDateDue_Job(String.valueOf(B6.getText()));
                eTodo_JOB.setSpecs_Job(String.valueOf(B7.getText()));

                eTodo_JOB.setName_Com_Job(String.valueOf(B8.getText()));
                eTodo_JOB.setAddress_Com_Job(String.valueOf(B9.getText()));
                eTodo_JOB.setTele_Job(String.valueOf(B10.getText()));
                eTodo_JOB.setLine_Job(String.valueOf(B11.getText()));
                eTodo_JOB.setFacebook_Job(String.valueOf(B12.getText()));
                eTodo_JOB.setEmail_Job(String.valueOf(B13.getText()));

                Job_ListDAO job_ListView_DAO = new Job_ListDAO(getApplicationContext()); //เชื่อมต่อ todoListDAO
                job_ListView_DAO.open();
                job_ListView_DAO.update(eTodo_JOB);                                      //อัพเดก
                job_ListView_DAO.close();                                                //ปิด
                finish();                                                           //เแก้ไข แล้ว ปิด หน้านี้
                Toast.makeText(getApplicationContext(), " บันทึกข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
            }
        });
        // ปุ้ม ลบ ข้อมูล  //
        Button delBtn = (Button)findViewById(R.id.job_But_cancel_edit);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
        delBtn.setOnClickListener(new View.OnClickListener() {                      //
            @Override
            public void onClick(View v) {
                try {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Job_Edit.this);
                    builder.setIcon(R.drawable.garbage_full_48);
                    builder.setTitle("ยืนยัน ลบข้อมูล ");
                    builder.setMessage("คุณต้องการ ลบข้อมูล นี้หรือไม่");
                    builder.setPositiveButton("ลบ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                Job_ListDAO job_ListView_DAO1 =new Job_ListDAO(getApplicationContext());
                                job_ListView_DAO1.open();
                                job_ListView_DAO1.delete(editTodoList);
                                job_ListView_DAO1.close();
                                finish();
                                Toast.makeText(getApplicationContext(), " ลบข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "ยกเลิก การลบ แล้ว", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    });
                    builder.show();
//                    database.delete(MyData.TABLE_NAME_Emp, MyData.ID_Emp + "=" + name, null);
//                    Toast.makeText(getApplicationContext(), name + " ลบข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                finish();
//                Job_ListDAO job_ListView_DAO1 =new Job_ListDAO(getApplicationContext());
//                job_ListView_DAO1.open();
//                job_ListView_DAO1.delete(editTodoList);
//                job_ListView_DAO1.close();
//                finish();
            }
        });
    }
}
