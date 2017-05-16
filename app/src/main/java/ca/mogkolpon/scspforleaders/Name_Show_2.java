package ca.mogkolpon.scspforleaders;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name__show_2);
//        nameListView = (ListView) findViewById(R.id.name_ListView_2);

        listView = (ListView) findViewById(R.id.name_ListView_2);

        list = new ArrayList<Z_MyDataList>();
        adapter = new ListView_Name_2(this, R.layout.listview_name_2, list);
        listView.setAdapter(adapter);

//        Name_ListDAO name_listDAO1 = new Name_ListDAO(getApplicationContext());
//        name_listDAO1.open();
//        ArrayList<Name_ToList> myList = name_listDAO1.getAllListDAO();
//
//        final ListView_Name adapter = new ListView_Name(this, myList);
//        nameListView.setAdapter(adapter);
//        name_listDAO1.close();

        // get all data from sqlite
//        Cursor cursor = Z_Name_SignUp.sqLiteHelper.getData("SELECT * FROM Employee_db");
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

            list.add(new Z_MyDataList(ID_Emp,Position_Emp,Salary_Emp, Name_Emp, Nickname_Emp, Age_Emp, image));
        }
        adapter.notifyDataSetChanged();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
//            }
//        });//  จบ กด ปกติ

//        //กด ค้าง
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
//            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
//                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show_2.this);
//                Intent eaitIntent = new Intent(getApplicationContext(), Name_Show.class);
//                eaitIntent.putExtra("eait", String.valueOf(adapter.getItem(position)));
//                startActivity(eaitIntent);
//                builder.show();
//                return true;
//            }
//        }); // จบ กด ค้าง


    } // จบ onCreate
    protected void onResume() {
        super.onResume();
// กด ปกติ
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
//                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name, MODE_PRIVATE, null);
//                Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT * FROM Employee_db", null);
//                cursor1.moveToFirst();

                try {
                    cursor.moveToPosition(position);
//
//                    String name = mCursor.getString(mCursor.getColumnIndex(DatabaseStudent.COL_NAME));
//                    String lastname = mCursor.getString(mCursor.getColumnIndex(DatabaseStudent.COL_LASTNAME));
//                    String school = mCursor.getString(mCursor.getColumnIndex(DatabaseStudent.COL_SCHOOL));
//
//                    Intent intent = new Intent(getApplicationContext(), UpdateStudent.class);
//                    intent.putExtra("NAME", name);
//                    intent.putExtra("LASTNAME", lastname);
//                    intent.putExtra("SCHOOL", school);
//                    startActivity(intent);

                    String name = cursor.getString(cursor.getColumnIndex(MyData.ID_Emp));
                    Intent eaitIntent = new Intent(getApplicationContext(), Work_NAME_JOB_2.class);
                    eaitIntent.putExtra("NAME", name);


//                    eaitIntent.putExtra("eait", String.valueOf(adapter.getItemId(position)));
                    startActivity(eaitIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//  จบ กด ปกติ
        //กด ค้าง
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show_2.this);
                try {
                    cursor.moveToPosition(position);
                    String name = cursor.getString(cursor.getColumnIndex(MyData.ID_Emp));
                    Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait_2.class);
                    eaitIntent.putExtra("NAME", name);

//                Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait.class);
//                eaitIntent.putExtra("eait", adapter.getItem(position));
//                startActivity(eaitIntent);

                    startActivity(eaitIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                builder.show();
                return true;
            }
        }); // จบ กด ค้าง
    } // จบ onResume
//    protected void onResume() {
//        super.onResume();
//        Name_ListDAO name_listDAO1 = new Name_ListDAO(getApplicationContext());
//        name_listDAO1.open();
//        ArrayList<Name_ToList> myList = name_listDAO1.getAllListDAO();
//
//        final ListView_Name_2 adapter = new ListView_Name_2(this, myList);
//        nameListView.setAdapter(adapter);
//        name_listDAO1.close();
//
//        // กด ปกติ
//        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
//                Intent eaitIntent = new Intent(getApplicationContext(), Work_NAME_JOB.class);
//                eaitIntent.putExtra("eait", adapter.getItem(position));
//                startActivity(eaitIntent);
//                // ทดลองเพิ่ม
//                try {
//                    Intent eaitIntent1 = new Intent(getApplicationContext(), Work_ListDAO.class);
//                    eaitIntent1.putExtra("eait", adapter.getItem(position));
//                    startActivity(eaitIntent1);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });//  จบ กด ปกติ
////กด ค้าง
//        nameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
//            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
//                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show_2.this);
//                Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait.class);
//                eaitIntent.putExtra("eait", adapter.getItem(position));
//                startActivity(eaitIntent);
//                builder.show();
//                return true;
//            }
//        }); // จบ กด ค้าง
////        //กด ค้าง
////        nameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
////            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
////                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Name_Show_2.this);
//////                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
//////                    public void onClick(DialogInterface dialog, int which) {
//////                        try {
//////                            database.delete(MyData.TABLE_NAME,MyData.ID_Wor + "=" + ID_Wor.get(arg2), null);
//////                            Toast.makeText( getApplicationContext(), jbt.get(arg2) + " ลบข้อมูลเรียบร้อย ", Toast.LENGTH_SHORT).show();
//////                            dialog.cancel();
//////                        } catch (Exception e) {
//////                            e.printStackTrace();
//////                        }
//////                    }
//////                });
////                builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int which) {
////
////                        Intent eaitIntent = new Intent(getApplicationContext(), Name_Eait.class);
////                        eaitIntent.putExtra("eait", adapter.getItem(position));
////                        startActivity(eaitIntent);
////                        dialog.cancel();
////                    }
////                });
////                builder.show();
////                return true;
////            }
////        }); // จบ กด ค้าง
//    } // จบ onResume
}// จบ class Name_Show
