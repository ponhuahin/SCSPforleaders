package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Name_Show extends AppCompatActivity {
    ListView nameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_show);

        nameListView =(ListView)findViewById(R.id.name_ListView);


    } // จบ onCreate

    protected void onResume(){
        super.onResume();
        Name_ListDAO name_listDAO1 = new Name_ListDAO(getApplicationContext());
        name_listDAO1.open();
        ArrayList<Name_ToList>myList = name_listDAO1.getAllListDAO();

        final ListView_Name adapter = new ListView_Name(this,myList);
        nameListView.setAdapter(adapter);
        name_listDAO1.close();

        // กด ปกติ
        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                Intent eaitIntent = new Intent(getApplicationContext(), Work_NAME_JOB.class);
                eaitIntent.putExtra("eait", adapter.getItem(position));
                startActivity(eaitIntent);
            }
        });//  จบ กด ปกติ

        //กด ค้าง
        nameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show.this);
//                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
                builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait.class);
                        eaitIntent.putExtra("eait", adapter.getItem(position));
                        startActivity(eaitIntent);
                        dialog.cancel();
                    }
                });
                builder.show();
                return true;
            }
        }); // จบ กด ค้าง
    } // จบ onResume
    public void onBackPressed(){
        Intent intent = new Intent(Name_Show.this, SCSP.class);
        startActivity(intent);
        finish();
    }
}// จบ class Name_Show
