package com.etyalab.flosspa.Network

import android.content.Context
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

fun get(url: String, context: Context, listener: Callback){
    val client = OkHttpClient()
    val request = Request
            .Builder()
            .url(url)
            .build()
    // Execute the request and get the response asynchronously.
    client.newCall(request).enqueue(listener)
}

fun post(body: RequestBody, url: String, context: Context, listener: Callback){
    val client = OkHttpClient()
    val request = Request.Builder()
            .url(url)
            .post(body)
            .addHeader("Authorization", "Bearer ")
            .build()
    // Execute the request and get the response asynchronously.
    client.newCall(request).enqueue(listener)
}

fun delete(body: RequestBody, url: String, context: Context, listener: Callback){
    val client = OkHttpClient()
    val request = Request.Builder()
            .url(url)
            .delete(body)
            .addHeader("Authorization", "Bearer ")
            .build()
    // Execute the request and get the response asynchronously.
    client.newCall(request).enqueue(listener)
}