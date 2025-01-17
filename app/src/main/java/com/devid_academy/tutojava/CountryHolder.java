package com.devid_academy.tutojava;

import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.devid_academy.tutojava.R;

import org.w3c.dom.Text;

public class CountryHolder extends RecyclerView.ViewHolder {

    public TextView tvItem;
    public ImageView ivItem;
    public View itemLayout;
    public CountryHolder(@NonNull View itemView) {
        super(itemView);

        tvItem = itemView.findViewById(R.id.tv_item_country);
        ivItem = itemView.findViewById(R.id.iv_item_rv_country);
        itemLayout = itemView.findViewById(R.id.cl_item_rv_country);

    }


}
