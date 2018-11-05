package com.luchongbin.enlarge.myenlarge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import com.bumptech.glide.Glide;
/**
 * Created by luchongbin on 2018/11/5/005.
 */
public class EnlargeImageDetailActivity extends Activity implements View.OnClickListener, EnlargeImageView.TransformListener {
	private EnlargeImageView imageView = null;
	private String imageUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent mIntent = getIntent();
		imageUrl = mIntent.getStringExtra(CommonUtils.SpaceImageDetail.IMAGEURL);
		int mLocationX = mIntent.getIntExtra(CommonUtils.SpaceImageDetail.LOCATIONX, 0);
		int mLocationY = mIntent.getIntExtra(CommonUtils.SpaceImageDetail.LOCATIONY, 0);
		int mWidth = mIntent.getIntExtra(CommonUtils.SpaceImageDetail.WIDTH, 0);
		int mHeight = mIntent.getIntExtra(CommonUtils.SpaceImageDetail.HEIGHT, 0);

		imageView = new EnlargeImageView(this);
		imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);
		imageView.transformIn();
		imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
		imageView.setScaleType(ScaleType.FIT_CENTER);
		setContentView(imageView);
		initData(imageUrl);
		setListener();


	}
	private void initData(String imageUrl){
		Glide.with(this)
				.load(imageUrl).asBitmap()
				.into(imageView);

	}
	private void setListener(){
		imageView.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		if(view.getId()==imageView.getId()){
			onBackPressed();
		}
	}


	@Override
	public void onTransformComplete(int mode) {
		if (mode == 2) {
			finish();
		}
	}

	@Override
	public void onBackPressed() {
		imageView.setOnTransformListener(this);
		imageView.transformOut();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (isFinishing()) {
			overridePendingTransition(0, 0);
		}
	}
}
