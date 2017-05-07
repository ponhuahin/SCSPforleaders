package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 3/23/2017.
 */

class MyName {
    private Context context;
    private MyData myData;
    private SQLiteDatabase sqLiteDatabase;

    private static final String TABLE_EMP = "Employee_db";

    private static final String emp_id = "ID_Emp";

    private static final String emp_position = "Position_Emp";
    private static final String emp_salary = "Salary_Emp";

    private static final String emp_idcard = "Idcard_Emp";
    private static final String emp_name = "Name_Emp";
    private static final String emp_nickname = "Nickname_Emp";
    private static final String emp_sex = "Sex_Emp";
    private static final String emp_datebirth = "DateBirth_Emp";
    private static final String emp_age = "Age_Emp";

    private static final String emp_address = "Address_Emp";
    private static final String emp_tel = "Tele_Emp";

    private static final String emp_line = "Line_Emp";
    private static final String emp_facebook = "Facebook_Emp";
    private static final String emp_email = "Email_Emp";

    private static final String emp_dateapp = "DateApp_Emp";
    private static final String emp_image = "Image_Emp";

    public MyName(Context context) {
        this.context = context;
        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    } // จบ MyName

    public long addNewValue(
            String strPosition_Emp,
            String strSalary_Emp,

            String strIdcard_Emp,
            String strName_Emp,
            String strNickname_Emp,
            String strSex_Emp,
            String strDateBirth_Emp,
            String strAge_Emp,

            String strAddress_Emp,
            String strTel_Emp,

            String strLine_Emp,
            String strFacebook_Emp,
            String strEmail_Emp,

            String strDateApp_Emp,
            byte[] strImage_Emp
    ) {
        ContentValues contentValues = new ContentValues();
//        contentValues.put(emp_id, strID_Emp);
        contentValues.put(emp_position, strPosition_Emp);
        contentValues.put(emp_salary, strSalary_Emp);

        contentValues.put(emp_idcard, strIdcard_Emp);
        contentValues.put(emp_name, strName_Emp);
        contentValues.put(emp_nickname, strNickname_Emp);
        contentValues.put(emp_sex, strSex_Emp);
        contentValues.put(emp_datebirth, strDateBirth_Emp);
        contentValues.put(emp_age, strAge_Emp);

        contentValues.put(emp_address, strAddress_Emp);
        contentValues.put(emp_tel, strTel_Emp);

        contentValues.put(emp_line, strLine_Emp);
        contentValues.put(emp_facebook, strFacebook_Emp);
        contentValues.put(emp_email, strEmail_Emp);

        contentValues.put(emp_dateapp, strDateApp_Emp);
        contentValues.put(emp_image, strImage_Emp);

        return sqLiteDatabase.insert(TABLE_EMP, null, contentValues);
    }

} // จบ class MyName
