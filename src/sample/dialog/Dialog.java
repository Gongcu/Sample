package sample.dialog;

import javafx.fxml.LoadException;
import javafx.scene.control.Alert;

public class Dialog {
    public static void getDialog(Exception e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(null);
        if(e instanceof IndexOutOfBoundsException) //instance of : 예외처리 비교
            alert.setContentText("표시된 정보가 없습니다.\n표시할 과목을 선택해주세요.");
        else if(e instanceof  NumberFormatException) //instance of : 예외처리 비교
            alert.setContentText("빈 값 혹은 0~100을 벗어난 값을 입력했습니다.\n표시할 과목을 선택해주세요.");
        else if (e instanceof LoadException)
            alert.setContentText("Excel 파일을 로드해주세요");
        alert.showAndWait();
    }
}
