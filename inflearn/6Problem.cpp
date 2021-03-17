#include <iostream> 
#include <string>
using namespace std; 

/*
▣ 입력설명
첫 줄에 바이러스에 걸린 영어단어가 주어진다.
바이러스에 걸린 영어단어의 길이(공백포함)는 100을 넘지 않는다. 
문자사이의 공백은 연속적으로 존재할 수 있습니다. 
입력은 알파벳과 공백만 주어집니다.

▣ 출력설명
첫 줄에 소문자로 된 정상적인 영어단어를 출력한다.
*/

int main(void) {

    string word; 

    //엔터가 나올 때 까지 입력을 받는 함수, char 배열로 읽으면 gets 사용할 것  
    getline(cin, word); 

    for(int i=0; i<word.size(); i++) {
        if(word[i] != ' ') {
            if(word[i] >= 97) cout << word[i]; 
            else cout << (char)(word[i]+32); 
        }
    }

    return 0;
}
