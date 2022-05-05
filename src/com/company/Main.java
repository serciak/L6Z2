package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Integer> createList(int k, int n) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            list.add(random.nextInt(0, k));

        list.set(random.nextInt(0, n), k);

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = createList(500, 1000000);

        CountingSort cs = new CountingSort();
        list = cs.sort(list);
        System.out.println("Przepisania: " + cs.getSwaps());
        System.out.println("Porownania: " + cs.getComparisons());
    }
}
