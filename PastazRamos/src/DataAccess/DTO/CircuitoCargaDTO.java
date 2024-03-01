package DataAccess.DTO;

public class CircuitoCargaDTO {
    private Integer idCircuitoCarga;       
    private String  nombre;       
    private String  estado;      
    private String  observacion;    
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public CircuitoCargaDTO(){ }

    public CircuitoCargaDTO(String nombre) {
        this.nombre = nombre;
    }

    public CircuitoCargaDTO(int idCircuitoCarga, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idCircuitoCarga = idCircuitoCarga;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdCircuitoCarga() {
        return idCircuitoCarga;
    }
    public void setIdCircuitoCarga(Integer idCircuitoCarga) {
        this.idCircuitoCarga = idCircuitoCarga;
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
        + "\n idCircuitoCarga: "+ getIdCircuitoCarga()       
        + "\n Nombre: "+ getNombre()       
        + "\n Estado: "+ getEstado()       
        + "\n Observacion: "+ getObservacion()    
        + "\n FechaCrea: "+ getFechaCrea()    
        + "\n FechaModifica: "+ getFechaModifica();
    }
}
