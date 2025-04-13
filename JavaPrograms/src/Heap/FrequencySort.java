package Heap;

import java.util.*;

public class FrequencySort {

    static class Pair {
        int freq;
        int key;

        Pair(int freq, int key) {
            this.freq = freq;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 3, 3};
        int[] result = frequencySort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] frequencySort(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return b.freq - a.freq;
            }
            return a.key - b.key;
        });

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
        }

        List<Integer> resultList = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Pair currentPair = maxHeap.poll();
            int freq = currentPair.freq;
            int ele = currentPair.key;

            for (int i = 0; i < freq; i++) {
                resultList.add(ele);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
