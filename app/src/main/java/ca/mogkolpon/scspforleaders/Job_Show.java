package ca.mogkolpon.scspforleaders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Job_Show extends AppCompatActivity {
    ListView jobListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_show);

        jobListView = (ListView) findViewById(R.id.job_ListView);
    } // จบ onCreate
    protected void onResume() { //เพื่อให้ เวลาเพิ่มข้อมูลจะอัพเดอรืข้อมูลให้ใหม่ คือ เพิ่มข้อมูลจะขึ้นทันที
        super.onResume();
        Job_ListDAO job_listDAO1 = new Job_ListDAO(getApplicationContext());
        job_listDAO1.open();
        ArrayList<Job_ToList> myList = job_listDAO1.getAllTodoList();

        final ListView_Job adapter = new ListView_Job(this, myList);
        jobListView.setAdapter(adapter);
        job_listDAO1.close();

// กดปกติ
        jobListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public void onItemClick(AdapterView<?> patent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                Intent editIntent = new Intent(getApplicationContext(), Job_Edit.class);
                editIntent.putExtra("editTodoList",adapter.getItem(position));
                startActivity(editIntent);
//                dialog.cancel();

            }
        });
//// กดค้าง
//        jobListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
//            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Job_Show.this);
//
//                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
//                Intent editIntent = new Intent(getApplicationContext(), Job_Show_Name.class);
//                editIntent.putExtra("editTodoList",adapter.getItem(position));
//                startActivity(editIntent);
////                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int which) {
////
////                    }
////                });
////                builder.setNegativeButton("แก้ไข/ลบ", new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int which) {
////                        Intent editIntent = new Intent(getApplicationContext(), Job_Edit.class);
////                        editIntent.putExtra("editTodoList",adapter.getItem(position));
////                        startActivity(editIntent);
////                        dialog.cancel();
////                    }
////                });
////                builder.show();
//                return true;
//            }
//        });
    }
    public void job_add(View view){
        Button job_add = (Button)findViewById(R.id.job_add);
        Intent intent=new Intent(Job_Show.this,Job_Add.class);
        startActivity(intent);
    }
//    public void onBackPressed(){
//        Intent intent = new Intent(Job_Show.this, SCSP.class);
//        startActivity(intent);
//        finish();
//    }
} //  จบ class Job_Show
