    package com.example.anime;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

    import androidx.appcompat.app.AppCompatActivity;

    import com.example.anime.databse.SqliteDatabase;

    import butterknife.BindView;
    import butterknife.ButterKnife;


    public class AddActivity extends AppCompatActivity {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.nameEditText)
        EditText mNameEditText;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.scoreEditText)
        EditText mScoreEditText;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.episodeEditText)
        EditText mEpisodeEditText;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.descriptionEditText)
        EditText mDescriptionEditText;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.urlEditText)
        EditText mUrlEditText;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.animeButton)
        Button mAnimeButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);

            ButterKnife.bind(this);

            SqliteDatabase dataBase = new SqliteDatabase(this);

            mAnimeButton.setOnClickListener((View v) -> {
                String name = mNameEditText.getText().toString();
                int score = Integer.parseInt(mScoreEditText.getText().toString());
                int episode = Integer.parseInt(mEpisodeEditText.getText().toString());
                String description = mDescriptionEditText.getText().toString();
                String url = mUrlEditText.getText().toString();

                Anime mNewAnime = new Anime(name, score, episode, description, url);
                getDataBase(dataBase).newAnime(mNewAnime);

                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
            });

        }

        private SqliteDatabase getDataBase(SqliteDatabase dataBase) {
            return dataBase;
        }
    }
