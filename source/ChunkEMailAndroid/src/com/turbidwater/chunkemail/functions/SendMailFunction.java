package com.turbidwater.chunkemail.functions;

import android.content.Context;
import android.content.Intent;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SendMailFunction implements FREFunction 
{

	@Override
	public FREObject call( FREContext context, FREObject[] args ) 
	{
		//Local variables
		String[] recipientList = {};
		String[] ccList = {};
		String[] bccList = {};
		
		//Parameter buckets
		String toAddresses = "";
		String subject = "";
		String body = "";
		String title = "";
		String ccAddresses = "";
		String bccAddresses = "";
		
		//Pull the parameters out of FREObject array and put in buckets
		try 
	    {
			toAddresses = args[0].getAsString();
	        subject = args[1].getAsString();
	        body = args[2].getAsString();
	        title = args[3].getAsString();
	        ccAddresses = args[4].getAsString();
	        bccAddresses = args[5].getAsString();
	    } 
	    catch (Exception e) 
	    {
			
	    }
		
		//Create array of addresses from String
		if( toAddresses != "" )
		{
			recipientList = toAddresses.split( ";" );
		}

		//Prep the email intent
		Intent emailIntent = new Intent( android.content.Intent.ACTION_SEND );    
	    emailIntent.setType("plain/text");    
	    emailIntent.putExtra( android.content.Intent.EXTRA_EMAIL, recipientList );
	    emailIntent.putExtra( android.content.Intent.EXTRA_SUBJECT, subject );   
	    emailIntent.putExtra( android.content.Intent.EXTRA_TEXT, body );
	    
	    //Add optional cc and bcc addresses
		if( ccAddresses != "" )
		{
			ccList = ccAddresses.split( ";" );
			emailIntent.putExtra( android.content.Intent.EXTRA_CC, ccList );
		}

		if( toAddresses != "" )
		{
			bccList = bccAddresses.split( ";" );
			emailIntent.putExtra( android.content.Intent.EXTRA_BCC, bccList );
		}
	    
		//Launch the composer from the application context
	    Context appContext = context.getActivity().getApplicationContext();
	    appContext.startActivity( Intent.createChooser( emailIntent, title ) );
		
		return null;
	}

}
