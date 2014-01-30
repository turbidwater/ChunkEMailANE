package com.turbidwater.chunkemail.functions;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SendMailFunction implements FREFunction {

	public static final String TAG = "ChunkEMail";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args ) {
		Log.d( TAG, "Send Mail Function" );
		
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
	    	Log.d( TAG, "Failed to pull parameters out: " + e.getMessage() );
	    }
		
		//Create array of addresses from String
		if( toAddresses != "" )
		{
			recipientList = toAddresses.split( ";" );
		}

		//Prep the email intent
		Intent emailIntent = new Intent( Intent.ACTION_SEND );    
	    emailIntent.setType( "plain/text" );    
	    emailIntent.putExtra( Intent.EXTRA_EMAIL, recipientList );
	    emailIntent.putExtra( Intent.EXTRA_SUBJECT, subject );   
	    emailIntent.putExtra( Intent.EXTRA_TEXT, body );
	    
	    //Add optional cc and bcc addresses
		if( !ccAddresses.equals( "" ) )
		{
			ccList = ccAddresses.split( ";" );
			emailIntent.putExtra( android.content.Intent.EXTRA_CC, ccList );
		}

		if( !bccAddresses.equals( "" ) )
		{
			bccList = bccAddresses.split( ";" );
			emailIntent.putExtra( android.content.Intent.EXTRA_BCC, bccList );
		}
		
		//Launch the composer from the application context
	    Context appContext = context.getActivity().getApplicationContext();
	    try
	    {
	    	Intent chooserIntent = Intent.createChooser( emailIntent, title );
	    	chooserIntent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
	    	appContext.startActivity( chooserIntent );
	    }
	    catch( Error e2 )
	    {
	    	Log.d( TAG, "Failed to launch activity: " + e2.getMessage() );
	    }
	    
		return null;
	}

}
