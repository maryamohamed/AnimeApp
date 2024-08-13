package com.training.animeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.animeapp.model.Character;

import java.util.ArrayList;

public class AnimeAdapter extends ArrayAdapter<Character> {

    public AnimeAdapter(Context context, ArrayList<Character> characters) {
        super(context, 0, characters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Character character = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_anime, parent, false);
        }

        ImageView characterImage = convertView.findViewById(R.id.characterImage);
        TextView characterName = convertView.findViewById(R.id.characterName);
        TextView characterDesc = convertView.findViewById(R.id.characterDesc);

        characterImage.setImageResource(character.getImageResourceId());
        characterName.setText(character.getName());
        characterDesc.setText(character.getDescription());

        return convertView;
    }
}
