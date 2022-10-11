import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> bubbleSort (ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        return dataList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        BubbleSort bSort = new BubbleSort();
        bSort.bubbleSort(testData);
        System.out.println(testData);
    }
}
