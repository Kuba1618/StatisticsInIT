module com.example.statisticsinit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.statisticsinit to javafx.fxml;
    exports com.example.statisticsinit;
}