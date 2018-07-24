package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int) Math.ceil(collection.size()/.75f)));

        collection.forEach((e) -> map.put(e, PRESENT));
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e))
            return false;
        
        map.put(e, PRESENT);

        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (!map.containsKey(o))
            return false;

        map.remove(o);

        return true;
    }

    @Override
    public Object clone() {
        AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }

        return copy;
    }

    private void writeObject(ObjectOutputStream oos) {
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        int size = size();

        try {
            oos.defaultWriteObject();
            oos.writeInt(capacity);
            oos.writeInt(size);
            oos.writeFloat(loadFactor);

            map.keySet().forEach((entry) -> {
                try {
                    oos.writeObject(entry);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream s) {
        try {
            s.defaultReadObject();
            int capacity = s.readInt();
            int size = s.readInt();
            float loadFactor = s.readFloat();
            map = new HashMap<>(capacity, loadFactor);

            for (int i = 0; i < size; i++) {
                @SuppressWarnings("unchecked")
                E e = (E) s.readObject();
                map.put(e, PRESENT);
            }
        } catch (Exception e) {

        }
    }
}
