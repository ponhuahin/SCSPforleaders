package ca.mogkolpon.scspforleaders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 5/16/2017.
 */

public class ListView_Name_3 extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    private int layout;
    ArrayList<Z_MyDataList> myNameToList;

    private int count;
    private boolean[] thumbnailsselection;

    public ListView_Name_3(Activity activity, int layout, ArrayList<Z_MyDataList> mtNameToList) {
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
        thumbnailsselection = new boolean[count];
        ListView_Name_3.ViewHolder holder = new ListView_Name_3.ViewHolder();
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = (TextView) row.findViewById(R.id.name_ListView_name);
            holder.txtPosition = (TextView) row.findViewById(R.id.name_ListView_Position);
            holder.imageView = (ImageView) row.findViewById(R.id.name_ListView_Image);
            holder.txtNickname = (TextView) row.findViewById(R.id.Nickname_Emp_L);
            holder.txtAge = (TextView) row.findViewById(R.id.Age_Emp_L);
            holder.txtSalary = (TextView) row.findViewById(R.id.Salary_Emp_L);

//            holder.checkBox = (CheckBox) row.findViewById(R.id.CheckBox_Emp);

//            holder.checkBox.setChecked(thumbnailsselection[position]);

            row.setTag(holder);
        } else {
            holder = (ListView_Name_3.ViewHolder) row.getTag();
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

//        holder.checkBox.setText(food.getID_Emp());
//        holder.checkBox.setOnClickListener(new View.OnClickListener() {  //ยังใช้ไมไ่ด้
//            public void onClick(View v) {
//                CheckBox cb = (CheckBox) v;
//                int ic = cb.getId();
//
//
//////                    // TODO Auto-generated method stub
////////                    CheckBox cb = (CheckBox) v;
////////                    int id = cb.getId();
////////                    if (thumbnailsselection[id]) {
////////                        cb.setChecked(false);
////////                        thumbnailsselection[id] = false;
////////                    } else {
////////                        cb.setChecked(true);
////////                        thumbnailsselection[id] = true;
////////                    }
//            }
//        });

        return row;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName, txtPosition, txtNickname, txtAge, txtSalary;
//        CheckBox checkBox;
    }

//    public void click(View v) {
//        if (v.getId() == R.id.button1) {
//            final ArrayList<Integer> posSel = new ArrayList<Integer>();
//            posSel.clear();
//            boolean noSelect = false;
//            for (int i = 0; i < thumbnailsselection.length; i++) {
//                if (thumbnailsselection[i] == true) {
//                    noSelect = true;
//                    Log.e("sel pos thu-->", "" + i);
//                    posSel.add(i);
//                    // break;
//                }
//            }
//            if (!noSelect) {
//                Toast.makeText(MainActivity.this, "Please Select Item!",
//                        Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(MainActivity.this,
//                        "Selected Items:" + posSel.toString(),
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//    }

}

