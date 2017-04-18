#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char ** argv)
{

	MPI_Comm client;
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
	MPI_Open_port(MPI_INFO_NULL,port_name);
	printf("Server running on port %s",port_name);
	while(1)
	{
		MPI_Comm_accept(port_name,MPI_INFO_NULL,0,MPI_COMM_WORLD,&client);
		MPI_Recv(&i,1,MPI_INT,MPI_ANY_SOURCE,MPI_ANY_TAG,client,&status);
		j=(float)1/(float)i;
		MPI_Send(&j,1,MPI_FLOAT,0,1,client);
	}
	MPI_Finalize();





	return 0;
}