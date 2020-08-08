// LC 48

package RotateMatrix;

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public class RotateMatrix {
	public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        
        // reverse up to down
        for(int col = 0; col < matrix[0].length; col++){
            int top = 0;
            int bottom = matrix.length-1;
            while(top < bottom){
                swap(matrix, top, col, bottom, col);
                top++;
                bottom--;
            }
        }
        
        // swap the symmetry
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++)
                swap(matrix, i, j, j ,i);
        }
    }
    
    public void swap(int[][] matrix, int a_i, int a_j, int b_i, int b_j){
        int tmp = matrix[a_i][a_j];
        matrix[a_i][a_j] = matrix[b_i][b_j];
        matrix[b_i][b_j] = tmp;
    }
}

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
// void anti_rotate(vector<vector<int> > &matrix) {
//     for (auto vi : matrix) reverse(vi.begin(), vi.end());
//     for (int i = 0; i < matrix.size(); ++i) {
//         for (int j = i + 1; j < matrix[i].size(); ++j)
//             swap(matrix[i][j], matrix[j][i]);
//     }
// }