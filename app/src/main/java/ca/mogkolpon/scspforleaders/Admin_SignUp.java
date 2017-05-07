package ca.mogkolpon.scspforleaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_SignUp extends AppCompatActivity {
    private EditText nameEditText, uesrEditText, passEditText;
    private Button button;
    private String nameString, uesrString, passString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_sign_up);
        // Main หลัก
        bindWidget();
        buttonController();

        // ปุ่ม ยกเลิก SignInbut_cancel
        Button Butcancel = (Button)findViewById(R.id.SignInbut_cancel);
        Butcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }); //  จบ ปุ่ม ยกเลิก SignInbut_cancel

    } // จบ onCreate

    private void buttonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = nameEditText.getText().toString().trim();
                uesrString = uesrEditText.getText().toString().trim();
                passString=passEditText.getText().toString().trim();
                if (nameString.equals("")||uesrString.equals("")||passString.equals("")){
                    Toast.makeText(Admin_SignUp.this,getResources().getString(R.string.haveSpace),Toast.LENGTH_SHORT).show();
                }else {

                    MyAdmin myAdmin = new MyAdmin(Admin_SignUp.this);
                    myAdmin.addNewValue(nameString,uesrString,passString);
                    finish();
                } //จบ if
            } //จบ onClick
        }); // จบ ปุ่ม button
    } // จบ buttonController

    private void bindWidget() {
        nameEditText= (EditText)findViewById(R.id.admin_Name);
        uesrEditText= (EditText)findViewById(R.id.admin_User);
        passEditText= (EditText)findViewById(R.id.admin_Pass);
        button=(Button)findViewById(R.id.SignInbut_Save);
    } // จบ bindWidget


} // จบ class Admin_SignUp
