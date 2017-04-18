#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char ** argv)
{

	MPI_Comm server;
	MPI_Status status;
	char port_name[MPI_MAX_PORT_NAME];
	int i,size;
	float j;

	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	if(size!=1)
	{
		printf("Server too big \n");
		return 0;
	}
	strcpy(port_name,argv[1]);
	MPI_Comm_connect(port_name,MPI_INFO_NULL,0,MPI_COMM_WORLD,&server);
	printf("Enter the number\n ");
	scanf("%d",&i);
	MPI_Send(&i,1,MPI_INT,0,1,server);
	MPI_Recv(&j,1,MPI_FLOAT,0,1,server,&status);
	printf("Reciprocal is %f\n",j );
		MPI_Finalize();
	return 0;
}

