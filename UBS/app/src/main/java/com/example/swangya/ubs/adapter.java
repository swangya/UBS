package com.example.swangya.ubs;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class adapter extends BaseAdapter {
    private Context context;
    ArrayList<Item> items;
    private static LayoutInflater inflater;

    public adapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null)
            view = inflater.inflate(R.layout.grid, null);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView price = (TextView) view.findViewById(R.id.price);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView email=(TextView) view.findViewById(R.id.email);

        Item e = new Item();
        e = items.get(i);
        image.setImageBitmap(getImage(e.getPhoto()));
        name.setText("Item: " + e.getItemname());
        price.setText("Price: " + e.getPrice());
        description.setText("Details: " + e.getDesc());
        email.setText("Email: "+e.getMail());
        return view;}

    public static Bitmap getImage(byte[] image){
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
