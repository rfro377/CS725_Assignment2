/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLCentralClient
  * @author JHC
  * @version 20201028/JHC
  */
public class ConveyorCTLCentralClient extends FBInstance
{
/** Input event qualifier */
  public BOOL PE_IN = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** Output event qualifier */
  public BOOL PE_OUT = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** EVENT I_PE_EVENT */
 public EventServer I_PE_EVENT = new EventInput(this);
/** EVENT GRANTED_TOKE */
 public EventServer GRANTED_TOKE = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
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
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("I_PE_EVENT".equals(s)) return I_PE_EVENT;
    if("GRANTED_TOKE".equals(s)) return GRANTED_TOKE;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("STOP".equals(s)) return STOP;
    if("START".equals(s)) return START;
    if("REQUEST_TOKE".equals(s)) return REQUEST_TOKE;
    if("RELEASE_TOKE".equals(s)) return RELEASE_TOKE;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("PE_IN".equals(s)) return PE_IN;
    if("Block".equals(s)) return Block;
    if("Candidate".equals(s)) return Candidate;
    if("PE_OUT".equals(s)) return PE_OUT;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("PE_IN".equals(ivName)) connect_PE_IN((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("PE_OUT".equals(ivName)) connect_PE_OUT((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable PE_IN
  * @param newIV The variable to connect
 */
  public void connect_PE_IN(BOOL newIV){
    PE_IN = newIV;
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
 */
  public void connect_Block(BOOL newIV){
    Block = newIV;
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
 */
  public void connect_Candidate(BOOL newIV){
    Candidate = newIV;
    }
/** Connect the given variable to the input variable PE_OUT
  * @param newIV The variable to connect
 */
  public void connect_PE_OUT(BOOL newIV){
    PE_OUT = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_REQ = 2;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_START = 3;
private void state_CAS_START(){
  eccState = index_CAS_START;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_STOP = 4;
private void state_CAS_STOP(){
  eccState = index_CAS_STOP;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_ST_REQUEST_TOKE = 5;
private void state_ST_REQUEST_TOKE(){
  eccState = index_ST_REQUEST_TOKE;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_PRINT_REQUEST();
  REQUEST_TOKE.serviceEvent(this);
}
private static final int index_ST_ACQUIRED_TOKE = 6;
private void state_ST_ACQUIRED_TOKE(){
  eccState = index_ST_ACQUIRED_TOKE;
  alg_START();
  START.serviceEvent(this);
  alg_PRINT_ACQUIRED();
  CNF.serviceEvent(this);
}
private static final int index_ST_RELEASE_TOKE = 7;
private void state_ST_RELEASE_TOKE(){
  eccState = index_ST_RELEASE_TOKE;
  alg_PRINT_RELEASED();
  RELEASE_TOKE.serviceEvent(this);
state_START();
}
private static final int index_LEFT_CONV = 8;
private void state_LEFT_CONV(){
  eccState = index_LEFT_CONV;
}
private static final int index_SECOND_BAG = 9;
private void state_SECOND_BAG(){
  eccState = index_SECOND_BAG;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_PRINT_REQUEST();
  REQUEST_TOKE.serviceEvent(this);
state_LEFT_CONV2();
}
private static final int index_LEFT_CONV2 = 10;
private void state_LEFT_CONV2(){
  eccState = index_LEFT_CONV2;
}
private static final int index_ST_RELEASE_TOKE_2 = 11;
private void state_ST_RELEASE_TOKE_2(){
  eccState = index_ST_RELEASE_TOKE_2;
  alg_PRINT_RELEASED();
  RELEASE_TOKE.serviceEvent(this);
}
private static final int index_WAITING_FOR_LEAVE = 12;
private void state_WAITING_FOR_LEAVE(){
  eccState = index_WAITING_FOR_LEAVE;
}
private static final int index_WAITING_FOR_LEAVE_2 = 13;
private void state_WAITING_FOR_LEAVE_2(){
  eccState = index_WAITING_FOR_LEAVE_2;
}
/** The default constructor. */
public ConveyorCTLCentralClient(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
    else if (e == I_PE_EVENT) service_I_PE_EVENT();
    else if (e == GRANTED_TOKE) service_GRANTED_TOKE();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START) && (Candidate.value)) state_REQ();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
    if ((eccState == index_START)) state_CAS_STOP();
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
    if ((eccState == index_START)) state_CAS_START();
  }
/** Services the I_PE_EVENT event. */
  public void service_I_PE_EVENT(){
    if ((eccState == index_ST_ACQUIRED_TOKE) && (PE_IN.value)) state_LEFT_CONV();
    else if ((eccState == index_START) && (!PE_IN.value)) state_ST_REQUEST_TOKE();
    else if ((eccState == index_LEFT_CONV) && (!PE_IN.value)) state_SECOND_BAG();
    else if ((eccState == index_LEFT_CONV) && (!PE_OUT.value)) state_WAITING_FOR_LEAVE();
    else if ((eccState == index_WAITING_FOR_LEAVE) && (PE_OUT.value)) state_ST_RELEASE_TOKE();
    else if ((eccState == index_LEFT_CONV2) && (!PE_OUT.value)) state_WAITING_FOR_LEAVE_2();
    else if ((eccState == index_WAITING_FOR_LEAVE_2) && (PE_OUT.value)) state_ST_RELEASE_TOKE_2();
  }
/** Services the GRANTED_TOKE event. */
  public void service_GRANTED_TOKE(){
    if ((eccState == index_ST_REQUEST_TOKE)) state_ST_ACQUIRED_TOKE();
    else if ((eccState == index_ST_RELEASE_TOKE_2)) state_ST_ACQUIRED_TOKE();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;

System.out.println(this+" "+MotoRotate.value);
System.out.println(MotoRotate.value);
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
System.out.println(this+" -> Candidate"+Candidate.value);
if(Candidate.value){
if(lastPE.value!=PE_IN.value){
if(!PE_IN.value){
BlockCon.value=true;
System.out.println("BlockCon = true");
}
else{
BlockCon.value=false;
System.out.println("BlockCon = false");
}
lastPE.value=PE_IN.value;
}
if(lastBlock.value!=Block.value){
if(Block.value){
STOP.serviceEvent(this);
MotoRotate.value=false;
System.out.println("Cas Stop");
}
else{
START.serviceEvent(this);
MotoRotate.value=true;
System.out.println("Cas Start");
}
lastBlock.value=Block.value;
}
}
}
  /** ALGORITHM START IN ST*/
public void alg_START(){
MotoRotate.value=true;
System.out.println(this+" Start "+MotoRotate.value);

System.out.println("Start "+MotoRotate.value);
}
  /** ALGORITHM STOP IN ST*/
public void alg_STOP(){
MotoRotate.value=false;
System.out.println(this+" Stop "+MotoRotate.value);

System.out.println("Stop "+MotoRotate.value);
}
  /** ALGORITHM PRINT_REQUEST IN ST*/
public void alg_PRINT_REQUEST(){
System.out.println(this+" requesting a token");
}
  /** ALGORITHM PRINT_ACQUIRED IN ST*/
public void alg_PRINT_ACQUIRED(){
System.out.println(this+" acquiring a token");
}
  /** ALGORITHM PRINT_RELEASED IN ST*/
public void alg_PRINT_RELEASED(){
System.out.println(this+" released a token");
}
}
