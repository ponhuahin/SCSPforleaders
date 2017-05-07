package ca.mogkolpon.scspforleaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 3/23/2017.
 */
public class MyJob {
    private Context context;
    private MyData myData;                      //เรียก calss MyData มาใช้
    private SQLiteDatabase sqLiteDatabase;      //เรียก ฐานข้อมูล  มาใช้

    private static final String Job_TABLE ="Job_db";                    //ตาราง พนักงาน

    private static final String Job_ID = "ID_Job";                      // id           0
    private static final String Job_Name = "Name_Job";                  //ชื่องาน           1
    private static final String Job_Address = "Address_Job";            //ที่อยุ่               2
    private static final String Job_Money = "Money_Job";                //เงิน              3
    private static final String Job_DateGet = "DateGet_Job";            //วันที่รับงาน          4
    private static final String Job_DateDue = "DateDue_Job";            //วันที่ส่งงาน          5
    private static final String Job_Specs = "Specs_Job";                //รายละเอียด            6
    private static final String Job_Name_Com = "Name_Com_Job";          //ชื่อบริษัท            7
    private static final String Job_Address_Com = "Address_Com_Job";    //ที่อยู่ บริษัท            8
    private static final String Job_Tele = "Tele_Job";                  //เบอร์โทร              9
    private static final String Job_Line = "Line_Job";                  //ไลน์                  10
    private static final String Job_Facebook = "Facebook_Job";          //เหส                   11
    private static final String Job_Email = "Email_Job";                //อีเมล                 12
    private static final String Job_DateApp = "DateApp_Job";            //วันที่บันทึก              13

    public MyJob(Context context) {
        this.context = context;
        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    }   // Constructor

    public long addNewValue(
//            String strID_Job,
            String strName_Job,
            String strAddress_Job,
            String strMoney_Job,
            String strDateGet_Job,
            String strDateDue_Job,
            String strSpecs_Job,
            String strName_Com_Job,
            String strAddress_Com_Job,
            String strTele_Job,
            String strLine_Job,
            String strFacebook_Job,
            String strEmail_Job,
            String strDateApp_Job
    ) {
        ContentValues contentValues = new ContentValues();
//        contentValues.put(Job_ID, strID_Job);
        contentValues.put(Job_Name, strName_Job);
        contentValues.put(Job_Address, strAddress_Job);
        contentValues.put(Job_Money, strMoney_Job);
        contentValues.put(Job_DateGet, strDateGet_Job);
        contentValues.put(Job_DateDue, strDateDue_Job);
        contentValues.put(Job_Specs, strSpecs_Job);
        contentValues.put(Job_Name_Com, strName_Com_Job);
        contentValues.put(Job_Address_Com, strAddress_Com_Job);
        contentValues.put(Job_Tele, strTele_Job);
        contentValues.put(Job_Line, strLine_Job);
        contentValues.put(Job_Facebook, strFacebook_Job);
        contentValues.put(Job_Email, strEmail_Job);
        contentValues.put(Job_DateApp, strDateApp_Job);

        return sqLiteDatabase.insert(Job_TABLE, null, contentValues);
    }

}
