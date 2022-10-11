import java.util.Collections;
import java.util.ArrayList;
public class InsertionSort {
    public ArrayList<Integer> insertionSort (ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (dataList.get(j) < dataList.get(j - 1)) {
                    Collections.swap(dataList, j, j -1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add((int)(Math.random()*100));
        }
        InsertionSort iSort = new InsertionSort();
        System.out.println(iSort.insertionSort(testList));
    }
}
