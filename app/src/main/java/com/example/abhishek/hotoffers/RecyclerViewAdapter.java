package com.example.abhishek.hotoffers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhishek on 7/4/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Content> cont = new ArrayList<>();
    Context context;
    int lastPosition = -1;


    public RecyclerViewAdapter(Context context, ArrayList<Content> cont) {
        this.cont = cont;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
        public void clearAnimation()
        {
            mView.clearAnimation();
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView t1 = (TextView) holder.mView.findViewById(R.id.desc);
        ImageView im1 = (ImageView) holder.mView.findViewById(R.id.backImage);
        ImageView im2 = (ImageView) holder.mView.findViewById(R.id.logo);
        t1.setText(cont.get(position).desc);
        im1.setImageResource(cont.get(position).resources);
        im2.setImageResource(cont.get(position).resource2);
        setAnimation(holder.mView, position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        AnimationSet animationSet = new AnimationSet(context, null);
        int y = viewToAnimate.getHeight()/2;
        int x = viewToAnimate.getWidth()/2;
        animationSet.addAnimation(new AlphaAnimation(0f, 1f));
        //animationSet.addAnimation(new ScaleAnimation(1,1,0.5f,1,x,y));
        animationSet.addAnimation(new TranslateAnimation(0,0,y,0));
        animationSet.setDuration(context.getResources().getInteger(android.R.integer.config_longAnimTime));
        if (position > lastPosition) {
            //Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale);
            viewToAnimate.startAnimation(animationSet);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return cont.size();
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        ((RecyclerViewAdapter.ViewHolder)holder).clearAnimation();
    }

}
