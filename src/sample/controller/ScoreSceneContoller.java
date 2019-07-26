package sample.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.poi.ss.formula.functions.Index;
import sample.ExcelController.ScoreExcelWriter;
import sample.data.ScoreData;

import java.net.URL;
import java.util.*;

public class ScoreSceneContoller implements Initializable {

    @FXML
    private ComboBox comboBox;
    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button mainButton;

    @FXML
    private TableView<ScoreData> tableView;
    @FXML
    private TableColumn<ScoreData, Integer> tableClass;
    @FXML
    private TableColumn<ScoreData, String> tableName;
    @FXML
    private TableColumn<ScoreData, Integer> tableId;
    @FXML
    private TableColumn<ScoreData, Float> tableKor;
    @FXML
    private TableColumn<ScoreData, Float> tableEng;
    @FXML
    private TableColumn<ScoreData, Float> tableMath;
    @FXML
    private TableColumn<ScoreData, Float> tableSoc;
    @FXML
    private TableColumn<ScoreData, Float> tableSci;
    @FXML
    private TableColumn<ScoreData, Float> tableMus;
    @FXML
    private TableColumn<ScoreData, Float> tableArt;
    @FXML
    private TableColumn<ScoreData, Float> tableSpo;
    @FXML
    private TableColumn<ScoreData, Float> tableAvg;
    @FXML
    private TableColumn<ScoreData, Integer> tableRank;
    @FXML
    private TextField upPercentText;
    @FXML
    private TextField downPercentText;
    @FXML
    private Button getUpButton;
    @FXML
    private Button getDownButton;
    @FXML
    private Label student_number;

    private static final NumberFormatException ERROR_FOR_ALERTDIALOG = new NumberFormatException();

    private List<ScoreData> data = Controller.getData();
    private ObservableList<ScoreData> newList = FXCollections.observableArrayList();
    private ObservableList<ScoreData> primaryTableList = FXCollections.observableArrayList(); //for % getUp,DownValue Method
    private int percent;

