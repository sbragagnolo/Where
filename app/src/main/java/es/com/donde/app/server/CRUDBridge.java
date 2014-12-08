package es.com.donde.app.server;

import android.util.JsonReader;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.List;

import es.com.donde.app.model.PersistentObject;
import es.com.donde.app.util.HttpGate;


public class CRUDBridge<ModelType extends PersistentObject> {

    /**
     * *************************************************************************************
     * endpoint : an endpoint string with some carets for service and class related
     * **************************************************************************************
     */
    String endpoint = "http://localhost:9000/%s/%s";
    /**
     * *************************************************************************************
     * klazz : class related with the endpoint. Generally is the name given in the server
     * for the ModelType given type
     * **************************************************************************************
     */
    String klazz = "";


    /**
     * *************************************************************************************
     * persist : Persist means to save the object it self. It doesn't matter if it's meant
     * to be created into the database or just updated.
     * **************************************************************************************
     */
    public ModelType persist(ModelType persistentObject) {
        JSONObject data = persistentObject.toJson();
        String endpoint = this.persistEndpoint();
        HttpResponse response;

        if (persistentObject.getId() == null || persistentObject.getId().isEmpty()) {
            // Creation
            response = new HttpGate().doPost(endpoint, data);
        } else {
            // Update
            response = new HttpGate().doGet(endpoint, data);
        }
        readerForContent(response);
        return persistentObject;

    }

    /**
     * *************************************************************************************
     * List : List ask for all the related instances for this given ModelType/Klazz/Endpoint
     * **************************************************************************************
     */
    public List<ModelType> list() {
        readerForContent(new HttpGate().doGet(this.listEndpoint()));
        return null;
    }

    /**
     * *************************************************************************************
     * List(search) : List ask for all the related instances for this given
     * ModelType/Klazz/Endpoint that match the given search.
     * **************************************************************************************
     */
    public List<ModelType> list(String search) {
        readerForContent(new HttpGate().doGet(this.listEndpoint(search)));
        return null;
    }


    /**
     * *************************************************************************************
     * delete(ModelType) : it deletes an instance of ModelType in the server. It's usually used
     * by the implementation of delete() at PersistentObject class (or subclasses)
     * **************************************************************************************
     */
    public void delete(ModelType persistentObject) {
        this.delete(persistentObject.getId());
    }

    /**
     * *************************************************************************************
     * delete(id) : it deletes an instance of ModelType in the server that is pointed by
     * the given id. It's mean to be used by any tool that has no support for objects,
     * but native types.
     * **************************************************************************************
     */
    public void delete(String id) {
        readerForContent(new HttpGate().doGet(this.deleteEndpoint(id)));
    }


    /**
     * *************************************************************************************
     * Protected helper methods. This methods are used to read json content from responses
     * **************************************************************************************
     */

    protected JsonReader readerForContent(HttpResponse response) {
        try {
            return new JsonReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * ******************************************************************************
     * Protected helper methods. This methods are used to build up endpoints.
     * *******************************************************************************
     */

    protected String endpoint(String service) {
        return new Formatter().format(endpoint, klazz, service).toString();
    }

    protected String persistEndpoint() {
        return this.endpoint("persist");
    }

    protected String listEndpoint() {
        return this.endpoint("list");
    }

    protected String listEndpoint(String search) {
        return this.endpoint("list") + "/" + search;
    }

    protected String deleteEndpoint(String id) {
        return this.endpoint("delete") + "/" + id;
    }
}















