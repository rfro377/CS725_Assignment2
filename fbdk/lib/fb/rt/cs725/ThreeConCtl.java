/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ThreeConCtl
  * @author JHC
  * @version 20201028/JHC
  */
public class ThreeConCtl extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE_A */
  public BOOL PE_A = new BOOL();
/** VAR PE_B */
  public BOOL PE_B = new BOOL();
/** VAR PE_C */
  public BOOL PE_C = new BOOL();
/** VAR PE_D */
  public BOOL PE_D = new BOOL();
/** VAR PE_E */
  public BOOL PE_E = new BOOL();
/** VAR IN_LAMPORT */
  public UINT IN_LAMPORT = new UINT();
/** VAR isProc0Requested */
  public BOOL isProc0Requested = new BOOL();
/** VAR isProc0Replied */
  public BOOL isProc0Replied = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR MotoRotate3 */
  public BOOL MotoRotate3 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR OUT_LAMPORT */
  public UINT OUT_LAMPORT = new UINT();
/** VAR thisProcRequested */
  public BOOL thisProcRequested = new BOOL();
/** VAR replyToProc0 */
  public BOOL replyToProc0 = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT CAS_STOP */
 public EventOutput CAS_STOP = new EventOutput();
/** EVENT CAS_START */
 public EventOutput CAS_START = new EventOutput();
/** EVENT GRANTED_RING_TOKEN */
 public EventOutput GRANTED_RING_TOKEN = new EventOutput();
/** EVENT I_PE_EVENT */
 public EventOutput I_PE_EVENT = new EventOutput();
/** EVENT CONFIRM_RELEASE_RING_TOKEN_IN */
 public EventOutput CONFIRM_RELEASE_RING_TOKEN_IN = new EventOutput();
/** EVENT IN_REPLY */
 public EventOutput IN_REPLY = new EventOutput();
/** EVENT IN_REQUEST */
 public EventOutput IN_REQUEST = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT RELEASE_RING_TOKEN */
 public EventOutput RELEASE_RING_TOKEN = new EventOutput();
/** EVENT CONFIRM_RELEASE_RING_TOKEN_OUT */
 public EventOutput CONFIRM_RELEASE_RING_TOKEN_OUT = new EventOutput();
/** EVENT Initial_Release */
 public EventOutput Initial_Release = new EventOutput();
/** EVENT OUT_REPLY */
 public EventOutput OUT_REPLY = new EventOutput();
