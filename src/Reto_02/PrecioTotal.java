public class PrecioTotal
{
    public double totalComputadores;
    public double totalPortatiles;
    public double totalDeMesa;
    public Computador[] listaComputadores;

     //Constructor
    public PrecioTotal(Computador[] arreglo){
        listaComputadores = arreglo;
    }
    //Metodos
    public void mostrarTotales()
    {

        for (var computador : listaComputadores) {
            

            if(computador instanceof DeMesa){
                totalDeMesa += computador.calcularPrecio();
            }

            if(computador instanceof Portatil){
                totalPortatiles += computador.calcularPrecio();
            }

            if(computador instanceof Computador){
                totalComputadores += computador.calcularPrecio();
            }
            
        }
    System.out.println("La suma del precio de los computadores es de " + totalComputadores);
    System.out.println("La suma del precio de los portatiles es de " + totalPortatiles);
    System.out.println("La suma del precio de los de mesa es de " + totalDeMesa);

    }
}
