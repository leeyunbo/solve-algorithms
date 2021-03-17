#include <iostream> 
using namespace std; 

/*
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
▣ 입력설명
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
▣ 출력설명
첫 번째 줄에 YES, NO를 출력한다.
*/

int main(void) {
    
    int cnt = 0;
    string input; 

    getline(cin, input); 

    // 닫는 괄호가 먼저 나오면 cnt가 무조건 음수가 된다. (NO) 
    for(int i=0; i<input.size() && cnt >= 0; i++) {
        if(input[i] == '(') {
            cnt++;
        }
        else {
            cnt--;
        }
    }

    if(cnt == 0) cout << "YES"; 
    else cout << "NO";
    

    return 0;
}
