package model.vo;

public class Consulta2VO_19 {
    
    private Integer idProyecto;
    private Integer areaMaxima;

    public Consulta2VO_19(){}

    public Consulta2VO_19(Integer idProyecto, Integer areaMaxima){
        this.idProyecto = idProyecto;
        this.areaMaxima = areaMaxima;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public void setAreaMaxima(Integer areaMaxima){
        this.areaMaxima =  areaMaxima;
    }

    public Integer getIdProeycto(){
        return this.idProyecto;
    }
    public Integer getAreaMaxima(){
        return this.areaMaxima;
    }
}
