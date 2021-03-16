/*
자연수 A, B가 주어지면 A부터 B까지의 합을 수식과 함께 출력하세요.
*/

#include <iostream> 
using namespace std; 

int main(void) {
    int a, b, i, sum=0; 

    cin >> a >> b; 

    for(i=a; i<b; i++) {
        cout << i << " + "; 
        sum += i; 
    }

    cout << b << " = " << sum; 

    return 0;
}
