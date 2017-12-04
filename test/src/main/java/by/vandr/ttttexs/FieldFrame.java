package by.vandr.ttttexs;

import android.app.Activity;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by V on 13.11.2017.
 */

public class FieldFrame {
    final int resourceId = R.drawable.chan;
    String program_time;
    String channel_name;
    String program_name;
    String program_description;

    public FieldFrame (String program_time,
            String channel_name,
            String program_name,
            String program_description
    )
    {
        this.program_time = program_time;
        this.channel_name = channel_name;
        this.program_name = program_name;
        this.program_description = program_description;
    }

}
