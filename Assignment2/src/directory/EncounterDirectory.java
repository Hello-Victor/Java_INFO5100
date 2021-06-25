package directory;

import model.EncounterModel;

import java.util.ArrayList;
import java.util.List;

public class EncounterDirectory {
    private List<EncounterModel> encounterList;

    public EncounterDirectory() {
        encounterList = new ArrayList<>();
    }

    public List<EncounterModel> getEncounterList() {
        return encounterList;
    }

    public void addEncounter(EncounterModel encounter) {
        encounterList.add(encounter);
    }

    public void removeEncounter(EncounterModel encounter) {
        encounterList.remove(encounter);
    }


    public List<EncounterModel> getEncounterModelListByCommunity(String community) {
        List<EncounterModel> retList = new ArrayList<>();
        for (EncounterModel encounterModel: encounterList) {
            if (encounterModel.getCommunity().equals(community)){
                retList.add(encounterModel);
            }
        }
        return retList;
    }


    public int getEncounterModelCountByCommunity(String community) {
        List<EncounterModel> retList = new ArrayList<>();
        int count = 0;
        for (EncounterModel encounterModel: encounterList) {
            if (encounterModel.getCommunity().equals(community) && encounterModel.isAbnormal()){
                count++;
            }
        }
        return count;
    }
}