/** EVENT OUT_REQUEST */
 public EventOutput OUT_REQUEST = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("GRANTED_RING_TOKEN".equals(s)) return GRANTED_RING_TOKEN;
    if("I_PE_EVENT".equals(s)) return I_PE_EVENT;
    if("CONFIRM_RELEASE_RING_TOKEN_IN".equals(s)) return CONFIRM_RELEASE_RING_TOKEN_IN;
    if("IN_REPLY".equals(s)) return IN_REPLY;
    if("IN_REQUEST".equals(s)) return IN_REQUEST;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("RELEASE_RING_TOKEN".equals(s)) return RELEASE_RING_TOKEN;
    if("CONFIRM_RELEASE_RING_TOKEN_OUT".equals(s)) return CONFIRM_RELEASE_RING_TOKEN_OUT;
    if("Initial_Release".equals(s)) return Initial_Release;
    if("OUT_REPLY".equals(s)) return OUT_REPLY;
    if("OUT_REQUEST".equals(s)) return OUT_REQUEST;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("Candidate".equals(s)) return Candidate;
    if("Block".equals(s)) return Block;
    if("PE_A".equals(s)) return PE_A;
    if("PE_B".equals(s)) return PE_B;
    if("PE_C".equals(s)) return PE_C;
    if("PE_D".equals(s)) return PE_D;
    if("PE_E".equals(s)) return PE_E;
    if("IN_LAMPORT".equals(s)) return IN_LAMPORT;
    if("isProc0Requested".equals(s)) return isProc0Requested;
    if("isProc0Replied".equals(s)) return isProc0Replied;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
    if("MotoRotate3".equals(s)) return MotoRotate3;
    if("BlockCon".equals(s)) return BlockCon;
    if("OUT_LAMPORT".equals(s)) return OUT_LAMPORT;
    if("thisProcRequested".equals(s)) return thisProcRequested;
    if("replyToProc0".equals(s)) return replyToProc0;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("PE_A".equals(ivName)) connect_PE_A((BOOL)newIV);
    else if("PE_B".equals(ivName)) connect_PE_B((BOOL)newIV);
    else if("PE_C".equals(ivName)) connect_PE_C((BOOL)newIV);
    else if("PE_D".equals(ivName)) connect_PE_D((BOOL)newIV);
    else if("PE_E".equals(ivName)) connect_PE_E((BOOL)newIV);
    else if("IN_LAMPORT".equals(ivName)) connect_IN_LAMPORT((UINT)newIV);
    else if("isProc0Requested".equals(ivName)) connect_isProc0Requested((BOOL)newIV);
    else if("isProc0Replied".equals(ivName)) connect_isProc0Replied((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    Conv7Ctl.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    Conv7Ctl.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE_A
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_A(BOOL newIV) throws FBRManagementException{
    PE_A = newIV;
    Conv7Ctl.connectIVNoException("PE_IN",PE_A);
    }
/** Connect the given variable to the input variable PE_B
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_B(BOOL newIV) throws FBRManagementException{
    PE_B = newIV;
    Conv7Ctl.connectIVNoException("PE_OUT",PE_B);
    }
/** Connect the given variable to the input variable PE_C
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_C(BOOL newIV) throws FBRManagementException{
    PE_C = newIV;
    FC13.connectIVNoException("PE",PE_C);
    Conv8Ctl.connectIVNoException("PE_IN",PE_C);
    }
/** Connect the given variable to the input variable PE_D
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_D(BOOL newIV) throws FBRManagementException{
    PE_D = newIV;
    Conv8Ctl.connectIVNoException("PE_OUT",PE_D);
    }
/** Connect the given variable to the input variable PE_E
  * @param newIV The variable to connect
 */
  public void connect_PE_E(BOOL newIV){
    PE_E = newIV;
    }
/** Connect the given variable to the input variable IN_LAMPORT
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_IN_LAMPORT(UINT newIV) throws FBRManagementException{
    IN_LAMPORT = newIV;
    Conv8Ctl.connectIVNoException("IN_LAMPORT",IN_LAMPORT);
    }
/** Connect the given variable to the input variable isProc0Requested
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_isProc0Requested(BOOL newIV) throws FBRManagementException{
    isProc0Requested = newIV;
    Conv8Ctl.connectIVNoException("isProc0Requested",isProc0Requested);
    }
/** Connect the given variable to the input variable isProc0Replied
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_isProc0Replied(BOOL newIV) throws FBRManagementException{
    isProc0Replied = newIV;
    Conv8Ctl.connectIVNoException("isProc0Replied",isProc0Replied);
    }
/** FB Conv7Ctl */
  protected ConveyorRingTokenCTL Conv7Ctl = new ConveyorRingTokenCTL() ;
/** FB Conv8Ctl */
  protected ConveyorCTLMulticast Conv8Ctl = new ConveyorCTLMulticast() ;
/** FB FC13 */
  protected ConveyorCTL FC13 = new ConveyorCTL() ;
/** The default constructor. */
public ThreeConCtl(){
    super();
    INIT.connectTo(Conv7Ctl.INIT);
    REQ.connectTo(Conv7Ctl.REQ);
    Conv7Ctl.INITO.connectTo(Conv8Ctl.INIT);
    Conv8Ctl.INITO.connectTo(FC13.INIT);
    FC13.INITO.connectTo(INITO);
    FC13.CNF.connectTo(CNF);
    REQ.connectTo(Conv8Ctl.REQ);
    REQ.connectTo(FC13.REQ);
    Conv7Ctl.CNF.connectTo(CNF);
    Conv8Ctl.CNF.connectTo(CNF);
    CAS_STOP.connectTo(Conv7Ctl.CAS_STOP);
    CAS_START.connectTo(Conv7Ctl.CAS_START);
    FC13.STOP.connectTo(STOP);
    FC13.START.connectTo(START);
    I_PE_EVENT.connectTo(Conv7Ctl.I_PE_EVENT);
    CONFIRM_RELEASE_RING_TOKEN_IN.connectTo(Conv7Ctl.CONFIRM_TOKEN_RECEIVED_IN);
    GRANTED_RING_TOKEN.connectTo(Conv7Ctl.GRANTED_RING_TOKEN);
    Conv7Ctl.RELEASE_RING_TOKEN.connectTo(RELEASE_RING_TOKEN);
    Conv7Ctl.CONFIRM_TOKEN_RECEIVED_OUT.connectTo(CONFIRM_RELEASE_RING_TOKEN_OUT);
    CAS_STOP.connectTo(Conv8Ctl.CAS_STOP);
    CAS_START.connectTo(Conv8Ctl.CAS_START);
    I_PE_EVENT.connectTo(Conv8Ctl.PE_EVENT);
    IN_REPLY.connectTo(Conv8Ctl.IN_REPLY);
    IN_REQUEST.connectTo(Conv8Ctl.IN_REQUEST);
    Conv8Ctl.OUT_REPLY.connectTo(OUT_REPLY);
    Conv8Ctl.OUT_REQUEST.connectTo(OUT_REQUEST);
    MotoRotate3 = (BOOL)FC13.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)Conv8Ctl.ovNamedNoException("MotoRotate");
    MotoRotate1 = (BOOL)Conv7Ctl.ovNamedNoException("MotoRotate");
    Conv7Ctl.connectIVNoException("Block",Block);
    BlockCon = (BOOL)Conv7Ctl.ovNamedNoException("BlockCon");
    Conv7Ctl.connectIVNoException("Candidate",Candidate);
    FC13.connectIVNoException("PE",PE_C);
    Conv7Ctl.connectIVNoException("PE_IN",PE_A);
    Conv7Ctl.connectIVNoException("PE_OUT",PE_B);
    Conv8Ctl.connectIVNoException("PE_OUT",PE_D);
    Conv8Ctl.connectIVNoException("PE_IN",PE_C);
    Conv8Ctl.connectIVNoException("isProc0Replied",isProc0Replied);
    thisProcRequested = (BOOL)Conv8Ctl.ovNamedNoException("thisProcRequested");
    replyToProc0 = (BOOL)Conv8Ctl.ovNamedNoException("replyToProc0");
    Conv8Ctl.connectIVNoException("IN_LAMPORT",IN_LAMPORT);
    OUT_LAMPORT = (UINT)Conv8Ctl.ovNamedNoException("OUT_LAMPORT");
    Conv8Ctl.connectIVNoException("isProc0Requested",isProc0Requested);
    Conv7Ctl.HAS_INITIAL_TOKEN.initializeNoException("0");
    Conv8Ctl.Block.initializeNoException("0");
    Conv8Ctl.Candidate.initializeNoException("0");
    FC13.Block.initializeNoException("0");
    FC13.Candidate.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    Conv7Ctl.initialize("Conv7Ctl",r);
    Conv8Ctl.initialize("Conv8Ctl",r);
    FC13.initialize("FC13",r);
}
/** Start the FB instances. */
public void start( ){
  Conv7Ctl.start();
  Conv8Ctl.start();
  FC13.start();
}
/** Stop the FB instances. */
public void stop( ){
  Conv7Ctl.stop();
  Conv8Ctl.stop();
  FC13.stop();
}
}
