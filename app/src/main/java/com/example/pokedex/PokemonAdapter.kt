package com.example.pokedex

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ActivityDetailBinding
import com.example.pokedex.databinding.ItemPokemonBinding

class PokemonAdapter(val list: ArrayList<PokemonModel>, var listener: ItemClicker):RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PokemonViewHolder(val binding: ItemPokemonBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(pokemonModel: PokemonModel){
            itemView.setOnClickListener {
                listener.itemClick(pokemonModel)
            }

            changeStrokeColor(binding.textView, pokemonModel.backgroundColor)
            changeSolidColor(binding.itemContainer, pokemonModel.backgroundColor)

            binding.textView.text = pokemonModel.name
            binding.number.text = pokemonModel.number
            binding.number.setTextColor(Color.parseColor(pokemonModel.backgroundColor))
            binding.pokemon.setImageResource(pokemonModel.image)
        }

        private fun changeSolidColor(view: View, color: String) {
            val drawable: GradientDrawable =
                view.background as GradientDrawable
            drawable.mutate()
            drawable.setStroke(4, Color.parseColor(color))
        }

        private fun changeStrokeColor(view: View, color: String) {
            val drawable: GradientDrawable =
                view.background as GradientDrawable
            drawable.mutate()
            drawable.setColor(Color.parseColor(color))
            drawable.setStroke(4, Color.parseColor(color))
        }
    }
}