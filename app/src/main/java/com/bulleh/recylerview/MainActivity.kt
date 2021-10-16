package com.bulleh.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bulleh.recylerview.adapter.CardViewAdapter
import com.bulleh.recylerview.adapter.GridHeroAdapter
import com.bulleh.recylerview.adapter.ListObatAdapter

class MainActivity : AppCompatActivity() {
    //    membuat variabel untuk inisilaisi recylerview
    private lateinit var rvNature: RecyclerView
    private var title: String = "Mode List"

    //    variabel yang berguna untuk menyimoan dara properties obat yang dijadikan menjadi arrayList, memudahkan untuk add data
    private var list: ArrayList<Obat> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)
//        inisilisasai id recylerview
        rvNature = findViewById(R.id.rv_heroes)
        rvNature.setHasFixedSize(true)

//        menambhakan semua data yang ada di object tanaman obat ke variabel list sesuai dengan posisi indexnya di listdata
        list.addAll(TanamanObat.listData)
        showRecylerList()
    }

    //    fungsi yang berguna untuk menampilkan style tampilan data yang sudah di proses sebelumnya
    private fun showRecylerList() {
        rvNature.layoutManager = LinearLayoutManager(this)

//    semua proses yang ada di recyler view ada di listobatadapter
        val listObatAdapter = ListObatAdapter(list)
        rvNature.adapter = listObatAdapter

        listObatAdapter.setOnItemClickCallback(object : ListObatAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Obat) {
                showSelectedObat(data)
            }
        })
    }

    //    inflate dari file menu pada folder menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //    mengambil action dari setaip menu ketika diklik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedObat(hero: Obat) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecylerViewGrid() {
        rvNature.layoutManager = GridLayoutManager(this, 3)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvNature.adapter = gridHeroAdapter


        gridHeroAdapter.setOnItemClickCallback(object : ListObatAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Obat) {
                showSelectedObat(data)
            }
        })


    }

    private fun showRecyclerCardView() {
        rvNature.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewAdapter(list)
        rvNature.adapter = cardViewHeroAdapter
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    //   perintah yang akan dijalankan ketika salah satu id yang di pake
    private fun setMode(selectMode: Int) {
        when (selectMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecylerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecylerViewGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }


}