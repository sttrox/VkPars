package by.vandr.vkpars.ui.fragment;

/**
 * Created by V on 08.11.2017.
 */



import android.support.v4.app.Fragment;
        import android.content.Context;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import by.vandr.vkpars.R;

public class Fragment1 extends Fragment {

    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, null);
        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText("fgdfgdfgdfgdfg");
        layout.addView(textView);

        return layout;
    }
}
