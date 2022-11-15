package com.canbayazit.sqliteusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vt = VeriTabaniYardimcisi(this@MainActivity)


       //Kisilerdao().kisiEkle(vt,"mehmet",999999,18,1.69)                         EKLEME

       // Kisilerdao().kisiGuncelle(vt,3,"Ahmet",1111111,28,1.88)           GÜNCELLEME
          //  Kisilerdao().kisiSil(vt,2)                                                                         SİLME

        val sonuc = Kisilerdao().kayitKontrol(vt,"mehmet")
        Log.e("Kayıt kontrol", sonuc.toString())

       val kisiListe = Kisilerdao().tumKisiler(vt)


       // val kisiListe = Kisilerdao().arama(vt,"ah")                                              ARAMA

       // val kisiListe = Kisilerdao().rastgeleGetir(vt)                                          RANDOM VERİ GETİRME




        for (k in kisiListe){

            Log.e("Kişi no",(k.kisi_no).toString())
            Log.e("Kişi ad",k.kisi_ad)
            Log.e("Kişi tel",k.kisi_tel)
            Log.e("Kişi yaş",(k.kisi_yas).toString())
            Log.e("Kişi boy",(k.kisi_boy).toString())

        }


    }
}