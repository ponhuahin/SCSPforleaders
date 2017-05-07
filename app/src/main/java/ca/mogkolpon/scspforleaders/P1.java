package ca.mogkolpon.scspforleaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class P1 extends AppCompatActivity {
    ListView workListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);

        workListView = (ListView) findViewById(R.id.work_ListView1);
    }
    protected void onResume() {
        super.onResume();
        Work_ListDAO work_listDAO = new Work_ListDAO(getApplicationContext());
        work_listDAO.open();
        ArrayList<Work_ToList> myList = work_listDAO.getAllListDAO();

        final ListView_Work adapter = new ListView_Work(this, myList);
        workListView.setAdapter(adapter);
        work_listDAO.close();


    }
}
