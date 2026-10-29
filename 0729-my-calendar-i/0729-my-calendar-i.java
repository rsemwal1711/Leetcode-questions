class MyCalendar {
    Map<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    public boolean book(int startTime, int endTime) {
        if(map.isEmpty()){
            map.put(startTime, endTime);
            return true;
        }
        for(int left : map.keySet()){
            int right = map.get(left);
            if(startTime < right && left < endTime){
                return false;
            }
        }
        map.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */