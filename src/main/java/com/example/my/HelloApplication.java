package com.example.my;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @FXML
    private AnchorPane Pane2;
    private Canvas canvas;
    private GraphicsContext gc;
    private double gridSize = 500.0;
    private double gridStep = gridSize / 10.0;

    private double scale = 1.0;
    private double rotateAngle = 0.0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        canvas = (Canvas) fxmlLoader.getNamespace().get("canvas");

        gc = canvas.getGraphicsContext2D();
        draw2DGrid(gc, gridSize, gridStep);
        canvas.setOnScroll(event -> {
            double deltaY = event.getDeltaY();
            scale += deltaY / 100.0;
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            draw2DGrid(gc, gridSize * scale, gridStep * scale);
        });

        canvas.setOnMouseDragged(event -> {
            if (event.isShiftDown()) {
                rotateAngle -= (event.getSceneY() - event.getSceneY()) * 0.5;
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                draw2DGrid(gc, gridSize * scale, gridStep * scale);
            }
        });

        Scene scene = new Scene(root, 1080, 720);

        stage.setTitle("七只蜗牛");
        stage.getIcons().add(new Image("file:icon.ico"));
        stage.setScene(scene);
        stage.show();

    }


    private void draw2DGrid(GraphicsContext gc, double gridSize, double gridStep) {
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        int rows = 10;
        int cols = 10;

        double cellWidth = canvasWidth / cols;
        double cellHeight = canvasHeight / rows;

        gc.clearRect(0, 0, canvasWidth, canvasHeight);

        // 绘制网格
        gc.setStroke(Color.LIGHTGRAY);
        gc.setLineWidth(1);

        // 绘制横线
        for (int i = 1; i < rows; i++) {
            double y = i * cellHeight;
            gc.strokeLine(0, y, canvasWidth, y);
        }

        // 绘制竖线
        for (int i = 1; i < cols; i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canvasHeight);
        }

        // 绘制原点
        gc.setFill(Color.GREEN);
        gc.fillOval(canvasWidth / 2 - 2, canvasHeight / 2 - 2, 4, 4);

        // 绘制坐标轴
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);

        gc.strokeLine(canvasWidth / 2, 0, canvasWidth / 2, canvasHeight); // Y轴
        gc.strokeLine(0, canvasHeight / 2, canvasWidth, canvasHeight / 2); // X轴
    }



    public static void main(String[] args) {
        launch();
    }








}



