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
 * Created by User-Gamer on 3/22/2017.
 */

public class ListView_Admin extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<Admin_ToList> myToList;

    public ListView_Admin(Activity activity, ArrayList<Admin_ToList> mtToList) {
        this.myToList = mtToList;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myToList.size();
    }

    @Override
    public Admin_ToList getItem(int position) {
        return myToList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myToList.get(position).getID_admin();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.listview_admin, null);
        TextView textView = (TextView) v.findViewById(R.id.admin_Name);
        TextView textView1 = (TextView) v.findViewById(R.id.admin_Username);
        TextView textView2 = (TextView) v.findViewById(R.id.admin_Password);

        Admin_ToList admin_toList = myToList.get(position);
        textView.setText(admin_toList.getName_admin());

        Admin_ToList admin_toList1=myToList.get(position);
        textView1.setText(admin_toList1.getUsername_admin());

        Admin_ToList admin_toList2=myToList.get(position);
        textView2.setText(admin_toList2.getPassword_admin());
        return v;
    }
}
