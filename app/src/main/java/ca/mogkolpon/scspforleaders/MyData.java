package ca.mogkolpon.scspforleaders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User-Gamer on 3/22/2017.
 */

public class MyData extends SQLiteOpenHelper {

    static final String database_name = "SCSPforleaders.sqlite";  // สร้างฐานข้อมูล ชื่อ SCSPforleaders
    private static final int databasVersion = 1;
    Context myContext;

    private static final String tableCreateSQL1 = "CREATE TABLE admin_db (" +
            "ID_admin INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Name_admin TEXT," +
            "Username_admin TEXT," +
            "Password_admin TEXT" +
            ");";
    private static final String tableCreateSQL2 = "CREATE TABLE Employee_db" +
            "("+ //ตาราง พนักงาน
            "ID_Emp INTEGER PRIMARY KEY AUTOINCREMENT, " +    // ID   		0
            "Position_Emp TEXT, " +                         //ตำแหน่ง         	1
            "Salary_Emp TEXT, " +                           //เงินเดือน        	2

            "Idcard_Emp Text, " +                           //รหัสบัตรประชาชน   	3
            "Name_Emp TEXT, " +                             //ชื่อ          	4
            "Nickname_Emp TEXT, " +                         //ชื่อเล่น         	5
            "Sex_Emp TEXT, " +                              //เพศ          	6
            "DateBirth_Emp TEXT, " +                        //วันเดือนปีเกิด      	7
            "Age_Emp TEXT, " +                              //อายุ          	8

            "Address_Emp TEXT, " +                          //ที่อยุ่         	9
            "Tele_Emp TEXT, " +                             //เบอร์โทร        	10

            "Line_Emp TEXT, " +                             //ไลน์          	11
            "Facebook_Emp TEXT, " +                         //Facebook    	12
            "Email_Emp TEXT, " +                            //อีเมล          	13

            "DateApp_Emp TEXT, " +                          //วันที่สมัคร        	14
            "Image_Emp BLOB " +                            //รูป           	15
            ");";

    private static final String tableCreateSQL3 = "CREATE TABLE Job_db ("+     //ตาราง รับงาน
            "ID_Job INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT 0
            "Name_Job TEXT, "+                 //ชื่แงาน                     1
            "Address_Job TEXT, "+              //ที่อยุ่                      2
            "Money_Job TEXT, "+                //เงิน                       3

            "DateGet_Job TEXT, "+              //วันที่บันทึก รับงาน             4
            "DateDue_Job TEXT, "+              //กำหนดส่งงาน                5
            "Specs_Job TEXT, "+               //รายละเอียดงาน                6

            "Name_Com_Job TEXT, "+             //ชื่อ บริษัท                  7
            "Address_Com_Job TEXT, "+          //ที่อยุ่ บริษัท                 8
            "Tele_Job TEXT, "+                 //เบอร์โทร        	          9
            "Line_Job TEXT, "+                 //ไลน์          		      10
            "Facebook_Job TEXT, "+             //Facebook    	          11
            "Email_Job TEXT, "+                //อีเมล          		      12

            "DateApp_Job TEXT "+              //วันที่สมัคร        	          13
            ");";

    private static final String tableCreateSQL4 = "CREATE TABLE Workoff_db ("+     //ตาราง ทำงาน
            "ID_Wor INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT
            "Workoff_Wor TEXT, "+          //ทำงาน / หยุด
            "ID_Job_Wor int, "+            //ID งาน
            "DateWork_Wor TEXT, "+         //เวลาทำงาน
            "DateOut_Wor TEXT, "+          //เวลาเลิกงาน
            "Withdraw_Wor TEXT,"+           // เบิกเงิน
            "ID_Emp_Wor int, "+         //ID พนักงาน
            "DateApp_Wor TEXT"+          //วันที่บันทึก
            ");";

    public MyData(Context context) {
        super(context, database_name, null, databasVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSQL1);
        db.execSQL(tableCreateSQL2);
        db.execSQL(tableCreateSQL3);
        db.execSQL(tableCreateSQL4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
