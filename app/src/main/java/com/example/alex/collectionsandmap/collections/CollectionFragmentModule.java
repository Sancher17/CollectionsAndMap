package com.example.alex.collectionsandmap.collections;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionFragmentModule {

    @Provides
    CollectionsContract.View provideView(){
        return new CollectionsFragment();
    }

    @Provides
    CollectionsPresenter provideCollectionsPresenter(CollectionsContract.View view){
        return new CollectionsPresenter(view);
    }
}
