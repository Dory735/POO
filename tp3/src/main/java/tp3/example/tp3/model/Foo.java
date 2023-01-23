package tp3.example.tp3.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Foo implements Serializable {
    private String type;

    private String version;
    // standard getters and setters
    private Feature[] features;
    
    
    public Foo() {
    	
    }

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}





	public Feature[] getFeatures() {
		return features;
	}





	public void setFeatures(Feature[] features) {
		this.features = features;
	}
}
