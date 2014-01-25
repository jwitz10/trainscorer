package com.jwitz.trainscorer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReviewActivity extends Activity {;
    
//    static final String[] numbers = new String[] { 
//            "A", "B", "C", "D", "E",
//            "F", "G", "H", "I", "J",
//            "K", "L", "M", "N", "O",
//            "P", "Q", "R", "S", "T",
//            "U", "V", "W", "X", "Y", "Z"};
//    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        
//        GridView gridView = (GridView) findViewById(R.id.gridView1);
//        
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, numbers);
// 
//        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.review, menu);
        return true;
    }

}
