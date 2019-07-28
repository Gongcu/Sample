package sample.data;

public class PrimaryData {
    private static String selectedFileName;

    public PrimaryData(){}
    public PrimaryData(String name){this.selectedFileName=name;}
    public static String getSelectedFileName() {
        return selectedFileName;
    }

    public static void setSelectedFileName(String selectedFileName) {
        selectedFileName = selectedFileName;
    }
}
