package com.bulleh.recylerview

import com.bulleh.recylerview.TanamanObat.listData

object TanamanObat {
    private val names = arrayOf("jarak", "jeruk", "kelapa", "kemiri", "lidah buaya")

    private val detailTanaman = arrayOf(
        "manfaat dari daun ini adalah meningkatkan daya tahan tubuh dan masa otot",
        "rasanya sanag wuenak diminum maupun di konsumsi tanpa diolah",
        "dapat dimanfaatkan sebagai santan untuk jadi bahan masak",
        "dapat meluruskan rambur serta terjada dengann warna yang sangat mengkilau",
        "dapat memanjangkan rambut"
    )


    private val photo = intArrayOf(
        R.drawable.jarak,
        R.drawable.jeruk,
        R.drawable.kelapa,
        R.drawable.kemiri,
        R.drawable.lidah_buaya,
    )


    //    membuat variabel yang akan menyimpan arraylist dari tanaman obat dimana variabel ini nantinya akan dipanggil
    val listData: ArrayList<Obat>
        get() {
            val list = arrayListOf<Obat>()
            for (position in names.indices) {
                val obat = Obat()
                obat.name = names[position]
                obat.detail = detailTanaman[position]
                obat.photo = photo[position]
                list.add(obat)
            }
            return list

        }
}


