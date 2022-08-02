package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokedex.databinding.FragmentPokemonBinding


class PokemonFragment : Fragment(), ItemClicker {
    lateinit var binding: FragmentPokemonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


    private fun initAdapter() {
        val list = arrayListOf<PokemonModel>()
        list.add(
            PokemonModel(
                "Bulbasaur",
                "#001",
                R.drawable.img,
                "#74CB48",
                EnumType.GRASS,
                EnumType.POISON,
                45,
                49,
                65,
                49,
                45,
                "6,9 kg",
                "0,7 m",
                "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                65,
                "Chlorophyll\n Overgrow",
                "Ivysaur",
                "Venusaur",
                "MEGA Venusaur",
                "#002",
                "#003",
                "#003",
                R.drawable.bulbasaur1,
                R.drawable.bulbasaur2,
                R.drawable.bulbasaur3,
                60,
                80,
                80,
                62,
                82,
                100,
                80,
                100,
                120,
                63,
                83,
                123,
                60,
                80,
                80,
                80,
                100,
                122,
                "13,0 kg",
                "100,0 kg",
                "155,5 kg",
                "1,0 m",
                "2,0 m",
                "2,4 m",
                "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.",
                "Its plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.",
                "In order to support its flower, which has grown larger due to Mega Evolution, its back and legs have become stronger."
            )
        )






        list.add(
            PokemonModel(
                "Charmander",
                "#004",
                R.drawable.img_4,
                "#F57D31",
                EnumType.FIRE,
                EnumType.NULL,
                39,
                52,
                50,
                43,
                65,
                "8,5 kg",
                "0,6 m",
                "It has a preference for hot things. When it rains, steam is said to spout from the tip of its tail.",
                60,
                "Mega-Punch\n Fire-Punch",
                "Charmeleon",
                "Charizard",
                "MEGA Charizard",
                "#005",
                "#006",
                "#006",
                R.drawable.ch1,
                R.drawable.ch2,
                R.drawable.ch3,
                58,
                78,
                78,
                64,
                84,
                104,
                65,
                85,
                115,
                58,
                78,
                78,
                80,
                100,
                100,
                80,
                109,
                159,
                "19,0 kg",
                "90,5 kg",
                "100,5 kg",
                "1,1 m",
                "1,7 m",
                "1,7 m",
                "It has a barbaric nature. In battle, it whips its fiery tail around and slashes away with sharp claws.",
                "It spits fire that is hot enough to melt boulders. It may cause forest fires by blowing flames.",
                "Its bond with its Trainer is the source of its power. It boasts speed and maneuverability greater than that of a jet fighter."
            )
        )
        list.add(
            PokemonModel(
                "Squirtle",
                "#007",
                R.drawable.img_5,
                "#6493EB",
                EnumType.WATER,
                EnumType.NULL,
                44,
                48,
                64,
                65,
                43,
                "9,0 kg",
                "0,5 m",
                "When it retracts its long neck into its shell, it squirts out water with vigorous force.",
                50,
                "Torrent\n Rain-Dish",
                "Wartortle",
                "Blastoise",
                "MEGA Blastoise",
                "#008",
                "#009",
                "#009",
                R.drawable.war1,
                R.drawable.war2,
                R.drawable.war3,
                59,
                79,
                79,
                63,
                83,
                103,
                80,
                105,
                115,
                80,
                100,
                120,
                58,
                78,
                78,
                65,
                85,
                135,
                "22,5 kg",
                "85,5 kg",
                "101,1 kg",
                "1,0 m",
                "1,6 m",
                "1,6 m",
                "It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old.",
                "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell.",
                "The cannon on its back is as powerful as a tank gun. Its tough legs and back enable it to withstand the recoil from firing the cannon."
            )
        )







        list.add(
            PokemonModel(
                "Caterpie",
                "#010",
                R.drawable.ca1,
                "#A7B723",
                EnumType.BUG,
                EnumType.FLYING,
                45,
                30,
                20,
                35,
                45,
                "2,9 kg",
                "0,3 m",
                "For protection, it releases a horrible stench from the antenna on its head to drive away enemies.",
                20,
                "Compound-Eyes\n Tinted-Lens",
                "Metapod",
                "Butterfree",
                "",
                "#010",
                "#011",
                "#012",
                R.drawable.ca2,
                R.drawable.ca3,
                R.drawable.img,
                50,
                60,
                1,
                20,
                45,
                1,
                25,
                80,
                1,
                55,
                50,
                1,
                30,
                70,
                1,
                25,
                90,
                1,
                "9,9 kg",
                "32,0 kg",
                "",
                "0,7 m",
                "1,1 m",
                "",
                "It is waiting for the moment to evolve. At this stage, it can only harden, so it remains motionless to avoid attack.",
                "In battle, it flaps its wings at great speed to release highly toxic dust into the air.",
                ""
            )
        )





        list.add(
            PokemonModel(
                "Pichu",
                "#172",
                R.drawable.pichu1,
                "#F9CF30",
                EnumType.ELECTRIC,
                EnumType.NULL,
                20,
                40,
                35,
                15,
                60,
                "6,0 kg",
                "0,4 m",
                "Despite its small size, it can zap even adult humans. However, if it does so, it also surprises itself.",
                35,
                "Mega-Punch\n Pay-Day",
                "Pikachu",
                "Raichu",
                "ALOLAN Raichu",
                "#025",
                "#026",
                "#026",
                R.drawable.pichu2,
                R.drawable.pichu4,
                R.drawable.pichu3,
                35,
                60,
                60,
                55,
                90,
                85,
                50,
                80,
                85,
                40,
                55,
                50,
                90,
                110,
                110,
                50,
                90,
                95,
                "6,0 kg",
                "30,0 kg",
                "21,0 kg",
                "0,4 m",
                "0,8 m",
                "0,7 m",
                "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.",
                "Its long tail serves as a ground to protect itself from its own high-voltage power.",
                "It’s believed that the weather, climate, and food of the Alola region all play a part in causing Pikachu to evolve into this form of Raichu."
            )
        )





        list.add(
            PokemonModel(
                "Gastly",
                "#092",
                R.drawable.ga1,
                "#70559B",
                EnumType.GHOST,
                EnumType.TYPE,
                30,
                35,
                35,
                30,
                80,
                "0,1 kg",
                "1,3 m",
                "Born from gases, anyone would faint if engulfed by its gaseous body, which contains poison.",
                100,
                "Levitate",
                "Haunter",
                "Gengar",
                "MEGA Gengar",
                "#093",
                "#094",
                "#094",
                R.drawable.ga2,
                R.drawable.ga3,
                R.drawable.ga4,
                45,
                60,
                60,
                50,
                65,
                65,
                55,
                75,
                95,
                45,
                60,
                80,
                95,
                110,
                130,
                115,
                130,
                170,
                "0,1 kg",
                "40,5 kg",
                "40,5 kg",
                "1,6 m",
                "1,5 m",
                "1,4 m",
                "Its tongue is made of gas. If licked, its victim starts shaking constantly until death eventually comes.",
                "On the night of a full moon, if shadows move on their own and laugh, it must be Gengar’s doing.",
                "It can pass through other dimensions and appear anywhere. It caused a stir one time when it stuck just one leg out of a wall."
            )
        )





        list.add(
            PokemonModel(
                "Ditto",
                "#132",
                R.drawable.img_9,
                "#AAA67F",
                EnumType.NORMAL,
                EnumType.NULL,
                48,
                48,
                48,
                48,
                48,
                "4,0 kg",
                "0,3 m",
                "It can reconstitute its entire cellular structure to change into what it sees, but it returns to normal when it relaxes.",
                48,
                "Limber\n Imposter",
                "",
                "",
                "MEGA",
                "",
                "",
                "",
                R.drawable.img,
                R.drawable.img,
                R.drawable.img,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            )
        )





        list.add(
            PokemonModel(
                "Mew",
                "#152",
                R.drawable.img_10,
                "#FB5584",
                EnumType.PSYCHIC,
                EnumType.NULL,
                100,
                100,
                100,
                100,
                100,
                "4,0 kg",
                "0,4 m",
                "When viewed through a microscope, this Pokémon’s short, fine, delicate hair can be seen.",
                100,
                "Synchronize",
                "",
                "",
                "MEGA",
                "",
                "",
                "",
                R.drawable.img,
                R.drawable.img,
                R.drawable.img,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            )
        )





        list.add(
            PokemonModel(
                "Aron",
                "#304",
                R.drawable.img_11,
                "#B7B9D0",
                EnumType.STEEL,
                EnumType.ROCK,
                50,
                70,
                40,
                100,
                30,
                "60,0 kg",
                "0,4 m",
                "It eats iron ore - and sometimes railroad tracks - to build up the steel armor that protects its body.",
                40,
                "Sturdy\n Rock-Head",
                "Lairon",
                "Aggron",
                "MEGA Aggron",
                "#305",
                "#306",
                "#306",
                R.drawable.aron1,
                R.drawable.aron2,
                R.drawable.aron3,
                60,
                70,
                70,
                90,
                110,
                140,
                50,
                60,
                80,
                140,
                180,
                230,
                40,
                50,
                50,
                50,
                60,
                60,
                "120,0 kg",
                "360,0 kg",
                "395,0 kg",
                "0,9 m",
                "2,1 m",
                "2,2 m",
                "Lairon live in mountains brimming with spring water and iron ore, so these Pokémon often came into conflict with humans in the past.",
                "Aggron has a horn sharp enough to perforate thick iron sheets. It brings down its opponents by ramming into them horn first.",
                "Aggron claims an entire mountain as its own territory. It mercilessly beats up anything that violates its environment. This Pokémon vigilantly patrols its territory at all times."
            )
        )







        list.add(
            PokemonModel(
                "Jusup",
                "#0001",
                R.drawable.img_12,
                "#FFC525",
                EnumType.PROGRAMMER,
                EnumType.CODER,
                150,
                150,
                150,
                150,
                150,
                "55,0 kg",
                "1,7 m",
                "Day after day suffering from crap",
                150,
                "Laziness\n Games",
                "Joseph",
                "",
                "",
                "#???????????",
                "",
                "",
                R.drawable.me,
                R.drawable.img,
                R.drawable.img,
                99999999,
                1,
                1,
                99999999,
                1,
                1,
                99999999,
                1,
                1,
                99999999,
                1,
                1,
                99999999,
                1,
                1,
                99999999,
                1,
                1,
                "?????????",
                "",
                "",
                "?????????",
                "",
                "",
                "?????????????????????????????????????",
                "",
                ""
            )
        )


        val pokemonAdapter = PokemonAdapter(list, this)
        binding.recycler.adapter = pokemonAdapter
    }

    override fun itemClick(pokemonModel: PokemonModel) {
        val bundle = Bundle()
        bundle.putSerializable("model", pokemonModel)
        findNavController().navigate(R.id.detailFragment, bundle)
    }


}