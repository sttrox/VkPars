package by.vandr.vkpars.ui.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import by.vandr.vkpars.R;

/**
 * Created by V on 09.11.2017.
 */

public class PageFragment extends Fragment {
    private int pageNum;

    public static PageFragment newInstance(int page){
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNum = getArguments() != null ? getArguments().getInt("num"):1;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_page,container,false);
        TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
        String header = String.format("Фрагмент %d", pageNum + 1);
        pageHeader.setText(header);

        return result;
    }

}
