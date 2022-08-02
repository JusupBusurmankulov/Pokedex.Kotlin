package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.databinding.FragmentBottomDialogBinding
import android.nfc.Tag
import android.widget.Toast

import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomDialogFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBottomDialogBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomDialogBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: PokemonModel = arguments?.getSerializable("key") as PokemonModel
        binding.tvPokemonName.text = model.name
        binding.tvDescription.text = model.dataPokemon
    }


}