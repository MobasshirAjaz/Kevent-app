package com.Mobasshir.kevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class Detail_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        ImageView image = findViewById(R.id.image_detail);
        TextView society = findViewById(R.id.society_name_detail);
        TextView event = findViewById(R.id.event_name_detail);
        TextView description = findViewById(R.id.event_desc_detail);
        Button button = findViewById(R.id.form_button);

        // Get the data from the intent
        String imageUrl = getIntent().getStringExtra("image");
        String event_name = getIntent().getStringExtra("event_name");
        String society_name = getIntent().getStringExtra("society");
        String form_link = getIntent().getStringExtra("formlink");
        String desc = getIntent().getStringExtra("description");

        society.setText(society_name);
        event.setText(event_name);
        description.setText(desc);

        event.setTypeface(event.getTypeface(), Typeface.BOLD);
        event.setTextSize(40);
        society.setTextSize(20);
        society.setTypeface(society.getTypeface(), Typeface.BOLD);

        System.out.println(form_link);
        if (form_link.equals("null")) {
            button.setEnabled(false);
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = form_link;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });
        }
            Glide.with(this)
                    .load("http://10.0.2.2:3000/images/" + imageUrl)
                    .into(image);
        }
    }

