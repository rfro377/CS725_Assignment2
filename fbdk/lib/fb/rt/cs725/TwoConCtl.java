/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtl
  * @author JHC
  * @version 20201026/JHC
  */
public class TwoConCtl extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE_A */
  public BOOL PE_A = new BOOL();
/** VAR PE_B */
  public BOOL PE_B = new BOOL();
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
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT PE_EVENT */
 public EventOutput PE_EVENT = new EventOutput();
/** EVENT IN_REPLY */
 public EventOutput IN_REPLY = new EventOutput();
/** EVENT IN_REQUEST */
 public EventOutput IN_REQUEST = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
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
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("PE_EVENT".equals(s)) return PE_EVENT;
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
    FC12.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC12.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE_A
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_A(BOOL newIV) throws FBRManagementException{
    PE_A = newIV;
    FC12.connectIVNoException("PE_IN",PE_A);
    }
/** Connect the given variable to the input variable PE_B
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_B(BOOL newIV) throws FBRManagementException{
    PE_B = newIV;
    FC11.connectIVNoException("PE",PE_B);
    FC12.connectIVNoException("PE_OUT",PE_B);
    }
/** Connect the given variable to the input variable IN_LAMPORT
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_IN_LAMPORT(UINT newIV) throws FBRManagementException{
    IN_LAMPORT = newIV;
    FC12.connectIVNoException("IN_LAMPORT",IN_LAMPORT);
    }
/** Connect the given variable to the input variable isProc0Requested
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_isProc0Requested(BOOL newIV) throws FBRManagementException{
    isProc0Requested = newIV;
    FC12.connectIVNoException("isProc0Requested",isProc0Requested);
    }
/** Connect the given variable to the input variable isProc0Replied
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_isProc0Replied(BOOL newIV) throws FBRManagementException{
    isProc0Replied = newIV;
    FC12.connectIVNoException("isProc0Replied",isProc0Replied);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB FC12 */
  protected ConveyorCTLMulticast FC12 = new ConveyorCTLMulticast() ;
/** The default constructor. */
public TwoConCtl(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    FC12.INITO.connectTo(INITO);
    FC12.CNF.connectTo(CNF);
    REQ.connectTo(FC12.REQ);
    STOP.connectTo(FC12.CAS_STOP);
    START.connectTo(FC12.CAS_START);
    FC12.STOP.connectTo(FC11.CAS_STOP);
    FC12.START.connectTo(FC11.CAS_START);
    FC11.INITO.connectTo(FC12.INIT);
    PE_EVENT.connectTo(FC12.PE_EVENT);
    IN_REPLY.connectTo(FC12.IN_REPLY);
    IN_REQUEST.connectTo(FC12.IN_REQUEST);
    FC12.OUT_REPLY.connectTo(OUT_REPLY);
    FC12.OUT_REQUEST.connectTo(OUT_REQUEST);
    FC12.connectIVNoException("Block",Block);
    FC12.connectIVNoException("Candidate",Candidate);
    BlockCon = (BOOL)FC12.ovNamedNoException("BlockCon");
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    FC11.connectIVNoException("PE",PE_B);
    FC12.connectIVNoException("PE_IN",PE_A);
    FC12.connectIVNoException("PE_OUT",PE_B);
    FC12.connectIVNoException("IN_LAMPORT",IN_LAMPORT);
    OUT_LAMPORT = (UINT)FC12.ovNamedNoException("OUT_LAMPORT");
    thisProcRequested = (BOOL)FC12.ovNamedNoException("thisProcRequested");
    replyToProc0 = (BOOL)FC12.ovNamedNoException("replyToProc0");
    FC12.connectIVNoException("isProc0Requested",isProc0Requested);
    FC12.connectIVNoException("isProc0Replied",isProc0Replied);
    FC11.Candidate.initializeNoException("0");
    FC11.Block.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    FC12.initialize("FC12",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  FC12.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  FC12.stop();
}
}
