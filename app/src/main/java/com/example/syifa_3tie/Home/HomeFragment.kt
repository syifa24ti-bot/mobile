package com.example.syifa_3tie.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.syifa_3tie.Home.data.api.CatFactApiClient
import com.example.syifa_3tie.Home.pertemuan_11.EleventhActivity
import com.example.syifa_3tie.Home.pertemuan_9.NinthActivity
import com.example.syifa_3tie.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Listener Tombol Pertemuan 9
        binding.btnPertemuan9.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToEleventh.setOnClickListener {
            val intent = Intent(requireContext(), EleventhActivity::class.java)
            startActivity(intent)
        }

        // Langkah 5: Panggil fungsi saat fragment dibuka
        loadCatFact()

        // Langkah 5: Panggil fungsi saat tombol Refresh diklik
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }
    }

    // Langkah 5: Fungsi untuk mengambil data fakta kucing dari API[cite: 3]
    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}