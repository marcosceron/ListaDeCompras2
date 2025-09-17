package com.example.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter: ItemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if(editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }
            val item = ItemModel(
                name = editText.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )
            itemsAdapter.addItem(item)
            editText.text.clear()
        }
    }
}