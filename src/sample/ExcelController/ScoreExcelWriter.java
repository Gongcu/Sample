package sample.ExcelController;
import java.io.*;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.data.ScoreData;


public class ScoreExcelWriter {

    public static void xlsWriter(ObservableList<ScoreData> list) {
        // 워크북 생성
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 워크시트 생성
        HSSFSheet sheet = workbook.createSheet();
        // 행 생성
        HSSFRow row = sheet.createRow(0);
        // 쎌 생성
        HSSFCell cell;

        // 헤더 정보 구성
        cell = row.createCell(0);
        cell.setCellValue("반");

        cell = row.createCell(1);
        cell.setCellValue("번호");

        cell = row.createCell(2);
        cell.setCellValue("이름");

        int column_index = 3;

        if (list.get(0).isKorHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("국어");
            column_index++;
        }
        if (list.get(0).isEngHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("영어");
            column_index++;
        }
        if (list.get(0).isMathHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("수학");
            column_index++;
        }
        if (list.get(0).isSocHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("사회");
            column_index++;
        }
        if (list.get(0).isSciHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("과학");
            column_index++;
        }
        if (list.get(0).isMusHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("음악");
            column_index++;
        }
        if (list.get(0).isArtHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("미술");
            column_index++;
        }
        if (list.get(0).isSpoHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("체육");
            column_index++;
        }
        cell = row.createCell(column_index);
        cell.setCellValue("평균");
        column_index++;

        cell = row.createCell(column_index);
        cell.setCellValue("석차");
        //column_index++;

        // 리스트의 size 만큼 row를 생성
        ScoreData vo;
        for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
            // 행 생성
            row = sheet.createRow(rowIdx + 1);

            cell = row.createCell(0);
            cell.setCellValue(vo.getClass_num());

            cell = row.createCell(1);
            cell.setCellValue(vo.getId());

            cell = row.createCell(2);
            cell.setCellValue(vo.getName());

            column_index = 3;

            if (list.get(rowIdx).isKorHeader() != false) { //기존 list.get(rowIdx).korProperty() != null 에서 변경, 열이 있는 경우에 추가
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getKor());
                column_index++;
            }
            if (list.get(rowIdx).isEngHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getEng());
                column_index++;
            }
            if (list.get(rowIdx).isMathHeader() !=false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getMath());
                column_index++;
            }
            if (list.get(rowIdx).isSocHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSoc());
                column_index++;
            }
            if (list.get(rowIdx).isSciHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSci());
                column_index++;
            }
            if (list.get(rowIdx).isMusHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getMus());
                column_index++;
            }
            if (list.get(rowIdx).isArtHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getArt());
                column_index++;
            }
            if (list.get(rowIdx).isSpoHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSpo());
                column_index++;
            }
            cell = row.createCell(column_index);
            cell.setCellValue(vo.getAvg());
            column_index++;
            cell = row.createCell(column_index);
            cell.setCellValue(vo.getRank());
            column_index++;
        }

            // 입력된 내용 파일로 쓰기
        File file = new File("C:\\excel\\testWrite.xls");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public void xlsxWiter (ObservableList < ScoreData > list) {
        // 워크북 생성
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 워크시트 생성
        XSSFSheet sheet = workbook.createSheet();
        // 행 생성
        XSSFRow row = sheet.createRow(0);
        // 쎌 생성
        XSSFCell cell;

        // 헤더 정보 구성
        cell = row.createCell(0);
        cell.setCellValue("반");

        cell = row.createCell(1);
        cell.setCellValue("번호");

        cell = row.createCell(2);
        cell.setCellValue("이름");
        System.out.println("         "+list.get(0).isKorHeader());
        int column_index = 3;
        //for (int i = 0; i < COLUMN_NUMBER; i++) {
        if (list.get(0).isKorHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("국어");
            column_index++;
        }
        if (list.get(0).isEngHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("영어");
            column_index++;
        }
        if (list.get(0).isMathHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("수학");
            column_index++;
        }
        if (list.get(0).isSocHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("사회");
            column_index++;
        }
        if (list.get(0).isSciHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("과학");
            column_index++;
        }
        if (list.get(0).isMusHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("음악");
            column_index++;
        }
        if (list.get(0).isArtHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("미술");
            column_index++;
        }
        if (list.get(0).isSpoHeader() != false) {
            cell = row.createCell(column_index);
            cell.setCellValue("체육");
            column_index++;
        }
        cell = row.createCell(column_index);
        cell.setCellValue("평균");
        column_index++;
        cell = row.createCell(column_index);
        cell.setCellValue("석차");
        //column_index++;
      //  }


            // 리스트의 size 만큼 row를 생성
        ScoreData vo;
        for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
                // 행 생성
            row = sheet.createRow(rowIdx + 1);

            cell = row.createCell(0);
            cell.setCellValue(vo.getClass_num());

            cell = row.createCell(1);
            cell.setCellValue(vo.getId());

            cell = row.createCell(2);
            cell.setCellValue(vo.getName());

            column_index = 3;

            if (list.get(rowIdx).isKorHeader() != false) { //기존 list.get(rowIdx).korProperty() != null 에서 변경, 열이 있는 경우에 추가
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getKor());
                column_index++;
            }
            if (list.get(rowIdx).isEngHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getEng());
                column_index++;
            }
            if (list.get(rowIdx).isMathHeader() !=false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getMath());
                column_index++;
            }
            if (list.get(rowIdx).isSocHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSoc());
                column_index++;
            }
            if (list.get(rowIdx).isSciHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSci());
                column_index++;
            }
            if (list.get(rowIdx).isMusHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getMus());
                column_index++;
            }
            if (list.get(rowIdx).isArtHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getArt());
                column_index++;
            }
            if (list.get(rowIdx).isSpoHeader() != false) {
                cell = row.createCell(column_index);
                cell.setCellValue(vo.getSpo());
                column_index++;
            }
            cell = row.createCell(column_index);
            cell.setCellValue(vo.getAvg());
            column_index++;
            cell = row.createCell(column_index);
            cell.setCellValue(vo.getRank());
            column_index++;
        }

            // 입력된 내용 파일로 쓰기
            FileOutputStream fos = null;

            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Excel file", "*.xlsx","*.xls"),
                    new FileChooser.ExtensionFilter("All file", "*.*")
            );
            File file = fileChooser.showSaveDialog(new Stage());

            try {
                fos = new FileOutputStream(file);
                workbook.write(fos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (workbook != null) workbook.close();
                    if (fos != null) fos.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }

}

