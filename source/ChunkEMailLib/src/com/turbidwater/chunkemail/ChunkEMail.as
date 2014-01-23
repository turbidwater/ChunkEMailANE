package com.turbidwater.chunkemail
{
	import flash.events.EventDispatcher;
	import flash.external.ExtensionContext;
	
	public class ChunkEMail extends EventDispatcher
	{
		//-----------------------------------------------------------
		//  DECLARATIONS
		//-----------------------------------------------------------
		public var extensionContext:ExtensionContext;
		
		private static var _instance:ChunkEMail;
		
		
		//-----------------------------------------------------------
		//  INIT
		//-----------------------------------------------------------
		public function ChunkEMail( sentry:SingletonSentry )
		{
			super();
			
			extensionContext = new ExtensionContext();
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
			extensionContext.call( 'sendMail', toAddresses, subject, body, title, ccAddresses, bccAddresses );
		}
		
		
		//-----------------------------------------------------------
		//  EVENT LISTENERS
		//-----------------------------------------------------------
		
		
		//-----------------------------------------------------------
		//  GETTERS/SETTERS
		//-----------------------------------------------------------	
	}
}

class SingletonSentry {}