package com.example.rickandmorty_mvvm.ui.characters

import androidx.lifecycle.ViewModel
import com.example.rickandmorty_mvvm.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
): ViewModel() {

    val characters = repository.getCharacters()
}