/*
1부터 N까지 M의 배수합
자연수 N이 입력되면 1부터 N까지의 수 중 M의 배수합을 출력하는 프로그램을 작성하세요.
*/

#include <iostream> 
using namespace std; 

int main(void) {
    int n, m, i, sum=0; 

    cin >> n >> m;

    for(i=1; i<=n; i++) {
        if(i % m == 0) {
            sum += i; 
        }
    } 

    cout << sum; 
    

    return 0;
}
