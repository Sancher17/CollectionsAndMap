package com.example.alex.collectionsandmap.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

// TODO: 08.04.2018 Now it is doesn't work. I have to do it
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }
}
