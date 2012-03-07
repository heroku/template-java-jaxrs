package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Step {
    
    public String id;
    public String title;
    public String body;

    public Step() {}

    public Step(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
