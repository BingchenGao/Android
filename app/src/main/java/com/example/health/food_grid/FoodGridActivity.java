package com.example.health.food_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.health.FoodDescActivity;
import com.example.health.R;
import com.example.health.bean.FoodBean;
import com.example.health.bean.FoodUtils;

import java.util.List;

public class FoodGridActivity extends AppCompatActivity {
    GridView gv;
    List<FoodBean> mDatas;
    private FoodGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);
        gv = findViewById(R.id.food_grid_gv);
//        数据源
        mDatas = FoodUtils.getAllFoodList();
//        创建适配器对象
        adapter = new FoodGridAdapter(this, mDatas);
//        设置适配器
        gv.setAdapter((ListAdapter) adapter);
        setListener();
    }

    private void setListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean = mDatas.get(position);
                Intent intent = new Intent(FoodGridActivity.this, FoodDescActivity.class);
                intent.putExtra("food", (Parcelable) foodBean);
                startActivity(intent);
            }
        });
    }
}