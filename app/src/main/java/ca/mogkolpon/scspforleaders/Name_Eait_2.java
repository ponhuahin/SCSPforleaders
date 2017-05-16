package ca.mogkolpon.scspforleaders;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.squareup.picasso.Picasso;

public class Name_Eait_2 extends AppCompatActivity {
    private ImageView imageView ;
    private String W_1, name1, W_2, workListView22;
    private String t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    private int t0,t15;
    Cursor mCursor;
    String name;
    private SQLiteDatabase database;
    private MyData myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_eait_2);

        name = getIntent().getExtras().getString("NAME");
        myData = new MyData(this);
        database = myData.getWritableDatabase();

        mCursor = database.rawQuery("SELECT * FROM Employee_db "
                + " WHERE ID_Emp ='" + name + "'", null);
        mCursor.moveToFirst();

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
//        imageView = (ImageView) findViewById(R.id.Image_Emp_eait);

        A1.setText(t1 = mCursor.getString(1));
        A2.setText(t2 = mCursor.getString(2));
        A3.setText(t3 = mCursor.getString(3));
        A4.setText(t4 = mCursor.getString(4));
        A5.setText(t5 = mCursor.getString(5));
        A6.setText(t6 = mCursor.getString(7));
        A7.setText(t7 = mCursor.getString(8));
        A8.setText(t8 = mCursor.getString(9));
        A9.setText(t9 = mCursor.getString(10));
        A10.setText(t10 = mCursor.getString(11));
        A11.setText(t11 = mCursor.getString(12));
        A12.setText(t12 = mCursor.getString(13));

        //Show Image
//        Picasso.with(this)
////                .load(getIntent().getStringExtra(String.valueOf(15)))
//                .load(getIntent().getByteExtra(mCursor.getString(15)))
//                .resize(150,150)
//                .into(imageView);

        // ปุ้ม แก้ไข ข้อมูล  //
        final Button editBtn = (Button) findViewById(R.id.Name_Save_eait);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name_ToList name_toList1 = new Name_ToList();
                name_toList1.setID_Emp(t0 = mCursor.getInt(0));

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
                try {
                    database.delete(MyData.TABLE_NAME_Emp, MyData.ID_Emp + "=" + name, null);
                    Toast.makeText(getApplicationContext(), name + " ลบข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    } // จบ onCreate
} // จบ class Name_Eait
