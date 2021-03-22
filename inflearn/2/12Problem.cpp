#include <iostream> 
using namespace std; 

int main(void) {
    int cnt[10]; 
    char n[101]; 
    int result, max = -1; 


    scanf("%s", &n);

    for(int i=0; n[i]!='\0'; i++) {
        int digit = n[i]-48;
        cnt[digit]++; 
    }

    for(int i=0; i<=9; i++) {
        if(cnt[i] >= max) {
            max = cnt[i]; 
            result = i; 
        }
    }

    printf("%d\n", result); 



    return 0;
}
