package com.example.statisticsinit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.net.URL;
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

        String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory() + "";
        BufferedReader reader = null;
        String line = "";

        try{
                reader = new BufferedReader(new FileReader(desktopPath + "\\example111.csv"));

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