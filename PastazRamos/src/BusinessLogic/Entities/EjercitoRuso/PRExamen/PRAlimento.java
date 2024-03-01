package BusinessLogic.Entities.EjercitoRuso.PRExamen;

abstract class PRAlimento {
    private String prAlimento;
    
    public PRAlimento(String prAlimento) {
        this.prAlimento = prAlimento;
    }


    public String getPRAlimento() {
        return prAlimento;
    }

    public void setPRAlimento(String PRAlimento) {
        this.prAlimento = prAlimento;
    }
}
