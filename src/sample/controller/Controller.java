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
import sample.data.PrimaryData;
import sample.data.ScoreData;
import sample.ExcelController.ScoreExcelReader;
import sample.dialog.Dialog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private static List<ScoreData> xlsxList;
    private static List<ScoreData> xlsList;

    @FXML private Button loadButton;
    @FXML private Label resultLabel;
    @FXML private Button resultButton;

    private static String ext;
    private static String selectedFilePath;
    private static ScoreExcelReader excelReader = new ScoreExcelReader();

    private static PrimaryData data; //ScoreSceneController로 확장자를 전달하여 xlsWrite, xlsxWriter 중 무엇을 쓸지 비교

    private static String selectedFileName;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //score.fxml에서 다시 넘어올 때 파일이 로드 되어 있는지 확인하기 위한 조건문
        if(selectedFileName==null)
            resultLabel.setText("                파일명:없음");
        else
            resultLabel.setText("파일명:"+selectedFileName);
        loadButton.setOnMouseClicked( event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Excel file", "*.xlsx","*.xls"),
                    new FileChooser.ExtensionFilter("All file", "*.*")
            );
            File selectedFIle = fileChooser.showOpenDialog(new Stage()); //file 객체 반환
            selectedFileName=selectedFIle.getName();
            data.setSelectedFileName(selectedFileName);
            if(selectedFileName==null)
                resultLabel.setText("파일을 불러오세요");
            else
                resultLabel.setText("파일명: " + selectedFileName);
            selectedFilePath = selectedFIle.getPath();
            excelReader = new ScoreExcelReader();
            /*추출된 파일명을 통해 xls or xlsx에 초기화*/
            int pos = selectedFIle.getName().lastIndexOf(".");
            ext = selectedFileName.substring(pos +1);
            data.setExt(ext);
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
                Dialog.getDialog(e);
            }
        });
    }
//xls와 xlsx인 경우 나눠서 get
    public static List<ScoreData>  getData(){
        if(ext.equals("xls"))
            return  xlsList;
        else
            return xlsxList;
    }

}
