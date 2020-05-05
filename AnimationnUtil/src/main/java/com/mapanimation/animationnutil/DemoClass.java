package com.mapanimation.animationnutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.Objects;

public class DemoClass {

    public Context mcontext;
    public GoogleMap mMap;
    public SupportMapFragment mMapFragment;
    public RadiusAnimation groundAnimation;
    public AnimationSet breadingAnimations;

    public DemoClass(Context context, GoogleMap Map,SupportMapFragment MapFragment)
    {
      //  Toast.makeText(context,"Hello",Toast.LENGTH_LONG).show();

        this.mcontext=context;
        this.mMap=Map;
        this.mMapFragment=MapFragment;
        breadingAnimations = new AnimationSet(false);
    }


    public void hope(LatLng xDesign1) {

        Bitmap mDotMarkerBitmap1 = generateBitmapFromDrawable(R.drawable.shape_first_view);

        final int widthOne = 80;
        final int animationDurationOne = 1500;
        GroundOverlay groundOverlay1 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap1))
                .position(xDesign1, widthOne));

        groundAnimation = new RadiusAnimation(groundOverlay1);
        groundAnimation.setRepeatCount(Animation.INFINITE);
        groundAnimation.setRepeatMode(Animation.RESTART);

        groundAnimation.setDuration(animationDurationOne);
//        groundAnimation.setStartOffset(700);
        breadingAnimations.addAnimation(groundAnimation);


        Bitmap mDotMarkerBitmap2 = generateBitmapFromDrawable(R.drawable.shape_second_view);
        final int widthTwo = 200;
        final int animationDurationTwo = 2200;
        GroundOverlay groundOverlay2 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap2))
                .position(xDesign1, widthTwo));

        Animation groundAnimation2 = new RadiusAnimation(groundOverlay2);
        groundAnimation2.setRepeatCount(Animation.INFINITE);
        groundAnimation2.setRepeatMode(Animation.RESTART);
        groundAnimation2.setDuration(animationDurationTwo);
//        groundAnimation2.setStartOffset(1500);
        breadingAnimations.addAnimation(groundAnimation2);


        Bitmap mDotMarkerBitmap3 = generateBitmapFromDrawable(R.drawable.shape_third_view);
        final int widthThree = 350;
        final int animationDurationThree = 3200;
        GroundOverlay groundOverlay3 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap3))
                .position(xDesign1, widthThree));

        Animation groundAnimation3 = new RadiusAnimation(groundOverlay3);
        groundAnimation3.setRepeatCount(Animation.INFINITE);
        groundAnimation3.setRepeatMode(Animation.RESTART);
//        groundAnimation3.setStartOffset(500);
        groundAnimation3.setDuration(animationDurationThree);

        breadingAnimations.addAnimation(groundAnimation3);


        Bitmap mDotMarkerBitmap4 = generateBitmapFromDrawable(R.drawable.shape_four_view);
        final int widthFour = 480;
        final int animationDurationFour = 4200;
        GroundOverlay groundOverlay4 = mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap4))
                .position(xDesign1, widthFour));

        Animation groundAnimation4 = new RadiusAnimation(groundOverlay4);
        groundAnimation4.setRepeatCount(Animation.INFINITE);
        groundAnimation4.setRepeatMode(Animation.RESTART);
//        groundAnimation3.setStartOffset(500);
        groundAnimation4.setDuration(animationDurationFour);

        breadingAnimations.addAnimation(groundAnimation4);

        //  findViewById(R.id.map).getRootView().startAnimation(breadingAnimations);
        Objects.requireNonNull(mMapFragment.getView()).startAnimation(breadingAnimations);

        // getSupportFragmentManager().findFragmentById(R.id.map).getView().startAnimation(breadingAnimations);
        //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xDesign1, 16));
        //  mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(xDesign1,16));
    }

    @NonNull
    private Bitmap generateBitmapFromDrawable(int drawablesRes) {
        // int px = getResources().getDimensionPixelSize(150);
        Bitmap mDotMarkerBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mDotMarkerBitmap);
        Drawable shape =mcontext.getResources().getDrawable(drawablesRes);
        shape.setBounds(0, 0, mDotMarkerBitmap.getWidth(), mDotMarkerBitmap.getHeight());
        shape.draw(canvas);
        return mDotMarkerBitmap;
    }

    public class RadiusAnimation extends Animation {
        private final int startingSize = 150;
        private GroundOverlay groundOverlay;

        public RadiusAnimation(GroundOverlay groundOverlay) {
            this.groundOverlay = groundOverlay;

        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            groundOverlay.setDimensions((startingSize * interpolatedTime));
            groundOverlay.setTransparency(interpolatedTime);

        }


        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }
    }
}
