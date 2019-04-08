package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabaseLockedException
import android.database.sqlite.SQLiteOpenHelper

class SQL_Helper(context: Context) : SQLiteOpenHelper(context,DB_Name, null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_Name(ID INTEGER PRIMARY KEY AUTOINCREMENT, S_Title TEXT, S_Desc TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TB_Name")
    }

    fun add_data(title_text: String, desc_text: String){
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(title,title_text)
        values.put(desc,desc_text)


        db.insert(TB_Name, null, values)

    }

    fun Delete_Data(id: String):Int{
        val db = this.writableDatabase
        val item = db.delete(TB_Name, "id = ?", arrayOf(id))
        return item
    }




    val getter_data: Cursor get() {
        val DB : SQLiteDatabase =  this.writableDatabase
        val data = DB.rawQuery("select * from " + TB_Name, null)
        return data

    }

    companion object {

        val DB_Name = "subjects.db "
        val TB_Name = "subject "
        val id = "ID"
        val title = "S_Title"
        val desc = "S_Desc"
    }
}