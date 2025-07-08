Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //optimised
        //T:O(N) , S:O(N)
        //i/p: [2,3,1,2,4,1,1]
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        //o/p: {1=3,
        //      2=2,
        //      3=1,
        //      4=1}

        //define 2D fixed size list this way, the length should be length+1
        //because we have freqMap with freq's with least val 1
        //and we use this freq's values as keys for 2D list and store the keys
        //eg:       [ [3,4],[2],[1]]
        //index:     0, 1  , 2,  3
        //ie in each bucket we store the actual keys and indexes represents count
        List<Integer>[] buckets = new List[nums.length +1];
       //here we used new List[num] instead of new int[num] because
     //new int[5] : [0,0,0,0,0] initializes array with single elements only
     //new List[5] : [null,null,null,null,null] initializes array with null so we can store list of numbers at each place
        for (int key : freqMap.keySet()) {    //{1,2,3,4} //key set
            int frequency = freqMap.get(key); //gives value ie for key value is 3
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
             }
             buckets[frequency].add(key);
        }

        int[] topK = new int[k];
        int index = 0;
        for (int i = buckets.length-1; i >= 0 && index <k ; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    topK[index++] = num;
                    if (index == k) {
                        break;
                    }
                 //lets say answer is not unique like in the eg we have taken, in that case index increases and becomes greater than k in inner loop and then out of bounds exception can occur
                }
            }
        }
        return topK;
        
        // //T:O(nlogn), S:O(n)
        // //eg:[2,1,3,1,2,1]
        // //store the frequencies in the map
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        //{2=2, 3=1, 1=3}, we will get this entries which gives us set
        //freqMap.entrySet() => 
        //(2=2, 3=1, 1=3), we convert this set to List to we can sort the elements
        //entries => [[2,2], [3,1], [1,3]]
        List<Map.Entry<Integer,Integer>> entries
                         = new ArrayList<>(freqMap.entrySet());
        //sort in descending order
        entries.sort((a,b) -> b.getValue().compareTo(a.getValue()));
        //o/p: [[1,3], [2,2], [3,1]]

        //now get the top k key and return them
        int[] topK = new int[k];
        for (int i=0; i<k; i++) {
            topK[i] = entries.get(i).getKey();
        }
        return topK;
    }
}
