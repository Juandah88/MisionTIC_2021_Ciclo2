public class Computador
 {

    private static final double constanteAno = 2019;
    private static final double constantePantalla = 16;
    private static final double constantePrecioBase = 1570500;

    public double ano;
    public double pantalla;
    public double precioBase;

    public double calcularPrecio(){
        return precioBase * (ano/2021) * (pantalla/16) * 1;
    }

    public double getAno(){
        return this.ano;
    }

    public double getPantalla(){
        return this.pantalla;
    }

    public double getPrecioBase(){
        return this.precioBase;
    }

    public Computador(){
        ano = constanteAno;
        precioBase  = constantePrecioBase;
        pantalla = constantePantalla;
    }

    public Computador(double precioBase){
        ano = constanteAno;
        pantalla = constantePantalla;
        this.precioBase = precioBase;
    }

    public Computador(double pantalla , double precioBase){
        ano = constanteAno;
        this.pantalla =  pantalla;
        this.precioBase = precioBase;
    }

    public Computador(double ano ,double pantalla ,double precioBase){
        this.ano = ano;
        this.pantalla =  pantalla;
        this.precioBase = precioBase;
    }   
}