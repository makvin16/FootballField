package com.example.sportexfield.model

data class PositionDto(
    val col: Int,
    val line: Int,
    val orderNumber: Int,
    val title: String,
    val subTitle: String,
    val slugPosition: String,
    val slugSubPosition: String
)