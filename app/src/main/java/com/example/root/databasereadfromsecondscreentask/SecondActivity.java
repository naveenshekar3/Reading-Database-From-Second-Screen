package com.example.root.databasereadfromsecondscreentask;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private TextView phone_tv,name_tv;
    private MyOpenHelper mMyHelper;
    private SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name_tv=(TextView)findViewById(R.id.name_tv);
        phone_tv=(TextView)findViewById(R.id.phone_tv);

        mMyHelper=new MyOpenHelper(SecondActivity.this,"empdb",null,1);
        mdb=mMyHelper.getWritableDatabase();

    }

    public void first(View view) {
        Cursor c=mdb.query("employee",null,null,null,null,null,null,null);
        c.moveToFirst();
        name_tv.setText(c.getString(1));
        phone_tv.setText(c.getString(2));
    }

    public void next(View view) {
        Cursor c=mdb.query("employee",null,null,null,null,null,null,null);
            c.moveToNext();
            name_tv.setText(c.getString(1));
            phone_tv.setText(c.getString(2));

    }

    public void previous(View view)
    {
        Cursor c=mdb.query("employee",null,null,null,null,null,null,null);
            c.moveToPrevious();
            name_tv.setText(c.getString(1));
            phone_tv.setText(c.getString(2));

    }

    public void last(View view)
    {
        Cursor c=mdb.query("employee",null,null,null,null,null,null,null);
        c.moveToLast();
        name_tv.setText(c.getString(1));
        phone_tv.setText(c.getString(2));
    }
}
