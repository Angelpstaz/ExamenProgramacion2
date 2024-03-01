package DataAccess.DTO;

public class AntBotDTO {
    private Integer idAntBot;
    private Integer idIABot;
    private Integer idHormiga;
    private Integer idAla;
    private Integer idProcesador;
    private Integer idCircuitoAnillado;
    private Integer idTenaza;
    private Integer idRadio;
    private Integer idSensorOptico;
    private Integer idAntena;
    private Integer idCamara;
    private Integer idCircuitoCarga;
    private Integer idPata;
    private Integer idFuentePoder;
    private Integer idExpertoIdiomas;
    private String Estado;
    private String Observacion;
    private String FechaCrea;
    private String FechaModifica;


    public AntBotDTO() {};

    public AntBotDTO(Integer idAntBot, Integer idIABot, Integer idHormiga, Integer idAla, Integer idProcesador, Integer idCircuitoAnillado, Integer idTenaza, Integer idRadio, Integer idSensorOptico, Integer idAntena, Integer idCamara, Integer idCircuitoCarga, Integer idPata, Integer idFuentePoder, Integer idExpertoIdiomas, String Estado, String Observacion, String FechaCrea, String FechaModifica) {
        this.idAntBot = idAntBot;
        this.idIABot = idIABot;
        this.idHormiga = idHormiga;
        this.idAla = idAla;
        this.idProcesador = idProcesador;
        this.idCircuitoAnillado = idCircuitoAnillado;
        this.idTenaza = idTenaza;
        this.idRadio = idRadio;
        this.idSensorOptico = idSensorOptico;
        this.idAntena = idAntena;
        this.idCamara = idCamara;
        this.idCircuitoCarga = idCircuitoCarga;
        this.idPata = idPata;
        this.idFuentePoder = idFuentePoder;
        this.idExpertoIdiomas = idExpertoIdiomas;
        this.Estado = Estado;
        this.Observacion = Observacion;
        this.FechaCrea = FechaCrea;
        this.FechaModifica = FechaModifica;
    }
    public AntBotDTO(Integer idIABot, Integer idHormiga) {
        this.idIABot = idIABot;
        this.idHormiga = idHormiga;
        
    }
    public Integer getIdAntBot() {
        return idAntBot;
    }

    public void setIdAntBot(Integer idAntBot) {
        this.idAntBot = idAntBot;
    }

    public Integer getIdIABot() {
        return idIABot;
    }

    public void setIdIABot(Integer idIABot) {
        this.idIABot = idIABot;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdAla() {
        return idAla;
    }

    public void setIdAla(Integer idAla) {
        this.idAla = idAla;
    }

    public Integer getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Integer idProcesador) {
        this.idProcesador = idProcesador;
    }

    public Integer getIdCircuitoAnillado() {
        return idCircuitoAnillado;
    }

    public void setIdCircuitoAnillado(Integer idCircuitoAnillado) {
        this.idCircuitoAnillado = idCircuitoAnillado;
    }

    public Integer getIdTenaza() {
        return idTenaza;
    }

    public void setIdTenaza(Integer idTenaza) {
        this.idTenaza = idTenaza;
    }

    public Integer getIdRadio() {
        return idRadio;
    }

    public void setIdRadio(Integer idRadio) {
        this.idRadio = idRadio;
    }

    public Integer getIdSensorOptico() {
        return idSensorOptico;
    }

    public void setIdSensorOptico(Integer idSensorOptico) {
        this.idSensorOptico = idSensorOptico;
    }

    public Integer getIdAntena() {
        return idAntena;
    }

    public void setIdAntena(Integer idAntena) {
        this.idAntena = idAntena;
    }

    public Integer getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public Integer getIdCircuitoCarga() {
        return idCircuitoCarga;
    }

    public void setIdCircuitoCarga(Integer idCircuitoCarga) {
        this.idCircuitoCarga = idCircuitoCarga;
    }

    public Integer getIdPata() {
        return idPata;
    }

    public void setIdPata(Integer idPata) {
        this.idPata = idPata;
    }

    public Integer getIdFuentePoder() {
        return idFuentePoder;
    }

    public void setIdFuentePoder(Integer idFuentePoder) {
        this.idFuentePoder = idFuentePoder;
    }

    public Integer getIdExpertoIdiomas() {
        return idExpertoIdiomas;
    }

    public void setIdExpertoIdiomas(Integer idExpertoIdiomas) {
        this.idExpertoIdiomas = idExpertoIdiomas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
public String toString(){
    return getClass().getName()
    + "\n idAntBot: " + getIdAntBot()
    + "\n idIABot: " + getIdIABot()
    + "\n idHormiga: " + getIdHormiga()
    + "\n idAla: " + getIdAla()
    + "\n idProcesador: " + getIdProcesador()
    + "\n idCircuitoAnillado: " + getIdCircuitoAnillado()
    + "\n idTenaza: " + getIdTenaza()
    + "\n idRadio: " + getIdRadio()
    + "\n idSensorOptico: " + getIdSensorOptico()
    + "\n idAntena: " + getIdAntena()
    + "\n idCamara: " + getIdCamara()
    + "\n idCircuitoCarga: " + getIdCircuitoCarga()
    + "\n idPata: " + getIdPata()
    + "\n idFuentePoder: " + getIdFuentePoder()
    + "\n idExpertoIdiomas: " + getIdExpertoIdiomas()
    + "\n Estado: " + getEstado()
    + "\n Observacion: " + getObservacion()
    + "\n FechaCrea: " + getFechaCrea()
    + "\n FechaModifica: " + getFechaModifica();
}
}
