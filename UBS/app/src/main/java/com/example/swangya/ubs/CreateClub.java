package com.example.swangya.ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateClub extends AppCompatActivity {


    DBHelper myDb;
    EditText editCname,editAdmin,editFunc,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);

        //create new database connection
        myDb = DBHelper.getInstance(this.getApplicationContext());

        editCname = (EditText)findViewById(R.id.select);
        editAdmin = (EditText)findViewById(R.id.admin);
        editTextId = (EditText)findViewById(R.id.id);
        editFunc = (EditText)findViewById(R.id.func);

        btnAddData = (Button)findViewById(R.id.send10);
        btnviewAll = (Button)findViewById(R.id.send111);
        btnDelete= (Button)findViewById(R.id.btnDelete);
        AddData();
        viewAll();
        DeleteData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertClubData(editCname.getText().toString(),
                                editAdmin.getText().toString(),
                                editFunc.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(CreateClub.this,"Request Send !",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CreateClub.this,"No Request",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteClubData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(CreateClub.this,"Club Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CreateClub.this,"Please Enter Valid Club ID",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getClubAllData();
                        if(res.getCount() == 0) {

                            showMessage("Alert","No Request Found!");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Data Base ID:" + res.getString(0) + "\n" + "Status: Pending" + "\n");
                            buffer.append("CLUB Name :" + res.getString(1) + "\n");
                            buffer.append("CLUB Introduction(S) :" + res.getString(3) + "\n\n");
                        }

                        res.close();
                        showMessage("Request List",buffer.toString());
                    }
                }
        );
    }





    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
