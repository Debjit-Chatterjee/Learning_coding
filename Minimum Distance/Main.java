#include<bits/stdc++.h>
#define li long long int
using namespace std;
int main()
{
  li X,Y,Vx,Vy;
  cin>>X>>Y>>Vx>>Vy;
  if(!(X<=0 || Y<=0 || Vx<=0 || Vy<=0)) {
    double distance = sqrt((X*X) + (Y*Y));
  	//printf("%.11lf",distance);
  	while(X>=0 || Y>=0)
  	{
  	  X = X-Vx; //cout<<"X updated "<<X<<endl;
  	  Y = Y-Vy; //cout<<"Y updated "<<Y<<endl;
  	  double dist = sqrt((X*X) + (Y*Y));
  	  if(dist < distance) distance = dist;
  	}
  	if(distance == 0) cout<<"0.0";
  	else printf("%.11lf",distance);
  }
  else cout<<"Invalid Input";
  return 0;
}