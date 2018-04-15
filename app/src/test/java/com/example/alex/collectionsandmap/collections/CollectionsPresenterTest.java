package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollectionCallback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CollectionsPresenterTest {

    @Mock
    private CollectionsContract.View view;

    @Mock
    private CollectionsRepository repository;

    @Mock
    private ExecutorCollection executor;

    private CollectionsPresenter presenter;

    ExecutorCollectionCallback callback;

    @Before
    void setupPresenter() {

        executor = new ExecutorCollection(callback);
        presenter = new CollectionsPresenter();
    }


    @Test
    public void calculate() throws Exception {
    }

    @Test
    public void updateAdapterItem() throws Exception {
    }

    @Test
    public void responseShowProgress() throws Exception {

        callback.responseShowProgress(0);

        verify(view).showProgressBar(0);

    }

    @Test
    public void responseHideProgress() throws Exception {
    }

    @Test
    public void createData() throws Exception {
    }

}