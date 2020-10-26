/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK CentralServerControl
  * @author JHC
  * @version 20201026/JHC
  */
public class CentralServerControl extends FBInstance
{
/** VAR requestQueue */
  public ARRAY requestQueue = new ARRAY(new INT(),25);
/** VAR arrayStart */
  public INT arrayStart = new INT();
/** VAR arrayEnd */
  public INT arrayEnd = new INT();
/** VAR tokenAvailable */
  public BOOL tokenAvailable = new BOOL();
/** VAR tokenOwner */
  public INT tokenOwner = new INT();
/** VAR targ2 */
  public BOOL targ2 = new BOOL();
/** VAR targ6 */
  public BOOL targ6 = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** EVENT REQUEST_TOKE_2 */
 public EventServer REQUEST_TOKE_2 = new EventInput(this);
/** EVENT RELEASE_TOKE_2 */
 public EventServer RELEASE_TOKE_2 = new EventInput(this);
/** EVENT REQUEST_TOKE_6 */
 public EventServer REQUEST_TOKE_6 = new EventInput(this);
/** EVENT RELEASE_TOKE_6 */
 public EventServer RELEASE_TOKE_6 = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT GRANT_TOKE_2 */
 public EventOutput GRANT_TOKE_2 = new EventOutput();
/** EVENT GRANT_TOKE_6 */
 public EventOutput GRANT_TOKE_6 = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQUEST_TOKE_2".equals(s)) return REQUEST_TOKE_2;
    if("RELEASE_TOKE_2".equals(s)) return RELEASE_TOKE_2;
    if("REQUEST_TOKE_6".equals(s)) return REQUEST_TOKE_6;
    if("RELEASE_TOKE_6".equals(s)) return RELEASE_TOKE_6;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("GRANT_TOKE_2".equals(s)) return GRANT_TOKE_2;
    if("GRANT_TOKE_6".equals(s)) return GRANT_TOKE_6;
    return super.eoNamed(s);}
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
state_START();
}
private static final int index_REQUESTED_2 = 2;
private void state_REQUESTED_2(){
  eccState = index_REQUESTED_2;
  alg_ADD_QUEUE_2();
state_GRANT_NEXT();
}
private static final int index_REQUESTED_6 = 3;
private void state_REQUESTED_6(){
  eccState = index_REQUESTED_6;
  alg_ADD_QUEUE_6();
state_GRANT_NEXT();
}
private static final int index_GRANT_NEXT = 4;
private void state_GRANT_NEXT(){
  eccState = index_GRANT_NEXT;
  alg_GRANT_FROM_QUEUE();
    if(!targ2.value&!targ6.value) state_START();
    else if(targ2.value) state_GRANT_2();
    else if(targ6.value) state_GRANT_6();
}
private static final int index_RELEASE_CURRENT_TOKEN = 5;
private void state_RELEASE_CURRENT_TOKEN(){
  eccState = index_RELEASE_CURRENT_TOKEN;
  alg_RECLAIM_TOKEN();
state_GRANT_NEXT();
}
private static final int index_GRANT_2 = 6;
private void state_GRANT_2(){
  eccState = index_GRANT_2;
  GRANT_TOKE_2.serviceEvent(this);
state_START();
}
private static final int index_GRANT_6 = 7;
private void state_GRANT_6(){
  eccState = index_GRANT_6;
  GRANT_TOKE_6.serviceEvent(this);
state_START();
}
/** The default constructor. */
public CentralServerControl(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQUEST_TOKE_2) service_REQUEST_TOKE_2();
    else if (e == RELEASE_TOKE_2) service_RELEASE_TOKE_2();
    else if (e == REQUEST_TOKE_6) service_REQUEST_TOKE_6();
    else if (e == RELEASE_TOKE_6) service_RELEASE_TOKE_6();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQUEST_TOKE_2 event. */
  public void service_REQUEST_TOKE_2(){
    if ((eccState == index_START)) state_REQUESTED_2();
  }
/** Services the RELEASE_TOKE_2 event. */
  public void service_RELEASE_TOKE_2(){
    if ((eccState == index_START)) state_RELEASE_CURRENT_TOKEN();
  }
/** Services the REQUEST_TOKE_6 event. */
  public void service_REQUEST_TOKE_6(){
    if ((eccState == index_START)) state_REQUESTED_6();
  }
/** Services the RELEASE_TOKE_6 event. */
  public void service_RELEASE_TOKE_6(){
    if ((eccState == index_START)) state_RELEASE_CURRENT_TOKEN();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
tokenAvailable.value=true;
tokenOwner.value=(short)(0);
arrayStart.value=(short)(0);
arrayEnd.value=(short)(0);
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
}
  /** ALGORITHM GRANT_FROM_QUEUE IN ST*/
public void alg_GRANT_FROM_QUEUE(){
System.out.println("Entered queue granting algorithm");

//firstcheckif(thetokenisalreadytaken
if(tokenAvailable.value==true){

//if(so,checkif(eitherpositionofthequeuehasawaitingrequeust
if(((INT)requestQueue.value[arrayStart.value]).value!=0){
tokenAvailable.value=false;
tokenOwner.value=(short)(((INT)requestQueue.value[arrayStart.value]).value);
((INT)requestQueue.value[arrayStart.value]).value=(short)(0);
arrayStart.value=(short)(((arrayStart.value+1)%20));
};

if(tokenOwner.value==2){
System.out.println("2");
targ2.value=true;
targ6.value=false;
}
else if(tokenOwner.value==6){
System.out.println("6");
targ6.value=true;
targ2.value=false;
}
else if(tokenOwner.value==0){
System.out.println("0");
targ2.value=false;
targ6.value=false;
};

}
else{
targ2.value=false;
targ6.value=false;
};
}
  /** ALGORITHM RECLAIM_TOKEN IN ST*/
public void alg_RECLAIM_TOKEN(){
tokenAvailable.value=true;
tokenOwner.value=(short)(0);
System.out.println("Token released and reclaimed!");
}
  /** ALGORITHM ADD_QUEUE_2 IN ST*/
public void alg_ADD_QUEUE_2(){
((INT)requestQueue.value[arrayEnd.value]).value=(short)(2);
arrayEnd.value=(short)(((arrayEnd.value+1)%20));
}
  /** ALGORITHM ADD_QUEUE_6 IN ST*/
public void alg_ADD_QUEUE_6(){
((INT)requestQueue.value[arrayEnd.value]).value=(short)(6);
arrayEnd.value=(short)(((arrayEnd.value+1)%20));
}
}
