#include<bits/stdc++.h>
#define lli long long int
using namespace std;
long long square_num(lli num)
{
  long long res = 0;
  while(num)
  {
    lli r = num%10;
    res += r*r;
    num/=10;
  }
  return res;
}
int isPrime(lli num)
{
  if(num < 2) return 0;
  if(num == 2 || num == 3) return 1;
  if(num%2 == 0 || num%3 == 0) return 0;
  lli i = 5;
  while(i < sqrt(num))
  {
    if(num%i == 0 || num%(i+2) == 0) return 0;
    i+=6;
  }
  return 1;
}
int number_of_game(lli num)
{
  lli slow = num, fast = num;
  do
  {
    slow = square_num(slow);
    fast = square_num(square_num(fast));
  } while(slow != fast);
  return (slow == 1);
}
int main()
{
  lli X=0,Y=0,N=0;
  cin>>X>>Y>>N;
  if(X > Y || X <= 0 || N <= 0) { cout<<"Invalid Input"; return 0; }
  int count = 0;
  for(lli i=X;i<=Y;i++)
  {
    if(isPrime(i) && number_of_game(i)) count++;
    if(count == N) { cout<<i; return 0; }
  }
  if(N > count) { cout<<"No number is present at this index"; }
  return 0;
}