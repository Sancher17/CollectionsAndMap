package com.example.alex.collectionsandmap.collections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionFragmentModule {


    @Singleton
    @Provides
    CollectionsContract.Presenter provideCollectionsPresenter(){
        return new CollectionsPresenter();
    }

    @Provides
    CollectionsAdapter provideCollectionsAdapter(){
        return new CollectionsAdapter();
    }
}
