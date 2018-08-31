package pmais.razatech.db;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import pmais.razatech.db.DBConstants.TableColumns;
import pmais.razatech.db.DBConstants.TableName;

public class DBTables {

    public static class CreateTable implements BaseColumns {
        public static final String USERS = "CREATE TABLE " + TableName.USER_PROFILE + "(" +
                _ID + " INTEGER PRIMARY KEY, " +
                TableColumns.TITLE + " TEXT, " +
                TableColumns.PASSWORD + "TEXT, " +
                TableColumns.PHONE + " TEXT, " +
                TableColumns.DESIGNATIONS + " INTEGER);";
        public static final String DESIGNATIONS = "CREATE TABLE " + TableName.DESIGNATIONS + "(" +
                _ID + " INTEGER PRIMARY KEY, " +
                TableColumns.TITLE + " TEXT);";
    }

    public static class InsertData {
        public static void insertUserProfile(String title, String pass, String Phone, int des) {
            SQLiteDatabase db = new DBHandler()

// Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_TITLE);
            values.put(FeedEntry.COLUMN_NAME_ADDRESS, FeedEntry.COLUMN_NAME_ADDRESS);
            values.put(FeedEntry.COLUMN_NAME_PHONE, FeedEntry.COLUMN_NAME_PHONE);

// Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
            return newRowId;
        }
    }
}
