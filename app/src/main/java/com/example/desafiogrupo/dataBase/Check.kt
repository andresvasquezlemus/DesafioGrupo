package com.example.desafiogrupo.dataBase

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

//class Check {
    @Entity(tableName="check_items")
    data class Check(
        @PrimaryKey @NonNull val name: String,
        val singlePrice: String ="",
        val quantity: Int = 0,
        val totalItem: String ="0")
