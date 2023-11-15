package com.example.statisticsinit;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class HelloController implements  Initializable{
    public CsvReader csv = new CsvReader();
    public ArrayList<Integer> carAccidentsInChosenYear = new ArrayList<>();
    public static String[] yearsList;
    @FXML
    private ComboBox statisticsYearsCmbBox,charnoffYearsListCmbBox;
    @FXML
    private TextField odchylenieStandTxtField,minTxtField,maksTxtField,avgTxtField,medianaTxtField,dominTxtField;
    @FXML
    private TextField q1TxtField,q2TxtField,q3TxtField,rozstepTxtField,skosnoscTxtField,varianceTxtField,kurtozaTxtField;
    @FXML
    private ImageView currentCharnoffImgView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCharnoffImg();
    }
    @FXML
    protected void onWczytajCSVBtnClick() {
        csv.main();
        yearsList = CsvReader.getYears(csv.data);
        statisticsYearsCmbBox.getItems().addAll(yearsList);
        charnoffYearsListCmbBox.getItems().addAll(yearsList);
    }

    @FXML
    public void loadCharnoffImg() {
        charnoffYearsListCmbBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(charnoffYearsListCmbBox.getValue());
                try{
                    int value = Integer.parseInt(String.valueOf(charnoffYearsListCmbBox.getValue()));
                    String quartile = getQuartileBasedOnValue(value);
                    currentCharnoffImgView.setImage(new Image(HelloController.class.getResourceAsStream("poland"
                            + quartile +".png")));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public String getQuartileBasedOnValue(int value){ //should return Q1,Q2 or Q3
        StatisticsMethod statisticsMethod = new StatisticsMethod(carAccidentsInChosenYear);

        double distanceToQ1 = Math.abs(value - statisticsMethod.firstQuartile());
        double distanceToQ2 = Math.abs(value - statisticsMethod.secondQuartile());
        double distanceToQ3 = Math.abs(value - statisticsMethod.thirdQuartile());

        if (distanceToQ1 <= distanceToQ2 && distanceToQ1 <= distanceToQ3) {
            return "Q1";
        } else if (distanceToQ2 <= distanceToQ1 && distanceToQ2 <= distanceToQ3) {
            return "Q2";
        } else {
            return "Q3";
        }
    }

    @FXML
    protected void onCountBtn(){
        int yearFromComboBox = 0;

        try{
            yearFromComboBox = Integer.parseInt(statisticsYearsCmbBox.getSelectionModel().getSelectedItem() + "");

        }catch (Exception e){
            System.out.println("Błąd konwersji typów (String na int)");
        }

        //Load concrete year data (without year number) to an ArrayList
        carAccidentsInChosenYear = csv.getDataByYear(yearFromComboBox);

        displayCarAccidentsByYear();

        //Load data to appriopriate fields
        StatisticsMethod statisticsMethods = new StatisticsMethod(carAccidentsInChosenYear);
        odchylenieStandTxtField.setText(String.valueOf(statisticsMethods.standardDivision()));
        minTxtField.setText(String.valueOf(statisticsMethods.min()));
        maksTxtField.setText(String.valueOf(statisticsMethods.maks()));
        avgTxtField.setText(String.valueOf(statisticsMethods.average()));
        medianaTxtField.setText(String.valueOf(statisticsMethods.median()));
        dominTxtField.setText(String.valueOf(statisticsMethods.mode()));
        q1TxtField.setText(String.valueOf(statisticsMethods.firstQuartile()));
        q2TxtField.setText(String.valueOf(statisticsMethods.secondQuartile()));
        q3TxtField.setText(String.valueOf(statisticsMethods.thirdQuartile()));
        rozstepTxtField.setText(String.valueOf(statisticsMethods.distance()));
        skosnoscTxtField.setText(String.valueOf(statisticsMethods.skewness()));
        varianceTxtField.setText(String.valueOf(statisticsMethods.variance()));
        kurtozaTxtField.setText(String.valueOf(statisticsMethods.kurtosis()));
    }

    public void displayCarAccidentsByYear(){

        for(int i : carAccidentsInChosenYear){
            System.out.print(i + "\t");
        }

        System.out.println("");
    }

}