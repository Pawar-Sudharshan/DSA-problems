class Solution {
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1, ans);

        List<Integer> result = new ArrayList<>();

        for (int count : ans) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(Pair[] arr, int l, int r, int[] ans) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid, ans);
        mergeSort(arr, mid + 1, r, ans);

        merge(arr, l, mid, r, ans);
    }

    private void merge(Pair[] arr, int l, int mid, int r, int[] ans) {
        Pair[] temp = new Pair[r - l + 1];

        int p1 = l;
        int p2 = mid + 1;
        int idx = 0;

        // Number of smaller elements already taken from the right half
        int rightSmaller = 0;

        while (p1 <= mid && p2 <= r) {
            if (arr[p1].value <= arr[p2].value) {
                // All right elements already placed are smaller than arr[p1]
                ans[arr[p1].index] += rightSmaller;

                temp[idx++] = arr[p1++];
            } else {
                // arr[p2] is smaller than arr[p1]
                rightSmaller++;

                temp[idx++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            ans[arr[p1].index] += rightSmaller;
            temp[idx++] = arr[p1++];
        }

        while (p2 <= r) {
            temp[idx++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }
}