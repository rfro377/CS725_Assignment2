/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Basic
  * @author JHC
  * @version 20201024/JHC
  */
public class Basic extends FBInstance
{
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
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
    if("REQ".equals(s)) return REQ;
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
private static final int index_REQ = 2;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  CNF.serviceEvent(this);
state_START();
}
/** The default constructor. */
public Basic(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == REQUEST_TOKE_2) service_REQUEST_TOKE_2();
    else if (e == RELEASE_TOKE_2) service_RELEASE_TOKE_2();
    else if (e == REQUEST_TOKE_6) service_REQUEST_TOKE_6();
    else if (e == RELEASE_TOKE_6) service_RELEASE_TOKE_6();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START)) state_REQ();
  }
/** Services the REQUEST_TOKE_2 event. */
  public void service_REQUEST_TOKE_2(){
  }
/** Services the RELEASE_TOKE_2 event. */
  public void service_RELEASE_TOKE_2(){
  }
/** Services the REQUEST_TOKE_6 event. */
  public void service_REQUEST_TOKE_6(){
  }
/** Services the RELEASE_TOKE_6 event. */
  public void service_RELEASE_TOKE_6(){
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
}
}
