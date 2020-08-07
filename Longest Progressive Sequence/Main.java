#include <bits/stdc++.h>
using namespace std;
int main()
{
  int n;
  cin>>n;
  int *arr = new int[n];
  for(int i=1;i<=n;i++) cin>>arr[i];
  int start = 0, end = 0, i = 1, max_count = 0;
  while(i <= n)
  {
    int j = i, count = 0; //cout<<"j value --> "<<j<<endl;
    while(arr[j+1] >= arr[j] && j < n) { count++; j++; }
   // cout<<"max_count -->"<<max_count<<" count --> "<<count<<endl;
    if(count > max_count)
    { max_count = count; start = i; end = j;}
    //cout<<"updated j value --> "<<j<<endl;
    //cout<<"longest subsequence between --> ("<<start<<", "<<end<<")"<<endl;
    i = j+1; //cout<<"updated i values --> "<<i<<endl;
  }
  //cout<<"longest subsequence between --> ("<<start<<", "<<end<<")"<<endl;
  for(int i=start; i <= end; ++i)
    cout<<arr[i]<<" ";
  return 0;
}