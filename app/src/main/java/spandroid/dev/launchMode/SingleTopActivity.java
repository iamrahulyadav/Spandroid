package spandroid.dev.launchMode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spandroid.dev.R;

public class SingleTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
    }
}