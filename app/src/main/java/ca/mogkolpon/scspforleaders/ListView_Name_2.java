package ca.mogkolpon.scspforleaders;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
 * Created by User-Gamer on 5/15/2017.
 */

public class ListView_Name_2 extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    private  int layout;
    ArrayList<Z_MyDataList> myNameToList;

    public ListView_Name_2(Activity activity,int layout, ArrayList<Z_MyDataList> mtNameToList) {
        this.myNameToList = mtNameToList;
        this.activity = activity;
        this.layout = layout;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return myNameToList.size();
    }

    @Override
    public Z_MyDataList getItem(int position) {
        return myNameToList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myNameToList.get(position).getID_Emp();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
//            row = inflater.inflate(R.layout.listview_name_2, null);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.name_ListView_name);
            holder.txtPosition = (TextView) row.findViewById(R.id.name_ListView_Position);
            holder.imageView = (ImageView) row.findViewById(R.id.name_ListView_Image);
            holder.txtNickname = (TextView) row.findViewById(R.id.Nickname_Emp_L);
            holder.txtAge = (TextView) row.findViewById(R.id.Age_Emp_L);
            holder.txtSalary = (TextView) row.findViewById(R.id.Salary_Emp_L);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Z_MyDataList food = myNameToList.get(position);

        holder.txtName.setText(food.getName_Emp());
        holder.txtPosition.setText(food.getPosition_Emp());

        holder.txtNickname.setText(food.getNickname_Emp());
        holder.txtAge.setText(food.getAge_Emp());
        holder.txtSalary.setText(food.getSalary_Emp());

        byte[] foodImage = food.getImage_Emp();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
//        View v = convertView;
//        v = inflater.inflate(R.layout.listview_name_2, null);
//        TextView textView = (TextView) v.findViewById(R.id.name_ListView_name);
//        TextView textView1 = (TextView) v.findViewById(R.id.name_ListView_Position);
//        ImageView imageView = (ImageView) v.findViewById(R.id.name_ListView_Image);
//        TextView textView2 = (TextView) v.findViewById(R.id.Nickname_Emp_L);
//        TextView textView3 = (TextView) v.findViewById(R.id.Age_Emp_L);
//        TextView textView4 = (TextView) v.findViewById(R.id.Salary_Emp_L);
//
//        Name_ToList name_toList = myNameToList.get(position);
//        textView.setText(name_toList.getName_Emp());
//
//        Name_ToList name_toList1 = myNameToList.get(position);
//        textView1.setText(name_toList1.getPosition_Emp());
//
////        byte[] image_Emp = Name_ToList.getImage_Emp();
////        Bitmap bitmap = BitmapFactory.decodeByteArray(image_Emp, 0, image_Emp.length);
////        imageView.setImageBitmap(bitmap);
//        byte[] image_Emp = name_toList1.getImage_Emp();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(image_Emp, 0, image_Emp.length);
//        imageView.setImageBitmap(bitmap);
//
//
//        Name_ToList name_toList2 = myNameToList.get(position);
//        textView2.setText(name_toList2.getNickname_Emp());
//
//        Name_ToList name_toList3 = myNameToList.get(position);
//        textView3.setText(name_toList3.getAge_Emp());
//
//        Name_ToList name_toList4 = myNameToList.get(position);
//        textView4.setText(name_toList4.getSalary_Emp());
//
//        return v;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName, txtPosition,txtNickname,txtAge,txtSalary;
    }

}
