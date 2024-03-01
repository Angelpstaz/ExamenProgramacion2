package DataAccess.DTO;

public class HormigaDTO {
    private Integer idHormiga;
    private Integer idHormigaTipo;
    private String nombre;
    private String estado;
    private String observacion;
    private String fechaCrea;
    private String fechaModifica;

    public HormigaDTO() { }

    public HormigaDTO(Integer idHormiga, Integer idHormigaTipo, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idHormiga = idHormiga;
        this.idHormigaTipo = idHormigaTipo;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    public HormigaDTO( Integer idHormigaTipo, String nombre) {
        this.idHormigaTipo = idHormigaTipo;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return getClass().getName()
        + "\n idHormiga: " + getIdHormiga()
        + "\n idHormigaTipo: " + getIdHormigaTipo()
        + "\n nombre: " + getNombre()
        + "\n estado: " + getEstado()
        + "\n observacion: " + getObservacion()
        + "\n fechaCrea: " + getFechaCrea()
        + "\n fechaModifica: " + getFechaModifica();
    }
}
