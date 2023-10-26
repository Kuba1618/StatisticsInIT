package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class HelloController implements  Initializable{
    public CsvReader csv = new CsvReader();
    public ArrayList<Integer> carAccidentsInChosenYear = new ArrayList<>();
    public static String[] yearsList;
    @FXML
    private ComboBox yearsComboBox;
    @FXML
    private TextField odchylenieStandTxtField,minTxtField,maksTxtField,avgTxtField,medianaTxtField,dominTxtField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    protected void onWczytajCSVBtnClick() {
        csv.main();
        yearsList = CsvReader.getYears(csv.data);
        yearsComboBox.getItems().addAll(yearsList);
    }

    @FXML
    protected void onCountBtn(){
        int yearFromComboBox = 0;

        try{
            yearFromComboBox = Integer.parseInt(yearsComboBox.getSelectionModel().getSelectedItem() + "");

        }catch (Exception e){
            System.out.println("Błąd konwersji typów (String na int)");
        }

        //UZUPEŁNIENIE DANYCH
        carAccidentsInChosenYear = csv.getDataByYear(yearFromComboBox);

        displayCarAccidentsByYear();

        StatisticsMethod statisticsMethods = new StatisticsMethod(carAccidentsInChosenYear);
        odchylenieStandTxtField.setText(String.valueOf(statisticsMethods.standardDivision()));
        minTxtField.setText(String.valueOf(statisticsMethods.min()));
        maksTxtField.setText(String.valueOf(statisticsMethods.maks()));
        avgTxtField.setText(String.valueOf(statisticsMethods.average()));
        medianaTxtField.setText(String.valueOf(statisticsMethods.median()));
        dominTxtField.setText(String.valueOf(statisticsMethods.mode()));

    }

    public void displayCarAccidentsByYear(){

        for(int i : carAccidentsInChosenYear){
            System.out.print(i + "\t");
        }

        System.out.println("");
    }

}