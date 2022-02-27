package com.spidey_children.barcelonaplayers.data

data class Player(
    val number: Double,
    val name: String,
    val position: String,
    val positionNum: Double
) {
    constructor() : this(number = 1.0, name = "", position = "", positionNum = 1.0)
}
