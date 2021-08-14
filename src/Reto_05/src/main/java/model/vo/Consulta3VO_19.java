package model.vo;

public class Consulta3VO_19 {

    private Integer idProyecto;
    private String nombreApellido;

    public Consulta3VO_19(){}

    public Consulta3VO_19(Integer idProyecto, String nombreApellido){
        this.idProyecto = idProyecto;
        this.nombreApellido = nombreApellido;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public void setNombreApellido(String nombreApellido){
        this.nombreApellido = nombreApellido;
    }

    public Integer getIdProyecto(){return this.idProyecto;  }

    public String getNombreAppellido(){return this.nombreApellido; }
}
