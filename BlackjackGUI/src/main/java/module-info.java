module com.example.blackjackgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjackgui to javafx.fxml;
    exports com.example.blackjackgui;
}