package ca.mogkolpon.scspforleaders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Name_Add extends AppCompatActivity {
    private MyName myName;
    private EditText Position_Emp;
    private EditText Salary_Emp;
    private EditText Idcard_Emp;
    private EditText Name_Emp;
    private EditText Nickname_Emp;
    private EditText DateBirth_Emp;
    private EditText Age_Emp;
    private EditText Address_Emp;
    private EditText Tele_Emp;
    private EditText Line_Emp;
    private EditText Facebook_Emp;
    private EditText Email_Emp;
    private String position_emp;
    private String salary_emp;
    private String idcard_emp;
    private String name_emp;
    private String nickname_emp;
    private String datebirth_emp;
    private String age_emp;
    private String address_emp;
    private String tele_emp;
    private String line_emp;
    private String facebook_emp;
    private String email_emp;
    private String imagePathString;
    private String imageNameString;
    private String idcard_emp2;
    private String age;

    private Button Name_Save;
    private ImageView imageView;
    DatePickerDialog datePickerDialog;
    private boolean statusABoolean = true;
    String Sex_Emp0 = "ชาย";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_add);

        myName = new MyName(Name_Add.this);
        bindWidget();
        buttonController();

        // ปุ่ม ยกเลิก Name_cancel
        Button Butcancel = (Button) findViewById(R.id.Name_cancel);
        Butcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Name_Add.this, SCSP.class);
                startActivity(intent);
                finish();
            }
        }); //  จบ ปุ่ม ยกเลิก Name_cancel

        DateBirth_Emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);  // ปี
                final int mMonth = c.get(Calendar.MONTH);  // เดือน
                final int mDay = c.get(Calendar.DAY_OF_MONTH); //วันที่

                datePickerDialog = new DatePickerDialog(Name_Add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        DateBirth_Emp.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
//                        Age_Emp.setText((c.get(Calendar.YEAR) - year) + "" + (month - month) + "" + (dayOfMonth - dayOfMonth));
                        age = String.valueOf(mYear - year);
                        Age_Emp.setText(age);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
//                dateapp_emp = (mDay + "/" + mMonth + "/" + mYear);
            }
        }); // ปุ่ม  เลือก วัน เดือน ปี เกิด

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 1);
            }   // onClick
        });
    } // จบ onCreate

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Log.d("SutFriendV1", "Result ==> Success");
            //Find Path of Image
            Uri uri = data.getData();
            imagePathString = myFindPath(uri);
            Log.d("SutFriendV1", "imagePathString ==> " + imagePathString);
            //Setup ImageView
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(uri));
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            statusABoolean = false;
            imageNameString = imagePathString.substring(imagePathString.lastIndexOf("/"));
            Log.d("SutFriendV1", "imageNameSting ==> " + imageNameString);
        }   // จบ if
    }   // จบ onActivityResult

    private String myFindPath(Uri uri) {
        String strResult = null;
        String[] strings = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            strResult = cursor.getString(index);
        } else {
            strResult = uri.getPath();
        }
        return strResult;
    } // จบ myFindPath

    private byte[] imageViewToByte(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    } // จบ imageViewToByte

    public void RadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Sex_Emp1:
                if (checked)
                    Sex_Emp0 = "หญิง";
                break;
            case R.id.Sex_Emp2:
                if (checked)
                    Sex_Emp0 = "ชาย";
                break;
        }
    } // จบ RadioButtonClicked

    private void buttonController() {
        Name_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAuthen();
//                // ดึงวัน เวลา มาจากเครื่องคอม
//                final Calendar c = Calendar.getInstance();
//                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                String dateapp_emp = df.format(c.getTime());
//                //
//                position_emp = Position_Emp.getText().toString().trim();
//                salary_emp = Salary_Emp.getText().toString().trim();
//
//                idcard_emp = Idcard_Emp.getText().toString().trim();
//                name_emp = Name_Emp.getText().toString().trim();
//                nickname_emp = Nickname_Emp.getText().toString().trim();
//                datebirth_emp = DateBirth_Emp.getText().toString().trim();
//                age_emp = Age_Emp.getText().toString().trim();
//
//                address_emp = Address_Emp.getText().toString().trim();
//                tele_emp = Tele_Emp.getText().toString().trim();
//
//                line_emp = Line_Emp.getText().toString().trim();
//                facebook_emp = Facebook_Emp.getText().toString().trim();
//                email_emp = Email_Emp.getText().toString().trim();
//
//                imageViewToByte(imageView);
//
//                if (position_emp.equals("")||
//                        salary_emp.equals("")||
//
//                        idcard_emp.equals("")||
//                        name_emp.equals("")||
//                        nickname_emp.equals("")||
//                        age_emp.equals("")||
//
//                        address_emp.equals("")||
//                        tele_emp.equals("")) {
//                    Toast.makeText(Name_Add.this, "กรุณากรอก ให้ครบทุกช่อง ", Toast.LENGTH_SHORT).show();
//                }else {
//                    MyName myName =new MyName(Name_Add.this);
//                    myName.addNewValue(
//                            position_emp,
//                            salary_emp,
//
//                            idcard_emp,
//                            name_emp,
//                            nickname_emp,
//                            Sex_Emp0,
//                            datebirth_emp,
//                            age_emp,
//
//                            address_emp,
//                            tele_emp,
//
//                            line_emp,
//                            facebook_emp,
//                            email_emp,
//                            dateapp_emp,
//                            imageViewToByte(imageView)
//                            );
////                    finish();
//                    Position_Emp.setText("");
//                    Salary_Emp.setText("");
//
//                    Idcard_Emp.setText("");
//                    Name_Emp.setText("");
//                    Nickname_Emp.setText("");
//                    DateBirth_Emp.setText("");
//                    Age_Emp.setText("");
//
//                    Address_Emp.setText("");
//                    Tele_Emp.setText("");
//
//                    Line_Emp.setText("");
//                    Facebook_Emp.setText("");
//                    Email_Emp.setText("");
//
//                    imageView.setImageResource(R.drawable.user255);
//                } // จบ else

            } // จบ onClick
        }); // จบ ปุ่ม Name_Save
    }// จบ buttonController

    private void checkAuthen() {
        final Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateapp_emp = df.format(c.getTime());
        //
        position_emp = Position_Emp.getText().toString().trim();
        salary_emp = Salary_Emp.getText().toString().trim();
        idcard_emp = Idcard_Emp.getText().toString().trim();
        name_emp = Name_Emp.getText().toString().trim();
        nickname_emp = Nickname_Emp.getText().toString().trim();
        datebirth_emp = DateBirth_Emp.getText().toString().trim();
        age_emp = Age_Emp.getText().toString().trim();
        address_emp = Address_Emp.getText().toString().trim();
        tele_emp = Tele_Emp.getText().toString().trim();
        line_emp = Line_Emp.getText().toString().trim();
        facebook_emp = Facebook_Emp.getText().toString().trim();
        email_emp = Email_Emp.getText().toString().trim();
        imageViewToByte(imageView);

//            if (checkUser()) {
//                Toast.makeText(getApplicationContext(), idcard_emp + idcard_emp2 + " ยังไม่ได้กรอก 2", Toast.LENGTH_SHORT).show();
//            } else {
        // ดึงวัน เวลา มาจากเครื่องคอม

        if (position_emp.equals("") || salary_emp.equals("") ||     //ตำแหน่ง       //เงินวัน
                idcard_emp.equals("") || name_emp.equals("") ||     //รหัสบัตร      //ชื่อจริง
                nickname_emp.equals("") || age_emp.equals("") ||    //ชื่อเล่น      //อายุ
                address_emp.equals("") || tele_emp.equals("")) {    //ที่อยุ่       //เบอร์โทร
            Toast.makeText(Name_Add.this, "กรุณากรอก ให้ครบทุกช่อง ", Toast.LENGTH_SHORT).show();
        } else if (!checkUser()) {
            Toast.makeText(getApplicationContext(), name_emp + " มีอยุ่แล้ว ", Toast.LENGTH_SHORT).show();
        } else {
            MyName myName = new MyName(Name_Add.this);
            myName.addNewValue(
                    position_emp, salary_emp, idcard_emp, name_emp, nickname_emp, Sex_Emp0, datebirth_emp,
                    age_emp, address_emp, tele_emp, line_emp, facebook_emp, email_emp, dateapp_emp,
                    imageViewToByte(imageView)
            );
//                    finish();
            Position_Emp.setText("");
            Salary_Emp.setText("");
            Idcard_Emp.setText("");
            Name_Emp.setText("");
            Nickname_Emp.setText("");
            DateBirth_Emp.setText("");
            Age_Emp.setText("");
            Address_Emp.setText("");
            Tele_Emp.setText("");
            Line_Emp.setText("");
            Facebook_Emp.setText("");
            Email_Emp.setText("");
            imageView.setImageResource(R.drawable.user255);
            Toast.makeText(getApplicationContext(), name_emp + " บันทึกข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
        } // จบ else
//            }
    } // จบ checkAuthen

    private boolean checkUser() {
        boolean result = true;
        try {
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
            Cursor cursor5 = sqLiteDatabase.rawQuery("SELECT * FROM Employee_db", null);
            cursor5.moveToFirst();
            for (int i = 0; i < cursor5.getCount(); i++) {
                if (idcard_emp.equals(cursor5.getString(3))) {
                    result = false;
                    idcard_emp2 = cursor5.getString(3);
                }
                cursor5.moveToNext();
            }// จบ for
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    } // จบ checkUser

    private void bindWidget() {
        Position_Emp = (EditText) findViewById(R.id.Position_Emp);              //ตำแหน่ง           15
        Salary_Emp = (EditText) findViewById(R.id.Salary_Emp);                  //เงินเดือน           12
        Idcard_Emp = (EditText) findViewById(R.id.Idcard_Emp);                  //รหัสบัตรประชาชน     1
        Name_Emp = (EditText) findViewById(R.id.Name_Emp);                      //ชื่อ               2
        Nickname_Emp = (EditText) findViewById(R.id.Nickname_Emp);              //ชื่อเล่น             7
        DateBirth_Emp = (EditText) findViewById(R.id.DateBirth_Emp);            //วัน เดือน ปี เกิด      5
        Age_Emp = (EditText) findViewById(R.id.Age_Emp);                        //อายุ               4
        Address_Emp = (EditText) findViewById(R.id.Address_Emp);                //ที่อยู่               6
        Tele_Emp = (EditText) findViewById(R.id.Tele_Emp);                      //เบอร์โทร            8
        Line_Emp = (EditText) findViewById(R.id.Line_Emp);                      //ไลน์               9
        Facebook_Emp = (EditText) findViewById(R.id.Facebook_Emp);              //เฟส               10
        Email_Emp = (EditText) findViewById(R.id.Email_Emp);                    //อีเมล              11
        imageView = (ImageView) findViewById(R.id.Image_Emp);                   //รูป               14
        Name_Save = (Button) findViewById(R.id.Name_Save);                       // ปุ่ม บันทึก
    } // จบ bindWidget
} // จบ class Name_Add
