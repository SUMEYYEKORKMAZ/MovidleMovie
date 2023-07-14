package com.example.movidlemovie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

public class MovieController {

    @FXML
    private TextField txtGuessMovie;

    @FXML
    private VBox vboxMovies;

    @FXML
    private Button btnEnter;

    @FXML
    private Label lblMessage;
    private int counter = 5;
    private ReadMovieList rml;
    private Movie randomMovie;


    private List<HBox> movieHBoxes = new ArrayList<>();

    public void initialize() {


        rml = new ReadMovieList();
        rml.ReaderMovie();
        randomMovie = rml.getMovieById(rml.movieList);
        lblMessage.setText(randomMovie.getMQuotes());
        System.out.println(randomMovie); // kontrol amaçlı yazıldı silinecek

    }

    @FXML
    public void btnEnterSetOnAction(ActionEvent event) {
        if (counter > 0) {
            movieControl();
            counter = counter - 1;
            txtGuessMovie.clear();
        } else {
            showMessageBox("GAME OVER! \n Unfortunately you lost \n Movie : " + randomMovie.getMName());

        }
    }


    private void movieControl() {
        String guessedMovie = txtGuessMovie.getText();
        Movie guessedMovieDetails = rml.getMovieDetails(guessedMovie, rml.movieList);

        if (guessedMovieDetails != null) {

            if (!guessedMovieDetails.getMName().equals(randomMovie.getMName())) {
                HBox newHBox = createMovieHBox(guessedMovieDetails);
                movieHBoxes.add(newHBox);
                vboxMovies.getChildren().add(newHBox);
                vboxMovies.setSpacing(5);
            }
            else {
                HBox newHBox = createMovieHBox(guessedMovieDetails);
                movieHBoxes.add(newHBox);
                vboxMovies.getChildren().add(newHBox);
                vboxMovies.setSpacing(5);
                showMessageBox("Congratulations! You won...");
                counter = 0;

            }
        } else {
            showMessageBox("Movie not found");
            counter = counter + 1;
        }
    }

    private HBox createMovieHBox(Movie movie) {

        HBox movieHBox = new HBox();
        movieHBox.setSpacing(10);

        Label lblName = createMovieLabel(movie.getMName());
        Label lblDirector = createMovieLabel(movie.getMDirector());
        Label lblYear = createMovieLabel(movie.getMYear());
        Label lblOrigin = createMovieLabel(movie.getMOrigin());
        Label lblGenre = createMovieLabel(movie.getMGenre());
        Label lblStar = createMovieLabel(movie.getMStar());

        setBackgroundColor(lblName, randomMovie.getMName(), movie.getMName());
        setBackgroundColor(lblGenre, randomMovie.getMGenre(), movie.getMGenre());
        setBackgroundColor(lblOrigin, randomMovie.getMOrigin(), movie.getMOrigin());
        setBackgroundColor(lblDirector, randomMovie.getMDirector(), movie.getMDirector());
        setBackgroundColor(lblStar, randomMovie.getMStar(), movie.getMStar());
        setBackgroundColor(lblYear, randomMovie.getMYear(), movie.getMYear());

        movieHBox.getChildren().addAll(lblName, lblYear, lblGenre, lblOrigin, lblDirector, lblStar);
        movieHBox.setSpacing(0);
        return movieHBox;
    }

    private Label createMovieLabel(String text) {
        Label label = new Label(text);
        label.setPrefSize(60, 60);
        label.setWrapText(true);
        return label;
    }

    private void setBackgroundColor(Label label, String randomValue, String guessValue) {
        if (randomValue.equalsIgnoreCase(guessValue)) {
            label.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        } else {
            label.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        }
    }

    private void showMessageBox(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
