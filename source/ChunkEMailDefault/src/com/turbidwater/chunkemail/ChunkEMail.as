package com.turbidwater.chunkemail
{
	import flash.events.EventDispatcher;
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	
	public class ChunkEMail extends EventDispatcher
	{
		//-----------------------------------------------------------
		//  DECLARATIONS
		//-----------------------------------------------------------
		private static var _instance:ChunkEMail;
		
		
		//-----------------------------------------------------------
		//  INIT
		//-----------------------------------------------------------
		public function ChunkEMail( sentry:SingletonSentry )
		{
			super();
		}
		
		public static function getInstance():ChunkEMail
		{
			if( !_instance )
			{
				_instance = new ChunkEMail( new SingletonSentry );
			}
			
			return _instance;
		}
		
		
		//-----------------------------------------------------------
		//  CONTROL
		//-----------------------------------------------------------
		/**
		 * Is ChunkEMail supported?
		 * 
		 * @return	Boolean
		 */
		public static function isSupported():Boolean
		{
			return true;
		}
		
		/**
		 * Open the native composer with prepopulated values.
		 * 
		 * @param	toAddresses	(String) semicolon-separated list of email addresses
		 * @param	subject		(String) subject line for email
		 * @param	body		(String) body of email (Defaults to "")
		 * @param	title		(String) title of email composer window (Defaults to "Send Email")
		 * @param	ccAddresses	(String) semicolon-separated list of email addresses for cc (Defaults to "")
		 * @param	bccAddresses(String) semicolon-separated list of email addresses for bcc (Defaults to "")
		 * 
		 * @return	void
		 */
		public function sendMail( toAddresses:String, subject:String, body:String='', title:String="Send Email", ccAddresses:String='', bccAddresses:String='' ):void
		{
			var mailRequest:URLRequest = new URLRequest( 'mailto:' + toAddresses + '?subject=' + subject + '&body=' + body );
			navigateToURL( mailRequest, '_blank' );
		}
	}
}

class SingletonSentry {}