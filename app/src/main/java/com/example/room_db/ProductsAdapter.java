package com.example.room_db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class ProductsAdapter extends BaseAdapter {
    Context cntx;
    List<Product> products;

    public ProductsAdapter(Context cntx, List<Product> products){
        this.cntx = cntx;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = products.get(position);

        convertView = LayoutInflater.from(cntx).inflate(R.layout.product_item, parent, false);

        TextView id = convertView.findViewById(R.id._id);
        TextView name = convertView.findViewById(R.id.name);
        TextView author = convertView.findViewById(R.id.author);
        TextView price = convertView.findViewById(R.id.price);

        name.setText(product.name);
        author.setText(product.author);
        price.setText(String.valueOf(product.price));

        return convertView;
    }
}
