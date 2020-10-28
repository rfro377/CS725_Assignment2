/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlCentralClient
  * @author JHC
  * @version 20201028/JHC
  */
public class TwoConCtlCentralClient extends FBInstance
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
/** EVENT PE_EVENT */
 public EventOutput PE_EVENT = new EventOutput();
/** EVENT GRANTED_TOKE */
 public EventOutput GRANTED_TOKE = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT REQUEST_TOKE */
 public EventOutput REQUEST_TOKE = new EventOutput();
/** EVENT RELEASE_TOKE */
 public EventOutput RELEASE_TOKE = new EventOutput();
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
    if("GRANTED_TOKE".equals(s)) return GRANTED_TOKE;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("REQUEST_TOKE".equals(s)) return REQUEST_TOKE;
    if("RELEASE_TOKE".equals(s)) return RELEASE_TOKE;
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
    ConvCentralCtl.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    ConvCentralCtl.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE_A
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_A(BOOL newIV) throws FBRManagementException{
    PE_A = newIV;
    ConvCentralCtl.connectIVNoException("PE_IN",PE_A);
    }
/** Connect the given variable to the input variable PE_B
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_B(BOOL newIV) throws FBRManagementException{
    PE_B = newIV;
    ConvCentralCtl.connectIVNoException("PE_OUT",PE_B);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB ConvCentralCtl */
  protected ConveyorCTLCentralClient ConvCentralCtl = new ConveyorCTLCentralClient() ;
/** The default constructor. */
public TwoConCtlCentralClient(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    ConvCentralCtl.INITO.connectTo(INITO);
    ConvCentralCtl.CNF.connectTo(CNF);
    REQ.connectTo(ConvCentralCtl.REQ);
    STOP.connectTo(ConvCentralCtl.CAS_STOP);
    START.connectTo(ConvCentralCtl.CAS_START);
    ConvCentralCtl.STOP.connectTo(FC11.CAS_STOP);
    ConvCentralCtl.START.connectTo(FC11.CAS_START);
    FC11.INITO.connectTo(ConvCentralCtl.INIT);
    PE_EVENT.connectTo(ConvCentralCtl.I_PE_EVENT);
    ConvCentralCtl.REQUEST_TOKE.connectTo(REQUEST_TOKE);
    ConvCentralCtl.RELEASE_TOKE.connectTo(RELEASE_TOKE);
    GRANTED_TOKE.connectTo(ConvCentralCtl.GRANTED_TOKE);
    ConvCentralCtl.connectIVNoException("Block",Block);
    ConvCentralCtl.connectIVNoException("Candidate",Candidate);
    BlockCon = (BOOL)ConvCentralCtl.ovNamedNoException("BlockCon");
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)ConvCentralCtl.ovNamedNoException("MotoRotate");
    ConvCentralCtl.connectIVNoException("PE_IN",PE_A);
    ConvCentralCtl.connectIVNoException("PE_OUT",PE_B);
    FC11.Candidate.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.PE.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    ConvCentralCtl.initialize("ConvCentralCtl",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  ConvCentralCtl.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  ConvCentralCtl.stop();
}
}
