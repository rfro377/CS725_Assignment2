/* Copyright (c)2020 HUT. All rights reserved. */
package fb.rt.student; import fb.rt.math.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK FB_XOR2
  * @author JHC
  * @version 20201020/JHC
  */
public class FB_XOR2 extends FBInstance
{
/** VAR X */
  public BOOL X = new BOOL();
/** VAR Y */
  public BOOL Y = new BOOL();
/** X XOR Y */
  public BOOL OUT = new BOOL();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("REQ".equals(s)) return REQ;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("CNF".equals(s)) return CNF;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("X".equals(s)) return X;
    if("Y".equals(s)) return Y;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("OUT".equals(s)) return OUT;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("X".equals(ivName)) connect_X((BOOL)newIV);
    else if("Y".equals(ivName)) connect_Y((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable X
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_X(BOOL newIV) throws FBRManagementException{
    X = newIV;
    NOTX.connectIVNoException("IN",X);
    AND2.connectIVNoException("IN1",X);
    }
/** Connect the given variable to the input variable Y
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Y(BOOL newIV) throws FBRManagementException{
    Y = newIV;
    NOTY.connectIVNoException("IN",Y);
    AND1.connectIVNoException("IN1",Y);
    }
/** FB AND1 */
  protected FB_AND AND1 = new FB_AND() ;
/** FB AND2 */
  protected FB_AND AND2 = new FB_AND() ;
/** FB OR1 */
  protected FB_OR OR1 = new FB_OR() ;
/** FB NOTX */
  protected FB_NOT NOTX = new FB_NOT() ;
/** FB NOTY */
  protected FB_NOT NOTY = new FB_NOT() ;
/** The default constructor. */
public FB_XOR2(){
    super();
    REQ.connectTo(NOTY.REQ);
    NOTX.CNF.connectTo(AND2.REQ);
    AND2.CNF.connectTo(AND1.REQ);
    AND1.CNF.connectTo(OR1.REQ);
    NOTY.CNF.connectTo(NOTX.REQ);
    OR1.CNF.connectTo(CNF);
    OR1.connectIVNoException("IN1",AND2.ovNamedNoException("OUT"));
    OR1.connectIVNoException("IN2",AND1.ovNamedNoException("OUT"));
    AND2.connectIVNoException("IN2",NOTY.ovNamedNoException("OUT"));
    AND1.connectIVNoException("IN2",NOTX.ovNamedNoException("OUT"));
    NOTY.connectIVNoException("IN",Y);
    NOTX.connectIVNoException("IN",X);
    AND2.connectIVNoException("IN1",X);
    AND1.connectIVNoException("IN1",Y);
    OUT = (BOOL)OR1.ovNamedNoException("OUT");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    AND1.initialize("AND1",r);
    AND2.initialize("AND2",r);
    OR1.initialize("OR1",r);
    NOTX.initialize("NOTX",r);
    NOTY.initialize("NOTY",r);
}
/** Start the FB instances. */
public void start( ){
  AND1.start();
  AND2.start();
  OR1.start();
  NOTX.start();
  NOTY.start();
}
/** Stop the FB instances. */
public void stop( ){
  AND1.stop();
  AND2.stop();
  OR1.stop();
  NOTX.stop();
  NOTY.stop();
}
}
