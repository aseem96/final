/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "2rpc.h"

float *
recp_1_svc(s *argp, struct svc_req *rqstp)
{
	static float  result;

	/*
	 * insert server code here
	 */
	 int a=argp->a;
	 result=(float)1/(float)a;

	return &result;
}
