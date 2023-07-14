module com.example.movidlemovie {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.movidlemovie to javafx.fxml;
    exports com.example.movidlemovie;

    // Diğer mod
    //}ül bildirimleri


}