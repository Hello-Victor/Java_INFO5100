/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

import java.util.Comparator;
import java.util.HashMap;
import model.User;

/**
 *
 * @author victor
 */
public class UserMapComparator  implements Comparator<User>{
    
    HashMap<Integer, Integer> userPostMap;
    
    public UserMapComparator(HashMap<Integer, Integer> userPostMap){
        this.userPostMap = userPostMap;

    }

    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(userPostMap.get(o1.getId()), userPostMap.get(o2.getId()));

    }
    
}
