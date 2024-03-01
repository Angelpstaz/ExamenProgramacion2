package DataAccess.DTO;


public class PataDTO {
    private Integer idPata;       
    private String  nombre;       
    private Integer numeroPatas;      
    private String  estado;    
    private String  observacion;
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public PataDTO(){ }

    public PataDTO(String nombre, Integer numeroPatas) {
        this.nombre = nombre;
        this.numeroPatas = numeroPatas;
    }

    public PataDTO(Integer idPata, String nombre, Integer numeroPatas, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idPata = idPata;
        this.nombre = nombre;
        this.numeroPatas = numeroPatas;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdPata() {
        return idPata;
    }
    public void setIdPata(Integer idPata) {
        this.idPata = idPata;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getNumeroPatas() {
        return numeroPatas;
    }
    public void setNumeroPatas(Integer numeroPatas) {
        this.numeroPatas = numeroPatas;
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
        + "\n idPata:       "+ getIdPata()       
        + "\n nombre:       "+ getNombre()       
        + "\n numeroPatas:  "+ getNumeroPatas()       
        + "\n estado:       "+ getEstado()       
        + "\n observacion:  "+ getObservacion()    
        + "\n fechaCrea:    "+ getFechaCrea()    
        + "\n fechaModifica:"+ getFechaModifica();
    }
}