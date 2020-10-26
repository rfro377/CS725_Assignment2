/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TWOCONRINGTOKEN
  * @author JHC
  * @version 20201026/JHC
  */
public class TWOCONRINGTOKEN extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE_A */
  public BOOL PE_A = new BOOL();
/** VAR PE_B */
  public BOOL PE_B = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT GRANTED_RING_TOKE */
 public EventOutput GRANTED_RING_TOKE = new EventOutput();
/** EVENT I_PE_EVENT */
 public EventOutput I_PE_EVENT = new EventOutput();
/** EVENT CONFIRM_RECEIVED_RING_TOKEN_IN */
 public EventOutput CONFIRM_RECEIVED_RING_TOKEN_IN = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT RELEASED_RING_TOKE */
 public EventOutput RELEASED_RING_TOKE = new EventOutput();
/** EVENT CONFIRM_RECEIVED_RING_TOKEN_OUT */
 public EventOutput CONFIRM_RECEIVED_RING_TOKEN_OUT = new EventOutput();
/** EVENT Initial_Release */
 public EventOutput Initial_Release = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("GRANTED_RING_TOKE".equals(s)) return GRANTED_RING_TOKE;
    if("I_PE_EVENT".equals(s)) return I_PE_EVENT;
    if("CONFIRM_RECEIVED_RING_TOKEN_IN".equals(s)) return CONFIRM_RECEIVED_RING_TOKEN_IN;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("RELEASED_RING_TOKE".equals(s)) return RELEASED_RING_TOKE;
    if("CONFIRM_RECEIVED_RING_TOKEN_OUT".equals(s)) return CONFIRM_RECEIVED_RING_TOKEN_OUT;
    if("Initial_Release".equals(s)) return Initial_Release;
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
    FC12.connectIVNoException("PE_OUT",PE_B);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB FC12 */
  protected ConveyorRingTokenCTL FC12 = new ConveyorRingTokenCTL() ;
/** The default constructor. */
public TWOCONRINGTOKEN(){
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
    GRANTED_RING_TOKE.connectTo(FC12.GRANTED_RING_TOKEN);
    FC12.RELEASE_RING_TOKEN.connectTo(RELEASED_RING_TOKE);
    I_PE_EVENT.connectTo(FC12.I_PE_EVENT);
    CONFIRM_RECEIVED_RING_TOKEN_IN.connectTo(FC12.CONFIRM_TOKEN_RECEIVED_IN);
    FC12.CONFIRM_TOKEN_RECEIVED_OUT.connectTo(CONFIRM_RECEIVED_RING_TOKEN_OUT);
    FC12.Initial_Release.connectTo(Initial_Release);
    FC12.connectIVNoException("Block",Block);
    FC12.connectIVNoException("Candidate",Candidate);
    BlockCon = (BOOL)FC12.ovNamedNoException("BlockCon");
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    FC12.connectIVNoException("PE_IN",PE_A);
    FC12.connectIVNoException("PE_OUT",PE_B);
    FC11.Candidate.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.PE.initializeNoException("0");
    FC12.HAS_INITIAL_TOKEN.initializeNoException("0");
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
