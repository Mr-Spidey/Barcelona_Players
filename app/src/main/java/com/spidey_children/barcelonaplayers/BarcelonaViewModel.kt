package com.spidey_children.barcelonaplayers

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.spidey_children.barcelonaplayers.data.Player

class BarcelonaViewModel : ViewModel() {
    private val db = Firebase.firestore
    var playerList by mutableStateOf(listOf<Player>())

    fun getPlayerList() {
        val collection = db.collection("players").orderBy("positionNum").orderBy("number")
        collection.addSnapshotListener { snapshot, _ ->
            val newPlayerList = mutableListOf<Player>()
            Log.d("playerListFromDatabase", "Read snapshot from online")
            for (doc in snapshot!!) {
                newPlayerList.add(doc.toObject())
            }
            playerList = newPlayerList
        }
    }
}