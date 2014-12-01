package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Importing json packaes
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Configurations {
  
    // FFkey is used in Encryption.java
    private String ffcryptkey = "3.1470";

    public String getFfcryptkey() {
        return ffcryptkey;
    }

    public void setFfcryptkey(String ffcryptkey) {
        this.ffcryptkey = ffcryptkey;
    }

}
