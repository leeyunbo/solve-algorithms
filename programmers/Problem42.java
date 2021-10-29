/**
https://programmers.co.kr/learn/courses/30/lessons/64064
*/

class Solution {    
    private static int result = 0;
    private static final List<List<String>> possibleLists = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for(int i=0; i<user_id.length; i++) {
            hashMap.put(user_id[i], new ArrayList<>());
            createNumberOfCases(user_id[i], hashMap.get(user_id[i]));
        }

        findBadUser(0, new ArrayList<>(), new boolean[user_id.length], banned_id, hashMap);

        return result;
    }

    private void createNumberOfCases(String userId, ArrayList<String> possibleList) {
        for(int i=0; i<userId.length(); i++) {
            if(userId.charAt(i) != '*') {
                String possible = userId.substring(0, i) + '*' + userId.substring(i+1);
                possibleList.add(possible);
                createNumberOfCases(possible, possibleList);
            }
        }
    }

    private void findBadUser(int select, ArrayList<String> possibles, boolean[] check, String[] banned_id, HashMap<String, ArrayList<String>> hashMap) {
        if(select == banned_id.length) {
            if(!isSame(possibles)) {
                possibleLists.add(new ArrayList<>(possibles));
                result += 1;
            }
            return;
        }

        List<String> keys = new ArrayList<>(hashMap.keySet());
        for(int j=0; j<keys.size(); j++) {
            if(hashMap.get(keys.get(j)).contains(banned_id[select])
                    && !check[j]) {
                check[j] = true;
                possibles.add(keys.get(j));
                findBadUser(select+1, possibles, check, banned_id, hashMap);
                check[j] = false;
                possibles.remove(keys.get(j));
            }
        }
    }

    private boolean isSame(ArrayList<String> possibles) {
        Collections.sort(possibles);
        return possibleLists.contains(possibles);
    }
}
