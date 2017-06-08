package ca.mogkolpon.scspforleaders;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Job_Show_Name extends AppCompatActivity {
    String edit60, edit60_A, edit40, edit40_B;
    int A = 100;
    int S1;
    private String W_1, name1, W_2, s2, workListView22, MoneyString, name_Text1;
    //    private EditText Edit60;
//    private EditText Edit60_A;
//    private String name1;
    int pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_show_name);

        final Job_ToList editTodoList = (Job_ToList) getIntent().getSerializableExtra("editTodoList");

        final TextView B1 = (TextView) findViewById(R.id.Name_Job_edit);
        final TextView B2 = (TextView) findViewById(R.id.Address_Job_edit);
        final TextView B3 = (TextView) findViewById(R.id.Money_Job_edit);
        final TextView B5 = (TextView) findViewById(R.id.DateGet_Job_edit);
        final TextView B6 = (TextView) findViewById(R.id.DateDue_Job_edit);
        final TextView B7 = (TextView) findViewById(R.id.Specs_Job_edit);
        final TextView B8 = (TextView) findViewById(R.id.Name_Com_Job_edit);
        final TextView B9 = (TextView) findViewById(R.id.Address_Com_Job_edit);
        final TextView B10 = (TextView) findViewById(R.id.Tele_Job_edit);
        final TextView B11 = (TextView) findViewById(R.id.Line_Job_edit);
        final TextView B12 = (TextView) findViewById(R.id.Facebook_Job_edit);
        final TextView B13 = (TextView) findViewById(R.id.Email_Job_edit);

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

//        final EditText Edit60 = (EditText) findViewById(R.id.edit60);
//        final EditText Edit40 = (EditText)findViewById(R.id.edit40);
////        final TextView Edit60_A = (TextView)findViewById(R.id.edit60_A);
//        final TextView Edit40_B = (TextView)findViewById(R.id.edit40_B);

        try {
            // เริ่ม
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
            Cursor cursor6 = sqLiteDatabase.rawQuery("SELECT * FROM Job_db WHERE Name_Job= '" + B1 + "'", null);
            cursor6.moveToFirst();

            String vb = editTodoList.getMoney_Job();

            EditText Name_Text1 = (EditText) findViewById(R.id.edit60);
//            Name_Text1.setText(edit60);
            name_Text1 = Name_Text1.getText().toString().trim();

            EditText name_Text2 = (EditText) findViewById(R.id.edit60_A);
            int dd = Integer.parseInt(name_Text1);
            name_Text2.setText(edit60_A = String.valueOf(dd / 100));
//            TextView name_Text3 = (TextView) findViewById(R.id.edit60_A);
//            int W_name1 = Integer.parseInt(s2);
//            int W_name2 = Integer.parseInt(W_1);
//            int ss = Integer.parseInt(String.valueOf(W_name2 * W_name1));
//            int ss1 = Integer.parseInt(MoneyString);
//
//            name_Text3.setText(name1 = String.valueOf(ss - ss1));

//        / เรียกฐานข้อมูล มาใช้แล้ว รวมรายได้ ทั้งหมด จบ
        } catch (Exception e) {
            e.printStackTrace();
        }
//        EditText Edit60 = (EditText) findViewById(R.id.edit60);
//        edit60 = Edit60.getText().toString().trim();
//
//        EditText Edit60_A = (EditText)findViewById(R.id.edit60_A);
//
////        edit60_A = Edit60_A.getText().toString().trim();
////        Edit60_A.getooText(String.valueOf(pp));
////       String age = String.valueOf(500/(600*10));
////        Edit60_A.setText(age);
//
//        int W_name1 = Integer.parseInt(edit60);
//        int W_name2 = Integer.parseInt(String.valueOf(100));
//        edit60_A = String.valueOf(Integer.parseInt(String.valueOf(W_name2 * W_name1)));
//
//        int ss1 = 100;
//        Edit60_A.setText(name1 = String.valueOf(edit60 - ss1));

    }
}
