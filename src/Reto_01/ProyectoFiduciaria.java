public class ProyectoFiduciaria {
    public static void main(String[] args) throws Exception {

        ProyectoFiduciaria proyectoFiduciaria = new ProyectoFiduciaria();

        System.out.println(proyectoFiduciaria.diferenciaInteresSimpleYCompuesto(12, 150000, 0.1));
    }

    
    public String diferenciaInteresSimpleYCompuesto(int pTiempo, double pMonto, double pInteres)
    {
        if(pTiempo <= 0 || pInteres <= 0 || pMonto <= 0 )
            return "Faltan datos para calcular la diferencia en el total de intereses "
            +"generados para el proyecto.";

            
            
        double totalInteresCompuesto = CalcularInteresCompuesto(pMonto, pInteres, pTiempo);
        double totalInteresSimple  = CalcularInteresSimple(pMonto, pInteres, pTiempo);

        //πππππππππΌππ£πππ πππ = π‘ππ‘πππΌππ‘ππππ πΆππππ’ππ π‘π β π‘ππ‘πππΌππ‘ππππ ππππππ
        double compararInversion  = totalInteresCompuesto - totalInteresSimple;

        return String.format("La diferencia en el total de intereses generados para el proyecto, si escogemos entre "
        + "evaluarlo a una tasa de interΓ©s Compuesto y evaluarlo a una tasa de interΓ©s Simple, asciende a"
        +" la cifra de: $%s.", compararInversion) ;
        
    }

    private double CalcularInteresSimple(double pMonto, double pInteres, int pTiempo)
    {
        //π‘ππ‘πππΌππ‘ππππ ππππππ = ππππ‘π β πΌππ‘ππππ ππ  β π‘πππποΏ½
        return (pMonto *pInteres* pTiempo);

    }

    private double CalcularInteresCompuesto(double pMonto, double pInteres, int pTiempo)
    {
        //π‘ππ‘πππΌππ‘ππππ πΆππππ’ππ π‘π = ππππ‘π β [ (1 + πΌππ‘ππππ )^π‘πππππ β 1 ]

        return pMonto * (Math.pow((1+pInteres), pTiempo)-1);
    }

}
