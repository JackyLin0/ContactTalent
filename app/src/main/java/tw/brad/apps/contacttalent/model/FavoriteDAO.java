package tw.brad.apps.contacttalent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tw.brad.apps.contacttalent.misc.Stroke;

/**
 * Created by hungming on 2017/4/12.
 */

public class FavoriteDAO {
    // 表格名稱
    public static final String TABLE_NAME = "favoritebook";

    public static final String KEY_ID = "_id";
    public static final String FAVORITE_STROKE_COLUMN ="stroke";
    public static final String FAVORITE_PHOTO_COLUMN = "favorite_photo";
    public static final String FAVORITE_NAME_COLUMN = "favorite_name";
    public static final String FAVORITE_DEPT_COLUMN = "favorite_dept"; //0:客,1:廠,2:員
    public static final String FAVORITE_PHONE_COLUMN = "favorite_phone";
    public static final String FAVORITE_MOBILE_COLUMN = "favorite_mobile";
    public static final String FAVORITE_COMPANY_COLUMN = "favorite_company";
    public static final String FAVORITE_CITY_COLUMN="favorite_city";
    public static final String FAVORITE_AREA_COLUMN ="favorite_area";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FAVORITE_STROKE_COLUMN + " TEXT , " +
                    FAVORITE_PHOTO_COLUMN + " TEXT , " +
                    FAVORITE_NAME_COLUMN + " TEXT , " +
                    FAVORITE_DEPT_COLUMN + " TEXT , " +
                    FAVORITE_PHONE_COLUMN + " TEXT , " +
                    FAVORITE_MOBILE_COLUMN + " TEXT, " +
                    FAVORITE_COMPANY_COLUMN + " TEXT, " +
                    FAVORITE_CITY_COLUMN + " TEXT, " +
                    FAVORITE_AREA_COLUMN + " TEXT ) " ;

    private SQLiteDatabase db;

    public FavoriteDAO(Context context)
    {
        db = ContactDBHelper.getDatabase(context);
    }

    public void close()
    {
        db.close();
    }

    public FavoriteBook insert(FavoriteBook favoriteBook) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        cv.put(FAVORITE_PHOTO_COLUMN, favoriteBook.getFavorite_photo());
        cv.put(FAVORITE_STROKE_COLUMN,favoriteBook.getFavorite_stroke());
        cv.put(FAVORITE_NAME_COLUMN, favoriteBook.getFavorite_name());
        cv.put(FAVORITE_DEPT_COLUMN, favoriteBook.getFavorite_dept());
        cv.put(FAVORITE_PHONE_COLUMN, favoriteBook.getFavorite_phone());
        cv.put(FAVORITE_MOBILE_COLUMN, favoriteBook.getFavorite_mobile());
        cv.put(FAVORITE_COMPANY_COLUMN, favoriteBook.getFavorite_company());
        cv.put(FAVORITE_CITY_COLUMN, favoriteBook.getFavorite_city());
        cv.put(FAVORITE_AREA_COLUMN, favoriteBook.getFavorite_area());
        long id = db.insert(TABLE_NAME, null, cv);
        favoriteBook.setId(id);
        // 回傳結果
        return favoriteBook;
    }

    // 刪除參數指定編號的資料
    public boolean delete(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    // 讀取所有記事資料
    public List<FavoriteBook> getAll() {
        List<FavoriteBook> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }


    // 取得指定編號的資料物件
    public FavoriteBook get(long id) {
        // 準備回傳結果用的物件
        FavoriteBook item = null;
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

     //取得比劃唯一值
    public List<String> getStroke()
    {
        List<String> strokes = new LinkedList<>();
        Cursor cursor = db.query(true,
                TABLE_NAME, new String[]{FAVORITE_STROKE_COLUMN}, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            strokes.add(cursor.getString(cursor.getColumnIndex(FAVORITE_STROKE_COLUMN)));
        }

        cursor.close();
        return strokes;
    }

    //用筆畫找資料
    public List<FavoriteBook> getDataByStroke(String stroke)
    {
        List<FavoriteBook> data = new LinkedList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null,"stroke = ?", new String[]{stroke}, null, null, null, null);
        while (cursor.moveToNext()) {
            data.add(getRecord(cursor));
        }

        cursor.close();
        return data;
    }


    // 把Cursor目前的資料包裝為物件
    public FavoriteBook getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        FavoriteBook result = new FavoriteBook();
        result.setId(cursor.getLong(0));

        result.setFavorite_photo(cursor.getString(cursor.getColumnIndex(FAVORITE_PHOTO_COLUMN)));
        result.setFavorite_stroke(cursor.getString(cursor.getColumnIndex(FAVORITE_STROKE_COLUMN)));
        result.setFavorite_name(cursor.getString(cursor.getColumnIndex(FAVORITE_NAME_COLUMN)));
        result.setFavorite_dept(cursor.getString(cursor.getColumnIndex(FAVORITE_DEPT_COLUMN)));
        result.setFavorite_phone(cursor.getString(cursor.getColumnIndex(FAVORITE_PHONE_COLUMN)));
        result.setFavorite_mobile(cursor.getString(cursor.getColumnIndex(FAVORITE_MOBILE_COLUMN)));
        result.setFavorite_company(cursor.getString(cursor.getColumnIndex(FAVORITE_COMPANY_COLUMN)));
        result.setFavorite_city(cursor.getString(cursor.getColumnIndex(FAVORITE_CITY_COLUMN)));
        result.setFavorite_area(cursor.getString(cursor.getColumnIndex(FAVORITE_AREA_COLUMN)));

        // 回傳結果
        return result;
    }

    public void sample() {

        FavoriteBook item = new FavoriteBook(0,"",new Stroke("林").getStroke(),"林昭維","0", "","0939689591","鴻奕資訊有限公司","台中市","西屯區");
        FavoriteBook item2 = new FavoriteBook(0,"",new Stroke("林").getStroke(),"林昭維","1", "","0939689591","穩贏融資有限公司","台中市","西屯區");
        FavoriteBook item3 = new FavoriteBook(0,"",new Stroke("林").getStroke(),"林昭維","2", "","0939689591","鴻奕資訊有限公司","台中市","西屯區");
        FavoriteBook item4 = new FavoriteBook(0,"",new Stroke("張").getStroke(),"張三豐","2", "","0939689591","武當山企業有限公司","台中市","西屯區");

        insert(item);
        insert(item2);
        insert(item3);
        insert(item4);
     }

}
