package com.example.listadeprodutos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Produto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun produtoDAO(): ProdutoDAO
}