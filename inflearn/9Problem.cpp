#include <iostream> 
using namespace std; 

/*
N개의 자연수가 입력되면 각 자연수의 자릿수의 합을 구하고, 그 합이 최대인 자연수를 출력 하는 프로그램을 작성하세요. 
각 자연수의 자릿수의 합을 구하는 함수를 int digit_sum(int x)를 꼭 작성해서 프로그래밍 하세요.
*/

int digit_sum(int x) {
    int sum = 0; 

    string str_x = to_string(x);   

    for(int i=0; i<str_x.size(); i++) {
        sum += (str_x[i]-48);
    }

    return sum;
}

int digit_sum2(int x) {
    int temp, sum=0; 
    //125 --> temp = 5, x = 12 -> temp = 2, x = 1 -> temp = 1, x = 0  
    while(x>0) {
        temp=x%10; 
        sum+=temp; 
        x=x/10; 
    }

    return sum;
}

int main(void) {
    int n, sum, max_number=-1, result, number; 

    cin >> n; 

    for(int i=0; i<n; i++) {
        scanf("%d", &number); 
        int sum = digit_sum2(number);
        if(max_number < sum) {
            max_number = sum;
            result = number;
        }
        else if(max_number == sum && number > result) {
            result = number;
        }
    }

    cout << result;

    return 0;
}
