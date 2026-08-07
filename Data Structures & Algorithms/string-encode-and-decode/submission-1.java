class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return "";
        }
        String result = "";
        for(String str: strs) {
            result = result + "|" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        String toAdd = "";
        for(Character c: str.substring(1).toCharArray()) {
            if(c == '|') {
                result.add(toAdd);
                toAdd = "";
                continue;
            }
            toAdd += c;
        }
        result.add(toAdd);
        return result;

    }
}
