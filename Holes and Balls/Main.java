#include<bits/stdc++.h>
#define lli long long int
using namespace std;
int main()
{
    int no_holes;
    cin>>no_holes;
    vector<lli> holes_d;
    for(int i=0;i<no_holes;i++)
    { int num; cin>>num; holes_d.push_back(num); }
    pair<int, int> holes[no_holes];
    for(int i=0;i<no_holes;i++)
    { holes[i].first = -1; holes[i].second = i; }
    int no_balls;
    cin>>no_balls;
    while(no_balls--)
    {
        lli balls_d;
        cin>>balls_d;
        int i = no_holes-1;
        for(i = no_holes-1;i>=0;i--)
        {
            
            //cout<<"Hole number is --> "<<i+1<<endl;
            if(holes_d[i] >= balls_d)
            {
                if(holes[i].first < holes[i].second)
                {
                    holes[i].first++;
                    cout/*<<balls_d<<" --> "*/<<i+1<<" ";//<<endl;
                    break;
                }
            }
        }
        if(i == -1)
        { cout/*<<balls_d<<" --> "*/<<"0"<<" ";/*<<endl;*/ }
    }
    return 0;
}