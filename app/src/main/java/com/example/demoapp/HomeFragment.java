package com.example.demoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.demoapp.adapter.GridLayoutAdapter;
import com.example.demoapp.modal.Data;
import com.example.demoapp.modal.DataMenu;
import com.example.demoapp.modal.DataModel;
import com.example.demoapp.modal.Hamburger_menu;
import com.example.demoapp.retrofit.MyAPI;
import com.example.demoapp.retrofit.MyInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment implements GridLayoutAdapter.EventListener{

    private RecyclerView recyclerView;
    private CheckBox checkBox;
    private MyInterface myInterface;
    private DataModel dataModel;
    private List<DataMenu> newDataList;
    private Button btn_save;
    List<String> stringList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //toolbar = view.findViewById(R.id.my_toolbar);
        //((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        LinearLayout custom_toolbar = view.findViewById(R.id.my_toolbar);

        checkBox = view.findViewById(R.id.cb_selectAll);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    recyclerView.setAdapter(new GridLayoutAdapter(newDataList, true,HomeFragment.this));
                    checkBox.setText(R.string.deselect_all);
                } else {
                    recyclerView.setAdapter(new GridLayoutAdapter(newDataList, false,HomeFragment.this));
                    checkBox.setText(R.string.select_all);
                }
             }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);
//        imageList.add(R.drawable.ic_news);

//        titleList.add("News");
//        titleList.add("Business");
//        titleList.add("Drama");
//        titleList.add("Tech");
//        titleList.add("Sports");
//        titleList.add("Astro");
//        titleList.add("Fitness");
//        titleList.add("Mumbai");
//        titleList.add("Bharat");
//        titleList.add("Kids");
//        titleList.add("UP");
//        titleList.add("MP");
//        titleList.add("Punjab");
//        titleList.add("World");
//        titleList.add("Delhi");
//        titleList.add("Crime");
        //recyclerView.setAdapter(new GridLayoutAdapter(imageList,titleList,false));
        myInterface = MyAPI.getClient(getContext()).create(MyInterface.class);

        btn_save = view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Saved", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onCLick"+stringList);
            }
        });

        setUpApi();
    }

    private void setUpApi() {

        Call<DataModel> call = myInterface.getAllData();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(@NotNull Call<DataModel> call, @NotNull Response<DataModel> response) {
                dataModel = response.body();
                assert dataModel != null;
                Data data = dataModel.getData();
                List<Hamburger_menu> hamburger = data.getHamburger_menu();
                 for(int i=0;i<hamburger.size();i++)
                 {
                     if(hamburger.get(i).getMenu_label().equals("Top Categories"))
                     {
                         newDataList = hamburger.get(i).getMenu();
                     }
                 }
                if (newDataList.size() > 0)
                {
                    recyclerView.setAdapter(new GridLayoutAdapter(newDataList, false,HomeFragment.this));
                }
            }
            @Override
            public void onFailure(@NotNull Call<DataModel> call, @NotNull Throwable t) {
                Toast.makeText(getContext(), "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onEvent(int position) {
        String id = newDataList.get(position).getId();

        if (stringList.contains(id)){
            stringList.remove(id);
        }else {
            stringList.add(id);
        }
        Log.d("TAG", "onEvent list"+stringList);
    }
}
