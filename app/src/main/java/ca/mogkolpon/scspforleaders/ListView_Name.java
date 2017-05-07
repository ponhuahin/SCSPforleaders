package ca.mogkolpon.scspforleaders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class ListView_Name extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<Name_ToList> myNameToList;

    public ListView_Name(Activity activity, ArrayList<Name_ToList> mtNameToList) {
        this.myNameToList = mtNameToList;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myNameToList.size();
    }

    @Override
    public Name_ToList getItem(int position) {
        return myNameToList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myNameToList.get(position).getID_Emp();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.listview_name, null);
        TextView textView = (TextView) v.findViewById(R.id.name_ListView_name);
        TextView textView1 = (TextView) v.findViewById(R.id.name_ListView_Position);
        ImageView imageView=(ImageView)v.findViewById(R.id.name_ListView_Image);

        Name_ToList name_toList = myNameToList.get(position);
        textView.setText(name_toList.getName_Emp());

        Name_ToList name_toList1=myNameToList.get(position);
        textView1.setText(name_toList1.getPosition_Emp());

        byte[] image_Emp = Name_ToList.getImage_Emp();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image_Emp, 0, image_Emp.length);
        imageView.setImageBitmap(bitmap);
        return v;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }
}
