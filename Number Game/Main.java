#include<bits/stdc++.h>
using namespace std;
int main(){
  int N;
  cin>>N;
  int *arr = new int[N];
  for(int i=0;i<N;i++) cin>>arr[i];
  int sum = 0;
  for(int i = 0;i<N;i++)
  {
    sum = sum ^ arr[i];
  }
  if(sum == 0) cout<<"JASBIR";
  else cout<<"AMAN";
  return 0 ;
}