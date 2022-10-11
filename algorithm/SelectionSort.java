import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> selectionSort (ArrayList<Integer> dataList) {
        int temp;
        for (int i = 0; i < dataList.size() - 1; i++) {
            temp = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(temp) > dataList.get(j)) {
                    temp = j;
                }
            }
            Collections.swap(dataList, temp, i);
        }
        return dataList;
    }
    public static void main (String[] args){
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            testList.add((int)(Math.random()*100));
        }
        SelectionSort sSort = new SelectionSort();
        sSort.selectionSort(testList);
        System.out.println(testList);
    }
}
