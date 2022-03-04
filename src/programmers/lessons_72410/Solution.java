package programmers.lessons_72410;

class Solution {
	public String solution(String new_id) {
        String tmp = new_id + "";
        // Depth - 1
        tmp = tmp.toLowerCase();

        // Depth - 2
        tmp = tmp.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        
        // Depth - 3
        while (tmp.indexOf("..") >= 0) {
        	tmp = tmp.replaceAll("\\.\\.", ".");	
        }
        
        // Depth - 4
        tmp = tmp.replaceAll("^\\.(.*)$", "$1");
        tmp = tmp.replaceAll("^(.*)\\.$", "$1");

        // Depth - 6
        if (tmp.length() > 15) tmp = tmp.substring(0, 15);

        // Depth - 5
        if (tmp.equals("")) tmp = "a";

        String answer = tmp;
        
        // Depth - 7
        if (tmp.length() < 3) {
        	String str = tmp.substring(tmp.length() -1, tmp.length());
        	for (int i = tmp.length(); i < 3; i++) {
        		answer += str;
        	}
        }
        
        return answer;
    }

}