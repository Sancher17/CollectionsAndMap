package com.example.alex.collectionsandmap.dagger;

import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;

import dagger.Component;

/**
 * created on 02.04.2018
 */
@Component
public interface AppComponent {

    ExecutorCollection getExecutorCollection();

//    void inject(CollectionsPresenter collectionsPresenter);
}
