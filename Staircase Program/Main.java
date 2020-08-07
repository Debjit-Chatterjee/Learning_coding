#include<bits/stdc++.h>
#define uli unsigned long int
using namespace std;
uli stair_count(int n)
{
  if(n == 1) return 1;
  if(n == 2) return 2;
  uli first = 1, second = 2, res = 0; int i = 3;
  while(i <= n)
  {
    res = first + second;
    first = second;
    second = res;
    i++;
  }
  return res;
}
int main()
{
  int n;
  cin>>n;
  cout<<stair_count(n);
  return 0;
}