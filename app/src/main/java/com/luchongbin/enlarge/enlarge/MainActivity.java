package com.luchongbin.enlarge.enlarge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luchongbin.enlarge.myenlarge.CommonUtils;
import com.luchongbin.enlarge.myenlarge.EnlargeImageDetailActivity;

/**
 * Created by luchongbin on 2018/11/5/005.
 */
public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener{
    private MyAdapter myAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.xRcvItem);
        initRecyclerView();
    }
    private void initRecyclerView(){
        String[] urls = DataSource.getInstance().urls;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdapter = new MyAdapter(this,urls);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        myAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, String imageUrl) {
        Intent intent = new Intent(this, EnlargeImageDetailActivity.class);
        intent.putExtra(CommonUtils.SpaceImageDetail.IMAGEURL, imageUrl);//传入 图片的URL
        int[] location = new int[2];
        view.getLocationOnScreen(location);//view 就是所点击的ImageView
        intent.putExtra(CommonUtils.SpaceImageDetail.LOCATIONX, location[0]);
        intent.putExtra(CommonUtils.SpaceImageDetail.LOCATIONY, location[1]);

        intent.putExtra(CommonUtils.SpaceImageDetail.WIDTH, view.getWidth());
        intent.putExtra(CommonUtils.SpaceImageDetail.HEIGHT, view.getHeight());
        startActivity(intent);
        overridePendingTransition(0, 0);

    }
}
