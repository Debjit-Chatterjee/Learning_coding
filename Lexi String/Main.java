#include<bits/stdc++.h>
using namespace std;
int main()
{
  int test;
  cin>>test;
  while(test--)
  {
    string dict, str;
    cin>>dict>>str;
    int *freq = (int*)calloc(sizeof(int),256);
    for(int i=0;str[i];i++)
    {
      freq[str[i]]++;
    }
    for(int i=0;dict[i];i++)
    {
      if(freq[dict[i]] != 0)
      {
        while(freq[dict[i]]--) cout<<dict[i];
      }
    }
    cout<<endl;
  }
  return 0;
}