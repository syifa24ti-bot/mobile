package com.example.syifa_3tie.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.syifa_3tie.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val data = Messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_dialog_alert)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        // Poin 8 Modul: Set OnClickListener langsung di view item adapter menggunakan Snackbar
        binding.root.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}