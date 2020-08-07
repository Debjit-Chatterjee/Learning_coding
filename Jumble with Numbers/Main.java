#include<bits/stdc++.h>
using namespace std;
int main()
{
  long t1, t2, m;
  cin>>t1>>t2>>m;
  if(t1 <= 0 || t2 <= 0 || t1 > 1000000 || t2 > 1000000 || m <= 0)
    cout<<"Invalid Input";
  else
  {
    vector<int> series;
    long i = 1, j = 1;
    while(i*j <= t2)
    {
      series.push_back(i*j);
      i++; j+=2;
    }
    i=0, j=0;
    while(series[i] < t1) i++;
    while(series[i] <= t2 && i < series.size())
    {
      j++;
      if(j == m) { cout<<series[i]; return 0; }
      i++;
    }
    cout<<"No number is present at this index";
  }
  return 0;
}
