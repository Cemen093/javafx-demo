package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;


public class App extends Application {

    public static final int WIDTH_SCENE = 1000;
    public static final int HEIGHT_SCENE = 800;
    public static final int WIDTH_LEFT_RECTANGLE =  (int) (WIDTH_SCENE * 0.7);
    public static final int HEIGHT_LEFT_RECTANGLE = HEIGHT_SCENE;
    public static final int WIDTH_RIGHT_RECTANGLE = (int) (WIDTH_SCENE * 0.3);
    public static final int HEIGHT_RIGHT_RECTANGLE = HEIGHT_SCENE;
    public static final int WIDTH_BUTTON = 175;
    public static final int HEIGHT_BUTTON = 35;
    public static final int WIDTH_TEXT_FIELD = 175;
    public static final int HEIGHT_TEXT_FIELD  = 35;
    public static final int WIDTH_LABEL = 175;
    public static final int HEIGHT_LABEL = 35;
    public static final int WIDTH_LABEL_BLACK_JACK = 400;
    public static final int HEIGHT_LABEL_BLACK_JACK = 100;

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
        Pane rootNode = new Pane();
//        Pane rootNode = FXMLLoader.load(new URL(pathToCard("win.fxml")));

        //прямоугольник
        Rectangle rectangleBlack = new Rectangle(WIDTH_LEFT_RECTANGLE, HEIGHT_LEFT_RECTANGLE);
        rectangleBlack.relocate(0,0);
        rectangleBlack.setFill(Color.BLACK);

        Rectangle rectangleGreen = new Rectangle(WIDTH_RIGHT_RECTANGLE, HEIGHT_RIGHT_RECTANGLE);
        rectangleGreen.relocate(WIDTH_LEFT_RECTANGLE,0);
        rectangleGreen.setFill(Color.GREEN);

        //Изображения
        /*Image image = new Image(pathToCard("cards/ace_of_clubs.png"));
        //Узел для отображения изображений
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(200);
        imageView.relocate(10, 50);*/

        //статический текст - label
        Label labelDealer = getLabel("Dealer: 0", (WIDTH_LEFT_RECTANGLE - WIDTH_LABEL) / 2,
                (int)(HEIGHT_SCENE * 0.03));
        Label labelPlayer = getLabel("Player: 0", (WIDTH_LEFT_RECTANGLE - WIDTH_LABEL) / 2,
                (int)((HEIGHT_SCENE - HEIGHT_LABEL) * 0.97));
        Label labelCash = getLabel("Cash: 1000", WIDTH_LEFT_RECTANGLE + (WIDTH_RIGHT_RECTANGLE - WIDTH_LABEL) / 2,
                (int)(HEIGHT_SCENE * 0.03));
        Label labelBet = getLabel("BET",WIDTH_LEFT_RECTANGLE + (WIDTH_RIGHT_RECTANGLE - WIDTH_LABEL) / 2,
                (int)(HEIGHT_SCENE * 0.55));
        Label labelBlackJack = getLabelBlackJack("Black Jack",(WIDTH_LEFT_RECTANGLE - WIDTH_LABEL_BLACK_JACK) / 2,
                (HEIGHT_SCENE - HEIGHT_LABEL_BLACK_JACK) / 2 );

        //Поле ввода
        TextField textFieldRate = getTextField("100", WIDTH_LEFT_RECTANGLE + (WIDTH_RIGHT_RECTANGLE - WIDTH_TEXT_FIELD) / 2,
                (int)(HEIGHT_SCENE * 0.6));



        //Кнопка
        int indentWightButton = WIDTH_LEFT_RECTANGLE + (WIDTH_RIGHT_RECTANGLE - WIDTH_BUTTON) / 2;
        Button buttonHIT = getButton("HIT", indentWightButton, (int)(HEIGHT_SCENE * 0.25));
        Button buttonSTAND = getButton("STAND", indentWightButton, (int)(HEIGHT_SCENE * 0.35));
        Button buttonPLAY = getButton("PLAY", indentWightButton, (int)(HEIGHT_SCENE * 0.85));

        //нажатие кнопки
        /*
        button.setOnAction(event -> {
            button.setText("Text field: " + textField.getText());
        });*/

        rootNode.getChildren().add(rectangleBlack);
        rootNode.getChildren().add(rectangleGreen);
        rootNode.getChildren().add(labelDealer);
        rootNode.getChildren().add(labelPlayer);
        rootNode.getChildren().add(labelCash);
        rootNode.getChildren().add(labelBet);
        rootNode.getChildren().add(labelBlackJack);
        rootNode.getChildren().add(textFieldRate);;
        rootNode.getChildren().add(buttonHIT);
        rootNode.getChildren().add(buttonSTAND);
        rootNode.getChildren().add(buttonPLAY);
        //rootNode.getChildren().add(imageView);


        Scene scene = new Scene(rootNode, WIDTH_SCENE, HEIGHT_SCENE);
        stage.setScene(scene);
        stage.setTitle("Black Jack");
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

    private Button getButton(String name, int x, int y){
        Button button = new Button(name);
        button.setMinSize(WIDTH_BUTTON, HEIGHT_BUTTON);
        button.relocate(x, y);
        button.setStyle("-fx-text-fill: black; -fx-background-radius: 10; -fx-background-color: grey");
        return button;
    }

    private Label getLabel(String str, int x, int y){
        Label label = new Label(str);
        label.setMinSize(WIDTH_LABEL, HEIGHT_LABEL);
        label.relocate(x,y);
        label.setFont(Font.font("Arial", 20));
        label.setStyle("-fx-text-fill: white; -fx-alignment: center");
        return label;
    }

    private Label getLabelBlackJack(String str, int x, int y){
        Label label = new Label(str);
        label.setMinSize(WIDTH_LABEL_BLACK_JACK, HEIGHT_LABEL_BLACK_JACK);
        label.relocate(x,y);
        label.setFont(Font.font("Arial", 75));
        label.setStyle("-fx-text-fill: white; -fx-alignment: center");
        return label;
    }

    private TextField getTextField(String str, int x, int y){
        TextField textField = new TextField(str);
        textField.setMinSize(WIDTH_TEXT_FIELD, HEIGHT_TEXT_FIELD);
        textField.setStyle("-fx-alignment: center");
        textField.relocate(x, y);
        return textField;
    }
}