import java.util.Map;

public class CreatorManager {
    private Map<String, Creator> creatorMap;// id -> creator

    public void addCreator(Creator creator) {
        creatorMap.put(creator.getId(), creator);
    }

    public void removeCreator(String id) {
        if(creatorMap.containsKey(id)) {
            creatorMap.remove(id);
        }
    }

    public Creator getCreatorById(String id) {
        return creatorMap.getOrDefault(id, null);
    }
}
