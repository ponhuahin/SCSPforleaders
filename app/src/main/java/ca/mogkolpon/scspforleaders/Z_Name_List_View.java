package ca.mogkolpon.scspforleaders;

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
 * Created by User-Gamer on 3/24/2017.
 */

public class Z_Name_List_View extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Z_MyDataList> foodsList;

    public Z_Name_List_View(Context context, int layout, ArrayList<Z_MyDataList> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.lv_nickname);
            holder.txtPrice = (TextView) row.findViewById(R.id.lv_telename);
            holder.imageView = (ImageView) row.findViewById(R.id.name_ListView_Image);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Z_MyDataList food = foodsList.get(position);

        holder.txtName.setText(food.getName_Emp());
        holder.txtPrice.setText(food.getNickname_Emp());

        byte[] foodImage = food.getImage_Emp();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
