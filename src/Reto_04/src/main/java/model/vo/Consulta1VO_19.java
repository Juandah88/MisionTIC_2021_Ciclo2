package model.vo;

public class Consulta1VO_19 {
    
    private Integer iD_Proyecto;
    private String fecha_Inicio;
    private String constructora;
    private String serial;

    public Consulta1VO_19(){

    }

    public Consulta1VO_19(Integer id
    , String fecha
    , String constructora
    , String serial){
        this.iD_Proyecto = id;
        this.fecha_Inicio = fecha;
        this.constructora = constructora;
        this.serial = serial;

    }

    public void setId( Integer id){
        this.iD_Proyecto = id;
    }

    public void setFecha(String fecha){
        this.fecha_Inicio = fecha;
    }

    public void setConstructora(String constructora){
        this.constructora = constructora;
    }

    public void setSerial(String  serial){
        this.serial = serial;
    }

    public Integer getId(){return this.iD_Proyecto;}

    public String getFecha(){return this.fecha_Inicio;}

    public String getConstructora(){return this.constructora;}

    public String getSerial(){return this.serial;}
}
