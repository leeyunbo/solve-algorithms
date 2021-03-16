#include <iostream> 
using namespace std; 

/*
자연수 N이 주어지면 자연수 N의 진약수의 합을 수식과 함께 출력하는 프로그램을 작성하세요.
*/

int main(void) {
    int n, sum=1; 

    cin >> n;

    // 1은 모든 수의 진약수에 포함되니까, 1을 무조건 포함하는 방법으로 패턴을 구현한다.
    cout << 1;

    for(int i=2; i<n; i++) {
        if( n % i == 0) {
            cout << " + " << i; 
            sum += i;
        }
    }

    cout << " = " << sum;

    return 0;
}
