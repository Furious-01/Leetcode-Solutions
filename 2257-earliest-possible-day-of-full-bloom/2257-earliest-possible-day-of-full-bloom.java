class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
    int n = plantTime.length;
    int[][] seeds = new int[n][2];
    for (int i = 0; i < n; i++) {
        seeds[i][0] = plantTime[i];
        seeds[i][1] = growTime[i];
        }
        Arrays.sort(seeds, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[1], a[1]);
        }
        });
    int currDay = 0;
    int maxBloom = 0;
    for (int i = 0; i < n; i++) {
        currDay += seeds[i][0];
        maxBloom = Math.max(maxBloom, currDay + seeds[i][1]);
    }

    return maxBloom;
    }
}
