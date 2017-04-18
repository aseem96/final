#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char ** argv)
{
	MPI_Comm server;
	MPI_Status status;
	char c,port_name[MPI_MAX_PORT_NAME],str[1000];
	int size,ch;
	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	strcpy(port_name,argv[1]);
	MPI_Comm_connect(port_name,MPI_INFO_NULL,0,MPI_COMM_WORLD,&server);
	int no;
	printf("Enter the number \n");
	scanf("%d",&no);
	MPI_Send(&no,1,MPI_INT,0,1,server);
	MPI_Recv(&no,1,MPI_INT,0,1,server,&status);
	printf("Factorial is %d \n",no);

MPI_Finalize();
	return 0;
}