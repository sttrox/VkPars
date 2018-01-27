package by.vandr.vkpars.utils;

/**
 * Created by V on 05.12.2017.
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerSpacesItemDecoration extends RecyclerView.ItemDecoration
{
    private int space;

    public RecyclerSpacesItemDecoration(int space)
    {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        //добавить переданное кол-во пикселей отступа снизу
        outRect.bottom = space;
    }
}