package com.example.pokedex

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokedex.databinding.FragmentDetailBinding
import com.google.android.material.progressindicator.LinearProgressIndicator


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    var int: Int? = null
    var int2: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.pokemonFragment)
        }
        val window = activity?.window

        val pokemonModel: PokemonModel = arguments?.getSerializable("model") as PokemonModel
        changeSolidColor(binding.containerDetail, pokemonModel.backgroundColor)

        if (window != null) {
            changeColorStatusBar(window, pokemonModel.backgroundColor)
        }
        binding.btnEvBack.visibility = View.GONE


        if (pokemonModel.name1.isEmpty()) {
            binding.btnEvGo.visibility = View.GONE
        }
        if (pokemonModel.name3.isEmpty()) {
            int2 = 2
        }
        if (pokemonModel.name2.isEmpty()) {
            int2 = 1
        }
        binding.pokeonDetail.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim)
            binding.pokeonDetail.startAnimation(animation)


            val bottomDialogFragment = BottomDialogFragment()
            bottomDialogFragment.show(requireActivity().supportFragmentManager, "")
            val bundle = Bundle()
            bundle.putSerializable("key", pokemonModel)
            bottomDialogFragment.arguments = bundle

        }
        changeSolidColor(binding.containerDetail, pokemonModel.backgroundColor)
        changeSolidColor(binding.firstType, pokemonModel.backgroundColor)
        changeSolidColor(binding.secondType, pokemonModel.backgroundColor)
        binding.firstType.text = pokemonModel.type1.toString()
        binding.secondType.text = pokemonModel.type2.toString()
        if (binding.secondType.text.toString() == "NULL") {
            binding.secondType.visibility = View.GONE
        }
        binding.idNameDetail.text = pokemonModel.name
        binding.numberDetail.text = pokemonModel.number
        binding.pokeonDetail.setImageResource(pokemonModel.image)
        binding.about.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.hpPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.atkPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.spdPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.defPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.satkPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.sdefPokemon.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.baseStats.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarHP.setProgress(pokemonModel.hp)
        binding.progressBarAtk.setProgress(pokemonModel.atk)
        binding.progressBarDef.setProgress(pokemonModel.def)
        binding.progressBarSdef.setProgress(pokemonModel.sdef)
        binding.progressBarSatk.setProgress(pokemonModel.satk)
        binding.progressBarSpd.setProgress(pokemonModel.spd)
        binding.progressBarHP.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarAtk.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarDef.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarSdef.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarSatk.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.progressBarSpd.progressTintList =
            ColorStateList.valueOf(Color.parseColor(pokemonModel.backgroundColor))
        binding.hp.text = pokemonModel.hp.toString()
        binding.atk.text = pokemonModel.atk.toString()
        binding.satk.text = pokemonModel.satk.toString()
        binding.def.text = pokemonModel.def.toString()
        binding.sdef.text = pokemonModel.sdef.toString()
        binding.spd.text = pokemonModel.spd.toString()
        binding.detailData.text = pokemonModel.dataPokemon
        binding.superPokemon.text = pokemonModel.superPokemon
        binding.kg.text = pokemonModel.weight
        binding.m.text = pokemonModel.height
        binding.btnEvGo.setOnClickListener {

            if (int == 2) {
                binding.progressBarHP.setProgress(pokemonModel.hp3)
                binding.progressBarAtk.setProgress(pokemonModel.atk3)
                binding.progressBarDef.setProgress(pokemonModel.def3)
                binding.progressBarSdef.setProgress(pokemonModel.sdef3)
                binding.progressBarSatk.setProgress(pokemonModel.satk3)
                binding.progressBarSpd.setProgress(pokemonModel.spd3)
                binding.hp.text = pokemonModel.hp3.toString()
                binding.atk.text = pokemonModel.atk3.toString()
                binding.satk.text = pokemonModel.satk3.toString()
                binding.def.text = pokemonModel.def3.toString()
                binding.sdef.text = pokemonModel.sdef3.toString()
                binding.spd.text = pokemonModel.spd3.toString()
                binding.detailData.text = pokemonModel.dataPokemon3
                binding.kg.text = pokemonModel.weight3
                binding.m.text = pokemonModel.height3
                binding.idNameDetail.text = pokemonModel.name3
                binding.numberDetail.text = pokemonModel.number3
                binding.pokeonDetail.setImageResource(pokemonModel.image3)
                binding.btnEvGo.visibility = View.GONE
                int = 3
            }
            if (int == 1) {
                if (int2 == 2) {
                    binding.btnEvGo.visibility = View.GONE
                }
                binding.progressBarHP.setProgress(pokemonModel.hp2)
                binding.progressBarAtk.setProgress(pokemonModel.atk2)
                binding.progressBarDef.setProgress(pokemonModel.def2)
                binding.progressBarSdef.setProgress(pokemonModel.sdef2)
                binding.progressBarSatk.setProgress(pokemonModel.satk2)
                binding.progressBarSpd.setProgress(pokemonModel.spd2)
                binding.hp.text = pokemonModel.hp2.toString()
                binding.atk.text = pokemonModel.atk2.toString()
                binding.satk.text = pokemonModel.satk2.toString()
                binding.def.text = pokemonModel.def2.toString()
                binding.sdef.text = pokemonModel.sdef2.toString()
                binding.spd.text = pokemonModel.spd2.toString()
                binding.detailData.text = pokemonModel.dataPokemon2
                binding.kg.text = pokemonModel.weight2
                binding.m.text = pokemonModel.height2
                binding.idNameDetail.text = pokemonModel.name2
                binding.numberDetail.text = pokemonModel.number2
                binding.pokeonDetail.setImageResource(pokemonModel.image2)
                int = 2
            }
            if (int == null) {
                if (int2 == 1) {
                    binding.btnEvGo.visibility = View.GONE
                }
                binding.progressBarHP.setProgress(pokemonModel.hp1)
                binding.progressBarAtk.setProgress(pokemonModel.atk1)
                binding.progressBarDef.setProgress(pokemonModel.def1)
                binding.progressBarSdef.setProgress(pokemonModel.sdef1)
                binding.progressBarSatk.setProgress(pokemonModel.satk1)
                binding.progressBarSpd.setProgress(pokemonModel.spd1)
                binding.hp.text = pokemonModel.hp1.toString()
                binding.atk.text = pokemonModel.atk1.toString()
                binding.satk.text = pokemonModel.satk1.toString()
                binding.def.text = pokemonModel.def1.toString()
                binding.sdef.text = pokemonModel.sdef1.toString()
                binding.spd.text = pokemonModel.spd1.toString()
                binding.detailData.text = pokemonModel.dataPokemon1
                binding.kg.text = pokemonModel.weight1
                binding.m.text = pokemonModel.height1
                binding.idNameDetail.text = pokemonModel.name1
                binding.numberDetail.text = pokemonModel.number1
                binding.btnEvBack.visibility = View.VISIBLE
                binding.pokeonDetail.setImageResource(pokemonModel.image1)
                int = 1
            }

        }
        binding.btnEvBack.setOnClickListener {
            if (int == 1) {
                binding.progressBarHP.setProgress(pokemonModel.hp)
                binding.progressBarAtk.setProgress(pokemonModel.atk)
                binding.progressBarDef.setProgress(pokemonModel.def)
                binding.progressBarSdef.setProgress(pokemonModel.sdef)
                binding.progressBarSatk.setProgress(pokemonModel.satk)
                binding.progressBarSpd.setProgress(pokemonModel.spd)
                binding.kg.text = pokemonModel.weight
                binding.m.text = pokemonModel.height
                binding.hp.text = pokemonModel.hp.toString()
                binding.atk.text = pokemonModel.atk.toString()
                binding.satk.text = pokemonModel.satk.toString()
                binding.def.text = pokemonModel.def.toString()
                binding.sdef.text = pokemonModel.sdef.toString()
                binding.spd.text = pokemonModel.spd.toString()
                binding.detailData.text = pokemonModel.dataPokemon
                binding.idNameDetail.text = pokemonModel.name
                binding.numberDetail.text = pokemonModel.number
                binding.pokeonDetail.setImageResource(pokemonModel.image)
                binding.btnEvBack.visibility = View.GONE
                int = null
            }
            if (int == 2) {
                binding.progressBarHP.setProgress(pokemonModel.hp1)
                binding.progressBarAtk.setProgress(pokemonModel.atk1)
                binding.progressBarDef.setProgress(pokemonModel.def1)
                binding.progressBarSdef.setProgress(pokemonModel.sdef1)
                binding.progressBarSatk.setProgress(pokemonModel.satk1)
                binding.progressBarSpd.setProgress(pokemonModel.spd1)
                binding.hp.text = pokemonModel.hp1.toString()
                binding.atk.text = pokemonModel.atk1.toString()
                binding.satk.text = pokemonModel.satk1.toString()
                binding.def.text = pokemonModel.def1.toString()
                binding.sdef.text = pokemonModel.sdef1.toString()
                binding.spd.text = pokemonModel.spd1.toString()
                binding.detailData.text = pokemonModel.dataPokemon1
                binding.kg.text = pokemonModel.weight1
                binding.m.text = pokemonModel.height1
                binding.idNameDetail.text = pokemonModel.name1
                binding.numberDetail.text = pokemonModel.number1
                binding.pokeonDetail.setImageResource(pokemonModel.image1)
                int = 1
            }
            if (int == 3) {
                binding.progressBarHP.setProgress(pokemonModel.hp2)
                binding.progressBarAtk.setProgress(pokemonModel.atk2)
                binding.progressBarDef.setProgress(pokemonModel.def2)
                binding.progressBarSdef.setProgress(pokemonModel.sdef2)
                binding.progressBarSatk.setProgress(pokemonModel.satk2)
                binding.progressBarSpd.setProgress(pokemonModel.spd2)
                binding.hp.text = pokemonModel.hp2.toString()
                binding.atk.text = pokemonModel.atk2.toString()
                binding.satk.text = pokemonModel.satk2.toString()
                binding.def.text = pokemonModel.def2.toString()
                binding.sdef.text = pokemonModel.sdef2.toString()
                binding.spd.text = pokemonModel.spd2.toString()
                binding.detailData.text = pokemonModel.dataPokemon2
                binding.kg.text = pokemonModel.weight2
                binding.m.text = pokemonModel.height2
                binding.idNameDetail.text = pokemonModel.name2
                binding.numberDetail.text = pokemonModel.number2
                binding.pokeonDetail.setImageResource(pokemonModel.image2)
                int = 2
                binding.btnEvGo.visibility = View.VISIBLE
            }
        }
    }


    fun changeColorStatusBar(window: Window, color: String) {
        window.statusBarColor = Color.parseColor(color)
    }


    fun changeSolidColor(view: View, color: String) {
        val drawable: GradientDrawable = view.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(4, Color.parseColor(color))
        drawable.setColor(Color.parseColor(color))
    }


}