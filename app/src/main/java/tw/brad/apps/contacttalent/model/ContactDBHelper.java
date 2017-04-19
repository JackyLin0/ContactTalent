package tw.brad.apps.contacttalent.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactDBHelper extends SQLiteOpenHelper {
    // 資料庫名稱
    public static final String DATABASE_NAME = "contact.db";
    public static final int VERSION = 2;
    private static SQLiteDatabase database;

    public ContactDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new ContactDBHelper(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }

        return database;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TelRecordDAO.CREATE_TABLE);
        db.execSQL(ContactBookDAO.CREATE_TABLE);
        db.execSQL(FavoriteDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS " + TelRecordDAO.TABLE_NAME);
         db.execSQL("DROP TABLE IF EXISTS " + ContactBookDAO.TABLE_NAME);
         db.execSQL("DROP TABLE IF EXISTS " + FavoriteDAO.TABLE_NAME);

        onCreate(db);

    }
}
