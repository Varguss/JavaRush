package com.javarush.task.task37.task3701;

import java.util.*;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
//
//        Iterator<Integer> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            System.out.println(integer);
//
//            if (integer.equals(2))
//                iterator.remove();
//
//            if (integer.equals(3))
//                break;
//        }
//
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        private int currentIndex = 0, expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return !Solution.this.isEmpty();
        }

        @Override
        public T next() {
            if (currentIndex == Solution.this.size())
                currentIndex = 0;

            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();

            return Solution.this.get(currentIndex++);
        }

        @Override
        public void remove() {
            Solution.this.remove(--currentIndex);

            expectedModCount++;
        }
    }
}
