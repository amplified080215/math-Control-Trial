package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
//        primaryStage.setX(1500);
//        primaryStage.setY(78);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene (scene);
        primaryStage.show();


        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getWidth() - 300;
        double y = bounds.getHeight() - 850;
        primaryStage.setX(x);
        primaryStage.setY(y);

        System.out.println(bounds);
        System.out.println(x);
        System.out.println(y);
    }

    public static void main(String[] args) {launch(args);}
}