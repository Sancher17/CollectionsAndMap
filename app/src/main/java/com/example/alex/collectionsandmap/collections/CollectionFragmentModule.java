package com.example.alex.collectionsandmap.collections;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionFragmentModule {


    @Provides
    CollectionsContract.Presenter provideCollectionsPresenter(){
        return CollectionsPresenter.getInstance();
    }

    @Provides
    CollectionsAdapter provideCollectionsAdapter(){
        return new CollectionsAdapter();
    }
}
