package com.proj.IMS.cache;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;

@Slf4j
public class LRUCache<K,T> {

    final int capacity;
    LinkedHashMap<K,T> map= new LinkedHashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
    }

    public T get(K key){
        T value = map.get(key);
        if (value != null) {
            map.remove(key);
            map.put(key, value);
            log.info("Cache at top "+ value);
            log.info("Cache updated data : "+ map);
            return value;
        }
        else{
            log.info("Data returned from DB and Cache state is : "+map);
        }
        return null;
    }

    public void put(K key, T obj){
        if(map.size()<capacity){
            map.put(key,obj);
            log.info("Cache entry added : " + map.get(key));
        }
        else{
            K oldestEntry = null;

            for(K ele : map.keySet()){
                oldestEntry = ele;
            }
            map.remove(oldestEntry);
            log.info("Removed the oldest entry : " + oldestEntry);
            map.put(key,obj);
            log.info("Cache : "+ map);
        }
    }
}
