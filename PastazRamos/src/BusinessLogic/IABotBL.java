package BusinessLogic;

import java.util.List;

import DataAccess.IABotDAO;
import DataAccess.DTO.IABotDTO;

public class IABotBL {
    private IABotDAO iaBotDAO;

    public IABotBL() {
        this.iaBotDAO = new IABotDAO();
    }

    public boolean create(IABotDTO iaBotDTO) throws Exception {
        return iaBotDAO.create(iaBotDTO);
    }

    public List<IABotDTO> readAll() throws Exception {
        return iaBotDAO.readAll();
    }

    public IABotDTO readBy(int id) throws Exception {
        return iaBotDAO.readBy(id);
    }

    public boolean update(IABotDTO iaBotDTO) throws Exception {
        return iaBotDAO.update(iaBotDTO);
    }

    public boolean delete(int id) throws Exception {
        return iaBotDAO.delete(id);
    }
}

