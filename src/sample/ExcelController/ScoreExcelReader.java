package sample.ExcelController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.data.ScoreData;


public class ScoreExcelReader {

    @SuppressWarnings("resource")
    public List<ScoreData> xlsToCustomerVoList(String filePath) {

        // 반환할 객체를 생성
        List<ScoreData> list = new ArrayList<ScoreData>();

        FileInputStream fis = null;
        HSSFWorkbook workbook = null;

        try {
            fis= new FileInputStream(filePath);
            // HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
            workbook = new HSSFWorkbook(fis);

            // 탐색에 사용할 Sheet, Row, Cell 객체
            HSSFSheet curSheet;
            HSSFRow   curRow;
            HSSFCell  curCell;
            ScoreData vo;

            // Sheet 탐색 for문
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                // 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                    // row 0은 헤더정보이기 때문에 무시
                    if(rowIndex != 0) {
                        // 현재 row 반환
                        curRow = curSheet.getRow(rowIndex);
                        vo = new ScoreData();
                        String value;

                        // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                        if(!"".equals(curRow.getCell(0).getStringCellValue())) {

                            // cell 탐색 for 문
                            for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                                curCell = curRow.getCell(cellIndex);

                                if(true) {
                                    value = "";
                                    // cell 스타일이 다르더라도 String으로 반환 받음
                                    switch (curCell.getCellType()){
                                        case FORMULA:
                                            value = curCell.getCellFormula();
                                            break;
                                        case NUMERIC:
                                            value = curCell.getNumericCellValue()+"";
                                            break;
                                        case STRING:
                                            value = curCell.getStringCellValue()+"";
                                            break;
                                        case BLANK:
                                            value = curCell.getBooleanCellValue()+"";
                                            break;
                                        case ERROR:
                                            value = curCell.getErrorCellValue()+"";
                                            break;
                                        default:
                                            value = new String();
                                            break;
                                    }

                                    // 현재 column index에 따라서 vo에 입력
                                    switch (cellIndex) {
                                        case 0: // 번호
                                            vo.setId((int)Float.parseFloat(value));;
                                            break;

                                        case 1: // 반
                                            vo.setClass_num((int)Float.parseFloat(value));;
                                            break;

                                        case 2: // 이름
                                            vo.setName(value);
                                            break;

                                        case 3: // 국어
                                            vo.setKor(Float.parseFloat(value));
                                            break;
                                        case 4: // 영어
                                            vo.setEng(Float.parseFloat(value));
                                            break;
                                        case 5: // 수학
                                            vo.setMath(Float.parseFloat(value));
                                            break;
                                        case 6: // 사회
                                            vo.setSoc(Float.parseFloat(value));
                                            break;
                                        case 7: // 과학
                                            vo.setSci(Float.parseFloat(value));
                                            break;
                                        case 8: // 음악
                                            vo.setMus(Float.parseFloat(value));
                                            break;
                                        case 9: // 미술
                                            vo.setArt(Float.parseFloat(value));
                                            break;
                                        case 10: // 체육
                                            vo.setSpo(Float.parseFloat(value));
                                            break;

                                        default:
                                            break;
                                    }
                                }
                            }
                            // cell 탐색 이후 vo 추가
                            list.add(vo);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if( workbook!= null) workbook.close();
                if( fis!= null) fis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * XLSX 파일을 분석하여 List<CustomerVo> 객체로 반환
     * @param filePath
     * @return
     */
    public List<ScoreData> xlsxToCustomerVoList(String filePath) {
        // 반환할 객체를 생성
        List<ScoreData> list = new ArrayList<ScoreData>();

        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        try {

            fis= new FileInputStream(filePath);
            // HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
            workbook = new XSSFWorkbook(fis);

            // 탐색에 사용할 Sheet, Row, Cell 객체
            XSSFSheet curSheet;
            XSSFRow   curRow;
            XSSFCell  curCell;
            ScoreData vo;

            // Sheet 탐색 for문
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                // 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                    // row 0은 헤더정보이기 때문에 무시
                    if(rowIndex==0) {
                        curRow = curSheet.getRow(0);
                        vo = new ScoreData();
                        String value;
                        for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
                            curCell = curRow.getCell(cellIndex);

                            if (true) {
                                value = "";
                                // cell 스타일이 다르더라도 String으로 반환 받음
                                switch (curCell.getCellType()) {
                                    case FORMULA: {
                                        value = curCell.getCellFormula() + "";
                                        break;
                                    }
                                    case NUMERIC: {
                                        value = curCell.getNumericCellValue() + "";
                                        break;
                                    }
                                    case STRING: {
                                        value = curCell.getStringCellValue() + "";
                                        break;
                                    }
                                    case BLANK: {
                                        value = curCell.getBooleanCellValue() + "";
                                        break;
                                    }
                                    case ERROR: {
                                        value = curCell.getErrorCellValue() + "";
                                        break;
                                    }
                                    default: {
                                        value = new String() + "";
                                        break;
                                    }
                                }
                                // 현재 column index에 따라서 vo에 입력
                                if (value.equals("국어")) {
                                    vo.setKorHeader(true);
                                    continue;
                                }
                                else if (value.equals("영어")) {
                                    vo.setEngHeader(true);
                                    continue;
                                }
                                else if (value.equals("수학")) {
                                    vo.setMathHeader(true);
                                    continue;
                                }
                                else if (value.equals("사회")) {
                                    vo.setSocHeader(true);
                                    continue;
                                }
                                else if (value.equals("과학")) {
                                    vo.setSciHeader(true);
                                    continue;
                                }
                                else if (value.equals("음악")) {
                                    vo.setMusHeader(true);
                                    continue;
                                }
                                else if (value.equals("미술")) {
                                    vo.setArtHeader(true);
                                    continue;
                                }
                                else if (value.equals("체육")) {
                                    vo.setSpoHeader(true);
                                    continue;
                                }
                            }
                        }
                    }

                    //헤더 정보 이후 실제 값의 추가
                    if(rowIndex != 0) {
                        // 현재 row 반환
                        curRow = curSheet.getRow(rowIndex);
                        vo = new ScoreData();
                        String value;

                        // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                        if(!"".equals(curRow.getCell(0).getNumericCellValue())) {


                            // cell 탐색 for 문
                            for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                                curCell = curRow.getCell(cellIndex);

                                if(true) {
                                    value = "";
                                    // cell 스타일이 다르더라도 String으로 반환 받음
                                    switch (curCell.getCellType()){
                                        case FORMULA:
                                            value = curCell.getCellFormula()+"";
                                            break;
                                        case NUMERIC:
                                            value = curCell.getNumericCellValue()+"";
                                            break;
                                        case STRING:
                                            value = curCell.getStringCellValue()+"";
                                            break;
                                        case BLANK:
                                            value = curCell.getBooleanCellValue()+"";
                                            break;
                                        case ERROR:
                                            value = curCell.getErrorCellValue()+"";
                                            break;
                                        default:
                                            value = new String()+"";
                                            break;
                                    } //curSheet.getRow(0).getCell(cellIndex).equal("과목명")
                                // 현재 column index에 따라서 vo에 입력
                                    /*
                                    switch (cellIndex) {
                                        case 0: // 번호
                                            vo.setId(Float.parseFloat(value));
                                            break;
                                        case 1: // 반
                                            vo.setClass_num(Float.parseFloat(value));;
                                            break;
                                        case 2: // 이름
                                            vo.setName(value);
                                            break;
                                        case 3: // 국어
                                            vo.setKor(Float.parseFloat(value));
                                            break;
                                        case 4: // 영어
                                            vo.setEng(Float.parseFloat(value));
                                            break;
                                        case 5: // 수학
                                            vo.setMath(Float.parseFloat(value));
                                            break;
                                        case 6: // 사회
                                            vo.setSoc(Float.parseFloat(value));
                                            break;
                                        case 7: // 과학
                                            vo.setSci(Float.parseFloat(value));
                                            break;
                                        case 8: // 음악
                                            vo.setMus(Float.parseFloat(value));
                                            break;
                                        case 9: // 미술
                                            vo.setArt(Float.parseFloat(value));
                                            break;
                                        case 10: // 체육
                                            vo.setSpo(Float.parseFloat(value));
                                            break;
                                        default:
                                            break;
                                    }*/
                                    if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("반")) {
                                        vo.setClass_num((int)Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("번호")) {
                                        vo.setId((int)Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("이름")) {
                                        vo.setName(value);
                                        continue;
                                    }
                                    if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("국어")) {
                                        vo.setKor(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("영어")) {
                                        vo.setEng(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("수학")) {
                                        vo.setMath(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("사회")) {
                                        vo.setSoc(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("과학")) {
                                        vo.setSci(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("음악")) {
                                        vo.setMus(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("미술")) {
                                        vo.setArt(Float.parseFloat(value));
                                        continue;
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("체육")) {
                                        vo.setSpo(Float.parseFloat(value));
                                        continue;
                                    }
                                    /*
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("기술가정")) {
                                        vo.setEng(Float.parseFloat(value));
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("정보")) {
                                        vo.setEng(Float.parseFloat(value));
                                    }
                                    else if(curSheet.getRow(0).getCell(cellIndex).getStringCellValue().equals("도덕")) {
                                        vo.setEng(Float.parseFloat(value));
                                    }*/
                                }
                            }
                            // cell 탐색 이후 vo 추가
                            list.add(vo);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if( workbook!= null) workbook.close();
                if( fis!= null) fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
/*
    public void SubjectFinder(){
        List<ScoreData> list = new ArrayList<ScoreData>();

        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        fis= new FileInputStream(filePath);
        // HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
        workbook = new XSSFWorkbook(fis);

        // 탐색에 사용할 Sheet, Row, Cell 객체
        XSSFSheet curSheet;
        XSSFRow   curRow;
        XSSFCell  curCell;
        ScoreData vo;

            // Sheet 탐색 for문
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                // 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);

                // row 0은 헤더정보
                curRow = curSheet.getRow(0);
                vo = new ScoreData();
                String value;

                // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                if(!"".equals(curRow.getCell(0).getNumericCellValue())) {
                    // cell 탐색 for 문
                    for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                        curCell = curRow.getCell(cellIndex);

                        if(true) {
                            value = "";
                            // cell 스타일이 다르더라도 String으로 반환 받음
                            switch (curCell.getCellType()){
                                case FORMULA:{
                                    value = curCell.getCellFormula()+"";
                                    break;
                                }
                                case NUMERIC:{
                                    value = curCell.getNumericCellValue()+"";
                                    break;
                                }
                                case STRING:{
                                    value = curCell.getStringCellValue()+"";
                                    break;
                                }
                                case BLANK:{
                                    value = curCell.getBooleanCellValue()+"";
                                    break;
                                }
                                case ERROR:{
                                    value = curCell.getErrorCellValue()+"";
                                    break;
                                }
                                default:{
                                    value = new String()+"";
                                    break;
                                }
                            }
                                    // 현재 column index에 따라서 vo에 입력
                            if(value.equals("국어"))
                                vo.setKorHeader(true);
                            else if(value.equals("영어"))
                                vo.setEngHeader(true);
                            else if(value.equals("수학"))
                                vo.setMathHeader(true);
                            else if(value.equals("사회"))
                                vo.setSocHeader(true);
                            else if(value.equals("과학"))
                                vo.setSciHeader(true);
                            else if(value.equals("음악"))
                                vo.setMusHeader(true);
                            else if(value.equals("미술"))
                                vo.setArtHeader(true);
                            else if(value.equals("체육"))
                                vo.setSpoHeader(true);

                        }
                    }
                            // cell 탐색 이후 vo 추가
                    list.add(vo);
                }
            }
    }*/
}
