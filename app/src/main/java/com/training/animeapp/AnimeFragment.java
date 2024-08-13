package com.training.animeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.training.animeapp.model.Character;

import java.util.ArrayList;

public class AnimeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime, container, false);

        ListView animeList = view.findViewById(R.id.animeList);

        ArrayList<Character> characters = new ArrayList<>();
        characters.add(new Character("Kirito", "Kirito is a skilled player in the virtual reality game Sword Art Online. He becomes one of the game\\'s strongest players and fights to free everyone trapped inside.", R.drawable.kirito));
        characters.add(new Character("Rem and Ram", "Rem and Ram are twin maids who work for Roswaal L Mathers. Rem has blue hair and is a skilled fighter, while Ram has pink hair and excels in magical abilities.", R.drawable.rem_and_ram));
        characters.add(new Character("Saitama", "Saitama is a superhero who can defeat any opponent with a single punch. Despite his immense power, he is often bored and seeks a worthy challenge.aitama is a superhero who can defeat any opponent with a single punch. Despite his immense power, he is often bored and seeks a worthy challenge.", R.drawable.saitama));
        characters.add(new Character("L Lawliet", "L is a world-renowned detective tasked with catching Kira, the person behind the mysterious deaths caused by the Death Note. He is known for his eccentric behavior and sharp mind.", R.drawable.l_lawliet));
        characters.add(new Character("Natsu Dragneel", "Natsu is a member of the Fairy Tail guild and a Dragon Slayer wizard with the power to breathe and manipulate fire. He is known for his reckless and carefree attitude.", R.drawable.natsu_dragneel));
        characters.add(new Character("Mikasa Ackerman", "Mikasa is Eren\\'s adoptive sister and one of the best soldiers in the Survey Corps. She is fiercely protective of Eren and highly skilled in comba.", R.drawable.mikasa_ackerman));
        characters.add(new Character("Eren Yeager", "Eren is a member of the Survey Corps who vows to exterminate the Titans after they destroy his hometown. He later discovers he has the ability to transform into a Titan himself.", R.drawable.eren_yeager));
        characters.add(new Character("Edward Elric", "Edward is a talented alchemist who lost his arm and leg in an alchemical accident. Alongside his brother Alphonse, he searches for the Philosopher\\'s Stone to restore their bodies.", R.drawable.edward_elric));
        characters.add(new Character("Ichigo Kurosaki", "Ichigo is a high school student who becomes a Soul Reaper, defending humans from evil spirits and guiding souls to the afterlife. He wields a powerful sword called Zangetsu.", R.drawable.lchigo_kurosaki));
        characters.add(new Character("Levi Ackerman", "Levi is the captain of the Survey Corps and is known for his incredible combat skills and stoic personality. He is deeply dedicated to eradicating the Titans.", R.drawable.leviackerman));
        characters.add(new Character("Light Yagami", "Light is a high school student who discovers the Death Note, a notebook that allows him to kill anyone by writing their name in it. He uses it to try to create a utopia free of crime.", R.drawable.lightyagami));
        characters.add(new Character("Sailor Moon", "Usagi is a clumsy and crybaby middle school girl who transforms into Sailor Moon, the leader of the Sailor Scouts. She fights evil forces and searches for the Moon Princess.", R.drawable.sailormoon));
        characters.add(new Character("Goku", "Goku is a Saiyan who loves fighting and getting stronger. He protects Earth from various threats and is known for his cheerful personality and insatiable appetite. His signature move is the Kamehameha wave.", R.drawable.goku));
        characters.add(new Character("Monkey D. Luffy", "Luffy is the captain of the Straw Hat Pirates. He has the ability to stretch his body like rubber after eating a Devil Fruit. His dream is to find the One Piece and become the Pirate King.", R.drawable.monkey_d_luffy));
        characters.add(new Character("Naruto Uzumaki", "Naruto is a ninja from the Hidden Leaf Village. He is cheerful, hyperactive, and determined to become the strongest ninja and earn the title of Hokage. He has a powerful fox demon, Kurama, sealed inside him.", R.drawable.naruto_uzumaki));


        AnimeAdapter adapter = new AnimeAdapter(getContext(), characters); // Pass context correctly
        animeList.setAdapter(adapter);

        // Set up item click listener to open the detail activity
        animeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Character character = (Character) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), AnimeDescriptionActivity.class);
                intent.putExtra("characterImage", character.getImageResourceId());
                intent.putExtra("characterName", character.getName());
                intent.putExtra("characterDescription", character.getDescription());
                startActivity(intent);
            }
        });

        return view;
    }
}
