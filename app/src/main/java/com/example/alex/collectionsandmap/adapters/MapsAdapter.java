package com.example.alex.collectionsandmap.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.model.repository.MapsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.ViewHolder>{

    private static Logger LOGGER = new Logger(MapsAdapter.class);

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.action)
    TextView action;

    @BindView(R.id.count)
    TextView count;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    public MapsAdapter(List<MapsData> list) {
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @Override
    public MapsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate
                (R.layout.card_captioned_image, parent, false);
        return new MapsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(MapsAdapter.ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ButterKnife.bind(this,cardView);

        name.setText(MapsData.list.get(position).getName());
        action.setText(MapsData.list.get(position).getAction());
        count.setText(String.valueOf(MapsData.list.get(position).getResultOfCalculation()));

        if (MapsData.list.get(position).getProgressBar()){
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }else {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return MapsData.list.size();
    }
}
