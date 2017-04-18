/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "rpc.h"


void
feet_meter_1(char *host)
{
	CLIENT *clnt;
	float  *result_1;
	s  feettometer_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, FEET_METER, FEET_MET, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	printf("Enter value in feet \n");
	scanf("%d",&feettometer_1_arg.a);

	result_1 = feettometer_1(&feettometer_1_arg, clnt);
	if (result_1 == (float *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	else
	{
		printf("meter value is %f \n",*result_1);
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
	feet_meter_1 (host);
exit (0);
}