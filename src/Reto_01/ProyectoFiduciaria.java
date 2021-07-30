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

        //𝑐𝑜𝑚𝑝𝑎𝑟𝑎𝑟𝐼𝑛𝑣𝑒𝑟𝑠𝑖𝑜𝑛 = 𝑡𝑜𝑡𝑎𝑙𝐼𝑛𝑡𝑒𝑟𝑒𝑠𝐶𝑜𝑚𝑝𝑢𝑒𝑠𝑡𝑜 − 𝑡𝑜𝑡𝑎𝑙𝐼𝑛𝑡𝑒𝑟𝑒𝑠𝑆𝑖𝑚𝑝𝑙𝑒
        double compararInversion  = totalInteresCompuesto - totalInteresSimple;

        return String.format("La diferencia en el total de intereses generados para el proyecto, si escogemos entre "
        + "evaluarlo a una tasa de interés Compuesto y evaluarlo a una tasa de interés Simple, asciende a"
        +" la cifra de: $%s.", compararInversion) ;
        
    }

    private double CalcularInteresSimple(double pMonto, double pInteres, int pTiempo)
    {
        //𝑡𝑜𝑡𝑎𝑙𝐼𝑛𝑡𝑒𝑟𝑒𝑠𝑆𝑖𝑚𝑝𝑙𝑒 = 𝑀𝑜𝑛𝑡𝑜 ∗ 𝐼𝑛𝑡𝑒𝑟𝑒𝑠𝑒𝑠 ∗ 𝑡𝑖𝑒𝑚𝑝�
        return (pMonto *pInteres* pTiempo);

    }

    private double CalcularInteresCompuesto(double pMonto, double pInteres, int pTiempo)
    {
        //𝑡𝑜𝑡𝑎𝑙𝐼𝑛𝑡𝑒𝑟𝑒𝑠𝐶𝑜𝑚𝑝𝑢𝑒𝑠𝑡𝑜 = 𝑀𝑜𝑛𝑡𝑜 ∗ [ (1 + 𝐼𝑛𝑡𝑒𝑟𝑒𝑠)^𝑡𝑖𝑒𝑚𝑝𝑜 − 1 ]

        return pMonto * (Math.pow((1+pInteres), pTiempo)-1);
    }

}
