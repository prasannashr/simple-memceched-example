import java.util.concurrent.Future;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
	    MemcachedClient memcachedClient = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
	    String commandName= "get";
	    String keyName = "msg";
	    String value = "Hello world 2";
	    if(commandName.equals("get")){
	        System.out.println("Key Name " +keyName);
	        System.out.println("Value of key " +memcachedClient.get(keyName));
	    }else if(commandName.equals("set")){
	        System.out.println("Key Name " +keyName + " value=" + value);
	        Future<Boolean> result= memcachedClient.set(keyName, 0, value);
	        System.out.println("Result of set " + result.get());
	    }else if(commandName.equals("add")){
	        System.out.println("Key Name " +keyName + " value=" + value);
	        Future<Boolean> result= memcachedClient.add(keyName, 0, value);
	        System.out.println("Result of add " + result.get());
	    }else if(commandName.equals("replace")){
	        System.out.println("Key Name " +keyName + " value=" + value);
	        Future<Boolean> result= memcachedClient.replace(keyName, 0, value);
	        System.out.println("Result of replace " + result.get());
	    }else if(commandName.equals("delete")){
	        System.out.println("Key Name " +keyName );
	        Future<Boolean> result= memcachedClient.delete(keyName);
	        System.out.println("Result of delete " + result.get());
	    }else{
	        System.out.println("Command not found");
	    }
	    memcachedClient.shutdown();

	}
}
