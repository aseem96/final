#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc,char **argv)
{
	MPI_Comm client;
	MPI_Status status;
	char ch,port_name[MPI_MAX_PORT_NAME];
	char str[1000];
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	MPI_Open_port(MPI_INFO_NULL,port_name);
	printf("Server running at port %s \n",port_name);
	while(1)
	{
		MPI_Comm_accept(port_name,MPI_INFO_NULL,0,MPI_COMM_WORLD,&client);
		int flag=1,int i=0;
		while(flag)
		{
			MPI_Recv(&ch,1,MPI_CHAR,MPI_ANY_SOURCE,MPI_ANY_TAG,client,&status);
			switch(status.MPI_TAG)
			{
				case 0:
					break;
				case 1:
					printf("Recieved string is %s \n",str);
					int j=i-1;
					char temp;
					i=0;
					while(i<j)
					{
						temp=str[i];
						str[i]=str[j];
						str[j]=temp;
						i++;
						j--;
					}
					i=0;
					while(i<strlen(str))
					{
						ch=str[i++];
						MPI_Send(&ch,1,MPI_CHAR,0,2,client);
					}
					MPI_Send(&ch,1,MPI_CHAR,0,1,client);
					MPI_Comm_disconnect(&client);
					flag=0;
					break;
				case 2:
					str[i++]=ch;
					str[i]='\0';
					break;
	
			}
		}
	}


	retun 0;
}