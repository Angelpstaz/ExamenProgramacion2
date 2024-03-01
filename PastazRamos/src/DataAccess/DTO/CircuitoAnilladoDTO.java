package DataAccess.DTO;

public class CircuitoAnilladoDTO {
    private Integer idCircuitoAnillado;       
    private String  nombre;       
    private String  estado;      
    private String  observacion;    
    private String  fechaCrea;    
    private String  fechaModifica;
    
    public CircuitoAnilladoDTO(){ }

    public CircuitoAnilladoDTO(String nombre) {
        this.nombre = nombre;
    }

    public CircuitoAnilladoDTO(int idCircuitoAnillado, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        this.idCircuitoAnillado = idCircuitoAnillado;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdCircuitoAnillado() {
        return idCircuitoAnillado;
    }
    public void setIdCircuitoAnillado(Integer idCircuitoAnillado) {
        this.idCircuitoAnillado = idCircuitoAnillado;
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
        + "\n idCircuitoAnillado: "+ getIdCircuitoAnillado()       
        + "\n Nombre: "+ getNombre()       
        + "\n Estado: "+ getEstado()       
        + "\n Observacion: "+ getObservacion()    
        + "\n FechaCrea: "+ getFechaCrea()    
        + "\n FechaModifica: "+ getFechaModifica();
    }
}