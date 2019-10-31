package Traveling_is_fun;

import java.util.Arrays;

public class Traveling_is_fun {
	static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        int[] root = new int[n + 1];
        int[] ids = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            root[i] = i;
            ids[i] = 1;
        }

        for (int i = g + 1; i <= n; i++)
            for (int j = 2 * i; j <= n; j += i)
                unionFind(j, i, root, ids);

        int[] res = new int[originCities.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < originCities.length && j < destinationCities.length) {
            if (getRoot(originCities[i], root) == getRoot(destinationCities[j], root)) {
                res[k] = 1;
            } else {
                res[k] = 0;
            }
            i++;
            j++;
            k++;
        }

        return res;
    }

    private static void unionFind(int a, int b, int[] root, int[] ids) {
        int aRoot = getRoot(a, root);
        int bRoot = getRoot(b, root);

        if (aRoot == bRoot)
            return;

        if (ids[aRoot] < ids[bRoot]) {
            root[aRoot] = root[bRoot];
            ids[bRoot] += ids[aRoot];
        } else {
            root[bRoot] = root[aRoot];
            ids[aRoot] += ids[bRoot];
        }
    }

    private static int getRoot(int a, int[] root) {
        while (a != root[a])
            a = root[a];
        return a;
    }
    
    public static void main(String[] args) {
    	int[] originCities = {1, 4, 3, 6};
    	int[] destinationCities = {3, 6, 2, 5};
    	int[] res = connectedCities(6, 0, originCities, destinationCities);
    	System.out.println(Arrays.toString(res));
    }
}
