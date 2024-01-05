package com.example.my;

import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class AboutController {
    @FXML
    private Label versionLabel;

    public void initData(String version) {
        if (versionLabel != null) {
            versionLabel.setText("Version: " + version);
        } else {
            System.out.println("versionLabel is null");
        }
    }


}