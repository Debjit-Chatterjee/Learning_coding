#include <bits/stdc++.h>
using namespace std;
int reverse(int num)
{
    int revnum = 0;
    while(num > 0)
    {
        int r = num%10;;
        revnum = revnum*10+r;
        num = num/10;
    }
    return revnum;
}

int sum(int num)
{
    int dig_sum = 0;
    while(num > 0)
    {
        int r = num%10;
        dig_sum += r;
        num /= 10;
    }
    return dig_sum;
}

int transform(int num)
{
    int base_6 = 0;
    while(num > 0)
    {
        int r = num%6;
        base_6 = base_6*10+r;
        num = num/6;
    }
    return base_6;
}

int main()
{
    int N;
    cin>>N;
    vector<int> sequence;
    for(int i=0;i<N;i++) { int number; cin>>number; sequence.push_back(number); }
    vector<int> derived;
    for(int i=0;i<sequence.size();i++)
    {
        int dec = sequence[i];
        derived.push_back(sum(reverse(transform(dec))));
    }
    int inversions = 0;
    for(int i=0;i<derived.size();i++)
    {
        for(int j = i+1;j<derived.size();j++)
        {
            if(derived[i] > derived[j]) inversions++;
        }
    }
    cout<</*"Inversions-->"<<*/inversions<<endl;
    return 0;
}
