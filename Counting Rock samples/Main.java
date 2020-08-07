#include <bits/stdc++.h>
using namespace std;

int main()
{
  int S,R;
  cin>>S>>R;
  vector<int> samples;
  for(int i=0;i<S;i++) { int num; cin>>num; samples.push_back(num); }
  vector<int> ranges;
  for(int i=0;i<2*R;i++) { int num; cin>>num; ranges.push_back(num); }
  
  vector<int> accepted; 
  int in = 0; while(in < R) { accepted.push_back(0); in++; } 
  int i = 0;
  while(i < samples.size())
  {
    int j = 0;
    while(j < ranges.size())
    {
      if(samples[i] >= ranges[j] && samples[i] <= ranges[j+1]) accepted[j/2]++;
      j += 2;
    }
    i++;
  }
  for(int k=0;k<accepted.size();k++)
    cout<<accepted[k]<<" ";
  return 0;
}