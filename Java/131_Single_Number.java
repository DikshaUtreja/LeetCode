/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

//METHOD 1

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) result ^= num;
        return result;
    }
}

/* We will do xor all the nums to each other. Xor of num and 0 is num and xor of num & num is 0.
Complexity: O(n)
*/

//METHOD 2

class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
	for(int num : nums) {
	   if(list.contains(num)) list.remove(num);
	   else list.add(num);
	}
	return list.get(0);
    }
}

/* Iterate over all the numbers and check weather number is present in list or not. If present then remove that number form the list and if not present then add it into the list.
*/

//We can do using Set or Hashmap(Store count wrt each number)