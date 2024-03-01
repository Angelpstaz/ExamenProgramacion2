package BusinessLogic.Entities.EjercitoRuso;

abstract class PRalimento {
    private String prAlimento;
    
    public PRalimento(String prAlimento) {
        this.prAlimento = prAlimento;
    }


    public String getPRAlimento() {
        return prAlimento;
    }

    public void setPRAlimento(String PRAlimento) {
        this.prAlimento = prAlimento;
    }
}
