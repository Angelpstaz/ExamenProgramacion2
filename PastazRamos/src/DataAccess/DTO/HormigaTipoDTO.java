/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
|----------------------------------------|
Autor : BaphomeT-T
Fecha : 25.feb.2k24
*/
package DataAccess.DTO;
public class HormigaTipoDTO {
    private Integer IdHormigaTipo;       
    private String  Nombre;       
    private String  Estado;      
    private String  FechaCrea;    
    private String  FechaModifica;
    
    public HormigaTipoDTO(){ }

    public HormigaTipoDTO(String nombre) {
        this.Nombre = nombre;
    }

    public HormigaTipoDTO(int idHormigaTipo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdHormigaTipo = idHormigaTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public Integer getIdHormigaTipo() {
        return IdHormigaTipo;
    }
    public void setIdHormigaTipo(Integer idHormigaTipo) {
        IdHormigaTipo = idHormigaTipo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
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
        + "\n IdHormigaTipo:       "+ getIdHormigaTipo()       
        + "\n Nombre:       "+ getNombre()       
        + "\n Estado:       "+ getEstado()       
        + "\n FechaCrea:    "+ getFechaCrea()    
        + "\n FechaModifica:"+ getFechaModifica();
    }
    
}
