
#include<iostream>
using namespace std;

#define MAX_ROW_SIZE 20
#define MAX_COL_SIZE 20

void compute_total_burn_time(char forest_layout[][MAX_COL_SIZE],
                        int current_row,
                        int current_col,
						int total_rows, int total_col,
                        unsigned int forest_fire_time[][MAX_ROW_SIZE],
                        unsigned int current_time)
{
    if((current_row >= total_rows) || (current_row < 0)  ||
       (current_col >= total_col)  || (current_col < 0))
    {
        return;
    }

	if(forest_layout[current_row][current_col] == 'W')
	{
		return;
	}


    // Current path to reach takes more time than the previous path
    if((forest_fire_time[current_row][current_col] != -1) && 
       (current_time >= forest_fire_time[current_row][current_col]))
    {
        return;
    }

    forest_fire_time[current_row][current_col] = current_time;

    compute_total_burn_time(forest_layout,
                       current_row, current_col+1,
			           total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row - 1, current_col,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row, current_col - 1,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row + 1, current_col,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);
					   
	compute_total_burn_time(forest_layout,
                       current_row-1, current_col-1,
			           total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row - 1, current_col + 1,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row + 1, current_col - 1,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    compute_total_burn_time(forest_layout,
                       current_row + 1, current_col + 1,
                       total_rows, total_col,
                       forest_fire_time,
                       current_time + 1);

    return;
}

unsigned int compute_total_burn_time_wrap(char forest_layout[][MAX_COL_SIZE],
								int first_infec_tree_row,
                                int first_infec_tree_col,
                                int total_rows, int total_col)
{
	// Tracking time for each room
    unsigned int forest_fire_time[MAX_ROW_SIZE][MAX_COL_SIZE];

    int i,j;
    for(i = 0; i < total_rows; i++)
    {
        for(j = 0; j < total_col; j++)
        {
            // Init infinite time for each path
            // How -1 is infinite time??
            forest_fire_time[i][j] = -1;
        }
    }
	
	//forest_fire_time[first_infec_tree_row][first_infec_tree_col] = 1;
	
    compute_total_burn_time(forest_layout,
					   first_infec_tree_row,
                       first_infec_tree_col,
					   total_rows, total_col,
                       forest_fire_time,
                       1 /* Current time */);
  

    int max = 0;
	for(i = 0; i < total_rows; i++)
    {
        for(j = 0; j < total_col; j++)
        {
            if((forest_fire_time[i][j] != -1) && (max < forest_fire_time[i][j]))
			{
				max = forest_fire_time[i][j];
			}
        }
    }

	return max;
}

int main() {
    // Input
    int total_rows, total_col;
    int first_infec_tree_row, first_infec_tree_col;
	char forest_layout[MAX_ROW_SIZE][MAX_COL_SIZE];

    int i,j;

    cin>>total_rows>>total_col;
    
	cin>>first_infec_tree_row>>first_infec_tree_col;
	
	for(i = 0; i < total_rows; i++)
	{
		for(j = 0; j < total_col; j++)
		{
			if(j != (total_col - 1))
			{
				cin>>forest_layout[i][j];
			}
			else
			{
				cin>>forest_layout[i][j];
			}
		}
	}

    int time_taken = compute_total_burn_time_wrap(forest_layout,
							   first_infec_tree_row - 1,
                               first_infec_tree_col - 1,
							   total_rows, total_col);

    cout<<time_taken;

    return 0;
}
