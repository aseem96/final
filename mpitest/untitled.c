# include <mpi.h>
# include <stdio.h>

int main()
{
	MPI_Init(NULL,NULL);
	int word_size;
	MPI_Comm_size(MPI_COMM_WORLD,&word_size);

	char pro_nme[MPI_MAX_PROCESSOR_NAME];
	int len;
	MPI_Get_processor_name(pro_nme,&len);

	printf("Hello world from %s processor \n",pro_nme);

	MPI_Finalize();



	return 0;
}