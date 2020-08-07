#include<bits/stdc++.h>
#define lli long long int 
using namespace std;
lli factorial(lli n) 
{  
    return (n==1 || n==0) ? 1: n * factorial(n - 1);  
} 

lli next_comb(lli *arr,int n)
{
  int i=0;
  lli number=0;
  while(i < n)
  {
    number = number*10+arr[i];
    i++;
  }
  return number;
}
int main(){
  lli a,b;
  cin>>a>>b;
  lli first = a, second = b, count_f = 0, count_s = 0;
  lli result = -1;
  while(first > 0 && second > 0)
  {
    count_f++; first /=10;
    count_s++; second/=10;
  }
  while(first > 0) { count_f++; first/=10; }
  //cout<<"count_f = "<<count_f<<" count_s = "<<count_s<<endl;
  if(!(count_f < count_s))
  {
    lli *first_number = new lli[count_f], first = a;
    for(int i=0;i<count_f;i++)
    {
      first_number[i] = first%10; 
      first/=10;
    }
    /*cout<<"display first number"<<endl;
    for(int i=0;i<count_f;i++) cout<<first_number[i]<<" "; cout<<endl;*/
    
    sort(first_number, first_number+count_f);
    
    /*cout<<"display first number sorted"<<endl;
    for(int i=0;i<count_f;i++) cout<<first_number[i]<<" "; cout<<endl;*/
    lli i = 0;
    //cout<<"b is  -- > "<<b<<endl;
    lli number = next_comb(first_number,count_f);
    if(number >= b) result = number;
    else
    {
      while(i < factorial(count_f))
      {
      	next_permutation(first_number, first_number+count_f);
      	lli next_number = next_comb(first_number, count_f);
      	//cout<<"Next Number is --> "<<next_number<<endl;
      	if(next_number > b) { result = next_number; break; }
      	i++;
      }
    }
  }
  cout<<result;
  return 0;
}