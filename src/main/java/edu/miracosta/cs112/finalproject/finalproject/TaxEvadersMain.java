package edu.miracosta.cs112.finalproject.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.MAIN_TITLE_TEXT;

public class TaxEvadersMain extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(TaxEvadersMain.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle(MAIN_TITLE_TEXT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
