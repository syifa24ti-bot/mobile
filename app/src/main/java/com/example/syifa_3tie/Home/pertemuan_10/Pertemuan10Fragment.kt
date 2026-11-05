package com.example.syifa_3tie.Home.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.syifa_3tie.databinding.FragmentPertemuan10Binding

class Pertemuan10Fragment : Fragment() {

    private var _binding: FragmentPertemuan10Binding? = null
    private val binding get() = _binding!!

    // Data List Bahasa Pemrograman (Poin 2 Modul)
    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript",
        "Dart", "Swift", "Go", "Ruby", "PHP", "C#", "TypeScript"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPertemuan10Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Definisi Adapter bawaan Android (simple_list_item_1)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            dataList
        )

        // Hubungkan Adapter ke ListView
        binding.listViewItems.adapter = adapter

        // Event saat item di-klik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}