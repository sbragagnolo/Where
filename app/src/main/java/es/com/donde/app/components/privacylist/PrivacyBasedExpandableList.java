package es.com.donde.app.components.privacylist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import es.com.donde.app.R;
import es.com.donde.app.components.listadapter.ExpandableListAdapter;
import es.com.donde.app.model.Game;
import es.com.donde.app.model.Place;
import es.com.donde.app.model.Privacy;
import es.com.donde.app.security.User;

/**
 * Created by santiago on 6/3/14.
 */
public class PrivacyBasedExpandableList extends ExpandableListAdapter<Game> {


    public PrivacyBasedExpandableList() {
        super();
    };

    static public List<Game> makeUpSomeGames () {

        List<Game> games = new ArrayList<Game> ();
        Place aPlace = Place.resolve("41 diego rapela");
        Place anOtherPlace = Place.resolve("43 diego rapela");
        Game aGame;
        User user;


        user = new User("ex", "ex", "Organizer 1");

        aGame = new Game();
        aGame.setPrivacy(Privacy.FRIENDS);
        aGame.setWhen(new Date());
        aGame.setWhere(aPlace);
        aGame.setItLacks(10);
        aGame.setOrganizer(user);
        games.add(aGame);

        aGame = new Game();
        aGame.setPrivacy(Privacy.FRIENDS_OF_FRIENDS);
        aGame.setWhen(new Date());
        aGame.setWhere(anOtherPlace);
        aGame.setItLacks(10);
        aGame.setOrganizer(user);
        games.add(aGame);


        user = new User("ex", "ex", "Organizer 2");


        aGame = new Game();
        aGame.setPrivacy(Privacy.FRIENDS);
        aGame.setWhen(new Date());
        aGame.setWhere(aPlace);
        aGame.setItLacks(10);
        aGame.setOrganizer(user);
        games.add(aGame);

        aGame = new Game();
        aGame.setPrivacy(Privacy.FRIENDS_OF_FRIENDS);
        aGame.setWhen(new Date());
        aGame.setWhere(anOtherPlace);
        aGame.setItLacks(10);
        aGame.setOrganizer(user);
        games.add(aGame);

        return games;

    }


    public PrivacyBasedExpandableList(Activity context){
        this(context, PrivacyBasedExpandableList.makeUpSomeGames());
    }

    public PrivacyBasedExpandableList(Activity context, List<Game> games) {
        this();
        this.context = context;
        Map<Privacy, List<Game>> pairs = Privacy.groupByPrivacy(games);
        List<ModelType<Game>> base = new ArrayList<ModelType<Game>>();
        for ( Privacy privacy : Privacy.values()) {
            base.add(new PrivacyModelAdapter(privacy, pairs.get(privacy)));
        }
        this.setModels(base);
    }


    @Override
    public View drawGroupView(ModelType<Game> model, boolean isExpanded, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.privacy_based_listview, null);

        TextView item = (TextView) convertView.findViewById(R.id.privacy);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(((PrivacyModelAdapter) model).getPrivacy().getName());
        return convertView;
    }

    @Override
    public View drawChildView(Game childModel, boolean isLast, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View convertView = inflater.inflate(R.layout.game_listview_item, null);
        TextView item = (TextView) convertView.findViewById(R.id.owner);
        item.setText(childModel.getOrganizer().getScreenName());
        return convertView;
    }
}
