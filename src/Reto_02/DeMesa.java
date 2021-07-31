public class DeMesa extends Computador
{
    private  double ram = 4;

    public DeMesa(double precioBase, double ram)    {
        super(precioBase);
        this.ram = ram;

    }
    public DeMesa(double pantalla, double precioBase, double ram){
        super(pantalla, precioBase);
        this.ram = ram;
    }

    public DeMesa(double ano, double pantalla, double precioBase, double ram){
        super(ano, pantalla, precioBase);
        this.ram = ram;
    }

    @Override
    public double calcularPrecio(){

        double factor;

        if(ram < 4){
            factor = 0.9;
        }
        else if(ram > 12){
            factor = 1.3;
        }
        else{
            factor = 1.1;
        }         
       
        return super.getPrecioBase() * (super.getAno()/2021) * (super.getPantalla()/16) * factor;
    }
}