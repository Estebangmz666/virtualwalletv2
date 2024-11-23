module com.github.estebangmz666 {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires spring.security.crypto;

    opens com.github.estebangmz666 to javafx.fxml;
    opens com.github.estebangmz666.controller to javafx.fxml;

    exports com.github.estebangmz666;
    exports com.github.estebangmz666.controller to javafx.fxml;
}