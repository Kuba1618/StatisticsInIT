package com.example.statisticsinit;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    public static List<List<String>> data;
    public static List<List<String>> readCsvFile(String filePath) {
        List<List<String>> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                int numColumns = columns.length;
                for (int i = 0; i < numColumns; i++) {
                    dataList.add(new ArrayList<>());
                    dataList.get(i).add(columns[i]);
                }
            }

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                for (int i = 0; i < columns.length; i++) {
                    dataList.get(i).add(columns[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public ArrayList<Integer> getDataByYear(int year){
        ArrayList<Integer> accidentsInConcreteYear = new ArrayList<>();

        for (List<String> column : data) {

            if(column.get(0).equals(year + "")){

                for (String value : column) {

                    try{
                        accidentsInConcreteYear.add(Integer.parseInt(value));
                    }
                    catch (Exception exception){
                        System.out.println("Błąd konwersji z String na int");
                    }
                }
            }
        }

        return accidentsInConcreteYear;
    }

    public static void showAllData(List<List<String>> data){

        // Wyświetlenie odczytanych danych
        for (List<String> column : data) {

            for (String value : column) {
                System.out.print(value + "\t");
            }
            System.out.println();

            //System.out.println(Arrays.toString(column.toArray()));
        }
    }

    public static String[] getYears(List<List<String>> data){

        String[] years = new String[data.size()];
        int i =0;

        for(List<String> concreteList : data){
            years[i] = concreteList.get(0);
            i++;
        }

        years = Arrays.copyOfRange(years,1,years.length);

        return years;
    }

    public static void main() {
        String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory() + "";
        String filePath = desktopPath + "\\wypadki.csv"; // Zmień na ścieżkę do swojego pliku CSV
        data = readCsvFile(filePath);
        showAllData(data);
        getYears(data);
    }

}

