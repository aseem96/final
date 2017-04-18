#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char ** argv)
{
	MPI_Comm client;
	MPI_Status status;
	char c,port_name[MPI_MAX_PORT_NAME],str[1000];
	int size,ch;
	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	MPI_Open_port(MPI_INFO_NULL,port_name);
	printf("Server running on %s \n",port_name);
	while(1)
	{
		MPI_Comm_accept(port_name,MPI_INFO_NULL,0,MPI_COMM_WORLD,&client);
		int flag=1,i=0;
		while(flag)
		{
			MPI_Recv(&ch,1,MPI_INT,MPI_ANY_SOURCE,MPI_ANY_TAG,client,&status);
			switch(status.MPI_TAG)
			{
				case 0:
					MPI_Finalize();
					break;
				case 1:
					printf("Recieved number is %d \n",ch);
					int res=1;
					for(i=1;i<=ch;i++)
					{
						res*=i;
					}
					MPI_Send(&res,1,MPI_INT,0,1,client);
					MPI_Comm_disconnect(&client);
					flag=0;
					break;
			}

		}
	}


	return 0;
} 