package com.example.listadeprodutos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "techstore-database"
        ).allowMainThreadQueries().build()

        val produtoDao = database.produtoDAO()

        val nome: EditText = findViewById(R.id.nomeProduto)
        val custo: EditText = findViewById(R.id.precoCusto)
        val venda: EditText = findViewById(R.id.precoVenda)
        val buscaNome: EditText = findViewById(R.id.textBuscaNome)
        val buttonInsert: Button = findViewById(R.id.buttonInsert)
        val buttonClean: Button = findViewById(R.id.buttonClean)
        val buttonSearch: Button = findViewById(R.id.buttonBuscaNome)
        val listView: ListView = findViewById(R.id.listView)

        val list = ArrayList<Produto>()
        val adapter = MyAdapter(this, list)

        listView.adapter = adapter

        list.addAll(produtoDao.all())
        adapter.notifyDataSetChanged()
        nome.requestFocus()

        fun clearInputs() {
            nome.text.clear()
            custo.text.clear()
            venda.text.clear()
        }

        buttonClean.setOnClickListener {
            clearInputs()
        }

        buttonSearch.setOnClickListener {
            list.removeAll(list)
            val busca = buscaNome.text.toString()
            list.addAll(produtoDao.find(busca))
            adapter.notifyDataSetChanged()
        }

        buttonInsert.setOnClickListener {
            val name = nome.text.toString()
            if (name != "") {
                val cost = custo.text.toString().toDouble()
                val sale = venda.text.toString().toDouble()
                val margin = sale - cost
                val product = Produto(0, name, cost, sale, margin)
                product.id = produtoDao.insert(product)
                list.add(product)
            }
        }

        listView.setOnItemLongClickListener { parent, view, position, id ->
            val product = list[position]
            list.remove(product)
            produtoDao.delete(product)
            adapter.notifyDataSetChanged()
            true
        }

    }
}