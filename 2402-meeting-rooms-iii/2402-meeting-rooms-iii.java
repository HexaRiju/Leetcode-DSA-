class Pair{
    long end;
    int roomNo;
    public Pair(long end, int roomNo){
        this.end = end;
        this.roomNo = roomNo;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> roomAvailable = new PriorityQueue<>();
        PriorityQueue<Pair> occupied = new PriorityQueue<>((a, b) -> {
            if(a.end != b.end)
                return Long.compare(a.end, b.end);
            return Integer.compare(a.roomNo, b.roomNo);
        });
        for(int i = 0; i < n; i++){
            roomAvailable.add(i);
        }
        for(int[] meeting : meetings){
            long start = meeting[0];
            long end = meeting[1];

            // check if any room is starting as such time that one or more rooms can be free from occuie at that time tough rooms can be available;
            while(!occupied.isEmpty() && meeting[0] >= occupied.peek().end){
                int room = occupied.poll().roomNo;
                roomAvailable.add(room);
            }
            // if no room is available 
            if(roomAvailable.isEmpty()){
                Pair p = occupied.poll();
                end = p.end + (end - start);
                roomAvailable.add(p.roomNo);
            }
            // now we always have a room 
            int room = roomAvailable.poll();
            count[room]++;
            occupied.add(new Pair(end, room));
        }
        int max = Integer.MIN_VALUE, minIndex = 0;
        for(int i = 0; i < n; i++){
            if(max < count[i]){
                max = count[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}