package com.example.syifa_3tie.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.syifa_3tie.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // 1. Data List Bahasa Pemrograman (Modul Poin 2)
    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript",
        "Dart", "Swift", "Go", "Ruby", "PHP", "C#", "TypeScript",
        "Shell", "SQL", "Perl", "Rust", "Scala", "Haskell"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Pasang ArrayAdapter bawaan Android (simple_list_item_1)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            dataList
        )

        // 3. Hubungkan ke ListView di XML
        binding.listViewItems.adapter = adapter

        // 4. Aksi saat item di-klik
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