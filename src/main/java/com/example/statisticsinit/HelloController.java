package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class HelloController implements  Initializable{

    public ArrayList<LinkedList<Integer>> numberOfCarAccidents;
    public final String[] yearsList = {"2018","2019","2020","2021","2022"};
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
        CsvReader csv = new CsvReader();
        csv.main();
        yearsComboBox.getItems().addAll(CsvReader.getYears(csv.data));
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


}