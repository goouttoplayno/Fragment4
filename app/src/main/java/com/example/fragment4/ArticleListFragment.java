package com.example.fragment4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.AndroidException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArticleListFragment extends ListFragment {
    private ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        String s = adapter.getItem(position);
//        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        DetailFragment detailFragment = new DetailFragment();

        transaction.replace(R.id.right, detailFragment, "detailFragment");

        String item = adapter.getItem(position);
        Bundle args = new Bundle();
        args.putString("item", item);
        detailFragment.setArguments(args);

        transaction.commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 30; i++){
            data.add("smyh" + i);
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
