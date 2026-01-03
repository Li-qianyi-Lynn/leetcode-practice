    public List<List<Integer>> threeSum(int[] array) {
        Arrays.sort(array);
        Set<List<Integer>> triplets = new HashSet<>();
        for (int left = 0; left < array.length - 2; left++) {
            int mid = left + 1;
            int right = array.length - 1;
            while (mid < right) {
                int sum = array[left] + array[mid] + array[right];
                if (sum < 0) {
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> triplet = Arrays.asList(array[left], array[mid], array[right]);
                    triplets.add(triplet);
                    mid++;
                }
            }
        }
        return new ArrayList<>(triplets);
    }