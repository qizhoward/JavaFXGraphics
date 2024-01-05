package com.example.my;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {

    public void PreferencsView(ActionEvent event) {

        try {
            // 加载第二个视图的FXML文件
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Preferences-view.fxml"));
            Parent root = fxmlLoader.load();

            // 创建新的舞台（窗口）和场景
            Stage stage = new Stage();
            stage.setTitle("Preferences View");
            stage.setScene(new Scene(root, 600, 400));
            // 显示第二个视图
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // 处理加载视图时的异常
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open preferences view");
            alert.setContentText("An error occurred while loading the preferences view.");
            alert.showAndWait();
        }


    }

    public void HotkeyEditor(ActionEvent event){
        try {
            // 加载第二个视图的FXML文件
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HotkeyEditor-view.fxml"));
            Parent root = fxmlLoader.load();

            // 创建新的舞台（窗口）和场景
            Stage stage = new Stage();
            stage.setTitle("Hotkey Editor View");
            stage.setScene(new Scene(root, 600, 400));
            // 显示第二个视图
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // 处理加载视图时的异常
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open HotkeyEditor view");
            alert.setContentText("An error occurred while loading the HotkeyEditor view.");
            alert.showAndWait();
        }

    }

    public void ViewCube(ActionEvent event){
        try {
            // 加载第二个视图的FXML文件
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewCube-view.fxml"));
            Parent root = fxmlLoader.load();

            // 创建新的舞台（窗口）和场景
            Stage stage = new Stage();
            stage.setTitle("ViewCube View");
            stage.setScene(new Scene(root, 600, 400));
            // 显示第二个视图
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // 处理加载视图时的异常
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open ViewCube view");
            alert.setContentText("An error occurred while loading the ViewCube view.");
            alert.showAndWait();
        }

    }

    public void OpenFile(ActionEvent event){


        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        // 设置文件类型过滤器（可选）
        FileChooser.ExtensionFilter objFilter =
                new FileChooser.ExtensionFilter("OBJ files (*.obj)", "*.obj");
        fileChooser.getExtensionFilters().add(objFilter);
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        FileChooser.ExtensionFilter ThreeDFilter =
                new FileChooser.ExtensionFilter("3D files (*.3d)", "*.3d");
        fileChooser.getExtensionFilters().add(ThreeDFilter);
        FileChooser.ExtensionFilter allFilesFilter =
                new FileChooser.ExtensionFilter("All Files", "*.*");
        fileChooser.getExtensionFilters().add(allFilesFilter);

        // 显示文件选择器并获取选定的文件
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            // 在这里可以处理选定的文件，例如读取文件内容或者其他操作
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    public void AboutView(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About-view.fxml"));
            Parent root = fxmlLoader.load();

            // 获取AboutController
            AboutController aboutController = new AboutController();
            aboutController.initData("0.1"); // Set version

            Stage stage = new Stage();
            stage.setTitle("About View");
            stage.setScene(new Scene(root, 400, 200));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open About view");
            alert.setContentText("An error occurred while loading the About view.");
            alert.showAndWait();


        }

    }

    public void SaveAs(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");
        // 设置文件类型过滤器（可选）
        FileChooser.ExtensionFilter threeDFilter =
                new FileChooser.ExtensionFilter("3D files 2024 (*.3d)", "*.3d");
        fileChooser.getExtensionFilters().add(threeDFilter);
        FileChooser.ExtensionFilter allFilesFilter =
                new FileChooser.ExtensionFilter("All Files", "*.*");
        fileChooser.getExtensionFilters().add(allFilesFilter);
        // 显示文件选择器并获取选定的文件路径
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile != null) {
            // 在这里可以处理选定的文件路径，进行文件保存操作
            // 例如，您可以获取要保存的数据并将其写入选定的文件中
            try {
                // 这里是一个示例，写入一些示例文本到选定的文件中
                FileWriter fileWriter = new FileWriter(selectedFile);
                fileWriter.write("这是保存的内容...");
                fileWriter.close();
                System.out.println("File saved: " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                // 处理文件保存时的异常
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed to save file");
                alert.setContentText("An error occurred while saving the file.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private Button toggleButton;

    @FXML
    private TreeView<String> treeView;
    @FXML
    public void toggleTreeView() {
        if (treeView.isVisible()) {
            treeView.setVisible(false);
        } else {
            treeView.setVisible(true);
        }
    }


}

