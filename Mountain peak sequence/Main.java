#include<iostream>
using namespace std;
int main()
{
  long int n;
  cin>>n;
  if(n > 2)
  {
    if(n == 3) cout<<"2";
    else
    {
      long int s = 2;
      for(int i=4;i<=n;i++)
      {
        s = (s*2 +2)%10000000007;
      }
      cout<<s;
    }
  }
  else cout<<"0";
  return 0;
}