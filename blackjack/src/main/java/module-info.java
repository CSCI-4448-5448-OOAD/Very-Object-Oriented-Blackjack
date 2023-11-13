module com.finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.finalproject to javafx.fxml;
    exports com.finalproject;
}
