package DataAccess.DTO;

public class FuentePoderDTO {
    private Integer idFuentePoder;       
    private String  Nombre;       
    private String  estado;      
    private String  observacion;    
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public FuentePoderDTO(){ }

    public FuentePoderDTO(String nombre, String observacion) {
        this.Nombre = nombre;
        this.observacion = observacion;
    }

    public FuentePoderDTO(int idFuentePoder, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idFuentePoder = idFuentePoder;
        this.Nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdFuentePoder() {
        return idFuentePoder;
    }
    public void setIdFuentePoder(Integer idFuentePoder) {
        this.idFuentePoder = idFuentePoder;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
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
        + "\n idFuentePoder:       "+ getIdFuentePoder()       
        + "\n nombre:       "+ getNombre()       
        + "\n estado:       "+ getEstado()       
        + "\n observacion:  "+ getObservacion()    
        + "\n fechaCrea:    "+ getFechaCrea()    
        + "\n fechaModifica:"+ getFechaModifica();
    }

    
    public void setId(int selectedId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
