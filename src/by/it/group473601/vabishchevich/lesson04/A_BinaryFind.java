package by.it.group473601.vabishchevich.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
В первой строке источника данных даны:
        - целое число 1<=n<=100000 (размер массива)
        - сам массив A[1...n] из n различных натуральных чисел,
          не превышающих 10E9, в порядке возрастания,
Во второй строке
        - целое число 1<=k<=10000 (сколько чисел нужно найти)
        - k натуральных чисел b1,...,bk не превышающих 10E9 (сами числа)
Для каждого i от 1 до kk необходимо вывести индекс 1<=j<=n,
для которого A[j]=bi, или -1, если такого j нет.

        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11

        Sample Output:
        3 1 -1 1 -1

(!) Обратите внимание на смещение начала индекса массивов JAVA относительно условий задачи
*/

public class A_BinaryFind {
    int[] findIndex(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер отсортированного массива
        int n = scanner.nextInt();
        //сам отсортированный массива
        int i=0;
        int mid=0;
        int[] a=new int[n];
        for ( i = 1; i <= n; i++) {
            a[i-1] = scanner.nextInt();
        }
        //размер массива индексов
        int k = scanner.nextInt();
        int[] result=new int[k];
        for ( i = 0; i < k; i++) {
            int left = 0;
            int right = n - 1;
            result[i] = -1;
            int value = scanner.nextInt();
            while (left <= right) {
                //тут реализуйте бинарный поиск индекса
                mid = left + (right - left) / 2;
                if (a[mid] == value) {
                    result[i] = mid + 1;
                    break;
                }
                else {
                    if (a[mid] > value) {
                        right = mid-1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream("C:\\Users\\Колобок\\IdeaProjects\\PISL2017-01-26\\src\\by\\it\\group473601\\vabishchevich\\lesson04\\dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.findIndex(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
