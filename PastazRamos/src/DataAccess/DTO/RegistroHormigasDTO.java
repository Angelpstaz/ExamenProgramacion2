package DataAccess.DTO;


public class RegistroHormigasDTO {
    private Integer idRegistroHormigas;
    private Integer idHormiga;
    private Integer idHormigaTipo;
    private String comio;
    private String recogio;
    private String estado;
    private String observacion;
    private String fechaCrea;
    private String fechaModifica;

    public Integer getIdRegistroHormigas() {
        return idRegistroHormigas;
    }

    public void setIdRegistroHormigas(Integer idRegistroHormigas) {
        this.idRegistroHormigas = idRegistroHormigas;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdHormigaTipo() {
        return idHormigaTipo;
    }

    public void setIdHormigaTipo(Integer idHormigaTipo) {
        this.idHormigaTipo = idHormigaTipo;
    }

    public String getComio() {
        return comio;
    }

    public void setComio(String comio) {
        this.comio = comio;
    }

    public String getRecogio() {
        return recogio;
    }

    public void setRecogio(String recogio) {
        this.recogio = recogio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public RegistroHormigasDTO() { }

    public RegistroHormigasDTO(Integer idRegistroHormigas, Integer idHormiga, Integer idHormigaTipo, String comio, String recogio, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idRegistroHormigas = idRegistroHormigas;
        this.idHormiga = idHormiga;
        this.idHormigaTipo = idHormigaTipo;
        this.comio = comio;
        this.recogio = recogio;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    public RegistroHormigasDTO(Integer idHormiga, Integer idHormigaTipo, String comio, String recogio, String estado) {
        this.idHormiga = idHormiga;
        this.idHormigaTipo = idHormigaTipo;
        this.comio = comio;
        this.recogio = recogio;
        this.estado = estado;
    }

    // Getters and setters for each field...

    @Override
    public String toString() {
        return getClass().getName()
        + "\n idRegistroHormigas: " + getIdRegistroHormigas()
        + "\n idHormiga: " + getIdHormiga()
        + "\n idHormigaTipo: " + getIdHormigaTipo()
        + "\n comio: " + getComio()
        + "\n recogio: " + getRecogio()
        + "\n estado: " + getEstado()
        + "\n observacion: " + getObservacion()
        + "\n fechaCrea: " + getFechaCrea()
        + "\n fechaModifica: " + getFechaModifica();
    }
}
