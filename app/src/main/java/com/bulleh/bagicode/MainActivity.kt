package com.bulleh.bagicode

import android.content.Intent
import android.icu.lang.UCharacter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var kepanjangn: EditText
    private lateinit var lebarnya: EditText
    private lateinit var tingginya: EditText
    private lateinit var button: Button
    private lateinit var hasilkah: TextView

    private lateinit var buttonIntent: Button

    private lateinit var buttonDial: Button


    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kepanjangn = findViewById(R.id.Panjang)
        lebarnya = findViewById(R.id.Lebar)
        tingginya = findViewById(R.id.Tinggi)
        button = findViewById(R.id.bt_hitung)
        hasilkah = findViewById(R.id.hasil)
        buttonIntent = findViewById(R.id.intentButton)
        buttonDial = findViewById(R.id.dialNumber)




        button.setOnClickListener(this)

        buttonIntent.setOnClickListener(this)

        buttonDial.setOnClickListener(this)


        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            hasilkah.text = result
        }
    }

    //    menyimpan nilai hasil, ketika device dalam keadaan rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, hasilkah.text.toString())
    }


    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.intentButton -> {
                val movieWithIntent = Intent(this@MainActivity, DetailActivity::class.java)
                movieWithIntent.putExtra(DetailActivity.EXTRA_NAME, "yan febriansyah")
                movieWithIntent.putExtra(DetailActivity.EXTRA_AGE, 12)
                startActivity(movieWithIntent)
            }
            R.id.dialNumber -> {
                val phoneNumber = "083147779266"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }

        if (p0?.id == R.id.bt_hitung) {
            val panjang = kepanjangn.text.toString().trim()
            val lebar = lebarnya.text.toString().trim()
            val tinggi = tingginya.text.toString().trim()

            var checkInputan = false
            if (panjang.isEmpty()) {
                checkInputan = true
                kepanjangn.error = "panjang tidak bisa kosong please input some value"
            }
            if (lebar.isEmpty()) {
                checkInputan = true
                lebarnya.error = "lebarnya tidak bisa kosong pak silahkan di isi"
            }
            if (tinggi.isEmpty()) {
                checkInputan = true
                tingginya.error = checkInputan.toString()

            }

//            atau kondisi if bisa ditulis "!checkInputan" sama artinya dengan "checkinputan == false"
            if (checkInputan == false) {
                val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                hasilkah.text = volume.toString() + checkInputan.toString()

            } else {
                val peringatan = "mohon semua fill diisi"
                hasilkah.text = peringatan.toString() + checkInputan.toString()
            }
        }
    }
}
