package visualizer;

public class BubbleSortAlgorithm extends Algorithm {
    
    public BubbleSortAlgorithm(int[] list) {
        super(list);
    }

    @Override
    public void doSortStep() {
        if (index+1 <= list.length-1) {
            if (list[index] > list[index+1]) {
                int n1 = list[index];
                int n2 = list[index+1];
                list[index] = n2;
                list[index+1] = n1;
                swaps = true;
            }
            selectedIndexes = new int[]{index, index+1};		
        }
        if (index == list.length-2 && !swaps) done = true;
        if (!done) {
            if (index == list.length-2) {
                index = 0;
                cycles++;
                swaps = false;
            } else {
                index++;
            }
        }
    }

}
