package es.com.donde.app.components.privacylist;

import java.util.List;

import es.com.donde.app.components.listadapter.ExpandableListAdapter;
import es.com.donde.app.model.Game;
import es.com.donde.app.model.Privacy;

/**
 * Created by santiago on 6/3/14.
 */
public class PrivacyModelAdapter implements ExpandableListAdapter.ModelType<Game> {

    Privacy privacy;
    List<Game> games;

    public PrivacyModelAdapter (Privacy privacy, List<Game> games) {
        this.privacy = privacy;
        this.games = games;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    @Override
    public Game getChild(int i) {
        return games.get(i);
    }

    @Override
    public int getChildrenCount() {
        return games.size();
    }


}
