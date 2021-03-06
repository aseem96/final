/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _2RPC_H_RPCGEN
#define _2RPC_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct s {
	int a;
};
typedef struct s s;

#define RECP_PROG 0x12345678
#define RECP_VERSION 1

#if defined(__STDC__) || defined(__cplusplus)
#define RECP 1
extern  float * recp_1(s *, CLIENT *);
extern  float * recp_1_svc(s *, struct svc_req *);
extern int recp_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define RECP 1
extern  float * recp_1();
extern  float * recp_1_svc();
extern int recp_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_s (XDR *, s*);

#else /* K&R C */
extern bool_t xdr_s ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_2RPC_H_RPCGEN */
