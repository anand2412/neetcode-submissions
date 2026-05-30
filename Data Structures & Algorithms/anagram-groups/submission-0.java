class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ana = new HashMap<>();
        for(int i=0; i< strs.length; i++) {
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String tempString = new String(tempArray);
            List<String> list;
            if(ana.containsKey(tempString)) {
                list = ana.get(tempString);
            } else {
               list = new ArrayList<>();
                
            }
            list.add(strs[i]);
            ana.put(tempString, list);          
        }
        Collection<List<String>> values = ana.values(); 
  
        // Creating an ArrayList of values 
        List<List<String>> listOfValues 
            = new ArrayList<>(values); 
        return listOfValues; 
    }
}
