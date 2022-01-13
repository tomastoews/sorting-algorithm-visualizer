package visualizer;

public class Algorithm {

    protected int[] list;
    protected int index;
	protected int[] selectedIndexes;
    protected int cycles;
	protected boolean swaps;
	protected boolean done;

    public Algorithm(int[] list) {
        this.list = list;
		this.selectedIndexes = new int[]{0, 1};
		this.index = 0;
		this.cycles = 0;
		this.swaps = false;
        this.done = false;
	}

	public boolean isDone() {
		return done;
	}

    public int[] getList() {
        return list;
    }

    public int[] getSelectedIndexes() {
        return selectedIndexes;
    }

    public int getCycles() {
        return cycles;
    }

	public void doSortStep() {

	};

	public void doSortCycle() {
		while (!isDone()) {
			doSortStep();
		}
	}

	public String toString() {
		String listString = "List: ";
		for (int n : list) {
			listString += String.valueOf(n).concat(" ");
		}
		return listString;
	}

}
