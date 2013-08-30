public class Solution {
    public ArrayList<Integer> spiralOrder (int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int m = matrix.length;
        if (m <= 0) {
            return res;
        }
        int n = matrix[0].length;
        
        int west = 0;
        int east = n;
        int north = 0;
        int south = m;

        int direction = 0;

        int row = 0;
        int col = -1;
        
        while (west != east && north != south) {
            switch (direction) {
                case 0:
                for (int i = west; i < east; i++) {
                    res.add(matrix[row][i]);
                }
                north++;
                col = east - 1;
                direction = 1;
                break;
                case 1:
                for (int i = north; i < south; i++) {
                    res.add(matrix[i][col]);
                }
                east--;
                row = south - 1;
                direction = 2;
                break;
                case 2:
                for (int i = east - 1; i >= west; i--) {
                    res.add(matrix[row][i]);
                }
                south--;
                col = west;
                direction = 4;
                break;
                case 4:
                for (int i = south - 1; i >= north; i--) {
                    res.add(matrix[i][col]);
                }
                west++;
                row = north;
                direction = 0;
                break;
                default:
                break;
            }
        }
        return res;
    }
}