package com.Mobasshir.kevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcard();
    }

    public void addcard(){
        TextView text1= findViewById(R.id.kevent_title);
        LinearLayout linearLayout_scroll = findViewById(R.id.linearLayout_scroll);
        text1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                TextView cardTextView = new TextView(view.getContext());

                // Set TextView attributes to give it a card-like appearance
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                // Adjust margin as needed
                // Fetch the dimensions
                int marginTop = (int) getResources().getDimension(R.dimen.card_margin_top);
                int marginRight = (int) getResources().getDimension(R.dimen.card_margin_right);
                int marginBottom = (int) getResources().getDimension(R.dimen.card_margin_bottom);
                int marginLeft = (int) getResources().getDimension(R.dimen.card_margin_left);

// Set margins in your LayoutParams
                layoutParams.setMargins(marginLeft, marginTop, marginRight,marginBottom);
                cardTextView.setLayoutParams(layoutParams);
                cardTextView.setBackgroundResource(R.drawable.rectangle); // Create a shape drawable for card background
                linearLayout_scroll.addView(cardTextView);

            }
        });
    }
}
