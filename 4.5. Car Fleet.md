There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.

 
```
Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Example 2:

Input: target = 10, position = [3], speed = [3]

Output: 1

Explanation:

There is only one car, hence there is only one fleet.
Example 3:

Input: target = 100, position = [0,2,4], speed = [4,2,1]

Output: 1

Explanation:

The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 

Constraints:

n == position.length == speed.length
1 <= n <= 105
0 < target <= 106
0 <= position[i] < target
All the values of position are unique.
0 < speed[i] <= 106
```

Solution:
```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Intuition
        //A car can never pass another car a head of it
        //But if it catches up, it becomes part of the same fleet
        //It can catch the car a head of it when the time taken to reach the target is
        //less than or equal to the time taken by the car a head of it
        //so, we can compute the time taken by each car
        //we will sort the positions in descending order and so can compare
        //if the next car will be fleet or not

        //timeTaken = (target-position)/speed
        //eg:  target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        //                       car =  a  b c d e

        //Time      12       3     7        1      1
        //Speed     1        3     1        4      2
        //car graph c        e     d        b      a
        //------------------------------------------------------------------- 
        //position  0  1  2  3  4  5  6  7  8  9  10

        //cars: a,b will be one fleet and d,e will be one fleet and c will be one fleet

        //T:O(nlogn) for sorting, S:O(n)
        int n = position.length;
        if (n==0) return 0;

        //pair up position and time taken
        double[][] cars = new double[n][2];
        for (int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target-position[i])/speed[i];
        }

        //sort cars position in descending
        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int fleets = 0;
        double time = 0;

        for (int i=0; i<n; i++) {
            if (cars[i][1] > time) {
                fleets++;
                time = cars[i][1];
            }
        }

        return fleets;
    }
}
```
