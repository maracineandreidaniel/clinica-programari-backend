package Model;

import java.time.LocalDateTime;

public class Programare  {
    private int id;
    private String client;
    private String medic;
    private LocalDateTime data;

    public Programare(int id, String c, String m, String d){
        this.id=id;
        this.client=c;
        this.medic=m;
        this.data=convertStringToLocalDateTime(d);
    }

    public Programare( String c, String m, String d){
        this.client=c;
        this.medic=m;
        this.data=convertStringToLocalDateTime(d);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public static String convertLDTtoStringTFormat(LocalDateTime ldt){
        return String.format("%s",ldt);
    }

    public static String fromDBToParameterConvert(String data){
        String dataF="";
        String[] p1=data.split("T");
        String[] p2=p1[0].split("-");
        String[] p3=p1[1].split(":");
        dataF+=p2[2]+","+p2[1]+","+p2[0]+","+p3[0]+","+p3[1];
        return dataF;
    }

    public static LocalDateTime convertStringToLocalDateTime(String data){
        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);
        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }

    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", medic='" + medic + '\'' +
                ", data=" + data +
                '}';
    }
}
