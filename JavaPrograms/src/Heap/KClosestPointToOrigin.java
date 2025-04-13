package Heap;

import java.util.*;

public class KClosestPointToOrigin {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int squaredDistance() {
            return x * x + y * y;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = kClosest(points, k);

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> b.squaredDistance() - a.squaredDistance());

        for (int[] p : points) {
            Point point = new Point(p[0], p[1]);
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Point point = maxHeap.poll();
            result[i++] = new int[]{point.x, point.y};
        }

        return result;
    }
}
