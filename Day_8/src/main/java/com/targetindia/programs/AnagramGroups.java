package com.targetindia.programs;

import java.util.*;

public class AnagramGroups {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
//        for(List<String> s : ans){
//            System.out.println(s);
//        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        int n = strs.length;

        for(int i=0; i<n; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String s = String.valueOf(str);

            if(map.get(s) != null){
                List<String> a = map.get(s);
                a.add(strs[i]);
                map.put(s, a);
            }
            else{
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                map.put(s, a);
            }
        }

        for(Map.Entry<String, List<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }

        return ans;
    }
}
