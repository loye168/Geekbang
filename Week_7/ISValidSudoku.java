/**
@Descriptor 有效的数独
输入：
board = [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
@auth luoye
@Date 2021-5-23
**/
public class ISValidSudoku{
 // 时间复杂度：O(1)。 因为只对81个单元格进行了一次遍历
    // 空间复杂度: O(1)。 HashMap的空间也是常量的
    public boolean isValidSudoku(char[][] board) {
    
        // 3个Map数组 注意是Map数组
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] col = new HashMap[9];
        Map<Integer, Integer>[] box = new HashMap[9];

        // 初始化
        for(int i = 0; i < 9; i++){
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }
        // 从（0，0）坐标开始
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j]; // 因为输入的是char的二维数组，每个元素都是char
                // 只有数字需要被加入map中，空格不需要
                if(c != '.'){
                    int num = (int)c; // 把Char转成int,因为map是Integer
                    int box_index = (i / 3) * 3 + j / 3; // 求每个子数独的坐标（0-8）。 二维坐标转一位坐标：x * col + y.

                    row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                    col[j].put(num, col[j].getOrDefault(num, 0) + 1);
                    box[box_index].put(num, box[box_index].getOrDefault(num, 0) + 1);

                    // 数独的有效规则，每行，每列，每个子数独，不能存在重复的数字
                    if(row[i].get(num) > 1 || col[j].get(num)  > 1 || box[box_index].get(num) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}