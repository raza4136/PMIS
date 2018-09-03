package pmais.razatech.db;

import android.content.ContentValues;
import android.content.Context;
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
        public static int insertUserProfile(Context context, String title, String pass, String phone, int des) {
            SQLiteDatabase db = new DBHandler(context).getReadableDatabase();

// Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(TableColumns.TITLE, title);
            values.put(TableColumns.PASSWORD, pass);
            values.put(TableColumns.PHONE, phone);
            values.put(TableColumns.DESIGNATIONS, des);
// Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(TableName.USER_PROFILE, null, values);
            return (int) newRowId;
        }
        public static int insertDesignation(Context context, String title) {
            SQLiteDatabase db = new DBHandler(context).getReadableDatabase();

// Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(TableColumns.TITLE, title);
// Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(TableName.DESIGNATIONS, null, values);
            return (int) newRowId;
        }
    }
}
