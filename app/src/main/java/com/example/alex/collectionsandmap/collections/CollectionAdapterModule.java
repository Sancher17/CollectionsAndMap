package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionAdapterModule {

    @Provides
    ArrayList provideArrayList(){
        return new ArrayList();
    }


    @Provides
    CollectionsAdapter provideCollectionsAdapter(ArrayList list){
        return new CollectionsAdapter(CollectionsData.list);
    }
}
