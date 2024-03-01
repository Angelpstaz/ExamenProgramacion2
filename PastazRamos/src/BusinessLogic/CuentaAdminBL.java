/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| dilan.calvache@epn.edu.ec  Msetoo      |
|----------------------------------------|
Autor : Mateo Calvache
Fecha : 29.02.2k24
*/
package BusinessLogic;

import DataAccess.CuentaAdminDAO;
import DataAccess.DTO.CuentaAdminDTO;
import Framework.AppException;
import java.util.List;

public class CuentaAdminBL {

    private CuentaAdminDAO cuentaAdminDAO;

    public CuentaAdminBL() {
        this.cuentaAdminDAO = new CuentaAdminDAO();
    }

    public CuentaAdminDTO login(String correo, String password) throws Exception {
        CuentaAdminDTO cuenta = cuentaAdminDAO.readByCorreo(correo);
        if (cuenta != null && cuenta.getPassword().equals(password)) {
            return cuenta;
        } else {
            throw new AppException("Credenciales inválidas", getClass().getName(), "login");
        }
    }

    public List<CuentaAdminDTO> obtenerTodasLasCuentas() throws Exception {
        return cuentaAdminDAO.readAll();
    }

    public boolean registrarCuenta(CuentaAdminDTO nuevaCuenta) throws Exception {
        
        
        // Suponiendo que se ha pasado la validación:
        return cuentaAdminDAO.create(nuevaCuenta);
    }

    public boolean actualizarCuenta(CuentaAdminDTO cuenta) throws Exception {
        // Validaciones similares a las del registro
        return cuentaAdminDAO.update(cuenta);
    }

    public boolean eliminarCuenta(String correo) throws Exception {
       
        return cuentaAdminDAO.delete(correo);
    }
}
