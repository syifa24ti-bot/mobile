package com.example.syifa_3tie.Home.pertemuan_10

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.syifa_3tie.databinding.ActivityPertemuan10Binding

class Pertemuan10Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan10Binding

    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript",
        "Dart", "Swift", "Go", "Ruby", "PHP", "C#", "TypeScript"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            dataList
        )
        binding.listViewItems.adapter = adapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            Toast.makeText(this, "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}