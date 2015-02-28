package com.loveahu.util.encrypy;

public enum HttpEncrypt {

	AES("a","xlns21Dks901D92j".getBytes(),null),
	AAA("aaa",null,"t");
	
	String encrypt;
	public final byte[] defaultKey;
	public final String tokenKey;
	
	private HttpEncrypt(String encrypt,byte[] defaultKey,String tokenKey){
		this.encrypt = encrypt;
		this.defaultKey = defaultKey;
		this.tokenKey = tokenKey;
	}
	
	public static HttpEncrypt getEncrypt(String encrypt){
		HttpEncrypt[] encrypts = HttpEncrypt.values();
		for(HttpEncrypt tmp:encrypts){
			if (tmp.encrypt.equalsIgnoreCase(encrypt)) {
				return tmp;
			}
		}
		return null;
	}
}
