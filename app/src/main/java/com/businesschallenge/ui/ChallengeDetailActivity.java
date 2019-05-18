package com.businesschallenge.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.businesschallenge.R;
import com.businesschallenge.model.Business;
import com.businesschallenge.utils.JsonUtils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChallengeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    @BindView(R.id.image_iv)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        assert intent != null;
        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] businessOne = getResources().getStringArray(R.array.business_details);
        String json = businessOne[position];
        Business business = JsonUtils.parseBusinessJson(json);
        if (business == null) {
            // Business data unavailable
            closeOnError();
            return;
        }

        populateUI(business);
        Picasso.get()
                .load(R.drawable.start)
                .placeholder(R.drawable.start)
                .error(R.drawable.start)
                .into(imageView);

        setTitle(business.getMainName());
            }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Business business) {
        // Set description
        setSandwichTexts(R.id.description_tv, business.getDescription());
    }

    private void setSandwichTexts(int viewId, String text) {

        TextView view = findViewById(viewId);

        if (!text.equals("")) {
            view.setText(text);
        } else {
            view.setText(R.string.blank);
        }
    }

}
