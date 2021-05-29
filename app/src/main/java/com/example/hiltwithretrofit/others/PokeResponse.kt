package com.example.hiltwithretrofit.others

data class PokeResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultPokemon>
)