package com.example.alex.collectionsandmap.dagger;

import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.collections.CollectionAdapterModule;
import com.example.alex.collectionsandmap.collections.CollectionFragmentModule;
import com.example.alex.collectionsandmap.collections.CollectionsContract;
import com.example.alex.collectionsandmap.collections.CollectionsFragment;
import com.example.alex.collectionsandmap.collections.CollectionsPresenter;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;

import dagger.Component;
import dagger.Provides;

/**
 * created on 02.04.2018
 */
@Component(modules = {
        CollectionFragmentModule.class,
        CollectionAdapterModule.class
})
public interface AppComponent {

//    CollectionsPresenter getCollectionsPresenter();//get method

    void inject(CollectionsFragment collectionsFragment);//inject method



}
