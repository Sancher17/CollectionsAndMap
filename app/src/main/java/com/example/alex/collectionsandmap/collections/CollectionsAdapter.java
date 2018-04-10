package com.example.alex.collectionsandmap.collections;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.ViewHolder> {

    private static Logger LOGGER = new Logger(CollectionsAdapter.class);

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.action)
    TextView action;

    @BindView(R.id.count)
    TextView count;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    private ArrayList list;

    @Inject
    public CollectionsAdapter() {
        list = CollectionsData.list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @Override
    public CollectionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate
                (R.layout.card_captioned_image, parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CollectionsAdapter.ViewHolder holder, final int position) {

        CardView cardView = holder.cardView;
        ButterKnife.bind(this,cardView);

        name.setText(CollectionsData.list.get(position).getName());
        action.setText(CollectionsData.list.get(position).getAction());
        count.setText(String.valueOf(CollectionsData.list.get(position).getResultOfCalculation()));

        if (CollectionsData.list.get(position).getProgressBar()){
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }else {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return CollectionsData.list.size();
    }

}
