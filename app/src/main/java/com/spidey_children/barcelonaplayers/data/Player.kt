package com.spidey_children.barcelonaplayers.data

data class Player(
    val number: Double = 0.0,
    val name: String = "",
    val position: String = "",
    val positionNum: Double = 0.0,
    val detail: Detail = Detail(
        height = "",
        weight = "",
        country = "",
        birth = "",
        content = ""
    )
)

data class Detail(
    val height: String = "",
    val weight: String = "",
    val country: String = "",
    val birth: String = "",
    val content: String? = ""
)

