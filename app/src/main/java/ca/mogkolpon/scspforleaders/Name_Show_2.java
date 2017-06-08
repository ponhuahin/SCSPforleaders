package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Name_Show_2 extends AppCompatActivity {
    ListView nameListView;
    private SQLiteDatabase database;
    private MyData myData;
    Cursor cursor;
    ListView listView;
    ArrayList<Z_MyDataList> list;
    ListView_Name_2 adapter = null;

//    private SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name__show_2);
        listView = (ListView) findViewById(R.id.name_ListView_2);

        list = new ArrayList<Z_MyDataList>();
        adapter = new ListView_Name_2(this, R.layout.listview_name_2, list);
        listView.setAdapter(adapter);

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM Employee_db", null);
        list.clear();
        while (cursor.moveToNext()) {

            int ID_Emp = cursor.getInt(0);
            String Position_Emp = cursor.getString(1);
            String Salary_Emp = cursor.getString(2);
            String Name_Emp = cursor.getString(4);
            String Nickname_Emp = cursor.getString(5);
            String Age_Emp = cursor.getString(8);
            byte[] image = cursor.getBlob(15);

            list.add(new Z_MyDataList(ID_Emp, Position_Emp, Salary_Emp, Name_Emp, Nickname_Emp, Age_Emp, image));
        }
        adapter.notifyDataSetChanged();

//        mSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
//        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                (new Handler()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        while (cursor.moveToNext()) {
//
//                            int ID_Emp = cursor.getInt(0);
//                            String Position_Emp = cursor.getString(1);
//                            String Salary_Emp = cursor.getString(2);
//                            String Name_Emp = cursor.getString(4);
//                            String Nickname_Emp = cursor.getString(5);
//                            String Age_Emp = cursor.getString(8);
//                            byte[] image = cursor.getBlob(15);
//
//                            list.add(new Z_MyDataList(ID_Emp, Position_Emp, Salary_Emp, Name_Emp, Nickname_Emp, Age_Emp, image));
//                        }
//                        adapter.notifyDataSetChanged();
//                        mSwipe.setRefreshing(false);
//                    }
//                },3000);
//            }
//        });


    } // จบ onCreate

    protected void onResume() {
        super.onResume();
// กด ปกติ
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                try {
                    cursor.moveToPosition(position);
                    String name = cursor.getString(cursor.getColumnIndex(MyData.ID_Emp));
                    Intent eaitIntent = new Intent(getApplicationContext(), Work_NAME_JOB_2.class);
                    eaitIntent.putExtra("NAME", name);
                    startActivity(eaitIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//  จบ กด ปกติ
        //กด ค้าง
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
//                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show_2.this);
                try {
                    cursor.moveToPosition(position);
                    String name = cursor.getString(cursor.getColumnIndex(MyData.ID_Emp));
//                    Intent eaitIntent = new Intent(getApplicationContext(), Name_Show_3.class);
                    Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait_2.class);
                    eaitIntent.putExtra("NAME", name);
                    startActivity(eaitIntent);
//                    finish();

                    finish();
//                    overridePendingTransition(0, 0);
//                    startActivity(getIntent());
//                    overridePendingTransition(0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                builder.show();
                return true;
            }
        }); // จบ กด ค้าง
    } // จบ onResume

}// จบ class Name_Show
