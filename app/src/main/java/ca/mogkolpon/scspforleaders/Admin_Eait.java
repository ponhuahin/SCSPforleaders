package ca.mogkolpon.scspforleaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Eait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_eait);

        //  ดึงค่า มา แสดง
        final Admin_ToList admin_toList = (Admin_ToList) getIntent().getSerializableExtra("eait");

        final EditText editText = (EditText) findViewById(R.id.admin_Name_Eait);
        final EditText editText1 = (EditText) findViewById(R.id.admin_User_Eait);
        final EditText editText2 = (EditText) findViewById(R.id.admin_Pass_Eait);
        editText.setText(admin_toList.getName_admin());
        editText1.setText(admin_toList.getUsername_admin());
        editText2.setText(admin_toList.getPassword_admin());
        //  จบ ดึงค่า มา แสดง

        // แก้ไข ข้อมูล
        final Button editBtn = (Button) findViewById(R.id.SignInbut_Save_Eait);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Admin_ToList admin_toList1 = new Admin_ToList();
                admin_toList1.setID_admin(admin_toList.getID_admin());
                admin_toList1.setName_admin(String.valueOf(editText.getText()));
                admin_toList1.setUsername_admin(String.valueOf(editText1.getText()));
                admin_toList1.setPassword_admin(String.valueOf(editText2.getText()));

                Admin_ListDAO admin_listDAO = new Admin_ListDAO(getApplicationContext());
                admin_listDAO.open();
                admin_listDAO.update(admin_toList1);
                admin_listDAO.close();
                finish();
            }
        });//จบ แก้ไข ข้อมูล

        // ลบ ข้อมูล
        final Button deleBtn = (Button) findViewById(R.id.SignInbut_cancel_Eait);
        deleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Admin_ListDAO dele_listDAO = new Admin_ListDAO(getApplicationContext());
                dele_listDAO.open();
                dele_listDAO.delete(admin_toList);
                dele_listDAO.close();
                finish();
            }
        });
    } // จบ onCreate
}// จบ class Admin_Eait
