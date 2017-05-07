package ca.mogkolpon.scspforleaders;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Z_Name_SignUp extends AppCompatActivity {
    private EditText Position_Emp, Salary_Emp, Name_Emp, Nickname_Emp,Idcard_Emp,
            DateBirth_Emp, Age_Emp, Address_Emp, Tel_Emp, Line_Emp, Facebook_Emp, Email_Emp;
    String Sex_Emp0 = "ชาย", DateApp_Emp;
    private Button Name_But_Save, Name_But, Name_SHOW;
    private ImageView imageView;
    final int REQUEST_CODE_GALLERY = 999;
    public static Z_SQLiteHelper sqLiteHelper;
    DatePickerDialog datePickerDialog;
    private String position_emp, salary_emp, id_emp, name_emp, nickname_emp, datebirth_emp, age_emp,idcard_Emp,
            address_emp, tel_emp, line_emp, facebook_emp, email_emp, image_emp, dateapp_emp, imagePathString, imageNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_name_sign_up);

        init();
        sqLiteHelper = new Z_SQLiteHelper(this, "SCSP.sqlite", null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Employee_db" +
                "(ID_Emp INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Idcard_Emp VARCHAR, " +                           //รหัสบัตรประชาชน   	3
                "Name_Emp VARCHAR, " +
                "nickname_emp  VARCHAR, " +
//                "Sex_Emp  VARCHAR,"+
//                "DateBirth_Emp VARCHAR, " +
                "age_emp  VARCHAR, " +
                "Address_Emp VARCHAR, " +
                "Tel_Emp VARCHAR, " +
                "Line_Emp VARCHAR, " +
                "Facebook_Emp VARCHAR, " +
                "Email_Emp VARCHAR, " +
                "Position_Emp VARCHAR, " +
                "Salary_Emp VARCHAR, " +
//                "DateApp_Emp VARCHAR, " +
                "image BLOB)");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(Z_Name_SignUp.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        Name_But_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqLiteHelper.insertData(

//                            id_emp = ID_Emp.getText().toString().trim(),                    //รหัสบัตรประชาชน     1
                            idcard_Emp = Idcard_Emp.getText().toString().trim(),
                            name_emp = Name_Emp.getText().toString().trim(),                //ชื่อ               2
                            nickname_emp = Nickname_Emp.getText().toString().trim(),        //ชื่อเล่น             3
//                            Sex_Emp0.toString().trim(),
//                            datebirth_emp = DateBirth_Emp.getText().toString().trim(),      //วัน เดือน ปี เกิด      4
                            age_emp = Age_Emp.getText().toString().trim(),                  //อายุ               5
                            address_emp = Address_Emp.getText().toString().trim(),          //ที่อยู่               6
                            tel_emp = Tel_Emp.getText().toString().trim(),                  //เบอร์โทร            7
                            line_emp = Line_Emp.getText().toString().trim(),                //ไลน์               8
                            facebook_emp = Facebook_Emp.getText().toString().trim(),        //เฟส               9
                            email_emp = Email_Emp.getText().toString().trim(),              //อีเมล              10
                            position_emp = Position_Emp.getText().toString().trim(),       //ตำแหน่ง            11
                            salary_emp = Salary_Emp.getText().toString().trim(),            //เงินเดือน            12
//                            dateapp_emp=DateApp_Emp.toString().trim(),                   //วันที่บัทึก            13
                            imageViewToByte(imageView)                                      //รูปภาพ             14

                    );
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    Idcard_Emp.setText("");
                    Name_Emp.setText("");
                    Nickname_Emp.setText("");
                    Age_Emp.setText("");
                    Address_Emp.setText("");
                    Tel_Emp.setText("");
                    Line_Emp.setText("");
                    Facebook_Emp.setText("");
                    Email_Emp.setText("");
                    Position_Emp.setText("");
                    Salary_Emp.setText("");

                    imageView.setImageResource(R.mipmap.ic_launcher);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        Name_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Z_Name_SignUp.this, Z_Name_List.class);
                startActivity(intent);
            }
        });

        Name_SHOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Z_Name_SignUp.this, SCSP.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

//    public void sss1(View view) {
//        Button sss1 = (Button) findViewById(R.id.Name_Reg_But);
//        Intent intent = new Intent(Z_Name_SignUp.this, Z_Name_List.class);
//        startActivity(intent);
//    }
    private void init() {

        Idcard_Emp = (EditText) findViewById(R.id.Idcard_Emp);                 //รหัสบัตรประชาชน     1
        Name_Emp = (EditText) findViewById(R.id.Name_Emp);              //ชื่อ               2
        Nickname_Emp = (EditText) findViewById(R.id.Nickname_Emp);      //ชื่อเล่น             3
        // เพศ
//        DateBirth_Emp = (EditText) findViewById(R.id.DateBirth_Emp);    //วัน เดือน ปี เกิด      4
        Age_Emp = (EditText) findViewById(R.id.Age_Emp);                //อายุ               5
        Address_Emp = (EditText) findViewById(R.id.Address_Emp);        //ที่อยู่               6
        Tel_Emp = (EditText) findViewById(R.id.Tel_Emp);                //เบอร์โทร            7
        Line_Emp = (EditText) findViewById(R.id.Line_Emp);              //ไลน์               8
        Facebook_Emp = (EditText) findViewById(R.id.Facebook_Emp);      //เฟส               9
        Email_Emp = (EditText) findViewById(R.id.Email_Emp);            //อีเมล              10
        Position_Emp = (EditText) findViewById(R.id.Position_Emp);      //ตำแหน่ง           11
        Salary_Emp = (EditText) findViewById(R.id.Salary_Emp);          //เงินเดือน           12
        // วันที่ บันทึก
        imageView = (ImageView) findViewById(R.id.Image_Emp);             //รูป               13


        Name_But_Save = (Button) findViewById(R.id.Name_Reg_But_Save);
        Name_But = (Button) findViewById(R.id.Name_Reg_But);
        Name_SHOW =(Button) findViewById(R.id.Name_SHOW);
//        imageView = (ImageView) findViewById(R.id.imageView);
    }
//    public void p5(View view) { //บริษัท
//        Button p5 = (Button) findViewById(R.id.Name_SHOW);
//        Intent intent = new Intent(Z_Name_SignUp.this, Z_Name_List.class);
//        startActivity(intent);
//    }// จบ p5



}
