package com.example.listadeprodutos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter (
    private val context: Context,
    private val list: ArrayList<Produto>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getItem(p0: Int): Produto {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return list[p0].id
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val row = inflater.inflate(R.layout.lista, p2, false)

        val nome: TextView = row.findViewById(R.id.textNome)
        val custo: TextView = row.findViewById(R.id.textPrecoCusto)
        val venda: TextView = row.findViewById(R.id.textPrecoVenda)
        val razao: TextView = row.findViewById(R.id.textRazao)

        val produto = getItem(p0)
        nome.text = produto.nome
        custo.text = produto.custo.toString()
        venda.text = produto.venda.toString()
        razao.text = produto.razao.toString()

        return row

    }

}