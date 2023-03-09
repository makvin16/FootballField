package com.example.sportexfield.model

data class SchemaDto(
    val id: Int,
    val orderNumber: Int,
    val title: String,
    val positions: List<PositionDto>
)