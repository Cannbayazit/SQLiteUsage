package com.canbayazit.sqliteusage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeriTabaniYardimcisi(contex:Context) : SQLiteOpenHelper(contex,"rehber",null,1) {


    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE kisiler (kisi_no INTEGER PRIMARY KEY AUTOINCREMENT  " +
                ",kisi_ad TEXT, kisi_tel TEXT,kisi_yas INTEGER,kisi_boy DOUBLE);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS kisiler")
        onCreate(db)


    }

}