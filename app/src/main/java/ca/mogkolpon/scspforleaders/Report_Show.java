package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Report_Show extends AppCompatActivity {
    ListView workListView;
    private String r11;
    private String r22;
    private String r33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_show);
        workListView = (ListView) findViewById(R.id.work_ListView1);


    }


    protected void onResume() {
        super.onResume();
        Report_ListDAO report_listDAO = new Report_ListDAO(getApplicationContext());
        report_listDAO.open();
        ArrayList<Work_ToList> myList = report_listDAO.getAllListDAO();

        final ListView_Report adapter = new ListView_Report(this, myList);
        workListView.setAdapter(adapter);
        report_listDAO.close();

        // โชว์ รวท ทำงาน เบิก คงเหลือ
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
        try {
            Cursor cursor5 = sqLiteDatabase.rawQuery("SELECT SUM( b.Workoff_Wor),SUM( b.Withdraw_Wor),SUM((( b.Workoff_Wor)* a.Salary_Emp )- (b.Withdraw_Wor))\n" +
                    "FROM Employee_db a, Workoff_db b\n" +
                    "WHERE a.Idcard_Emp = b.ID_Emp_Wor", null);
            cursor5.moveToFirst();
            TextView r1 = (TextView) findViewById(R.id.R1);
            TextView r2 = (TextView) findViewById(R.id.R2);
            TextView r3 = (TextView) findViewById(R.id.R3);
            r1.setText(r11 = cursor5.getString(0));
            r2.setText(r22 = cursor5.getString(1));
            r3.setText(r33 = cursor5.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //กด ค้าง
        workListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Report_Show.this);
                builder.setIcon(R.drawable.garbage_full_48);
                builder.setTitle("ลบข้อมูลการทำงาน/เบิก");
                builder.setMessage("คุณต้องการลบข้อมูล การทำงาน/การเบิก ทั้งหมดนี้ใช่หรือไม่?");
                builder.setPositiveButton("ลบทั้งหมด", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), " ลบข้อมูลทั้งหมด เรียบร้อย  ",Toast.LENGTH_LONG).show();
                        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
                        Cursor cursor5 = sqLiteDatabase.rawQuery("DELETE FROM Workoff_db", null);
                        cursor5.moveToFirst();
                    }
                });
                builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "ยกเลิก การลบแล้ว ",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
                return true;
            }
        }); // จบ กด ค้าง
    }

}
