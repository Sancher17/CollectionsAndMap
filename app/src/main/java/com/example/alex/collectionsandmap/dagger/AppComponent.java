package com.example.alex.collectionsandmap.dagger;

import com.example.alex.collectionsandmap.collections.CollectionFragmentModule;
import com.example.alex.collectionsandmap.collections.CollectionsFragment;
import com.example.alex.collectionsandmap.collections.CollectionsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * created on 02.04.2018
 */
@Component(modules = {
        CollectionFragmentModule.class,
})
@Singleton
public interface AppComponent {

    void inject(CollectionsFragment collectionsFragment);
}

