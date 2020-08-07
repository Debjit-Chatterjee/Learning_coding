#include<bits/stdc++.h>
using namespace std;
int main()
{
  int test;
  cin>>test;
  while(test--)
  {
    int n;
    cin>>n;
    priority_queue<int, vector<int>, greater<int>> candies;
    for(int i=0;i<n;i++)
    { int num; cin>>num; candies.push(num); }
    int time_taken = 0;
    for(int i=0;i<=n-2;i++)
    {
      int m1 = candies.top(); candies.pop();
      //cout<<"minimum 1 --> "<<m1<<endl;
      int m2 = candies.top(); candies.pop();
      //cout<<"minimum 2 --> "<<m2<<endl;
      time_taken += m1 + m2;
      //cout<<"time taken = "<<time_taken<<endl;
      candies.push(m1+m2);
    }
    cout<<time_taken<<endl;
  }
  return 0;
}