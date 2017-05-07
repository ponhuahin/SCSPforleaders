package ca.mogkolpon.scspforleaders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Z_Name_List extends AppCompatActivity {

    ListView listView;
    ArrayList<Z_MyDataList> list;
    Z_Name_List_View adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_name_list);
        listView = (ListView) findViewById(R.id.name_ListView);
        list = new ArrayList<>();
        adapter = new Z_Name_List_View(this, R.layout.z_my_list_view, list);
        listView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = Z_Name_SignUp.sqLiteHelper.getData("SELECT * FROM Employee_db");
        list.clear();
        while (cursor.moveToNext()) {

            int ID_Emp = cursor.getInt(0);
            String Name_Emp = cursor.getString(1);
            String Nickname_Emp = cursor.getString(2);
            String Age_Emp = cursor.getString(3);
            byte[] image = cursor.getBlob(12);

            list.add(new Z_MyDataList(ID_Emp, Name_Emp, Nickname_Emp, Age_Emp, image));
        }
        adapter.notifyDataSetChanged();
        // กด ปกติ
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
            }
        });//  จบ กด ปกติ

    }
}
