```java
//[오름차순]
HashMap<Integer, Double>Map = new HashMahp<>();

List<Integer> list = new ArrayList<>(map.keySet());
Collections.sort(list, (o1, o2) -> Double.compare(map.get(o1), map.get(o2)));

//[내림차순]
HashMap<Integer, Double> map = new HashMap<>();

List<Integer> list = new ArrayList<>(map.keySet());
Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
```