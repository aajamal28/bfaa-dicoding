package com.example.mysubmission1bfaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";
    TextView tvNamedt, tvUsernamedt, tvRepodt, tvCompanydt, tvLocationdt, tvFollowerdt, tvFollowingdt;
    ImageView imgAvatardt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNamedt = findViewById(R.id.dtName);
        tvUsernamedt = findViewById(R.id.dtUsername);
        tvRepodt = findViewById(R.id.dtRepo);
        tvCompanydt = findViewById(R.id.dtCompany);
        tvLocationdt = findViewById(R.id.dtLocation);
        tvFollowerdt = findViewById(R.id.dtFollower);
        tvFollowingdt= findViewById(R.id.dtFollowing);
        imgAvatardt = findViewById(R.id.dtAvatar);


        User user = getIntent().getParcelableExtra(EXTRA_USER);
        tvNamedt.setText(user.getName());
        tvUsernamedt.setText(user.getUsername());
        tvRepodt.setText(user.getRepo());
        tvCompanydt.setText(user.getCompany());
        tvLocationdt.setText(user.getLocation());
        tvFollowerdt.setText(user.getFollower());
        tvFollowingdt.setText(user.getFollowing());
        imgAvatardt.setImageResource(user.getPhoto());
    }
}
