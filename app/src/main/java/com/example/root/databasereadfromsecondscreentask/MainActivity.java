package com.example.root.databasereadfromsecondscreentask;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText name_etv;
    private EditText phone_etv;
    private MyOpenHelper mMyHelper;
    private SQLiteDatabase mDb;
    private ContentValues cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_etv=(EditText)findViewById(R.id.name_etv);
        phone_etv=(EditText)findViewById(R.id.phone_etv);

        mMyHelper=new MyOpenHelper(MainActivity.this,"empdb",null,1);
        mDb=mMyHelper.getWritableDatabase();

    }

    public void insert(View view)
    {
        cv=new ContentValues();
        cv.put("name",name_etv.getText().toString());
        cv.put("phone",phone_etv.getText().toString());
        long id=mDb.insert("employee",null,cv);
        Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
    }

    public void goNext(View view)
    {

        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }
}
