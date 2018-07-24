package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache lruCache = new LRUCache(6);
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object cachedValue = lruCache.find(id);

        if (cachedValue == null) {
            Object retrievedValue = originalRetriever.retrieve(id);
            lruCache.set(id, retrievedValue);
            return retrievedValue;
        }

        return cachedValue;
    }
}
