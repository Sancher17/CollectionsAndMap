package com.example.alex.collectionsandmap.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.model.MapsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.ViewHolder>{

    private static Logger LOGGER = new Logger(CollectionsAdapter.class);

    //данные передаются адаптеру через конструктор
    public MapsAdapter(List<MapsData> list) {
    }

    MapsData collections = new MapsData();

    public MapsAdapter() {
    }


    //Предоставляет ссылку на представления, используемые в RecyclerView
    //При создании адаптера для RecyclerView необходимо создать ViewHolder внутри адаптера.
    // Для этого вы расширяете класс RecyclerView.ViewHolder и указываете, данные какого типа он должен содержать.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //сообщает с какими данными должен работать адаптер
        //Каждый вариант в RecyclerView представляет собой карточку; следовательно,
        // класс ViewHolder должен содержать CardView:
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    //Чтобы компонент RecyclerView мог определить, сколько объектов ViewHolder ему потребуется, ему
    // необходимо сообщить, какой макет должен использоваться для каждой ячейки, — эта информация
    // передается в методе onCreateViewHolder() адаптера.
    @Override
    public MapsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        //Создание нового представления
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate
                (R.layout.card_captioned_image, parent, false);
        return new MapsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(MapsAdapter.ViewHolder holder, final int position) {
        //Заполнение заданного представления данными
        CardView cardView = holder.cardView;

        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(MapsData.list.get(position).getName());

        TextView textView3 = cardView.findViewById(R.id.action);
        textView3.setText(MapsData.list.get(position).getAction());

        TextView textView2 = cardView.findViewById(R.id.count);
        textView2.setText(String.valueOf(MapsData.list.get(position).getResultOfCalculation()));

        ProgressBar progressBar = cardView.findViewById(R.id.progress);
        if (MapsData.list.get(position).getFlag() == 1){
            progressBar.setVisibility(ProgressBar.INVISIBLE);
        }else {
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        //Возвращает количество вариантов в наборе данных
        return MapsData.list.size();//длинна массива равна количеству элементов в RecyclerView
    }
}
