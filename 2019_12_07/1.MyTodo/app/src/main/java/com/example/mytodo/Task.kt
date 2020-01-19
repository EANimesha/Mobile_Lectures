package com.example.mytodo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task (
    /*
   * Getters and Setters
   * */
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    @ColumnInfo(name = "task")
    val task:String,
    @ColumnInfo(name = "desc")
    val desc:String,
    @ColumnInfo(name = "finish_by")
    val finishBy:String,
    @ColumnInfo(name = "finished")
    val isFinished:Boolean = false
)