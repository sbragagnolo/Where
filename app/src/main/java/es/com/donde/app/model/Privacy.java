package es.com.donde.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by santiago on 6/3/14.
 */


public enum Privacy {

        FRIENDS("solo amigos"),
        FRIENDS_OF_FRIENDS("amigos de amigos"),
        PUBLIC("todos");


    String name;

    Privacy(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Privacy fromString ( String name ) {
        if( name.equalsIgnoreCase(FRIENDS.name)) return FRIENDS;
        if( name.equalsIgnoreCase(FRIENDS_OF_FRIENDS.name)) return FRIENDS_OF_FRIENDS;
        return PUBLIC;
    }

    public static Map<Privacy, List<Game>> groupByPrivacy ( List<Game> games ){
        HashMap<Privacy, List<Game>> group = new HashMap<Privacy, List<Game>>();
        for(Privacy privacy : Privacy.values()) group.put(privacy, new ArrayList<Game>());
        for ( Game game : games) {
            group.get(game.getPrivacy()).add(game);
        }
        return group;
    }
}


