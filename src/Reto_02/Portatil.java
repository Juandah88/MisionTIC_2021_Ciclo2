public class Portatil extends Computador
{
    private   boolean tarjetaDeVideo = false;


    public Portatil(double precioBase, boolean tarjetaDeVideo){
        super(precioBase);
        this.tarjetaDeVideo = tarjetaDeVideo;
    }

    public Portatil(double pantalla, double precioBase, boolean tarjetaDeVideo){
        super(pantalla, precioBase);
        this.tarjetaDeVideo = tarjetaDeVideo;
    }

    public Portatil(double ano, double pantalla, double precioBase, boolean tarjetaDeVideo){
        super(ano, pantalla, precioBase);
        this.tarjetaDeVideo = tarjetaDeVideo;
    }

    @Override
    public double calcularPrecio(){

        double factor = 0.0;
        if(tarjetaDeVideo){
            factor =  1.2;
        }
        else{
            factor = 1.0;
        }
        return super.getPrecioBase() * (super.getAno()/2021) * (super.getPantalla()/16) * factor;
    }    
}