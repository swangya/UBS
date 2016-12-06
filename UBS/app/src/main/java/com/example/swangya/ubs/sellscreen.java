package com.example.swangya.ubs;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;




public class sellscreen extends AppCompatActivity {
    Database DB;
    EditText name, price, desc, mail, num;
    ImageView imageView;
    private static int RESULT_LOAD_IMAGE = 1;
    String imgDecodable;
    Button btnregisterdata;
    byte[] pic;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_screen);

        DB = Database.getInstance(this.getApplicationContext());
        name = (EditText) findViewById(R.id.editText);
        price = (EditText) findViewById(R.id.editprice);
        desc = (EditText) findViewById(R.id.editdesc);
        mail = (EditText) findViewById(R.id.editmail);
        num = (EditText) findViewById(R.id.editphone);


        btnregisterdata = (Button) findViewById(R.id.button2);

        registerdata();
    }

    public void uploadPhoto(View view){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, RESULT_LOAD_IMAGE);
    }
    public void registerdata(){btnregisterdata.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    boolean isInserted = DB.insertMarket(name.getText().toString(), price.getText().toString(), desc.getText().toString(),
                            mail.getText().toString(), num.getText().toString(), pic);
                    if (isInserted == true)
                        Toast.makeText(sellscreen.this, "Item posted into Buypage List", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(sellscreen.this, "Conflict on Saving Data into System", Toast.LENGTH_LONG).show();

                }
            }
    );

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodable = cursor.getString(columnIndex);
                cursor.close();
                imageView = (ImageView) findViewById(R.id.imageView);
                // Set the Image in ImageView after decoding the String
                //imageView.setImageBitmap(BitmapFactory.decodeFile(imgDecodable));
                Bitmap bitmap=BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));
                imageView.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage)));
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
                pic=stream.toByteArray();

            }
            else {
                Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
