package com.omnie.shareyourviewservice.utility;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list")
public class JaxbListWrapper<T> {
    private List<T> items;
     
    public JaxbListWrapper() {
        items = new ArrayList<T>();
    }
  
    public JaxbListWrapper(List<T> items) {
        this.items = items;
    }
  
    @XmlAnyElement(lax=true)
    public List<T> getItems() {
        return items;
    }
}
