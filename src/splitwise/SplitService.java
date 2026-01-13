package splitwise;

import splitwise.entity.Group;
import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.HashMap;
import java.util.Map;

public class SplitService {

    private static SplitService instance;
    private Map<Integer, User> userMap;
    private Map<Integer, Group> groupMap;

    private SplitService(){}

    public SplitService getInstance(){
        if(instance==null){
            return new SplitService();
        }
        return instance;
    }

    public void addUser(User user){
        userMap.put(user.getId(),user);
    }

    public void addGroup(Group group){
        groupMap.put(group.getId(),group);
    }

    
}
