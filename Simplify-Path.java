public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        ArrayList<String> retPath = new ArrayList<String>();
        String[] tokens = path.split("/");
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("."))
                continue;
            if(tokens[i].equals("..")){
                if(retPath.size() > 0)
                    retPath.remove(retPath.size()-1);
                continue;
            }
            if(tokens[i].length() > 0)
                retPath.add(tokens[i]);
        }
        //combine the tokens now
        String ret = "/";
        for(int i = 0; i < retPath.size(); i++){
            ret += retPath.get(i);
            if(i != retPath.size() -1)
                ret += "/";
        }
        return ret;
    }
}
