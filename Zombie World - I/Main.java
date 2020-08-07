#include <bits/stdc++.h>
#include <queue>
using namespace std;
int main() 
{
   int test;
  cin>>test;
  while(test--)
  {
    int n,t;
  	cin>>n>>t;
     priority_queue <int,vector<int>,greater<int>> ez;
  	for(int i=0;i<n;i++) { int num; cin>>num; ez.push(num); }
  	int p,d;
  	cin>>p>>d;
    if(n > t) cout<<"NO";
  	else
  	{
      //cout<<"N = "<<n<<" T = "<<t<<" P = "<<p<<" D = "<<d<<endl; 
    	while(!ez.empty())
    	{
          if(p >= ez.top())
          {
            p += p-ez.top();
      		ez.pop();
          }
          else break;
    	}
    	if(p >= d && ez.empty()) cout<<"YES";
    	else cout<<"NO";
  	}
  }
    return 0;
}