package com.andrean.lazzlax.resepmasakanjav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detil extends AppCompatActivity {

    ImageView imgDetailAvatar;
    TextView txtDetailJudul,txtDetailDesc,txtDetailBahan,txtDetailCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        imgDetailAvatar = (ImageView)findViewById(R.id.img_detail_avatar);
        txtDetailJudul = (TextView)findViewById(R.id.txt_detail_judul);
        txtDetailDesc = (TextView)findViewById(R.id.txt_detail_desc);
        txtDetailBahan = (TextView)findViewById(R.id.txt_detail_bahan);
        txtDetailCara = (TextView)findViewById(R.id.txt_detail_cara);
        getData();
    }
    private void getData(){
        txtDetailJudul.setText(getIntent().getStringExtra("id_judul"));
        txtDetailDesc.setText(getIntent().getStringExtra("id_desc"));
        txtDetailCara.setText(getIntent().getStringExtra("id_cara"));
        txtDetailBahan.setText(getIntent().getStringExtra("id_bahan"));
        Glide.with(this)
                .load(getIntent().getIntExtra("id_img",0)).into(imgDetailAvatar);
    }
}
