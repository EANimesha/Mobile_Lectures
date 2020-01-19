package com.example.mytodo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface TaskDao {
    @get:Query("SELECT * FROM task")
    val getAll:List<Task>
    @Insert
    fun insert(task:Task)
    @Delete
    fun delete(task:Task)
    @Update
    fun update(task:Task)
}