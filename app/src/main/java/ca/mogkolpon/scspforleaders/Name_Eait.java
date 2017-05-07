package ca.mogkolpon.scspforleaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Name_Eait extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_eait);

        //  ดึงค่า มา แสดง
        final Name_ToList name_toList = (Name_ToList) getIntent().getSerializableExtra("eait");

        final EditText A1 = (EditText) findViewById(R.id.Position_Emp_eait);
        final EditText A2 = (EditText) findViewById(R.id.Salary_Emp_eait);      //
        final EditText A3 = (EditText) findViewById(R.id.Idcard_Emp_eait);
        final EditText A4 = (EditText) findViewById(R.id.Name_Emp_eait);
        final EditText A5 = (EditText) findViewById(R.id.Nickname_Emp_eait);
        final EditText A6 = (EditText) findViewById(R.id.DateBirth_Emp_eait);
        final EditText A7 = (EditText) findViewById(R.id.Age_Emp_eait);         //
        final EditText A8 = (EditText) findViewById(R.id.Address_Emp_eait);
        final EditText A9 = (EditText) findViewById(R.id.Tele_Emp_eait);        //
        final EditText A10 = (EditText) findViewById(R.id.Line_Emp_eait);
        final EditText A11 = (EditText) findViewById(R.id.Facebook_Emp_eait);
        final EditText A12 = (EditText) findViewById(R.id.Email_Emp_eait);      //

        imageView = (ImageView) findViewById(R.id.Image_Emp);

        A1.setText(name_toList.getPosition_Emp());
        A2.setText(name_toList.getSalary_Emp());        //
        A3.setText(name_toList.getIdcard_Emp());
        A4.setText(name_toList.getName_Emp());
        A5.setText(name_toList.getNickname_Emp());
        A6.setText(name_toList.getDateBirth_Emp());
        A7.setText(name_toList.getAge_Emp());           //
        A8.setText(name_toList.getAddress_Emp());
        A9.setText(name_toList.getTele_Emp());          //
        A10.setText(name_toList.getLine_Emp());
        A11.setText(name_toList.getFacebook_Emp());
        A12.setText(name_toList.getEmail_Emp());        //
        //  จบ ดึงค่า มา แสดง

        // ปุ้ม แก้ไข ข้อมูล  //
        final Button editBtn = (Button) findViewById(R.id.Name_Save_eait);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name_ToList name_toList1 = new Name_ToList();
                name_toList1.setID_Emp(name_toList.getID_Emp());

                name_toList1.setPosition_Emp(String.valueOf(A1.getText()));
                name_toList1.setSalary_Emp(String.valueOf(A2.getText()));

                name_toList1.setIdcard_Emp(String.valueOf(A3.getText()));
                name_toList1.setName_Emp(String.valueOf(A4.getText()));
                name_toList1.setNickname_Emp(String.valueOf(A5.getText()));
                name_toList1.setDateBirth_Emp(String.valueOf(A6.getText()));
                name_toList1.setAge_Emp(String.valueOf(A7.getText()));

                name_toList1.setAddress_Emp(String.valueOf(A8.getText()));
                name_toList1.setTele_Emp(String.valueOf(A9.getText()));

                name_toList1.setLine_Emp(String.valueOf(A10.getText()));
                name_toList1.setFacebook_Emp(String.valueOf(A11.getText()));
                name_toList1.setEmail_Emp(String.valueOf(A12.getText()));


                Name_ListDAO nameListDAO = new Name_ListDAO(getApplicationContext()); //เชื่อมต่อ todoListDAO
                nameListDAO.open();
                nameListDAO.update(name_toList1);                                      //อัพเดก
                nameListDAO.close();                                                //ปิด
                finish();                                                           //เแก้ไข แล้ว ปิด หน้านี้
            }
        });
        // ปุ้ม ลบ ข้อมูล  //
        Button delBtn = (Button) findViewById(R.id.Name_cancel_eait);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
        delBtn.setOnClickListener(new View.OnClickListener() {                      //
            @Override
            public void onClick(View v) {
                Name_ListDAO name_listDAO1 = new Name_ListDAO(getApplicationContext());
                name_listDAO1.open();
                name_listDAO1.delete(name_toList);
                name_listDAO1.close();
                finish();
            }
        });
    } // จบ onCreate
} // จบ class Name_Eait
