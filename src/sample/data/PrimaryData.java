package sample.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PrimaryData {
    private static String selectedFileName;
    private static String ext;


    public PrimaryData(){}
    public PrimaryData(String name, String ext){this.selectedFileName=name; this.ext=ext;}
    public static String getSelectedFileName() {
        return selectedFileName;
    }

    public static void setSelectedFileName(String selectedFileName) {
        selectedFileName = selectedFileName;
    }

    public static String getExt() {
        return ext;
    }

    public static void setExt(String ext) {
        PrimaryData.ext = ext;
    }
}
