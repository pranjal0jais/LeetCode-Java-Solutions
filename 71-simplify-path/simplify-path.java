class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] comp = path.split("/");
        for(String c : comp){
            if(c.isEmpty() || c.equals(".")){
                continue;
            }
            if(c.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        StringBuilder newPath = new StringBuilder();
        for(String str : s){
            newPath.append("/").append(str);
        }

        return newPath.length() == 0 ? "/" : newPath.toString();
    }
}