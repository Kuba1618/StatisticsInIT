package com.example.statisticsinit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public float median(){ //Mediana

        if (carAccidents.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta. Nie można obliczyć mediany.");
        }

        Collections.sort(carAccidents);

        int size = carAccidents.size();

        if (size % 2 == 1) {       // Dla listy o nieparzystej liczbie elementów, mediana to środkowy element
            return carAccidents.get(size / 2);
        }
        else {
            // Dla listy o parzystej liczbie elementów, mediana to średnia dwóch środkowych elementów
            int middle1 = carAccidents.get(size / 2 - 1);
            int middle2 = carAccidents.get(size / 2);
            return (float) (middle1 + middle2) / 2;
        }
    }

    public static int mode(List<Integer> list) { //Dominanta
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Lista jest pusta. Nie można obliczyć dominującej.");
        }

        Collections.sort(list);

        int currentNumber = list.get(0);
        int mode = currentNumber;
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == currentNumber) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    mode = currentNumber;
                }
                count = 1;
                currentNumber = list.get(i);
            }
        }

        // Sprawdzenie ostatniego zestawienia
        if (count > maxCount) {
            mode = currentNumber;
        }

        return mode;
    }

}
