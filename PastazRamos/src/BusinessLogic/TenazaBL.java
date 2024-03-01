package BusinessLogic;

import java.util.List;

import DataAccess.TenazaDAO;
import DataAccess.DTO.TenazaDTO;

public class TenazaBL {
    private TenazaDAO tenazaDAO;

    public TenazaBL() {
        this.tenazaDAO = new TenazaDAO();
    }

    public boolean create(TenazaDTO tenazaDTO) throws Exception {
        return tenazaDAO.create(tenazaDTO);
    }

    public List<TenazaDTO> readAll() throws Exception {
        return tenazaDAO.readAll();
    }

    public TenazaDTO readBy(int id) throws Exception {
        return tenazaDAO.readBy(id);
    }

    public boolean update(TenazaDTO tenazaDTO) throws Exception {
        return tenazaDAO.update(tenazaDTO);
    }

    public boolean delete(int id) throws Exception {
        return tenazaDAO.delete(id);
    }
}
