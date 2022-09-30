//[List를 Set으로]
//(1)
//Set를 생성할 때 인자로 List를 전달하면 됩니다.
List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
Set<Integer> targetSet = new HashSet<>(sourceList);
//(2)
//Guava는 Lists, Sets라는 Util 클래스를 제공합니다. 이것을 이용하면 간단한 코드로 List를 생성하고 Set로 변환할 수 있습니다.
List<Integer> sourceList = Lists.newArrayList(0, 1, 2, 3, 4, 5);
Set<Integer> targetSet = Sets.newHashSet(sourceList);

//[Set를 List로 변환]
//(1)
//List를 생성할 때 인자로 Set를 전달하면 됩니다.
Set<Integer> sourceSet = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
List<Integer> targetList = new ArrayList<>(sourceSet);
//(2)
//Guava의 Lists, Sets를 이용하면 쉽게 생성 및 변환이 가능합니다.
Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
List<Integer> targetList = Lists.newArrayList(sourceSet);

//[Array를 Set로 변환]
//Stream을 이용하면 Array를 Set로 변환할 수 있습니다.
Integer[] array = {1, 2, 3};
Set<Integer> set = Arrays.stream(array).collect(Collectors.toSet()); // Set: [1, 2, 3]

//[Set를 Array로 변환]
//Set.toArray()를 이용하면 Set를 Array로 쉽게 변환할 수 있습니다..
Set<Integer> set = Sets.newHashSet(1, 2, 3);
Integer[] array = new Integer[set.size()];

set.toArray(array); // Array: [1, 2, 3]

//[Array를 List로 변환]
//Stream을 이용하면 Array를 List로 변환할 수 있습니다.
Integer[] array = {1, 2, 3};
List<Integer> list = Arrays.stream(array).collect(Collectors.toList());

//[List를 Array로 변환]
//List.toArray()를 이용하면 List를 Array로 쉽게 변환할 수 있습니다.
List<Integer> list = Arrays.asList(1, 2, 3);
Integer[] array = new Integer[list.size()];
list.toArray(array);
