
public class RURottenTomatoes {
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[1]);
        int d = 2;
        int[][] arr = new int[row][column];

        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            for (int j = 0; j < Integer.parseInt(args[1]); j++) {
                arr[i][j] = Integer.parseInt(args[d]);
                d++ ;
            }
        }
    int sum = 0;
    int max = 0;
    int index = -2;

    for(int j = 0;j<Integer.parseInt(args[1]);j++){
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            sum += arr[i][j];
        }
        if (sum >= max) {
            if (sum == max) {
                if (j < index) {
                    index = j;
                }
            } else {
                max = sum;
                index = j;
            }
        }
        sum = 0;
    }System.out.print(index);

}
}
