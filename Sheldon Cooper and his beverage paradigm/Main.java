#include<bits/stdc++.h>
using namespace std;
int pairSolve(int *arr,int X, int in,int n)
{
    int low = in, high = n-1;
    while(!(low >= high))
    {
        if(arr[low]+arr[high] > X) high--;
        else if(arr[low]+arr[high] < X) low++;
        else return 1;
    }
    return 0;
}
int solve(int *arr, int X,int n)
{
    sort(arr,arr+n);
    for(int i=0;i<n-2;i++)
    {
        if(pairSolve(arr,X-arr[i],i+1,n)) return 1;
    }
    return 0;
}
int main()
{
        int n;
        cin>>n;
        int *drinks = new int[n];
        for(int i=0;i<n;i++) cin>>drinks[i];
        int sum; cin>>sum;
        if(solve(drinks,sum,n)) cout<<"TRUE"<<endl;
        else cout<<"FALSE"<<endl;
    return 0;
}