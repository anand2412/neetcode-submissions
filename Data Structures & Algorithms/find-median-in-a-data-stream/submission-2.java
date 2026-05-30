class MedianFinder {

    private ArrayList<Integer> numbers;

    public MedianFinder() {
        numbers = new ArrayList<>();
    }
    
    public void addNum(int num) {
        numbers.add(num);
    }
    
    public double findMedian() {
        Collections.sort(numbers);
        int n = numbers.size();
        if((n & 1)==1) {
            return numbers.get(n/2);
        } else {
            return (numbers.get(n/2) + numbers.get(n/2 - 1)) /2.0;
        }
    }
}
