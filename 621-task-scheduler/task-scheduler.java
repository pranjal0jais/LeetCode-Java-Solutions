class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> count = new HashMap<>();

        for(Character task : tasks){
            count.put(task, count.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        pq.addAll(count.values());

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int remaining = pq.poll()-1;
                if(remaining > 0){
                    q.offer(new int[]{remaining, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}