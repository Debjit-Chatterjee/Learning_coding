#include<bits/stdc++.h>
using namespace std;

int count(int l, int b)
{
  int sum = 0;
  while(l && b)
  {
    sum++;
    if(l > b) l -= b;
    else b -= l;
  }
  return sum;
}

int main()
{
  int minL,maxL,minB,maxB;
  cin>>minL>>maxL>>minB>>maxB;
  int students = 0;
  if(minL < 1501 && maxL < 1501 && minB < 1501 && maxB < 1501)
  {
    for(int i=minL;i <= maxL;i++)
    {
      for(int j=minB;j <= maxB;j++)
      {
        students += count(i,j);
      }
    }
  }
  cout<<students;
  return 0;
}