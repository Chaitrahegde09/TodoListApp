package com.example.todolistapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTask = findViewById<EditText>(R.id.etTask)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val listTasks = findViewById<ListView>(R.id.listTasks)

        val tasks = ArrayList<String>()
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            tasks
        )

        listTasks.adapter = adapter

        btnAdd.setOnClickListener {
            val task = etTask.text.toString().trim()
            if (task.isNotEmpty()) {
                tasks.add("○  $task")
                adapter.notifyDataSetChanged()
                etTask.text.clear()
            }
        }

        listTasks.setOnItemClickListener { _, _, position, _ ->
            if (tasks[position].startsWith("○")) {
                tasks[position] = tasks[position].replaceFirst("○", "✔")
            } else {
                tasks[position] = tasks[position].replaceFirst("✔", "○")
            }
            adapter.notifyDataSetChanged()
        }

        btnClear.setOnClickListener {
            tasks.clear()
            adapter.notifyDataSetChanged()
        }


    }
}