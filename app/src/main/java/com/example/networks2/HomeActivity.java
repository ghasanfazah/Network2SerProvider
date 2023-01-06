package com.example.networks2;

import static com.android.volley.Request.Method.GET;
import static com.example.networks2.LoginActivity.CHECK_BOX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.networks2.Interface.ItemClickListener;
import com.example.networks2.Interface.OnClick;
import com.example.networks2.Modal.AdapterRecycle;
import com.example.networks2.Modal.ProfessionModel;
import com.example.networks2.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements OnClick {

    ActivityHomeBinding binding;
    RequestQueue queue;
    String email;
    String password;
    JsonObjectRequest jsonObjectRequest;
    // MyRecyclerViewAdapter adapter;
    ArrayList<ProfessionModel> arrayList = new ArrayList<>();

    OnClick onClick=this;

    BottomNavigationAdapter adapter;

    String name;
    int id;



    RecyclerView recyclerView;

    private long backPressed;
    public static final int TIME = 2000;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences(CHECK_BOX,MODE_PRIVATE);
        editor = preferences.edit();



        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

        queue= Volley.newRequestQueue(HomeActivity.this);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.Recycler.setHasFixedSize(true);
        getAllData();


        adapter = new BottomNavigationAdapter(HomeActivity.this,fragmentArrayList);
        binding.viewPager2.setAdapter(adapter);
        binding.navigationBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.navService) {
                    binding.viewPager2.setCurrentItem(0);
                } else if (itemId == R.id.navOrder) {
                    binding.viewPager2.setCurrentItem(1);
                } else if (itemId == R.id.navUser) {
                    binding.viewPager2.setCurrentItem(2);
                } else if (itemId == R.id.navMore) {
                    binding.viewPager2.setCurrentItem(3);
                }
                return false;
            }
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.navigationBottom.getMenu().getItem(position).setChecked(true);
            }
        });

        binding.viewPager2.setUserInputEnabled(false);
    }
    @Override
    public void onBackPressed() {

        if (backPressed + TIME > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Please Click Again", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }



    void getAllData(){
        String uri="https://studentucas.awamr.com/api/all/works";

        StringRequest stringRequest=new StringRequest(GET, uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        jsonObject1=jsonArray.getJSONObject(i);

                        ProfessionModel model;
                        AdapterRecycle adapterRecycle;
                        name=jsonObject1.getString("name");
                        id=jsonObject1.getInt("id");
                        model = new ProfessionModel(id, name);
                        arrayList.add(model);

//                        workList.add(work);
                        adapterRecycle=new AdapterRecycle(HomeActivity.this,arrayList,onClick);
                        binding.Recycler.setAdapter(adapterRecycle);
                        binding.Recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        queue.add(stringRequest);
    }


    @Override
    public void onClickListener() {
        startActivity(new Intent(HomeActivity.this,OrderDetailsActivity.class));

    }
}