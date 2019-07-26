package sample.data;

import javafx.beans.property.*;

public class ScoreData implements Comparable<ScoreData>{
    private final IntegerProperty class_num;
    private final IntegerProperty id;
    private final SimpleStringProperty name;
    private final FloatProperty kor;
    private final FloatProperty eng;
    private final FloatProperty math;
    private final FloatProperty soc;
    private final FloatProperty sci;
    private final FloatProperty mus;
    private final FloatProperty art;
    private final FloatProperty spo;
    private final FloatProperty avg;
    private final IntegerProperty rank;

    private final BooleanProperty korHeader;
    private final BooleanProperty engHeader;
    private final BooleanProperty mathHeader;
    private final BooleanProperty socHeader;
    private final BooleanProperty sciHeader;
    private final BooleanProperty musHeader;
    private final BooleanProperty artHeader;
    private final BooleanProperty spoHeader;

    //object라 null을 넣으면 안되고 new로 obj 전부 생성
    public ScoreData(){
        this.class_num = new SimpleIntegerProperty();
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.kor = new SimpleFloatProperty();
        this.eng = new SimpleFloatProperty();
        this.math = new SimpleFloatProperty();
        this.soc = new SimpleFloatProperty();
        this.sci = new SimpleFloatProperty();
        this.mus = new SimpleFloatProperty();
        this.art = new SimpleFloatProperty();
        this.spo = new SimpleFloatProperty();
        this.avg = new SimpleFloatProperty();
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public ScoreData(int class_num, int id, String name, float kor, float eng, float math, float soc, float sci, float mus, float art, float spo) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty(kor);
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty(soc);
        this.sci = new SimpleFloatProperty(sci);
        this.mus = new SimpleFloatProperty(mus);
        this.art = new SimpleFloatProperty(art);
        this.spo = new SimpleFloatProperty(spo);
        this.avg = new SimpleFloatProperty((kor+eng+math+soc+sci+mus+art+spo)/8);
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public ScoreData(int class_num, int id, String name, float kor, float eng, float math, float soc, float sci, float mus, float art, float spo, float avg, int rank) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty(kor);
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty(soc);
        this.sci = new SimpleFloatProperty(sci);
        this.mus = new SimpleFloatProperty(mus);
        this.art = new SimpleFloatProperty(art);
        this.spo = new SimpleFloatProperty(spo);
        this.avg = new SimpleFloatProperty((avg));
        this.rank = new SimpleIntegerProperty(rank);

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public ScoreData(int class_num, int id, String name, float kor, float eng, float math, float soc, float sci, float mus, float art, float spo,int rank) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty(kor);
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty(soc);
        this.sci = new SimpleFloatProperty(sci);
        this.mus = new SimpleFloatProperty(mus);
        this.art = new SimpleFloatProperty(art);
        this.spo = new SimpleFloatProperty(spo);
        this.avg = new SimpleFloatProperty((kor+eng+math+soc+sci+mus+art+spo)/8);
        this.rank = new SimpleIntegerProperty(rank);

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public ScoreData(int class_num, int id, String name, float kor, float eng, float math, float soc, float sci) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty(kor);
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty(soc);
        this.sci = new SimpleFloatProperty(sci);
        this.mus = new SimpleFloatProperty();
        this.art = new SimpleFloatProperty();
        this.spo = new SimpleFloatProperty();
        this.avg = new SimpleFloatProperty((kor+eng+math+soc+sci)/5);
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }
    public ScoreData(int class_num, int id, String name, float kor, float eng, float math) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty(kor);
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty();
        this.sci = new SimpleFloatProperty();
        this.mus = new SimpleFloatProperty();
        this.art = new SimpleFloatProperty();
        this.spo = new SimpleFloatProperty();
        this.avg = new SimpleFloatProperty((kor+eng+math)/3);
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }
    public ScoreData(int class_num, int id, String name,float math,float sci) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty();
        this.eng = new SimpleFloatProperty();
        this.math = new SimpleFloatProperty(math);
        this.soc = new SimpleFloatProperty();
        this.sci = new SimpleFloatProperty(sci);
        this.mus = new SimpleFloatProperty();
        this.art = new SimpleFloatProperty();
        this.spo = new SimpleFloatProperty();
        this.avg = new SimpleFloatProperty((sci+math)/2);
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public ScoreData(int class_num, int id, String name,float eng) {
        this.class_num = new SimpleIntegerProperty(class_num);
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.kor = new SimpleFloatProperty();
        this.eng = new SimpleFloatProperty(eng);
        this.math = new SimpleFloatProperty();
        this.soc = new SimpleFloatProperty();
        this.sci = new SimpleFloatProperty();
        this.mus = new SimpleFloatProperty();
        this.art = new SimpleFloatProperty();
        this.spo = new SimpleFloatProperty();
        this.avg = new SimpleFloatProperty(eng);
        this.rank = new SimpleIntegerProperty();

        this.korHeader = new SimpleBooleanProperty();
        this.engHeader = new SimpleBooleanProperty();
        this.mathHeader = new SimpleBooleanProperty();
        this.socHeader = new SimpleBooleanProperty();
        this.sciHeader = new SimpleBooleanProperty();
        this.musHeader = new SimpleBooleanProperty();
        this.artHeader = new SimpleBooleanProperty();
        this.spoHeader = new SimpleBooleanProperty();
    }

    public int getClass_num() {
        return class_num.get();
    }

    public IntegerProperty class_numProperty() {
        return class_num;
    }

    public void setClass_num(int class_num) {
        this.class_num.set(class_num);
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id){
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getKor() {
        return kor.get();
    }

    public FloatProperty korProperty() {
        return kor;
    }

    public void setKor(float kor) {
        this.kor.set(kor);
    }

    public float getEng() {
        return eng.get();
    }

    public FloatProperty engProperty() {
        return eng;
    }

    public void setEng(float eng) {
        this.eng.set(eng);
    }

    public float getMath() {
        return math.get();
    }

    public FloatProperty mathProperty() {
        return math;
    }

    public void setMath(float math) {
        this.math.set(math);
    }

    public float getSoc() {
        return soc.get();
    }

    public FloatProperty socProperty() {
        return soc;
    }

    public void setSoc(float soc) {
        this.soc.set(soc);
    }

    public float getSci() {
        return sci.get();
    }

    public FloatProperty sciProperty() {
        return sci;
    }

    public void setSci(float sci) {
        this.sci.set(sci);
    }

    public float getMus() {
        return mus.get();
    }

    public FloatProperty musProperty() {
        return mus;
    }

    public void setMus(float mus) {
        this.mus.set(mus);
    }

    public float getArt() {
        return art.get();
    }

    public FloatProperty artProperty() {
        return art;
    }

    public void setArt(float art) {
        this.art.set(art);
    }

    public float getSpo() {
        return spo.get();
    }

    public FloatProperty spoProperty() {
        return spo;
    }

    public void setSpo(float spo) {
        this.spo.set(spo);
    }

    public float getAvg() {
        return avg.get();
    }

    public FloatProperty avgProperty() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg.set(avg);
    }

    public int getRank() {
        return rank.get();
    }

    public IntegerProperty rankProperty() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }

    public boolean isKorHeader() {
        return korHeader.get();
    }

    public BooleanProperty korHeaderProperty() {
        return korHeader;
    }

    public void setKorHeader(boolean korHeader) {
        this.korHeader.set(korHeader);
    }

    public boolean isEngHeader() {
        return engHeader.get();
    }

    public BooleanProperty engHeaderProperty() {
        return engHeader;
    }

    public void setEngHeader(boolean engHeader) {
        this.engHeader.set(engHeader);
    }

    public boolean isMathHeader() {
        return mathHeader.get();
    }

    public BooleanProperty mathHeaderProperty() {
        return mathHeader;
    }

    public void setMathHeader(boolean mathHeader) {
        this.mathHeader.set(mathHeader);
    }

    public boolean isSocHeader() {
        return socHeader.get();
    }

    public BooleanProperty socHeaderProperty() {
        return socHeader;
    }

    public void setSocHeader(boolean socHeader) {
        this.socHeader.set(socHeader);
    }

    public boolean isSciHeader() {
        return sciHeader.get();
    }

    public BooleanProperty sciHeaderProperty() {
        return sciHeader;
    }

    public void setSciHeader(boolean sciHeader) {
        this.sciHeader.set(sciHeader);
    }

    public boolean isMusHeader() {
        return musHeader.get();
    }

    public BooleanProperty musHeaderProperty() {
        return musHeader;
    }

    public void setMusHeader(boolean musHeader) {
        this.musHeader.set(musHeader);
    }

    public boolean isArtHeader() {
        return artHeader.get();
    }

    public BooleanProperty artHeaderProperty() {
        return artHeader;
    }

    public void setArtHeader(boolean artHeader) {
        this.artHeader.set(artHeader);
    }

    public boolean isSpoHeader() {
        return spoHeader.get();
    }

    public BooleanProperty spoHeaderProperty() {
        return spoHeader;
    }

    public void setSpoHeader(boolean spoHeader) {
        this.spoHeader.set(spoHeader);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("ID : " + id);
        sb.append("CLASS_NUM : " + class_num);
        sb.append(" ,NAME : " + name);
        sb.append(" ,kor : " + kor);
        sb.append(" ,eng : " + eng);
        sb.append(" ,math : " + math);
        sb.append(" ,soc : " + soc);
        sb.append(" ,sci : " + sci);
        sb.append(" ,mus : " + mus);
        sb.append(" ,art : " + art);
        sb.append(" ,spo : " + spo);
        return sb.toString();
    }

    public float getSum(){
        return (getKor()+getMath()+getEng()+getSoc()+getSci()+getMus()+getArt()+getSpo());
    }

    @Override
    public int compareTo(ScoreData s) {
        if (this.getRank() < s.getRank()) {
            return -1;
        } else if (this.getRank() > s.getRank()) {
            return 1;
        }
        return 0;
    }


}
