#include<bits/stdc++.h>
using namespace std;
int main(){
  int test;
  cin>>test;
  while(test--)
  {
    int r,n;
    cin>>r>>n;
    if(r >= n) cout<<"1"<<endl;
    else
    {
      vector<long long int> factorial;
      factorial.push_back(1);
      for(int i=1;i<=n+1;i++) factorial.push_back(i*factorial[i-1]);
      int PA = 0, PB = 0, TA = 0, TB = 0;
      PA = n/r;
      PB = PA+1;
      TB = n%r;
      TA = r-TB;
      long int divide = 0, arrange = 0;
      divide = factorial[n]/( pow(factorial[PA],TA) * pow(factorial[PB],TB) * factorial[TA] * factorial[TB] );
      if(PB >= 4)
      {
        arrange = divide * pow(factorial[PA-1]/2,TA) * pow(factorial[PB-1]/2,TB);
      }
      else arrange = divide;
      cout<<arrange<<endl;
    }
  }
  return 0;
}