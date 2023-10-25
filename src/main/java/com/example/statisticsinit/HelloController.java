package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class HelloController implements  Initializable{

    public CsvReader csv = new CsvReader();
    public ArrayList<LinkedList<Integer>> numberOfCarAccidents;
    public static String[] yearsList;
    @FXML
    private Label welcomeText;
    @FXML
    private Button wczytajCSVBtn;
    @FXML
    private ComboBox yearsComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
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

        for(int i :csv.getDataByYear(yearFromComboBox)){
            System.out.print(i + "\t");
        }
    }

}