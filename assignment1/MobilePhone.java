import java.util.*;
import java.io.*;
import java .lang.*;
class MobilePhone
{
	int newmobile;
	Boolean checknewnumberstatus;  //we basically checking mobilephone status whether it is switchOn or OFF...if on then it is true else false
	Exchange basestation;
	MobilePhone(int number)
	{
      newmobile=number;
      checknewnumberstatus=true;
	}
	public int number()
	{

       return newmobile;
	}
	public Boolean status()
	{
		//it will return status 
       return checknewnumberstatus;
	}
	//if we want to ON  the  mobile then we call swithOn
	public void switchOn()
	{

      checknewnumberstatus=true;
	}
	public void switchOff()
	{
      checknewnumberstatus=false;
	}
	public Exchange location()
	{
		if(checknewnumberstatus)
			return basestation;
	return null;
	}
}