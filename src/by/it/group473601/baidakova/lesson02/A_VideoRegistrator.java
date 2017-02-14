package by.it.group473601.baidakova.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
даны события events
реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
заданный период времени (1) было минимальным, а все события events
были зарегистрированы.

Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result;
        result = new ArrayList<>();
        int i;                              //i - это индекс события events[i]
        //комментарии от проверочного решения сохранены для подсказки, но вы можете их удалить.
        Arrays.sort(events);                   //подготовка к жадному поглощению массива событий
        double finish;                     //hint: сортировка Arrays.sort обеспечит скорость алгоритма
                                              //C*(n log n) + C1*n = O(n log n)

        for (i=0;i<events.length;i++) {       //пока есть незарегистрированные события
            result.add(events[i]);              //получим одно событие по левому краю
            finish=events[i]+workDuration;

            for (int j=i+1; j<events.length; j++) {
                if (events[j]<=finish) i++;
                else break;
            }
        }

        return result;                        //вернем итог
    }
}
