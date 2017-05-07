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

public class Admin_Show extends AppCompatActivity {
    ListView adminListView;
//    private SQLiteDatabase database;
//    private MyData myData;
//    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_show);

        adminListView = (ListView) findViewById(R.id.admin_ListView);
    } // จบ onCreate

    protected void onResume() {
        super.onResume();
        Admin_ListDAO admin_listDAO = new Admin_ListDAO(getApplicationContext());
        admin_listDAO.open();
        ArrayList<Admin_ToList> myList = admin_listDAO.getAllAdminToList();

        final ListView_Admin adapter = new ListView_Admin(this, myList);
        adminListView.setAdapter(adapter);
        admin_listDAO.close();
// กด ปกติ
        adminListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
            }
        });//  จบ กด ปกติ
//กด ค้าง
        adminListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Admin_Show.this);
                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent eaitIntent = new Intent(getApplicationContext(), Admin_Eait.class);
                        eaitIntent.putExtra("eait", adapter.getItem(position));
                        startActivity(eaitIntent);
//                        dialog.cancel();
                    }
                });
                builder.show();
                return true;
            }
        }); // จบ กด ค้าง

    } // จบ onResume
} // จบ class Admin_Show
