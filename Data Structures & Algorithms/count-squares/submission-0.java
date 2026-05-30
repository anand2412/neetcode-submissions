class CountSquares {

    HashMap<String, Integer> map = new HashMap<>();

    public CountSquares() {
        map.clear();
    }
    
    public void add(int[] point) {
        String key = point[0]+"_"+point[1];
        map.put(key, map.getOrDefault(key, 0)+1);
    }
    
    public int count(int[] point) {
        return isPointAvailable(point[0], point[1]);       
    }

    public int isPointAvailable(int x, int y) {
        int count =0;
        for(int i = 1; i<1000; i++) {
            if(map.containsKey((x+i)+"_"+y)) {   
                if(map.containsKey(x+"_"+(y+i))) {
                    if(map.containsKey((x+i)+"_"+(y+i))) {
                        int fr1 = map.get((x+i)+"_"+y);
                        int fr2 = map.get(x+"_"+(y+i));
                        int fr3 = map.get((x+i)+"_"+(y+i));
                        count += fr1*fr2*fr3;
                    }
                }
            }
        }

        for(int i = 1; i < 1000; i++) {
            if(map.containsKey((x-i)+"_"+y)) {
                if(map.containsKey(x+"_"+(y+i))) {
                    if(map.containsKey((x-i)+"_"+(y+i))) {
                        int fr1 = map.get((x-i)+"_"+y);
                        int fr2 = map.get(x+"_"+(y+i));
                        int fr3 = map.get((x-i)+"_"+(y+i));
                       count += fr1*fr2*fr3;
                    }
                }
            }
        }

        for(int i = 1; i<1000; i++) {
            if(map.containsKey((x-i)+"_"+y)) {
                if(map.containsKey(x+"_"+(y-i))) {
                    if(map.containsKey((x-i)+"_"+(y-i))) {
                        int fr1 = map.get((x-i)+"_"+y);
                        int fr2 = map.get(x+"_"+(y-i));
                        int fr3 = map.get((x-i)+"_"+(y-i));
                        count += fr1*fr2*fr3;
                    }
                }
            }
        }

        for(int i = 1; i < 1000; i++) {
            if(map.containsKey(x+"_"+(y-i))) {
                if(map.containsKey((x+i)+"_"+y)) {
                    if(map.containsKey((x+i)+"_"+(y-i))) {
                        int fr1 = map.get(x+"_"+(y-i));
                        int fr2 = map.get((x+i)+"_"+y);
                        int fr3 = map.get((x+i)+"_"+(y-i));
                         count += fr1*fr2*fr3;
                    }
                }
           }
        }
        return count;
    }
}
