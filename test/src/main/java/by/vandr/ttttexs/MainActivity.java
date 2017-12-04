package by.vandr.ttttexs;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ListView framesContainer;

    ArrayList<FieldFrame> field = new ArrayList<FieldFrame>();
    PanelAdapter panelAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        framesContainer = (ListView) findViewById(R.id.frame);
        System.out.println("ggggg");
        fillData();
        panelAdapter = new PanelAdapter(this, field);

        System.out.println(panelAdapter.channelFrame);
        framesContainer.setAdapter(panelAdapter);
        System.out.println("kreate");
    }
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            field.add(new FieldFrame("time","Russia24","Vesty","Padenie s vershiny"));
        }
    }

}