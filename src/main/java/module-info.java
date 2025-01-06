module com.example.ca2real {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.ca2real to javafx.fxml, xstream;
    exports com.example.ca2real;
    exports Model to xstream;
    opens Model to javafx.fxml, xstream;

}