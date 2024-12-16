module com.example.ca2real {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ca2real to javafx.fxml;
    exports com.example.ca2real;
}