package com.example.statisticsinit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.sqrt;

public class StatisticsMethod {
    public static List<Integer> carAccidents;
    public StatisticsMethod(ArrayList<Integer> carAccidents){
           this.carAccidents = carAccidents;
    }

    public float average(){

        int sum = 0;

        for(int numberAccidentsOnConcreteWay : carAccidents){
            sum += numberAccidentsOnConcreteWay;
        }

        return  (float) sum /carAccidents.size();
    }

    public int min(){
        return Collections.min(carAccidents);
    }

    public int maks() {

        return Collections.max(carAccidents);
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

    public double firstQuartile() {
        int size = carAccidents.size();
        int index = size / 4;
        if (size % 4 == 0) {
            return (carAccidents.get(index - 1) + carAccidents.get(index)) / 2.0;
        } else {
            return carAccidents.get(index);
        }
    }

    public double secondQuartile() {
        Collections.sort(carAccidents);
        int size = carAccidents.size();
        if (size % 2 == 0) {
            int mid1 = carAccidents.get(size / 2 - 1);
            int mid2 = carAccidents.get(size / 2);
            return (mid1 + mid2) / 2.0;
        } else {
            return carAccidents.get(size / 2);
        }
    }

    public double thirdQuartile() {
        int size = carAccidents.size();
        int index = 3 * size / 4;
        if (size % 4 == 0) {
            return (carAccidents.get(index - 1) + carAccidents.get(index)) / 2.0;
        } else {
            return carAccidents.get(index);
        }
    }

    public double variance() {
        double standardDivision = 0.0f;
        float average = average();
        int n = carAccidents.size(); //amount of data(numbers of car accidents)
        float expression = 0.0f;

        for(int x : carAccidents){
            expression += ((x - average) * (x - average));
        }

        standardDivision = (expression)/n;

        return standardDivision;
    }
    public double standardDivision(){
        return sqrt(variance());
    }

    public int distance(){ //ROZSTĘP
        return this.maks() - this.min();
    }

    public float skewness(){
        return this.average() - mode();
    }

    public double fourCentralMoment(){
        double fourCentralMoment = 0.0f;
        float average = average();
        int n = carAccidents.size(); //amount of data(numbers of car accidents)
        float expression = 0.0f;

        for(int x : carAccidents){
            expression += ((x - average) * (x - average) * (x - average) * (x - average));
        }

        fourCentralMoment = (expression)/n;

        return fourCentralMoment;
    }

    public double kurtosis(){
        return this.fourCentralMoment()/(this.variance() * variance()); //wariancja to odchylenie podniesione do 2 potęgi stąd wariancja do kwadratu to odchylenie do potęgi 4
    }
}
