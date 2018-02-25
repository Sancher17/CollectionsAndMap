package com.example.alex.collectionsandmap.model;

import java.util.Map;

public interface IMapProcessor {

    int add(Map<Integer, String> map);

    int search(Map<Integer, String> map);

    int remove(Map<Integer, String> map);
}


