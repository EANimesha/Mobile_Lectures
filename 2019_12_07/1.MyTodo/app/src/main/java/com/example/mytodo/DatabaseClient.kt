package com.example.mytodo

import android.content.Context

import androidx.room.Room

class DatabaseClient private constructor(mCtx:Context) {
    private val mCtx:Context = mCtx
    //our app database object
    val appDatabase:AppDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos").build()

    init{
        //creating the app database with Room database builder
        //MyToDos is the name of the database
    }
    companion object {
        private var mInstance:DatabaseClient?=null
        @Synchronized fun getInstance(mCtx:Context):DatabaseClient {
            if (mInstance == null)
            {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }
    }
}