package ClientWorker;

public class encryption {
	/**
	 * This method decrypts the messages that is sent from the client to the server. 
	 * @param b
	 * @return String encrypted, an encrypted string of the data that is to be sent to the client.
	 */
	public String decrypt(byte[] b)
	{
		
		//		Defines the decryption value of the byte
		String crypKey = "3.1470";
		double value = Double.parseDouble(crypKey);
		byte ff = (byte) value;
		//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		//		Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
		//		Returns decrypted String
		return encrypted;
	}
}
