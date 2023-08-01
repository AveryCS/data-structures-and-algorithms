package com.practice.miscellaneous;
import java.util.*;
/**Problem statement:
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 Note:
 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.

 Example 1:
 Input: board =
 [["5","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 Output: true
 Example 2:
 Input: board =
 [["8","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


 Constraints:

 board.length == 9
 board[i].length == 9
 board[i][j] is a digit 1-9 or '.'.

 Leetcode link: https://leetcode.com/problems/valid-sudoku/description/
 **/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Coordinates coord = new Coordinates(0, 0);

        //check rows
        boolean rowsAreValid = allRowsAreValid(board,   coord );

        //check columns
        boolean colsAreValid = allColumnsAreValid(board,  coord );

        //check boxes
        List<List<Character>> cubesList = createCubesList(board, coord);

        boolean cubesAreValid = allCubesAreValid(cubesList, coord);

        return rowsAreValid && colsAreValid && cubesAreValid;
    }

    public static boolean allCubesAreValid(List < List < Character >> cubesList,  Coordinates coord ) {

        for (List < Character > singleCubeList: cubesList) {
            Set < Character > set = new HashSet < > ();
            for (Character c: singleCubeList) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static List < List < Character >> createCubesList(char[][] board,  Coordinates coord ) {
        List < List < Character >> result = new ArrayList < > ();
        int width = board[0].length;
        int height = board.length;

        //get the top

        while (coord.wall <= width) {

            List < Character > singleCubeList = addElementsForCube(board, coord);
            result.add(singleCubeList);
            coord.goRight();
        }

        //get the middle
        coord.resetCoordinatesToZero();
        coord.goDown();

        while (coord.wall <= width) {
            List < Character > singleCubeList = addElementsForCube(board, coord);
            result.add(singleCubeList);
            coord.goRight();
        }

        //get the end
        coord.resetCoordinatesToZero();
        coord.goDown();
        coord.goDown();
        while (coord.wall <= width) {
            List < Character > singleCubeList = addElementsForCube(board, coord);
            result.add(singleCubeList);
            coord.goRight();
        }
        return result;
    }

    public static List < Character > addElementsForCube(char[][] board, Coordinates coord) {

        List < Character > result = new ArrayList < > ();

        for (int row = coord.floor - 3; row < coord.floor; row++) {
            for (int col = coord.wall - 3; col < coord.wall; col++) {
                char current = board[row][col];
                if (Character.isDigit(current)) {
                    result.add(current);
                }
            }
        }

        return result;

    }
    public static boolean allColumnsAreValid(char[][] board,  Coordinates coord ) {
        int height = board.length;
        int width = board[0].length;
        for (int col = 0; col < width; col++) {
            Set < Character > set = new HashSet < > ();
            for (int row = 0; row < height; row++) {

                char number = board[row][col];
                if (Character.isDigit(number)) {
                    if (!set.add(number)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean allRowsAreValid(char[][] board,  Coordinates coord ) {

        for (char[] singleRow: board) {
            Set < Character > set = new HashSet < > ();
            for (char number: singleRow) {
                if (Character.isDigit(number)) {
                    if (!set.add(number)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
class Coordinates {
    int row;
    int col;
    int wall;
    int floor;

    Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
        this.wall = col + 3;
        this.floor = row + 3;
    }

    public void goRight() {
        col += 3;
        wall += 3;
    }

    public void resetCoordinatesToZero() {
        row = 0;
        col = 0;
        wall = col + 3;
        floor = row + 3;
    }

    public void goDown() {
        row += 3;
        floor += 3;
    }
}
