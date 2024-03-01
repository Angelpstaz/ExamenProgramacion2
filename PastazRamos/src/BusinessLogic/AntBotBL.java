package BusinessLogic;

import java.util.List;

import DataAccess.AntBotDAO;
import DataAccess.DTO.AntBotDTO;

public class AntBotBL {
    private AntBotDTO AntBot;
    private AntBotDAO antBotDAO = new AntBotDAO();
    public List<AntBotDTO> getAll() throws Exception{
        return antBotDAO.readAll();
    }
    public AntBotBL() {
        this.antBotDAO = new AntBotDAO();
    }

    public boolean create(AntBotDTO antBotDTO) throws Exception {
        return antBotDAO.create(antBotDTO);
    }
    public AntBotDTO readBy(int id) throws Exception {
        return antBotDAO.readBy(id);
    }

    public boolean update(AntBotDTO antBotDTO) throws Exception {
        return antBotDAO.update(antBotDTO);
    }

    public boolean delete(int id) throws Exception {
        return antBotDAO.delete(id);
    }

    public AntBotDTO getByIdAntBot(int idAntBot) throws Exception{
        AntBot = antBotDAO.readBy(idAntBot);
        return AntBot;
    }
    public Integer getMaxRow() throws Exception{
        return antBotDAO.getMaxRow();
    }
}
