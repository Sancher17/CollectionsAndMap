package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.dataCollections.CollectionsRepository;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.model.ICollectionsProcessor;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionPresenterModule {

    @Provides
    ICollectionsProcessor collectionsProcessor(){
        return new CollectionsProcessor();
    }

    @Provides
    CollectionsRepository repository(){
        return new CollectionsData();
    }
}
