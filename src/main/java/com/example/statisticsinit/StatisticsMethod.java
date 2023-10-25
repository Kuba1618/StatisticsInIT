package com.example.statisticsinit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsMethod {

    public List<Integer> carAccidents;
    public StatisticsMethod(ArrayList<Integer> carAccidents){
           this.carAccidents = carAccidents;
    }

    public float average(){

        int sum = 0;

        for(int numberAccidentsOnConcreteWay : carAccidents){
            sum += numberAccidentsOnConcreteWay;
        }

        return (float) sum /carAccidents.size();
    }

    public int minCarAccidentsInYear(){

        int min = 0;

        for(int numberAccidentsOnConcreteWay : carAccidents){
            if(min > numberAccidentsOnConcreteWay){
                min = numberAccidentsOnConcreteWay;
            }
        }

        return min;
    }

    public int maksCarAccidentsInYear() {

        int max = 0;

        for (int numberAccidentsOnConcreteWay : carAccidents) {
            if (max < numberAccidentsOnConcreteWay) {
                max = numberAccidentsOnConcreteWay;
            }
        }

        return max;
    }


    /** Mediana - środkowy wynik
     *  1. Sortowanie wyników
     *  2. Wybranie środkowego wyniku()
     *     a) dla nieparzystej ilości wyników w zbiorze --> należy wybrać środkowy element (size/2)
     *     b) dla parzystej ilości wyników w zbiorze --> należy policzyć średnią dwóch środkowych elementów
     */
    public float median(){

        if (carAccidents.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta. Nie można obliczyć mediany.");
        }

        //Opis funckji pkt 1
        Collections.sort(carAccidents);

        int size = carAccidents.size();

        if (size % 2 == 1) { //Opis funkcji pkt 2a
            return carAccidents.get(size / 2);
        }
        else {
            // Opis funkcji pkt 2b
            int middle1 = carAccidents.get(size / 2 - 1);
            int middle2 = carAccidents.get(size / 2);
            return (float) (middle1 + middle2) / 2;
        }
    }

    /**
     * @return most popularity result
     */
    public int mode() { //Dominanta
        if (carAccidents.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta. Nie można obliczyć dominującej.");
        }

        Collections.sort(carAccidents);

        int currentNumber = carAccidents.get(0);
        int mode = currentNumber;
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < carAccidents.size(); i++) {
            if (carAccidents.get(i) == currentNumber) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    mode = currentNumber;
                }
                count = 1;
                currentNumber = carAccidents.get(i);
            }
        }

        // Sprawdzenie ostatniego zestawienia
        if (count > maxCount) {
            mode = currentNumber;
        }

        return mode;
    }

    public static double firstQuartile(List<Integer> list) {
        int size = list.size();
        int index = size / 4;
        if (size % 4 == 0) {
            return (list.get(index - 1) + list.get(index)) / 2.0;
        } else {
            return list.get(index);
        }
    }

    public static double secondQuartile(List<Integer> list) {
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 0) {
            int mid1 = list.get(size / 2 - 1);
            int mid2 = list.get(size / 2);
            return (mid1 + mid2) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }

    public static double thirdQuartile(List<Integer> list) {
        int size = list.size();
        int index = 3 * size / 4;
        if (size % 4 == 0) {
            return (list.get(index - 1) + list.get(index)) / 2.0;
        } else {
            return list.get(index);
        }
    }

    //@ToDo uzupełnić kolejne metody statystyczne

}
