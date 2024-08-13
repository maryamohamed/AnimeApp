package com.training.animeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimeDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_description);

        ImageView characterImage = findViewById(R.id.characterImageDesc);
        TextView characterName = findViewById(R.id.characterNameDesc);
        TextView characterDescription = findViewById(R.id.characterDescriptionDesc);
        ImageView backArrow = findViewById(R.id.backArrow);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characterImage.setImageResource(extras.getInt("characterImage"));
            characterName.setText(extras.getString("characterName"));
            characterDescription.setText(extras.getString("characterDescription"));
        }
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimeDescriptionActivity.this, NavDrawerActivity.class);
                        startActivity(intent);
            }
        });
    }

}
