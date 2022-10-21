Map<String, Integer> map = new HashMap<String, Integer>();
for (String str : list) {
  Integer count = map.get(str);
  if (count == null) {
    map.put(str, 1);
  }
  else {
    map.put(str, count + 1);
  }
}
