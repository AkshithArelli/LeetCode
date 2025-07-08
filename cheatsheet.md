cheat sheet:
str.substring(i,j) ✔️
str.subString(i,j) ❌

return new ArrayList<>(map.values());

map1.equals(map2)

Integer.parseInt(string);

Map<Integer,Integer> freqMap = new HashMap<>();

for(int num: nums) {
    freqMap.put(num, freqMap.getOrDefault(num,0)+1);
}

List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(freqMap.entrySet());

entries.get(i).getKey();
