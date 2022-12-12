package com.example.rickandmorty_mvvm.data.remote

import com.example.rickandmorty_mvvm.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.rickandmorty_mvvm.data.entities.Character

interface CharacterService {
    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}