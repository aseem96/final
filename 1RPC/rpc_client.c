/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "rpc.h"


void
fact_prog_1(char *host)
{
	CLIENT *clnt;
	int  *result_1;
	s  factorial_1_arg;

	printf("Enter the number to calculate \n");
	scanf("%d",&(factorial_1_arg.a));

#ifndef	DEBUG
	clnt = clnt_create (host, FACT_PROG, FACT_VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	result_1 = factorial_1(&factorial_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	else
	{
		printf("factorial is %d",*result_1);
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	fact_prog_1 (host);
exit (0);
}
