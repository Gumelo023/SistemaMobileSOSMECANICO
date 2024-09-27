package com.tcc.tccmecanico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;

public class Avaliacao extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        float rating = ratingBar.getRating();



        EditText feedbackText = findViewById(R.id.feedback_text);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(view -> {
            String feedback = feedbackText.getText().toString();
            // Lógica para enviar feedback, como salvar no banco de dados ou enviar para um servidor
        });
    }
}
