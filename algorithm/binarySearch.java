import java.util.ArrayList;
import java.util.Collections; //이진탐색을 사용하려면 정렬이 되어 있어야 함.

public class BinarySearch {
    public boolean binarySearch (ArrayList<Integer> dataList, int searchData) {
        if (dataList.size() == 1 && dataList.get(0) == searchData) {
            return true;
        }
        if (dataList.size() == 1 && dataList.get(0) != searchData) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }
        int medium = dataList.size()/2;

        if (searchData == dataList.get(medium)) {
            return true;
        }
        else {
            if (searchData < dataList.get(medium)) {
                return this.binarySearch(new ArrayList<Integer>(dataList.subList(0, medium)), searchData);
            } else {
                return this.binarySearch(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchData);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testList.add((int)(Math.random())*100);
        }
        int searchItem = 55;
        BinarySearch sd = new BinarySearch();
        System.out.println(sd.binarySearch(testList, searchItem));
    }
}
