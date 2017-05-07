package ca.mogkolpon.scspforleaders;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 5/7/2017.
 */

public class ListView_Report extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<Work_ToList> myToList;

    public ListView_Report(Activity activity, ArrayList<Work_ToList> mtToList) {
        this.myToList = mtToList;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myToList.size();
    }

    @Override
    public Work_ToList getItem(int position) {
        return myToList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myToList.get(position).getID_Wor();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.listview_report, null);
        TextView textView = (TextView) v.findViewById(R.id.work_Name);
        TextView textView1 = (TextView) v.findViewById(R.id.work_Username);
        TextView textView2 = (TextView) v.findViewById(R.id.work_Password);
        TextView textView3 = (TextView) v.findViewById(R.id.ID_Emp_Wor1);

//        Work_ToList work_toList = myToList.get(position);
//        textView.setText(work_toList.getWithdraw_Wor());
        Work_ToList work_toList = myToList.get(position);
        textView.setText(work_toList.getWithdraw_Wor());

        Work_ToList work_toList1 = myToList.get(position);
        textView1.setText(work_toList1.getWorkoff_Wor());

        Work_ToList work_toList2 = myToList.get(position);
        textView2.setText(work_toList2.getDateApp_Wor());

        Work_ToList work_toList3 = myToList.get(position);
        textView3.setText(work_toList3.getID_Emp_Wor());
        return v;
    }
}
