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
        yearsComboBox.getItems().addAll(CsvReader.showOnlyYears(csv.data));
    }
}