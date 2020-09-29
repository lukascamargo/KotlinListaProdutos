package com.example.listadeprodutos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Produto(

    @PrimaryKey (autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo (name = "nome")
    var nome: String,
    @ColumnInfo (name = "custo")
    var custo: Double,
    @ColumnInfo (name = "venda")
    var venda: Double,
    @ColumnInfo (name = "razao")
    var razao: Double

)