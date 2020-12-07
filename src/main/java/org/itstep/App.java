package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
//        ImageView logoView = new ImageView();
//
//        Image image = new Image(pathToCard("itstep-logo.png"));
//
//        logoView.setImage(image);
//        logoView.setPreserveRatio(true);
//        logoView.setFitWidth(100);
//
//        playAnimation(logoView);
        /*Pane rootNode = new Pane();

        Rectangle rectangle = new Rectangle(800, 600);
        rectangle.setFill(Color.RED);


        //статический текст - lable
        Label label = new Label("Hello World");
        label.setFont(Font.font("Arial", 25));
        label.relocate(10, 10);

        //Изображения
        Image image = new Image(pathToCard("cards/ace_of_clubs.png"));
        //Ужзел для отображения изображений
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(200);
        imageView.relocate(10, 50);

        //Кнопка
        Button button = new Button("Push me");
        button.relocate(200, 10);
        button.setBackground(new Background((new BackgroundFill(Color.GREEN, null, null))));
        button.setStyle("-fx-text-fill: white");

        //Поле ввода
        TextField textField = new TextField();
        textField.relocate(10, 300);

        button.setOnAction(event -> {
            button.setText("Text field: " + textField.getText());
        });

        rootNode.getChildren().add(rectangle);
        rootNode.getChildren().add(label);
        rootNode.getChildren().add(imageView);
        rootNode.getChildren().add(button);
        rootNode.getChildren().add(textField);*/

        Pane rootNode = FXMLLoader.load(new URL(pathToCard("win.fxml")));

        Scene scene = new Scene(rootNode, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}