module com.example.blackjackgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjackgui to javafx.fxml;
    exports com.example.blackjackgui;
    exports com.example.blackjackgui.model;
    opens com.example.blackjackgui.model to javafx.fxml;
    exports com.example.blackjackgui.command;
    opens com.example.blackjackgui.command to javafx.fxml;
}