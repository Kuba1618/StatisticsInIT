package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
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

        /*String path = "D:\\PROGRAMMING_PROJECTS\\StatisticsInIT\\StatisticsInIT\\src\\main\\resources\\com\\example\\statisticsinit\\aaa.txt";

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
        */

        String path = "D:\\PROGRAMMING_PROJECTS\\StatisticsInIT\\StatisticsInIT\\src\\main\\resources\\com\\example\\statisticsinit\\example111.csv";
        BufferedReader reader = null;
        String line = "";

        try{
                reader = new BufferedReader(new FileReader(path));

                while ((line = reader.readLine()) != null){
                    String[] row = line.split(",");

                    for (String rowLine : row) {
                        System.out.printf("%-10s",rowLine);
                    }

                    System.out.println();
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}