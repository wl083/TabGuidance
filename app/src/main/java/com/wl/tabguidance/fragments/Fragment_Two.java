package com.wl.tabguidance.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wl.tabguidance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wl on 2016/10/3.
 */
public class Fragment_Two extends Fragment{

    public static Fragment_Two fragment_two;
    private List<String> datas = new ArrayList<>();
    private RecyclerView mRecyclerView;

    public static Fragment_Two getInstance(int index){
//        if (fragment_two == null)
            fragment_two = new Fragment_Two();
        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment_two.setArguments(bundle);
        return fragment_two;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int getIndex = getArguments().getInt("index");
        initData(getIndex);
    }

    private void initData(int getIndex) {
        for (int i = 0; i < 50; i++) {
            datas.add("第-" + getIndex + "-页-" + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_two,null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyc_two);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MyAdapter());

        return view;

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView tv = new TextView(getContext());
            return new MyHolder(tv);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.textView.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size() == 0 ? 0 : datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public MyHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }
    }

}
