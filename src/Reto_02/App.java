
public class App {
    public static void main(String[] args) {
     //Ejemplo de como se evaluaran las soluciones
 //Solucion prueba 1
 //Inicializacion de la lista de computadores
    Computador[] arregloComputadores2 = new Computador[5];
    //Definicion de cada componente de la lista
    arregloComputadores2[0] = new Computador(1200000);
    arregloComputadores2[1] = new Computador(19,1600000);
    arregloComputadores2[2] = new DeMesa(1300000,8);
    arregloComputadores2[3] = new DeMesa(1650000,16);
    arregloComputadores2[4] = new DeMesa(21,1659000);
    //Inicializacion de la solucion (Clase PrecioTotal)
    PrecioTotal precioTotal = new PrecioTotal(arregloComputadores2);
    //Mostrar Totales
    precioTotal.mostrarTotales();
    }
 
}