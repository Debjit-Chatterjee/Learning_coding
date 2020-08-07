#include<bits/stdc++.h>
using namespace std;

int main()
{
  unsigned long int n;
  int k;
  cin>>n>>k;
  unsigned long int factor = n;
  int count=0;
  for(unsigned long int i=n; i>0;i--)
  {
    if(count == k) break;
    if(n%i == 0 && i <= factor) { factor = i; count++; }
  }
  if(count < k) cout<<"1";
  else cout<<factor;
  return 0;
}