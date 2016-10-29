package com.demo.chenpf.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.chenpf.activity.R;
import com.demo.chenpf.customview.UpFilpView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabOneFragment extends Fragment {
    private UpFilpView mUpFilpView;

    List<String> data = new ArrayList<String>();
    List<View> views = new ArrayList<>();


    public TabOneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_one, container, false);
        mUpFilpView = (UpFilpView) view.findViewById(R.id.upfilpview);
        // Add Data
        addData();
        //
        for (int i = 0; i < data.size(); i++) {
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.filp_item_view, null);
            TextView textView = (TextView) moreView.findViewById(R.id.filp_text);

            SpannableString spannableString = new SpannableString(data.get(i));
            spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,data.get(i).split(":")[0].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new UnderlineSpan(),0,data.get(i).split(":")[0].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            textView.setText(spannableString);

            views.add(moreView);
        }
        mUpFilpView.setViews(views);
        return view;
    }

    private void addData() {
        data.add("ViewFilper:Animate between views that have been added.Can automatically flip.");
        data.add("ViewPager:Layout manager that allows the user to flip left and right through pages of data.Should implementation of PagerAdapter.");
        data.add("SpannableString:This is the class for text whose content is immutable but to which markup objects can be attached and detached.");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
