package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friends {
    public static void main(String[] args) {

        String[] friendship_list = new String[]{
                "1,2",
                "1,3",
                "1,4",
                "2,6"
        };

        String[] employeeList = new String[]{
                "1,Jose",
                "2,Miguel",
                "3,Carlos",
                "4,Jose",
                "5,Pepe",
                "6,Martin",
                "7,Roberto",
                "8,Eric",
                "9,Victor"
        };

        Map<String, List<String>> resultFriends = new HashMap<>();

        for(int i = 0; i < employeeList.length; i++){
            String[] employee_part = employeeList[i].split(",");
            resultFriends.put(employee_part[0], new ArrayList<>());

            for(int j = 0; j < friendship_list.length; j++){
                String[] friends_part = friendship_list[j].split(",");
                if(friends_part[0].equals(employee_part[0])){
                    resultFriends.get(employee_part[0]).add(friends_part[1]);
                }else if(friends_part[1].equals(employee_part[0])){
                    resultFriends.get(employee_part[0]).add(friends_part[0]);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : resultFriends.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

}
