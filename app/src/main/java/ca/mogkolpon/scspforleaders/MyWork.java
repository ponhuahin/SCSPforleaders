package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 3/24/2017.
 */

public class MyWork {
    private Context context;
    private MyData myData;
    private SQLiteDatabase sqLiteDatabase;
    private static final String w_table = "Workoff_db";

    private static final String w_id_wor = "ID_Wor";
    private static final String w_workoff_wor = "Workoff_Wor";
    private static final String w_job_wor = "ID_Job_Wor";
    private static final String w_datework_wor = "DateWork_Wor";

    private static final String w_dateout_wor = "DateOut_Wor";
    private static final String w_withdraw_wor= "Withdraw_Wor";
    private static final String w_id_emp_wor = "ID_Emp_Wor";
    private static final String w_dateapp_wor = "DateApp_Wor";

    public MyWork(Context context) {
        this.context = context;
        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    }// จบ public MyWork

    public long addNewValue(String strWorkoff_Wor,
                            String strID_Job_Wor,
                            String strDateWork_Wor,
                            String strDateOut_Wor,
                            String strWithdraw_Wor,
                            String strID_Emp_Wor,
                            String strDateApp_Wor
    ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(w_workoff_wor, strWorkoff_Wor);
        contentValues.put(w_job_wor, strID_Job_Wor);
        contentValues.put(w_datework_wor, strDateWork_Wor);

        contentValues.put(w_dateout_wor, strDateOut_Wor);
        contentValues.put(w_withdraw_wor, strWithdraw_Wor);
        contentValues.put(w_id_emp_wor, strID_Emp_Wor);
        contentValues.put(w_dateapp_wor, strDateApp_Wor);
        return sqLiteDatabase.insert(w_table, null, contentValues);
    } // จบ long addNewValue

}
