#include<bits/stdc++.h>
#define ld long double
#define lli long long int
using namespace std;
ld emi_calculation(lli p,  ld n, ld i)
{
  ld emi = 0;
  ld blah = 1/(pow(1+i,(12 * n)));
  blah = 1 - blah;
  emi = (p * i)/blah;
  return emi;
}
int main()
{
  lli p;
  int t;
  cin>>p>>t;
  vector<ld> emi;
  int i=2;
  while(i--)
  {
    int s; cin>>s;
    ld ar[s][2];
    for(int it= 0;it<s;it++)
    {
      for(int jt=0;jt<2;jt++)
      {
        cin>>ar[it][jt];
      }
    }
    ld bank = 0;
    for(int it= 0;it<s;it++)
    {
        bank += emi_calculation(p,ar[it][0],ar[it][1]);
    }
    emi.push_back(bank);
  }
  if(emi[0] >= emi[1]) cout<<"Bank B";
  else cout<<"Bank A";
  return 0;
}