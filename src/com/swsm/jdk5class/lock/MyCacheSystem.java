package com.swsm.jdk5class.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class MyCacheSystem {

    // 自己写的一个缓存系统
    private Map<String, Object> caChe = new HashMap<>();
    private ReadWriteLock wrl = new ReentrantReadWriteLock();

    public Object getDate(String key) {
        wrl.readLock().lock();
        Object value = null;
        try {
            value = caChe.get(key);
            if (value == null) {
                wrl.readLock().unlock();
                wrl.writeLock().lock();
                try {
                    if (caChe.get(key) == null) {
                        value = "aaa";
                    }
                } finally {
                    wrl.writeLock().unlock();
                }
                wrl.readLock().lock();
            }
        } finally {
            wrl.readLock().unlock();
        }

        return value;
    }
    
}
