package visualizer;

class SortAlgorithmVisualizer {

    private static Window window;
    private static int[] list;

    private static void draw() {
        window.updateList(list);
        window.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        list = new int[]{1,5,8,10,3,17,0};

        BubbleSortAlgorithm bubbleSort = new BubbleSortAlgorithm(list);
        window = new Window(list);
        window.setSelectionIndexes(bubbleSort.getSelectedIndexes());

        while(!bubbleSort.isDone()) {
            window.setSelectionIndexes(bubbleSort.getSelectedIndexes());
            draw();
            bubbleSort.doSortStep();
            window.updateList(bubbleSort.getList());
            Thread.sleep(500);
        }
        window.selectAllItems();
        System.out.println("Cycles needed: " + bubbleSort.getCycles());
    }

}
