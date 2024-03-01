package DataAccess.DTO;


public class CamaraDTO {
    private Integer idCamara;       
    private String  nombre;       
    private String  estado;      
    private String  observacion;    
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public CamaraDTO(){ }

    public CamaraDTO(String nombre) {
        this.nombre = nombre;
    }

    public CamaraDTO(int idCamara, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idCamara = idCamara;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdCamara() {
        return idCamara;
    }
    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
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
    public String toString(){
        return getClass().getName()
        + "\n idCamara:       "+ getIdCamara()       
        + "\n nombre:       "+ getNombre()       
        + "\n estado:       "+ getEstado()       
        + "\n observacion:    "+ getObservacion()    
        + "\n fechaCrea:    "+ getFechaCrea()    
        + "\n fechaModifica:"+ getFechaModifica();
    }
}
