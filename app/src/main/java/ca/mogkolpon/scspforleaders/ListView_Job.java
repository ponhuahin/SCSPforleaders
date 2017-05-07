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
 * Created by User-Gamer on 3/23/2017.
 */

public class ListView_Job extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<Job_ToList> myTodoJOB;
    int job;

    public ListView_Job(Activity activity, ArrayList<Job_ToList> mtTodoJOB) {
        this.myTodoJOB = mtTodoJOB;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return myTodoJOB.size();
    }

    @Override
    public Job_ToList getItem(int position) {
        return myTodoJOB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myTodoJOB.get(position).getID_Job();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listview_job, null);
        TextView textView = (TextView) v.findViewById(R.id.lv_job_name);
        TextView textView1 = (TextView) v.findViewById(R.id.lv_job_money);
        TextView textView2 = (TextView) v.findViewById(R.id.lv_job_dateget);
        TextView textView3 = (TextView) v.findViewById(R.id.lv_job_datedue);
        TextView textView4 = (TextView) v.findViewById(R.id.lv_job_name_com);

        Job_ToList todo_JOB = myTodoJOB.get(position);
        textView.setText(todo_JOB.getName_Job());

        Job_ToList todo_JOB1 = myTodoJOB.get(position);
        textView1.setText(todo_JOB1.getMoney_Job());

        Job_ToList todo_JOB2 = myTodoJOB.get(position);
        textView2.setText(todo_JOB2.getDateGet_Job());

        Job_ToList todo_JOB3 = myTodoJOB.get(position);
        textView3.setText(todo_JOB3.getDateDue_Job());

        Job_ToList todo_JOB4 = myTodoJOB.get(position);
        textView4.setText(todo_JOB4.getName_Com_Job());

        return v;
    } // จบ View getView
} // จบ class ListView_Job
