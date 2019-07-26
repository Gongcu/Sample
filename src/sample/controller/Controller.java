package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.data.ScoreData;
import sample.ExcelController.ScoreExcelReader;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private Stage primaryStage;
    private String selectedFilePath;
    private static List<ScoreData> xlsxList;
    private static List<ScoreData> xlsList;

    @FXML private Button loadButton;
    @FXML private Label resultLabel;
    @FXML private Button resultButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadButton.setOnMouseClicked( event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Excel file", "*.xlsx","*.xls"),
                    new FileChooser.ExtensionFilter("All file", "*.*")
            );
            File selectedFIle = fileChooser.showOpenDialog(new Stage()); //file 객체 반환
            if(selectedFIle==null)
                resultLabel.setText("파일을 불러오세요");
            else
                resultLabel.setText("파일명: " + selectedFIle.getName());
            selectedFilePath = selectedFIle.getPath();
            ScoreExcelReader excelReader = new ScoreExcelReader();

            /*추출된 파일명을 통해 xls or xlsx에 초기화*/
            int pos = selectedFIle.getName().lastIndexOf(".");
            String ext = selectedFIle.getName().substring(pos +1);

            if(ext.equals("xls")){
                xlsList = excelReader.xlsToCustomerVoList(selectedFilePath);
            }
            else if(ext.equals("xlsx")) {
                xlsxList = excelReader.xlsxToCustomerVoList(selectedFilePath);
            }
        });

        //테이블뷰 fxml로 이동
        resultButton.setOnMouseClicked(event -> {
            try{
                Parent score = FXMLLoader.load(getClass().getResource("../fxml/score_scene.fxml"));
                Scene scene = new Scene(score);
                Stage primaryStage = (Stage) resultButton.getScene().getWindow();
                primaryStage.setScene(scene);
            }catch (Exception e){
                getAlertDialog();
            }
        });
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage=primaryStage;
    }

    public String getSelectedFilePath(){
        return selectedFilePath;
    }

    public static List<ScoreData>  getData(){
        return xlsxList;
    }

    private void getAlertDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(null);
        alert.setContentText("Excel 파일을 로드하세요.");
        alert.showAndWait();
    }
}
