#include <iostream> 
#include <math.h>
using namespace std; 

/*
자연수 N이 입력되면 1부터 N까지의 자연수를 종이에 적을 때 각 숫자는 몇 개 쓰였을까요? 
예를 들어 1부터 15까지는 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5으로 총 21개가 쓰였음을 알 수 있습니다.
자연수 N이 입력되면 1부터 N까지 각 숫자는 몇 개가 사용되었는지를 구하는 프로그램을 작성하세요.

*3<=N<=1,000,000,000이 주어진다.*
*/

int main(void) {
    int n, l, temp, total = 0; 

    cin >> n;

    l = to_string(n).size();
    total = (n - pow(10, l-1) + 1) * l;
    for(int i=l-1; i>=1; i--) {
        temp = pow(10, i) - 1;
        total += (temp - pow(10, i-1) + 1) * i; 
    }

    cout << total; 

    return 0;
}
