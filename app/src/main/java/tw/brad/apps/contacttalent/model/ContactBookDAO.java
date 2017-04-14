package tw.brad.apps.contacttalent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactBookDAO {
    // 表格名稱
    public static final String TABLE_NAME = "contactbook";

    public static final String KEY_ID = "_id";
    public static final String CONTACT_ID_COLUMN = "contact_id";
    public static final String CONTACT_PHOTO_COLUMN = "contact_photo";
    public static final String CONTACT_NAME_COLUMN = "contact_name";
    public static final String CONTACT_DEPT_COLUMN = "contact_dept"; //0:客,1:廠,2:員
    public static final String CONTACT_PHONE_COLUMN = "contact_phone";
    public static final String CONTACT_MOBILE_COLUMN = "contact_mobile";
    public static final String CONTACT_COMPANY_COLUMN = "contact_company";
    public static final String CONTACT_POSTAL="contact_postal";
    public static final String CONTACT_ADDRESS ="contact_address";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CONTACT_ID_COLUMN +" TEXT," +
                    CONTACT_PHOTO_COLUMN + " TEXT , " +
                    CONTACT_NAME_COLUMN + " TEXT , " +
                    CONTACT_DEPT_COLUMN + " TEXT , " +
                    CONTACT_PHONE_COLUMN + " TEXT , " +
                    CONTACT_MOBILE_COLUMN + " TEXT, " +
                    CONTACT_COMPANY_COLUMN + " TEXT, " +
                    CONTACT_POSTAL + " TEXT, " +
                    CONTACT_ADDRESS + " TEXT ) " ;

    private SQLiteDatabase db;

    public ContactBookDAO(Context context)
    {
        db = ContactDBHelper.getDatabase(context);
    }

    public void close()
    {
        db.close();
    }

    public ContactBook insert(ContactBook contactBook) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        cv.put(CONTACT_PHOTO_COLUMN, contactBook.getContact_photo());
        cv.put(CONTACT_ID_COLUMN,contactBook.getContact_id());
        cv.put(CONTACT_NAME_COLUMN, contactBook.getContact_name());
        cv.put(CONTACT_DEPT_COLUMN, contactBook.getContact_dept());
        cv.put(CONTACT_PHONE_COLUMN, contactBook.getContact_phone());
        cv.put(CONTACT_MOBILE_COLUMN, contactBook.getContact_mobile());
        cv.put(CONTACT_COMPANY_COLUMN, contactBook.getContact_company());
        cv.put(CONTACT_POSTAL, contactBook.getContact_postal());
        cv.put(CONTACT_ADDRESS, contactBook.getContact_address());
        long id = db.insert(TABLE_NAME, null, cv);
        contactBook.setKey_id(id);
        // 回傳結果
        return contactBook;
    }

    // 刪除參數指定編號的資料
    public boolean delete(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<ContactBook> getAll() {
        List<ContactBook> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }


    // 取得指定編號的資料物件
    public ContactBook get(long id) {
        // 準備回傳結果用的物件
        ContactBook item = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=" + id;
        // 執行查詢
        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);

        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }


    // 把Cursor目前的資料包裝為物件
    public ContactBook getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        ContactBook result = new ContactBook();
        result.setKey_id(cursor.getLong(0));
        result.setContact_photo(cursor.getString(cursor.getColumnIndex(CONTACT_PHOTO_COLUMN)));
        result.setContact_id(cursor.getString(cursor.getColumnIndex(CONTACT_ID_COLUMN)));
        result.setContact_name(cursor.getString(cursor.getColumnIndex(CONTACT_NAME_COLUMN)));
        result.setContact_dept(cursor.getString(cursor.getColumnIndex(CONTACT_DEPT_COLUMN)));
        result.setContact_phone(cursor.getString(cursor.getColumnIndex(CONTACT_PHONE_COLUMN)));
        result.setContact_mobile(cursor.getString(cursor.getColumnIndex(CONTACT_MOBILE_COLUMN)));
        result.setContact_company(cursor.getString(cursor.getColumnIndex(CONTACT_COMPANY_COLUMN)));
        result.setContact_postal(cursor.getString(cursor.getColumnIndex(CONTACT_POSTAL)));
        result.setContact_address(cursor.getString(cursor.getColumnIndex(CONTACT_ADDRESS)));

        // 回傳結果
        return result;
    }

    public void sample() {
//
        ContactBook item = new ContactBook(0,"HY001","","林昭維","0", "","0939689591","鴻奕資訊有限公司","422","台中市西屯路2段256巷6號9F-3");
        ContactBook item2 = new ContactBook(0,"HY001","","林昭維","1", "","0939689591","穩贏融資有限公司","422","台中市西屯路2段256巷6號9F-3");
        ContactBook item3 = new ContactBook(0,"HY001","","林昭維","2", "","0939689591","鴻奕資訊有限公司","22","台中市西屯路2段256巷6號9F-3");
        insert(item);
        insert(item2);
        insert(item3);
     }

}
