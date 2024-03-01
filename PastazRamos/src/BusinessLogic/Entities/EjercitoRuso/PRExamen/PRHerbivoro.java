package BusinessLogic.Entities.EjercitoRuso.PRExamen;

public class PRHerbivoro extends PRAlimento {
    
    public String getPRNombreAlimento() {
        return prNombreAlimento;
    }
    public void setPRNombreAlimento(String prNombreAlimento) {
        this.prNombreAlimento = prNombreAlimento;
    }
    private String prNombreAlimento;
    public PRHerbivoro(String dcAlimento) {
        super(dcAlimento);
    }
    @Override
    public String toString() {
        return "PRomnivoro{" +
                "nombreAlimento='" + getPRNombreAlimento() + '\'' +
                '}';
    }
}
