package com.company;

import java.util.ArrayList;

public class CountingSort {

    private int swaps;
    private int comparisons;

    public CountingSort() {
        swaps = 0;
        comparisons = 0;
    }

    private int max(ArrayList<Integer> list) {
        int max = list.get(0);

        for(int i : list) {
            if(max < i) {
                max = i;
            }
        }

        return max;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        swaps = 0;
        comparisons = 0;
        int n = list.size();
        int k = max(list)+1;
        System.out.println("n: " + n);
        System.out.println("k: " + (k-1));
        ArrayList<Integer> pos = new ArrayList<>(k);
        ArrayList<Integer> res = new ArrayList<>(n);
        int i,j;

        for(i = 0; i < k; i++)
            pos.add(0);

        for(i = 0; i < n; i++)
            res.add(0);

        for(j = 0; j < n; j++) {
            pos.set(list.get(j), pos.get(list.get(j)) + 1);
            swaps++;
        }

        pos.set(0, pos.get(0)-1);

        for(i = 1; i < k; i++) {
            pos.set(i, pos.get(i) + pos.get(i - 1));
            swaps++;
        }

        for(j = n-1; j >= 0; --j) {
            res.set(pos.get(list.get(j)), list.get(j));
            pos.set(list.get(j), pos.get(list.get(j))-1);
            swaps++;
        }

        return res;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }
}
