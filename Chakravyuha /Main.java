#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n;
  cin>>n;
  int **chakra = new int *[n];
  for(int i=0;i<n;i++) chakra[i] = new int[n];
  int powerPoints = 1 + ((n*n)/11);
  vector<int> points; points.push_back(0); points.push_back(0);
  int count = 1;
  for(int i=0;i<n/2;i++)
  {
    int k = i, j = i;
    while(j < n-i-1)
    {
      chakra[k][j] = count++;
      if(chakra[k][j]%11 == 0) { points.push_back(k); points.push_back(j); }
      j++;
    }
    while(k < n-i-1)
    {
      chakra[k][j] = count++;
      if(chakra[k][j]%11 == 0) { points.push_back(k); points.push_back(j); }
      k++;
    }
    while(j > i)
    {
      chakra[k][j] = count++;
      if(chakra[k][j]%11 == 0) { points.push_back(k); points.push_back(j); }
      j--;
    }
    while(k > i)
    {
      chakra[k][j] = count++;
      if(chakra[k][j]%11 == 0) { points.push_back(k); points.push_back(j); }
      k--;
    }
  }
  if(n%2 != 0)
  {
    chakra[n/2][n/2] = count;
    if(chakra[n/2][n/2]%11 == 0) { points.push_back(n/2); points.push_back(n/2); }
  }
  for(int row = 0;row < n;row++)
  {
    for(int col = 0;col < n;col++)
    {
      cout<<chakra[row][col]<<"\t";
    }
    cout<<"\n";
  }
  cout<<"Total Power points : "<<powerPoints<<endl;
  for(int i=0;i<points.size();i+=2)
    cout<<"("<<points[i]<<", "<<points[i+1]<<")"<<endl;
  return 0;
}
