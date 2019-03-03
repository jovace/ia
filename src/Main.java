import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Prueba pr = new Prueba(1,"jorge",new ArrayList<String>());
		Prueba pr2 = new Prueba(1,"jorge",new ArrayList<String>());
		
		System.out.println(pr.getHashCode());
		System.out.println(pr2.getHashCode());
		System.out.println();
		
		pr.addList("miry");
		pr2.addList("miry");
		
		System.out.println(pr.getHashCode());
		System.out.println(pr2.getHashCode());
		System.out.println();
		
		pr.addList("miry");
		pr.addList("jorge");
		pr2.addList("jorge");
		pr2.addList("miry");
		
		System.out.println(pr.getHashCode());
		System.out.println(pr2.getHashCode());
		
	}
	
}

class Prueba implements Serializable{
	int x;
	String y;
	List<String> z;
	private long timeStamp;
	
	public Prueba(int x, String y, ArrayList<String> z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void addList(String d) {
		this.z.add(d);
	}
	
	private void setTimeStamp() {
		this.timeStamp=System.currentTimeMillis();
	}
	
	public String getHashCode() {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			//Applies sha256 to our input, 
			this.setTimeStamp();
			String input=this.toBLOBString();
			byte[] hash = digest.digest(input.getBytes());	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private String toBLOBString() throws IOException {
		Serializable o = this;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
    }
	
}
