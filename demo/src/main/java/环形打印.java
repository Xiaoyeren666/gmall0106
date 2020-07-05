import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huadaxia
 * @create 2020-07-04 22:10
 */
public class 环形打印 {

    public static List<Integer> print(int[][] matrix) {
        List<Integer> results = new ArrayList<>();

        // 读完后剩余的行数
        int remainingRows = matrix.length;
        // 读完后剩余的列数
        int remainingColumns = matrix[0].length;

        // 标记当前应从第几列开始读
        int startColumn = 0;
        // 标记当前应读到哪一列结束
        int endColumn;

        // 标记当前应从第几行开始读
        int startRow;
        // 标记当前应读到哪一行结束
        int endRow;

        // 标记当前的读到了第几列
        int curColumns = 0;
        // 标记当前的读到了第几行
        int curRows = 0;


        // 循环条件：当还有剩余的 列/行 没遍历
        while (remainingColumns > 0 || remainingRows > 0) {

            // 顺时针开始循环

            // 1.从左到右打印第一行
            if (remainingRows <= 0) return results;
            if (startColumn > 0) {
                startColumn = curColumns + 1;
            } else {
                startColumn = 0;
            }
            endColumn = startColumn + remainingColumns - 1;
            System.out.println("从" + startColumn + "列-" + endColumn + "列开始遍历");
            for (int i = startColumn; i <= endColumn; i++) {
                curColumns = i;
                results.add(matrix[curRows][i]);
            }
            // 读完一行-1
            remainingRows--;
            System.out.println("还剩" + remainingRows + "行，当前是第" + curColumns + "列");


            // 2.从上到下
            if (remainingColumns <= 0) return results;
            startRow = curRows + 1;
            endRow = startRow + remainingRows - 1;
            System.out.println("从" + startRow + "行-" + endRow + "行开始遍历");
            for (int i = startRow; i <= endRow; i++) {
                curRows = i;
                results.add(matrix[i][curColumns]);
            }
            remainingColumns--;
            System.out.println("还剩" + remainingColumns + "列");

            // 3. 从右到左
            if (remainingRows <= 0) return results;
            startColumn = curColumns - 1;
            endColumn = startColumn - remainingColumns + 1;
            System.out.println("从" + startColumn + "列-" + endColumn + "列开始遍历");
            for (int i = startColumn; i >= endColumn; i--) {
                curColumns = i;
                results.add(matrix[curRows][i]);
            }
            remainingRows--;
            System.out.println("还剩" + remainingRows + "行，当前是第" + curColumns + "列");


            // 4. 从下到上
            if (remainingColumns <= 0) return results;
            startRow = curRows - 1;
            endRow = startRow - remainingRows + 1;
            System.out.println("从" + startRow + "行-" + endRow + "行开始遍历");
            for (int i = startRow; i >= endRow; i--) {
                curRows = i;
                results.add(matrix[i][curColumns]);
            }
            remainingColumns--;
            System.out.println("还剩" + remainingColumns + "列");

        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> list = 环形打印.print(new int[10][10]);
        System.out.println(list);

    }
}
