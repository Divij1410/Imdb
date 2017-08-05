package com.example.admin.imdbreturns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ADMIN on 27-Jul-17.
 */
public class MyAdapter extends ArrayAdapter<Moviedata> {
    ArrayList<Moviedata> popularlist;
    Context context;
    public MyAdapter(@NonNull Context context, ArrayList<Moviedata> popularlist ) {
        super(context, 0);
        this.context=context;
        this.popularlist=popularlist;
    }


    @Override
    public int getCount() {
        return popularlist.size();
    }

    static class ExpenseViewHolder{
        TextView title;
        TextView language;
        TextView rating;
        ImageView imageView;
        ExpenseViewHolder(ImageView imageView,TextView title,TextView language,TextView rating){
            this.title=title;
            this.language=language;
            this.rating=rating;
            this.imageView=imageView;
        }

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
            TextView title=(TextView)convertView.findViewById(R.id.title);
            TextView language=(TextView)convertView.findViewById(R.id.language);
            TextView rating=(TextView)convertView.findViewById(R.id.rating);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView) ;
            ExpenseViewHolder expenseViewholder=new ExpenseViewHolder(imageView,title,language,rating);
            convertView.setTag(expenseViewholder);
        }
        Moviedata e=popularlist.get(position);
        ExpenseViewHolder expenseViewholder=(ExpenseViewHolder) convertView.getTag();
        //we can make button here and call expenseViewholder.button.setonclicklistener
        expenseViewholder.title.setText(e.title);
        expenseViewholder.language.setText(e.original_language);
        expenseViewholder.rating.setText(Double.toString(e.vote_average));
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300/"+e.poster_path).into(expenseViewholder.imageView);
        return convertView;
    }}