package ca.mogkolpon.scspforleaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Report_Show extends AppCompatActivity {
    ListView workListView;
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
    }
}
