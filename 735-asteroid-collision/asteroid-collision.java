class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            boolean alive = true;
            while(alive && !s.isEmpty() && s.peek() > 0 && asteroids[i] < 0){
                int top = s.peek();
                if(Math.abs(top) == Math.abs(asteroids[i])){
                    s.pop();
                    alive = false;
                } else if(Math.abs(top) < Math.abs(asteroids[i])){
                    s.pop();
                } else{
                    alive = false;
                }
            }

            if(alive){
                s.push(asteroids[i]);
            }
        }
        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}