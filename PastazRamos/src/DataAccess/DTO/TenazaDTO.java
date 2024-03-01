package DataAccess.DTO;

public class TenazaDTO {
    private Integer idTenaza;       
    private String  nombre;       
    private String  estado;      
    private String  observacion;    
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public TenazaDTO(){ }

    public TenazaDTO(String nombre) {
        this.nombre = nombre;
    }

    public TenazaDTO(int idTenaza, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idTenaza = idTenaza;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdTenaza() {
        return idTenaza;
    }
    public void setIdTenaza(Integer idTenaza) {
        this.idTenaza = idTenaza;
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
        + "\n idTenaza:       "+ getIdTenaza()       
        + "\n nombre:       "+ getNombre()       
        + "\n estado:       "+ getEstado()       
        + "\n observacion:    "+ getObservacion()    
        + "\n fechaCrea:    "+ getFechaCrea()    
        + "\n fechaModifica:"+ getFechaModifica();
    }
}