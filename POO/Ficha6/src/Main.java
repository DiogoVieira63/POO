import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        DriveIt driveIt = new DriveIt();
        AutocarroInteligente autocarroInteligente = new AutocarroInteligente("AA-98-BB","Mercedes","Classe A",2017,50,4.5,null,1000,0);
        VeiculoPremium veiculoPremium = new VeiculoPremium("AA-25-AL","Audi","r8",2018,65,6.5,null,100,1.5);
        VeiculoOcasiao veiculoOcasiao = new VeiculoOcasiao("AA-56-AC","BMW","x6",2019,58,5.7,null,250,false);
        try {
            driveIt.adiciona(veiculoPremium);
            driveIt.adiciona(autocarroInteligente);
            driveIt.adiciona(veiculoOcasiao);
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        try {
            driveIt.getVeiculo("OLA");
        }
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());
        };
        System.out.println(driveIt.ordenarVeiculos(Comparator.comparingDouble(Veiculo::getAnoConstrucao)));
        String outputFile = driveIt.saveState();
        DriveIt driveIt2 = new DriveIt();
        driveIt2.loadState(outputFile);
        System.out.println(driveIt2);
    }
}
