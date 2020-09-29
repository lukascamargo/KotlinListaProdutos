package com.example.listadeprodutos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDAO {

    @Query("SELECT * FROM produto")
    fun all(): List<Produto>

    @Insert
    fun insert(produto: Produto): Long

    @Delete
    fun delete(produto: Produto)

    @Query("SELECT count(id) FROM produto WHERE id=:id")
    fun exists(id: Long): Int

    @Query("SELECT * FROM produto WHERE nome=:nome")
    fun find(nome: String): List<Produto>

}