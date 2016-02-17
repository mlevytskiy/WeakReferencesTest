package mlevytskiy.com.weakreferencestest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<WeakReference<Activity>> list = new ArrayList<>();
        list.add(new WeakReference<Activity>(this));
        list.remove(new WeakReference<Activity>(this));
        Toast.makeText(this, "default weak reference behavior list size = " + list.size(), Toast.LENGTH_LONG).show();
        list.clear();

        list.add(new CustomWeakReference<Activity>(this));
        list.remove(new CustomWeakReference<Activity>(this));
        Toast.makeText(this, "custom weak reference behavior list size = " + list.size(), Toast.LENGTH_LONG).show();
    }
}
