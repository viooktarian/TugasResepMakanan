package com.andrean.lazzlax.resepmasakanjav;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Dimas on 10/12/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    Context context;
    List<PolaItem> items;

    public RecyclerAdapter(Context context, List<PolaItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        Glide.with(context)
                .load((items.get(position)).getImg()).into(holder.imgAvatar);

        holder.txtJudul.setText(items.get(position).getJudul());
        holder.txtDesc.setText(items.get(position).getDesc());

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),Detil.class);
                i.putExtra("id_judul",items.get(position).getJudul());
                i.putExtra("id_desc",items.get(position).getDesc());
                i.putExtra("id_bahan",items.get(position).getBahan());
                i.putExtra("id_cara",items.get(position).getCara());
                i.putExtra("id_img",items.get(position).getImg());
                v.getContext().startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        CardView cardItem;
        ImageView imgAvatar;
        TextView txtJudul,txtDesc;
        public Holder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView)itemView.findViewById(R.id.avatar);
            txtJudul = (TextView)itemView.findViewById(R.id.txt_judul);
            txtDesc = (TextView)itemView.findViewById(R.id.txt_desc);
            cardItem = (CardView)itemView.findViewById(R.id.card_item);
        }
    }
}
