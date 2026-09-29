class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        List<Integer> list = new ArrayList<>();
        for(int i : cost)
            list.add(i);
        int i = list.size() - 2, j = list.size() - 1;
        int sum = 0;
        while(list.size() > 2){
            sum += (list.get(i) + list.get(j));
            list.remove(j);
            list.remove(i);
            list.remove(i - 1);
            j = list.size() - 1;
            i = j - 1;
        }
        if(list.size() == 2){
            sum += list.get(0) + list.get(1);
            return sum;
        }
        else if(list.size() == 1){
            sum += list.get(0);
            return sum;
        }
        return sum;
    }
}