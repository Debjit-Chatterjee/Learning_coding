#include <bits/stdc++.h>
#include <queue>
using namespace std;
int main() 
{
  long int N,B;
  cin>>B>>N;
  priority_queue<long int> ez;
  for(int i=0;i<N;i++) { long int num; cin>>num; ez.push(num); }
  while(!ez.empty())
  {
      long int zombie = ez.top();
	  B -= (zombie%2)+(zombie/2); 
      ez.pop();
  }
  if(B <= 0)  cout<<"NO"; 
  else cout<<"YES";
  return 0;
}