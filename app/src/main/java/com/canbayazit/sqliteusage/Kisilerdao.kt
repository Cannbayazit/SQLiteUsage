package com.canbayazit.sqliteusage

import android.annotation.SuppressLint
import android.content.ContentValues

class Kisilerdao {

    //  Kişi ekleme işlemi
    fun kisiEkle(
        vt: VeriTabaniYardimcisi,
        kisi_ad: String,
        kisi_tel: String,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db = vt.writableDatabase

        val values = ContentValues()

        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.insertOrThrow("kisiler", null, values)
        db.close()

    }

    //  Kişi güncelleme işlemi

    fun kisiGuncelle(
        vt: VeriTabaniYardimcisi,
        kisi_no: Int,
        kisi_ad: String,
        kisi_tel: Int,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db = vt.writableDatabase

        val values = ContentValues()

        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.update("kisiler", values, "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()

    }

            //  Kişi silme işlemi
    fun kisiSil(vt: VeriTabaniYardimcisi, kisi_no: Int) {
        val db = vt.writableDatabase

        db.delete("kisiler", "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()


    }

            // veri tabanı arama işlemi
    @SuppressLint("Range")
    fun arama(vt: VeriTabaniYardimcisi, keyWord: String): ArrayList<Kisiler> {


        val kisilerArrayList = ArrayList<Kisiler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT *FROM kisiler WHERE kisi_ad like '%$keyWord%'", null)

        while (cursor.moveToNext()) {

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

        //   veri tabanından random veri getirme işlemi
    @SuppressLint("Range")
    fun rastgeleGetir(vt: VeriTabaniYardimcisi): ArrayList<Kisiler> {


        val kisilerArrayList = ArrayList<Kisiler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("select * from kisiler ORDER BY RANDOM() LIMIT 2", null)

        while (cursor.moveToNext()) {

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

        // veri tabanı tüm verileri getime işlemi
    @SuppressLint("Range")
    fun tumKisiler(vt: VeriTabaniYardimcisi): ArrayList<Kisiler> {


        val kisilerArrayList = ArrayList<Kisiler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("select * from kisiler", null)

        while (cursor.moveToNext()) {

            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }

        return kisilerArrayList

    }

    // veri tabanında kayıt kontrol işlemi
    @SuppressLint("Range")
    fun kayitKontrol(vt: VeriTabaniYardimcisi, kisi_ad:String): Int {

        var sonuc = 0

        val db = vt.writableDatabase

        val cursor = db.rawQuery("select count(*) as sonuc from kisiler where kisi_ad = '$kisi_ad'", null)

        while (cursor.moveToNext()){
            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"))
        }

        return sonuc


    }




}




