package com.example.admin.a2d_puzzle;

public class Random_function {

    public static boolean equals(int a, int[][] arr, int N,int M, int ia, int ja){
        for (int i = 0; i < N; ++i){
            for (int j = 0; j < M; ++j){
                if (!(ia == i && ja == j)){
                    if (a == arr[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[][] randomArr(int N, int M, int rand) {

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = -1;
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; j++){
                arr[i][j] = (int)(Math.random()*rand);
                if (equals(arr[i][j],arr,N,M, i, j)){
                    if (j == 0) {
                        --i;
                        j = M - 1;
                    }
                    else
                        --j;
                }
            }
        }
        return arr;
    }



    public static boolean equals_dobl(int[] arr1,int[] arr2, int N, int ia){
        for (int i = 0; i < N; ++i)
            if (!(ia == i))
                if (arr1[i] == arr1[ia] && arr2[i] == arr2[ia])
                    return true;
        return false;
    }

}

