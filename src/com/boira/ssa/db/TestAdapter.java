package com.boira.ssa.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.boira.ssa.model.editable;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class TestAdapter 
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;
 // Table Names
    private static final String TABLE_EDITABLE = "editable";
    
    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORIA = "categoria";
    private static final String KEY_BAJA = "baja";
    private static final String KEY_FECHA = "creado";
    
    // NOTES Table - column names
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_CONTENIDO = "contenido";
    

    public TestAdapter(Context context) 
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public TestAdapter createDatabase() throws SQLException 
    {
        try 
        {
            mDbHelper.createDataBase();
            Log.e(TAG, "BBDD creada");
        } 
        catch (IOException mIOException) 
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public TestAdapter open() throws SQLException 
    {
        try 
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
            Log.e(TAG, "BBDD abierta");
        } 
        catch (SQLException mSQLException) 
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close() 
    {
        mDbHelper.close();
    }

     public Cursor getTestData()
     {
         try
         {
             String sql ="SELECT * FROM editable";
             mDb = mDbHelper.getReadableDatabase();
             Cursor mCur = mDb.rawQuery(sql, null);
             if (mCur!=null)
             {
                mCur.moveToNext();
             }
             return mCur;
         }
         catch (SQLException mSQLException) 
         {
             Log.e(TAG, "getTestData >>"+ mSQLException.toString());
             throw mSQLException;
         }
     }
     
     public List<editable> getAllToDosByTag(int categoria_id) {
         List<editable> todos = new ArrayList<editable>();
      
         String selectQuery = "SELECT distinct * FROM editable WHERE categoria = " + categoria_id;
      
      
         mDb = mDbHelper.getReadableDatabase();
         Cursor c = mDb.rawQuery(selectQuery, null);
      
         // looping through all rows and adding to list
         if (c.moveToFirst()) {
             do {
                 editable td = new editable();
                 td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                 td.setNombre((c.getString(c.getColumnIndex(KEY_NOMBRE))));
                 td.setContenido((c.getString(c.getColumnIndex(KEY_CONTENIDO))));
                 td.setCategoria(c.getInt(c.getColumnIndex(KEY_CATEGORIA)));
                 td.setBaja(c.getInt(c.getColumnIndex(KEY_BAJA)));
                 td.setCreado(c.getString(c.getColumnIndex(KEY_FECHA)));
      
                 
                 // adding to todo list
                 todos.add(td);
             } while (c.moveToNext());
         }
         
         return todos;
     }
     
     public editable getEditable(int editable_id) {
         
    	 
         String selectQuery = "SELECT  * FROM editable WHERE id = " + editable_id;
      
      
         mDb = mDbHelper.getReadableDatabase();
         Cursor c = mDb.rawQuery(selectQuery, null);
      
         // looping through all rows and adding to list
         if (c.moveToFirst()) {
             
             editable td = new editable();
             td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
             td.setNombre((c.getString(c.getColumnIndex(KEY_NOMBRE))));
             td.setContenido((c.getString(c.getColumnIndex(KEY_CONTENIDO))));
             td.setCategoria(c.getInt(c.getColumnIndex(KEY_CATEGORIA)));
             td.setBaja(c.getInt(c.getColumnIndex(KEY_BAJA)));
             td.setCreado(c.getString(c.getColumnIndex(KEY_FECHA)));
  
             // adding to todo list
             return td;
         }
         
         return null;
         
     }
}