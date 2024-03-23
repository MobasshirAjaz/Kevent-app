package com.Mobasshir.kevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LinearLayout container = findViewById(R.id.container);
                add_card(connect_database(), container);
            }
        }).start();
    }

    public String connect_database() {
        System.out.println("no");
        String response = "";
        try {
            URL url = new URL("http://10.0.2.2:3000/data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }

    private String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public void add_card(String response, LinearLayout container) {
        try {
            // Convert the response string to a JSONArray
            JSONArray jsonArray = new JSONArray(response);

            // Loop through each object in the array
            for (int i = 0; i < jsonArray.length(); i++) {
                // Get the JSONObject at the current index
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Access column values using the column names (keys)
                String eventName = jsonObject.getString("event_name");
                int event_id=jsonObject.getInt("event_id");
                String society=jsonObject.getString("society");
                String description = jsonObject.getString("description");
                String short_description=jsonObject.getString("short_description");
                String img=jsonObject.getString("event_bg");
                String formlink=jsonObject.getString("form_link");
                String startdate = formatDate(jsonObject.getString("start_date"));
                String enddate = formatDate(jsonObject.getString("end_date"));
                String publishdate = formatDate(jsonObject.getString("publish_date"));

                // Create a new CardView and set its properties
                CardView cardView = new CardView(this);
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create an Intent to start the new Activity
                        Intent intent = new Intent(MainActivity.this, Detail_screen.class);

                        // You can put extra data into the Intent, for example, the event name
                        intent.putExtra("event_name", eventName);
                        intent.putExtra("description",description);
                        intent.putExtra("society",society);
                        intent.putExtra("formlink",formlink);
                        intent.putExtra("image",img);

                        // Start the new Activity
                        startActivity(intent);
                    }
                });
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(16, 14, 16, 14);
                cardView.setLayoutParams(layoutParams);
                cardView.setCardBackgroundColor(Color.WHITE);
                cardView.setRadius(20);


                // Create a LinearLayout for the CardView content
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setPadding(16, 16, 16, 16);

                // Create TextViews for the event name and other columns
                TextView textView1 = new TextView(this);
                textView1.setTextSize(20);
                LinearLayout.LayoutParams layoutParams_t1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                int leftMargin_t1 = convertDpToPixels(8); // Replace with desired value
                int topMargin_t1 = convertDpToPixels(8); // Replace with desired value
                int rightMargin_t1 = convertDpToPixels(8); // Replace with desired value
                int bottomMargin_t1 = convertDpToPixels(8); // Replace with desired value
                layoutParams_t1.setMargins(leftMargin_t1, topMargin_t1, rightMargin_t1, bottomMargin_t1);
                textView1.setLayoutParams(layoutParams_t1);


                textView1.setText(eventName);
                textView1.setTextColor(Color.BLACK);
                textView1.requestLayout();
                textView1.setTypeface(textView1.getTypeface(), Typeface.BOLD);

                TextView textView2 = new TextView(this);

                LinearLayout.LayoutParams layoutParams_t2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                int leftMargin_t2 = convertDpToPixels(8); // Replace with desired value
                int topMargin_t2 = convertDpToPixels(6); // Replace with desired value
                int rightMargin_t2 = convertDpToPixels(0); // Replace with desired value
                int bottomMargin_t2 = convertDpToPixels(10); // Replace with desired value
                layoutParams_t2.setMargins(leftMargin_t2, topMargin_t2, rightMargin_t2, bottomMargin_t2);
                textView2.setLayoutParams(layoutParams_t2);
                textView2.setText(short_description);
                textView2.setTextColor(Color.BLACK);
                textView2.requestLayout();

                TextView textView3 = new TextView(this);
                textView3.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                textView3.setText(startdate);
                textView3.setTextColor(Color.BLACK);
                textView3.setGravity(Gravity.END);

                // Add the TextViews to the LinearLayout
                linearLayout.addView(textView1);
                linearLayout.addView(textView2);
                linearLayout.addView(textView3);

                // Add the LinearLayout to the CardView
                cardView.addView(linearLayout);

                // Add the CardView to the container
                container.addView(cardView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private int convertDpToPixels(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    public String formatDate(String dateString) {

        // The original format of the date string from the database
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        originalFormat.setTimeZone(TimeZone.getTimeZone("UTC")); // Set the timezone to UTC

        // The new format for the date without time
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            // Parse the date string into a Date object
            Date date = originalFormat.parse(dateString);
            // Format the Date object into the new date string format
            return newFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}


