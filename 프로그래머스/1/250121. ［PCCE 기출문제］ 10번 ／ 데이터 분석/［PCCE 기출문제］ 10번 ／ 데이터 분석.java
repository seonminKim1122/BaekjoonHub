import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int idx = indexOfSortColumn(sort_by);
        Object[] arr = Arrays.stream(data)
            .filter(row -> isValid(row, ext, val_ext))
            .sorted((o1, o2) -> o1[idx] - o2[idx])
            .toArray();
        
        int H = arr.length;
        int W = data[0].length;
        
        int[][] answer = new int[H][W];
        for (int i = 0; i < H; i++) {
            if (arr[i] instanceof int[]) {
                int[] temp = (int[]) arr[i];
                for (int j = 0; j < W; j++) {
                    answer[i][j] = temp[j];
                }
            }
        }
        
        return answer;
    }
    
    int indexOfSortColumn(String sort_by) {
        switch (sort_by) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            default:
                return 3;
        }
    }
    
    boolean isValid(int[] data, String ext, int val_ext) {
        switch (ext) {
            case "code":
                return data[0] < val_ext;
            case "date":
                return data[1] < val_ext;
            case "maximum":
                return data[2] < val_ext;
            default:
                return data[3] < val_ext;
        }
    }
}