    //빈 값 버튼 클릭시 dialog 띄우기
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataInit();
        ScoreExcelWriter excelWriter = new ScoreExcelWriter();
        //Combo box 아이템 따라 성적 산출
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                tableView.getColumns().clear();
                //tableView.getColumns().remove(); 선택적 컬럼 제거 가능할듯 반번호이름은 공통되니 냅두고 나머지만 삭제하는 방식으로 만들어보기
                if (t1.equals("전과목")) {
                    Insert_all();
                } else if (t1.equals("국영수사과")) {
                    Insert_main();
                } else if (t1.equals("국영수")) {
                    Insert_kem();
                } else if (t1.equals("수학과학")) {
                    Insert_ms();
                } else {
                    Insert_eng();
                }
            }
        });

        saveButton.setOnMouseClicked(event -> {
            //tableView item이 없을 때 경고창으로 예외처리
            try {
                excelWriter.xlsxWiter(getTableItem());
            }catch (IndexOutOfBoundsException e){getAlertDialog(e);}
        });
        /*메인화면 getScene*/
        mainButton.setOnMouseClicked(event ->{
            Stage stage = (Stage) exitButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        });
        /*종료*/
        exitButton.setOnMouseClicked(event ->{
            Platform.exit();
        });
        /*percent값 받기*/
        getUpButton.setOnMouseClicked(event ->{
            try{
                percent = Integer.parseInt(upPercentText.getText());
                if(percent>100 || percent<0)
                    getAlertDialog(ERROR_FOR_ALERTDIALOG);
                getUpValue(percent, primaryTableList);
                upPercentText.setText("");
            }catch (NumberFormatException e) //값이 ""이거나 문자열일 경우 예외처리
            {getAlertDialog(e);}
        });
        getDownButton.setOnMouseClicked(event ->{
            try{
                percent = Integer.parseInt(downPercentText.getText());
                if(percent>100 || percent<0)
                    getAlertDialog(ERROR_FOR_ALERTDIALOG);
                getDownValue(percent, primaryTableList);
                downPercentText.setText("");
            }catch (NumberFormatException e) //값이 ""이거나 문자열일 경우 예외처리
            {getAlertDialog(e);}
        });
    }

    private void Insert_all() {
        //initialize new table column
        tableClass = new TableColumn("반");
        tableId = new TableColumn("번호");
        tableName = new TableColumn("이름");
        tableKor = new TableColumn("국어");
        tableEng = new TableColumn("영어");
        tableMath = new TableColumn("수학");
        tableSoc = new TableColumn("사회");
        tableSci = new TableColumn("과학");
        tableMus = new TableColumn("음악");
        tableArt = new TableColumn("미술");
        tableSpo = new TableColumn("체육");
        tableAvg = new TableColumn("평균");
        tableRank = new TableColumn("석차");

        //set the table column
        tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableClass.setCellValueFactory(cellData -> cellData.getValue().class_numProperty().asObject());
        tableId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tableKor.setCellValueFactory(cellData -> cellData.getValue().korProperty().asObject());
        tableEng.setCellValueFactory(cellData -> cellData.getValue().engProperty().asObject());
        tableMath.setCellValueFactory(cellData -> cellData.getValue().mathProperty().asObject());
        tableSoc.setCellValueFactory(cellData -> cellData.getValue().socProperty().asObject());
        tableSci.setCellValueFactory(cellData -> cellData.getValue().sciProperty().asObject());
        tableMus.setCellValueFactory(cellData -> cellData.getValue().musProperty().asObject());
        tableArt.setCellValueFactory(cellData -> cellData.getValue().artProperty().asObject());
        tableSpo.setCellValueFactory(cellData -> cellData.getValue().spoProperty().asObject());
        tableAvg.setCellValueFactory(cellData -> cellData.getValue().avgProperty().asObject());
        tableRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());

        //tableView.getItems().clear();
        tableView.getColumns().addAll(tableClass, tableId, tableName, tableKor, tableEng, tableMath, tableSoc, tableSci, tableMus, tableArt, tableSpo, tableAvg, tableRank);

        tableView.setItems(newList); // finally add data to tableview
        int[] rank = getRank();
        float[] avg = getAvg();
        for(int i=0; i<newList.size(); i++){
            newList.get(i).setRank(rank[i]);
            newList.get(i).setAvg(avg[i]);
        }
        primaryTableList=newList;
        tableView.setItems(newList); // finally add data to tableview
    }

    private void Insert_main() {
        //initialize new table column
        tableClass = new TableColumn("반");
        tableId = new TableColumn("번호");
        tableName = new TableColumn("이름");
        tableKor = new TableColumn("국어");
        tableEng = new TableColumn("영어");
        tableMath = new TableColumn("수학");
        tableSoc = new TableColumn("사회");
        tableSci = new TableColumn("과학");
        tableMus = null;
        tableArt = null;
        tableSpo = null;
        tableAvg = new TableColumn("평균");
        tableRank = new TableColumn("석차");


        //set the table column
        tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableClass.setCellValueFactory(cellData -> cellData.getValue().class_numProperty().asObject());
        tableId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tableKor.setCellValueFactory(cellData -> cellData.getValue().korProperty().asObject());
        tableEng.setCellValueFactory(cellData -> cellData.getValue().engProperty().asObject());
        tableMath.setCellValueFactory(cellData -> cellData.getValue().mathProperty().asObject());
        tableSoc.setCellValueFactory(cellData -> cellData.getValue().socProperty().asObject());
        tableSci.setCellValueFactory(cellData -> cellData.getValue().sciProperty().asObject());
        tableAvg.setCellValueFactory(cellData -> cellData.getValue().avgProperty().asObject());
        tableRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());

        //tableView.getItems().clear();
        tableView.getColumns().addAll(tableClass, tableId, tableName, tableKor, tableEng, tableMath, tableSoc, tableSci,tableAvg,tableRank);
        /*tableView를 세팅하고 세팅된 값을 받아서 rank를 설정한 뒤 다시 tableView 세팅*/
        tableView.setItems(newList); // finally add data to tableview
        int[] rank = getRank();
        float[] avg = getAvg();
        for(int i=0; i<newList.size(); i++){
            newList.get(i).setRank(rank[i]);
            newList.get(i).setAvg(avg[i]);
        }
        primaryTableList=newList;
        tableView.setItems(newList); // finally add data to tableview
    }

    private void Insert_kem() {
        //initialize new table column
        tableClass = new TableColumn("반");
        tableId = new TableColumn("번호");
        tableName = new TableColumn("이름");
        tableKor = new TableColumn("국어");
        tableEng = new TableColumn("영어");
        tableMath = new TableColumn("수학");
        tableSoc = null;
        tableSci = null;
        tableMus = null;
        tableArt = null;
        tableSpo = null;
        tableAvg = new TableColumn("평균");
        tableRank = new TableColumn("석차");

        //set the table column
        tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableClass.setCellValueFactory(cellData -> cellData.getValue().class_numProperty().asObject());
        tableId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tableKor.setCellValueFactory(cellData -> cellData.getValue().korProperty().asObject());
        tableEng.setCellValueFactory(cellData -> cellData.getValue().engProperty().asObject());
        tableMath.setCellValueFactory(cellData -> cellData.getValue().mathProperty().asObject());
        tableAvg.setCellValueFactory(cellData -> cellData.getValue().avgProperty().asObject());
        tableRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());


        //tableView.getItems().clear();
        tableView.getColumns().addAll(tableClass, tableId, tableName, tableKor, tableEng, tableMath,tableAvg,tableRank);
        tableView.setItems(newList); // finally add data to tableview
        int[] rank = getRank();
        float[] avg = getAvg();
        for(int i=0; i<newList.size(); i++){
            newList.get(i).setRank(rank[i]);
            newList.get(i).setAvg(avg[i]);
        }
        primaryTableList=newList;
        tableView.setItems(newList); // finally add data to tableview
    }

    private void Insert_ms() {
        //initialize new table column
        tableClass = new TableColumn("반");
        tableId = new TableColumn("번호");
        tableName = new TableColumn("이름");
        tableMath = new TableColumn("수학");
        tableSci = new TableColumn("과학");
        tableKor = null;
        tableEng = null;
        tableSoc = null;
        tableMus = null;
        tableArt = null;
        tableSpo = null;
        tableAvg = new TableColumn("평균");
        tableRank = new TableColumn("석차");

        //set the table column
        tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableClass.setCellValueFactory(cellData -> cellData.getValue().class_numProperty().asObject());
        tableId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tableMath.setCellValueFactory(cellData -> cellData.getValue().mathProperty().asObject());
        tableSci.setCellValueFactory(cellData -> cellData.getValue().sciProperty().asObject());

        tableAvg.setCellValueFactory(cellData -> cellData.getValue().avgProperty().asObject());
        tableRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());

        //tableView.getItems().clear();
        tableView.getColumns().addAll(tableClass, tableId, tableName, tableMath, tableSci,tableAvg,tableRank);

        tableView.setItems(newList); // finally add data to tableview
        int[] rank = getRank();
        float[] avg = getAvg();
        for(int i=0; i<newList.size(); i++){
            newList.get(i).setRank(rank[i]);
            newList.get(i).setAvg(avg[i]);
        }
        primaryTableList=newList;
        tableView.setItems(newList); // finally add data to tableview
    }

    private void Insert_eng() {
        //initialize new table column
        tableClass = new TableColumn("반");
        tableId = new TableColumn("번호");
        tableName = new TableColumn("이름");
        tableEng = new TableColumn("영어");
        tableKor = null;
        tableMath = null;
        tableSci = null;
        tableSoc = null;
        tableMus = null;
        tableArt = null;
        tableSpo = null;
        tableAvg = new TableColumn("평균");
        tableRank = new TableColumn("석차");

        tableName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableClass.setCellValueFactory(cellData -> cellData.getValue().class_numProperty().asObject());
        tableId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tableEng.setCellValueFactory(cellData -> cellData.getValue().engProperty().asObject());
        tableAvg.setCellValueFactory(cellData -> cellData.getValue().avgProperty().asObject());
        tableRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());

        //tableView.getItems().clear();
        tableView.getColumns().addAll(tableClass, tableId, tableName, tableEng,tableAvg,tableRank);

        tableView.setItems(newList); // finally add data to tableview
        int[] rank = getRank();
        float[] avg = getAvg();
        for(int i=0; i<newList.size(); i++){
            newList.get(i).setRank(rank[i]);
            newList.get(i).setAvg(avg[i]);
        }
        primaryTableList=newList;
        tableView.setItems(newList); // finally add data to tableview
    }


    private void dataInit() {
        student_number.setText(data.size()+"");
        for (int i = 0; i < data.size(); i++) {
            //myList.add(data.get(i));
            newList.add(new ScoreData(data.get(i).getClass_num(), data.get(i).getId(), data.get(i).getName(), data.get(i).getKor(),
                    data.get(i).getEng(), data.get(i).getMath(), data.get(i).getSoc(), data.get(i).getSci(), data.get(i).getMus(), data.get(i).getArt(),
                    data.get(i).getSpo()));
        }
    }


    //TABLE VALUE GETTER
    private ObservableList<ScoreData> getTableItem() {
        ScoreData getData = new ScoreData();
        List<List<String>> arrList = new ArrayList<>();
        ObservableList<ScoreData> obList = FXCollections.observableArrayList();
        int[] rank = getRank();

        for (int i = 0; i < tableView.getItems().size(); i++) {
            getData = tableView.getItems().get(i);
            obList.add(new ScoreData());
            obList.get(i).setClass_num(getData.getClass_num());
            obList.get(i).setId(getData.getId());
            obList.get(i).setName(getData.getName());
            if (tableKor != null)
                obList.get(i).setKor(getData.getKor());
            if (tableEng != null)
                obList.get(i).setEng(getData.getEng());
            if (tableMath != null)
                obList.get(i).setMath(getData.getMath());
            if (tableSoc != null)
                obList.get(i).setSoc(getData.getSoc());
            if (tableSci != null)
                obList.get(i).setSci(getData.getSci());
            if (tableMus != null)
                obList.get(i).setMus(getData.getMus());
            if (tableArt != null)
                obList.get(i).setArt(getData.getArt());
            if (tableSpo != null)
                obList.get(i).setSpo(getData.getSpo());
            obList.get(i).setAvg(getData.getAvg());
            obList.get(i).setRank(rank[i]);
        }

        return obList;
    }

    private int[] getRank() {
        ScoreData prevData = new ScoreData();
        ScoreData nextData = new ScoreData();
        float prevSum=0;
        float nextSum=0;
        int[] rank = new int[tableView.getItems().size()];

        for (int i = 0; i < tableView.getItems().size(); i++) {
            rank[i] = 1;
            for (int j = 0; j < tableView.getItems().size(); j++) {
                prevData = tableView.getItems().get(i);
                nextData = tableView.getItems().get(j);
                if(tableKor!=null) {
                    prevSum += prevData.getKor();
                    nextSum += nextData.getKor();
                }
                if(tableEng!=null) {
                    prevSum += prevData.getEng();
                    nextSum += nextData.getEng();

                }
                if(tableMath!=null) {
                    prevSum += prevData.getMath();
                    nextSum += nextData.getMath();
                }
                if(tableSoc!=null) {
                    prevSum += prevData.getSoc();
                    nextSum += nextData.getSoc();
                }
                if(tableSci!=null) {
                    prevSum += prevData.getSci();
                    nextSum += nextData.getSci();
                }
                if(tableMus!=null) {
                    prevSum += prevData.getMus();
                    nextSum += nextData.getMus();
                }
                if(tableArt!=null) {
                    prevSum += prevData.getArt();
                    nextSum += nextData.getArt();
                }
                if(tableSpo!=null) {
                    prevSum += prevData.getSpo();
                    nextSum += nextData.getSpo();
                }

                if (prevSum < nextSum) {
                    rank[i]++;
                }
                nextSum=0;
                prevSum=0;
            }
        }
        return rank;
    }

    private float[] getAvg(){
        float[] avg=new float[tableView.getItems().size()];
        ScoreData prevData = new ScoreData();
        float prevSum=0;
        int subject_num=0;
        for (int i = 0; i < tableView.getItems().size(); i++) {
            prevData = tableView.getItems().get(i);
            if(tableKor!=null) {
                prevSum += prevData.getKor();
                subject_num++;
            }
            if(tableEng!=null) {
                prevSum += prevData.getEng();
                subject_num++;
            }
            if(tableMath!=null) {
                prevSum += prevData.getMath();
                subject_num++;
            }
            if(tableSoc!=null) {
                prevSum += prevData.getSoc();
                subject_num++;
            }
            if(tableSci!=null) {
                prevSum += prevData.getSci();
                subject_num++;
            }
            if(tableMus!=null) {
                prevSum += prevData.getMus();
                subject_num++;
            }
            if(tableArt!=null) {
                prevSum += prevData.getArt();
                subject_num++;
            }
            if(tableSpo!=null) {
                prevSum += prevData.getSpo();
                subject_num++;
            }
            avg[i]=prevSum/subject_num;
            prevSum=0;
            subject_num=0;
        }
        return avg;
    }

    private void getUpValue(int percent, List<ScoreData> list){
        ObservableList<ScoreData> resultList = FXCollections.observableArrayList();
        int student_num =(list.size()*percent)/100;
        Collections.sort(list);
        for(int i=0; i<student_num; i++)
            resultList.add(list.get(i));
        tableView.setItems(resultList);
    }

    private void getDownValue(int percent, List<ScoreData> list){
        ObservableList<ScoreData> resultList = FXCollections.observableArrayList();
        int student_num =(list.size()*percent)/100;
        Collections.sort(list);
        for(int i=list.size(); i>list.size()-student_num; i--)
            resultList.add(list.get(i-1));
        tableView.setItems(resultList);
    }

    private void getAlertDialog(Exception e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(null);
        if(e instanceof IndexOutOfBoundsException) //instance of : 예외처리 비교
            alert.setContentText("표시된 정보가 없습니다.\n표시할 과목을 선택해주세요.");
        else if(e instanceof  NumberFormatException) //instance of : 예외처리 비교
            alert.setContentText("빈 값 혹은 0~100을 벗어난 값을 입력했습니다.\n표시할 과목을 선택해주세요.");
        alert.showAndWait();
    }

}

