package com.hnf.tugasakhir2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvBuah: RecyclerView
    private val list = ArrayList<Buah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBuah = findViewById(R.id.dt_buah)
        rvBuah.setHasFixedSize(true)

        list.addAll(getListBuah())
        showRecyclerList()
    }

    private fun getListBuah(): ArrayList<Buah> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listBuah = ArrayList<Buah>()
        for (i in dataName.indices) {
            val buah = Buah(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listBuah.add(buah)
        }
        return listBuah
    }

    private fun showRecyclerList(){
        rvBuah.layoutManager = LinearLayoutManager(this)
        val listBuahAdapter =ListBuahAdapter(list)
        rvBuah.adapter =listBuahAdapter
    }
}