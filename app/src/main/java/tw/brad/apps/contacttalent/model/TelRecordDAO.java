package tw.brad.apps.contacttalent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelRecordDAO {
    // 表格名稱
    public static final String TABLE_NAME = "tel_record";

    public static final String KEY_ID = "_id";
    public static final String PHOTO_COLUMN = "photo";
    public static final String NAME_COLUMN = "name";
    public static final String DEPT_COLUMN = "dept"; //0:客,1:廠,2:員
    public static final String PHONE_COLUMN = "phone";
    public static final String MOBILE_COLUMN = "mobile";
    public static final String COMPANY_COLUMN = "company";
    public static final String TIME_COLUMN = "date";
    public static final String STYLE_COLUMN ="style"; //0:已接,1:未接,2:撥打


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PHOTO_COLUMN + " TEXT , " +
                    NAME_COLUMN + " TEXT , " +
                    DEPT_COLUMN + " TEXT , " +
                    PHONE_COLUMN + " TEXT , " +
                    MOBILE_COLUMN + " TEXT, " +
                    COMPANY_COLUMN + " TEXT, " +
                    TIME_COLUMN + " TEXT, " +
                    STYLE_COLUMN + " TEXT ) " ;

    private SQLiteDatabase db;

    public TelRecordDAO(Context context)
    {
        db = ContactDBHelper.getDatabase(context);
    }

    public void close()
    {
        db.close();
    }

    public TelRecord insert(TelRecord telRecord) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料

        cv.put(PHOTO_COLUMN, telRecord.getPhoto());
        cv.put(NAME_COLUMN, telRecord.getName());
        cv.put(DEPT_COLUMN, telRecord.getDept());
        cv.put(PHONE_COLUMN, telRecord.getPhone());
        cv.put(MOBILE_COLUMN, telRecord.getMobile());
        cv.put(COMPANY_COLUMN, telRecord.getCompany());
        cv.put(TIME_COLUMN, telRecord.getdTime());
        cv.put(STYLE_COLUMN, telRecord.getStyle());
        long id = db.insert(TABLE_NAME, null, cv);
        telRecord.setKey_id(id);
        // 回傳結果
        return telRecord;
    }

    // 刪除參數指定編號的資料
    public boolean delete(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<TelRecord> getAll() {
        List<TelRecord> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }


    // 取得指定編號的資料物件
    public TelRecord get(long id) {
        // 準備回傳結果用的物件
        TelRecord item = null;
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
    public TelRecord getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        TelRecord result = new TelRecord();

        result.setKey_id(cursor.getLong(0));
        result.setPhoto(cursor.getString(cursor.getColumnIndex(PHONE_COLUMN)));
        result.setName(cursor.getString(cursor.getColumnIndex(NAME_COLUMN)));
        result.setDept(cursor.getString(cursor.getColumnIndex(DEPT_COLUMN)));
        result.setPhone(cursor.getString(cursor.getColumnIndex(PHONE_COLUMN)));
        result.setMobile(cursor.getString(cursor.getColumnIndex(MOBILE_COLUMN)));
        result.setCompany(cursor.getString(cursor.getColumnIndex(COMPANY_COLUMN)));
        result.setdTime(cursor.getString(cursor.getColumnIndex(TIME_COLUMN)));
        result.setStyle(cursor.getString(cursor.getColumnIndex(STYLE_COLUMN)));

        // 回傳結果
        return result;
    }

    public void sample() {
//        long key_id, String photo, String name, String dept
//                , String phone, String mobile, String company, String dTime, String style
        Date current = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        TelRecord item = new TelRecord(0,"","林昭維","0", "","0939689591","鴻奕資訊有限公司",sdf.format(current),"0");
        TelRecord item2 = new TelRecord(0,"","林昭維","1", "","0939689591","穩贏融資有限公司",sdf.format(current),"0");
        TelRecord item3 = new TelRecord(0,"","林昭維","2", "","0939689591","鴻奕資訊有限公司",sdf.format(current),"0");
        insert(item);
        insert(item2);
        insert(item3);
     }

}
