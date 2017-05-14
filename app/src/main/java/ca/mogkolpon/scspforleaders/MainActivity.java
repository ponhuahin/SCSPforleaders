package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyAdmin myAdmin;
    private Button signInBrt, signUpBut;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString, passwordTrusString, nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Main หลัก
        myAdmin = new MyAdmin(MainActivity.this);
        bindWidget();
        buttonController();
    } // จบ onCreate

    private void buttonController() {
        signUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Admin_SignUp.class));
            }
        });
        signInBrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAuthen();
            }
        });
    } // จบ buttonController

    private void checkAuthen() {
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            myDialog(getResources().getString(R.string.haveSpace));
        } else if (checkUser()) {
            myDialog(getResources().getString(R.string.userFalse));
        } else if (!passwordString.equals(passwordTrusString)) {
            myDialog(getResources().getString(R.string.passFalse));
        } else {
            myDialog("สวัสดีคับ : " + nameString);
            startActivity(new Intent(MainActivity.this,SCSP.class));
            userEditText.setText("");
            passwordEditText.setText("");
        }
    } // จบ checkAuthen

    private boolean checkUser() {
        boolean result = true;
        try {
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM admin_db", null);
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                if (userString.equals(cursor.getString(2))) {
                    result = false;
                    passwordTrusString = cursor.getString(3);
                    nameString=cursor.getString(1);
                }
                cursor.moveToNext();
            }// จบ for
        } catch (Exception e){
        e.printStackTrace();
    }
        return result;
    } // จบ checkUser

    private void myDialog(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    } // จบ myDialog

    private void bindWidget() { // เชื่อม ความสัมพัน ระหว่าง ตัวแปร
        signInBrt = (Button) findViewById(R.id.SignInbut);
        signUpBut = (Button) findViewById(R.id.SignUpbut);
        userEditText = (EditText) findViewById(R.id.Username);
        passwordEditText = (EditText) findViewById(R.id.Password);
    } // จบ bindWidget

    public void admin_show(View view){
        Button admin_show = (Button)findViewById(R.id.admin_show);
        Intent intent=new Intent(MainActivity.this,Admin_Show.class);
        startActivity(intent);
    }

//    public void sss(View view){
//        Button sss1 = (Button)findViewById(R.id.sss);
//        Intent intent = new Intent(MainActivity.this,SCSP.class);
//        startActivity(intent);
//    }

    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("SCSP forleaders");
        alertDialog.setMessage("คุณต้องการออกจากโปรแกรมหรือไม่ ?");
        alertDialog.setIcon(R.drawable.ddd1112_1);
        alertDialog.setPositiveButton("ใช้",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                MainActivity.super.onBackPressed();
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


}// จบ MainActivity
