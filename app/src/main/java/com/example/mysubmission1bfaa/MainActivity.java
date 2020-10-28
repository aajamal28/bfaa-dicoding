package com.example.mysubmission1bfaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private String[] dataName;
    private String[] dataUsername;
    private String[] dataCompany;
    private String[] dataLocation;
    private String[] dataRepo;
    private String[] dataFollower;
    private String[] dataFollowing;
    private TypedArray dataAvatar;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        additem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, users.get(i).getName(), Toast.LENGTH_LONG).show();
                Intent movetoDetail = new Intent(MainActivity.this, DetailActivity.class);

                ArrayList<User> users = new ArrayList<User>();

                User user = new User(Parcel.obtain());
                user.setName(dataName[i]);
                user.setUsername(dataUsername[i]);
                user.setCompany(dataCompany[i]);
                user.setPhoto(dataAvatar.getResourceId(i, -1));
                user.setLocation(dataLocation[i]);
                user.setRepo(dataRepo[i]);
                user.setFollower(dataFollower[i]);
                user.setFollowing(dataFollowing[i]);

                users.add(user);

                movetoDetail.putParcelableArrayListExtra(DetailActivity.EXTRA_USER, users);
                movetoDetail.putExtra(DetailActivity.EXTRA_USER, user);
                startActivity(movetoDetail);

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepo = getResources().getStringArray(R.array.repository);
        dataFollower = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);

    }

    private void additem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            User user = new User(Parcel.obtain());
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setPhoto(dataAvatar.getResourceId(i, -1));
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            user.setRepo(dataRepo[i]);
            user.setFollower(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);

            users.add(user);
        }

        adapter.setUsers(users);
    }
}
