class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }
        return result;
    }
}