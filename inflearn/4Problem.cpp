#include <iostream> 
using namespace std; 

/*
N(2<=N<=100)명의 나이가 입력됩니다. 이 N명의 사람 중 가장 나이차이가 많이 나는 경우는
몇 살일까요? 최대 나이 차이를 출력하는 프로그램을 작성하세요.
*/

int main(void) {
    int n, i, a, max=-2147000000, min=2147000000;
    cin>>n; 

    for(i=1; i<n; i++) {
        cin>>a;
        if(max < a) max = a;
        if(min > a) min = a;
    }

    cout<<max - min; 
    

    return 0;
}
