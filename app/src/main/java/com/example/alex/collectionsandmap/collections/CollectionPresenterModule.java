package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.dataCollections.CollectionsRepository;
import com.example.alex.collectionsandmap.dataCollections.CollectionsProcessor;
import com.example.alex.collectionsandmap.dataCollections.ICollectionsProcessor;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionPresenterModule {


    @Provides
    CollectionsRepository repository(){
        return new CollectionsData();
    }

    @Provides
    CollectionsContract.View provideView(){
        return new CollectionsFragment();
    }


}
