package visualizer;

public class Utils {
    
    public static int calculateTotalBoxesWidth(int boxesCount) {
        int boxesWidth = Config.boxSize * boxesCount;
        int paddingWidth = Config.padding * (boxesCount - 1);
        return boxesWidth + paddingWidth;
    }

}
