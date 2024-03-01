package BusinessLogic.Entities.EjercitoRuso;

public class PRHerbivoro extends PRalimento {
    
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
