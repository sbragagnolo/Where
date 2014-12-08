package es.com.donde.app.model;


import org.json.JSONObject;

import es.com.donde.app.server.CRUDBridge;

abstract public class PersistentObject {
    protected static CRUDBridge bridge;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void persist() {
        bridge.persist(this);

    }

    public void delete() {
        bridge.delete(this);

    }


    public JSONObject toJson() {
        try {
            JSONObject object = new JSONObject();
            object.put("id", id);
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
