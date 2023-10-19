package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button wczytajCSVBtn;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onWczytajCSVBtnClick(){
        //String path = "src\\example111.csv";
        String path = "D:\\PROGRAMMING_PROJECTS\\StatisticsInIT\\StatisticsInIT\\src\\main\\resources\\com\\example\\statisticsinit\\aaa.txt";

        String line = "";

        try {
                Scanner s1 = new Scanner(new File(path)).useDelimiter(System.lineSeparator());
                while (s1.hasNextLine()){
                    line = line + " " + s1.nextLine();
                }
        }catch (FileNotFoundException ex) {
            line = null;
        }

        System.out.println(line);

    }

}