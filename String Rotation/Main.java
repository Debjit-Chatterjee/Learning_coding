#include<bits/stdc++.h>
using namespace std;
int anagram(string s1, string s2)
{
  if(s1.size() != s2.size()) return 0;
  int *count = (int*)calloc(sizeof(int), 26); // There are 256 charcaters.
  for(int i=0;s1[i]&&s2[i];i++)
  {
    count[s1[i]-'a']++; count[s2[i]-'a']--;
  }
  for(int i=0;i<26;i++)
  {
    if(count[i] != 0) return 0;
  }
  return 1;
}
int main()
{
  string str;
  cin>>str;
  int rot; cin>>rot;
  if(str.size()<1 || str.size()>30 || rot<1 || rot>10) return 0;
  string first_char, temp = str;
  while(rot--)
  {
    char dir; int times;
    cin>>dir>>times;
    if(dir == 'L') 
    {
      while(times--)
 	 {
    	char f = str[0];
    	str.replace(0,1,"");
    	str += f;
  	 }
    }//rotateLeft(&str,times);
    else
    {
      while(times--)
  	{
    	char l = str[str.size()-1];
    	str.replace(str.size()-1,str.size(),"");
    	str = l+str;
  	}
    }//rotateRight(&str,times);
    first_char += str[0];
  }
  //cout<<"first characters string: "<<first_char<<endl;
  for(int i=0;i<str.size();i++)
  {
    string part = temp.substr(i,first_char.size());
    //cout<<"part is --> "<<part<<endl;
    if(anagram(first_char,part)) { cout<<"YES"; return 0; }
  }
  cout<<"NO";
  return 0;
}