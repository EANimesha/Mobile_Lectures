package com.example.mytodo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
class Task:Serializable {
    /*
   * Getters and Setters
   * */
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
    @ColumnInfo(name = "task")
    lateinit var task:String
    @ColumnInfo(name = "desc")
    lateinit var desc:String
    @ColumnInfo(name = "finish_by")
    lateinit var finishBy:String
    @ColumnInfo(name = "finished")
    var isFinished:Boolean = false
}