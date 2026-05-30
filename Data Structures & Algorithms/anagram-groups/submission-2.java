class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            List<String> list;
            if(map.containsKey(s)) {
                list = map.get(s);
            } else {
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(s, list);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
