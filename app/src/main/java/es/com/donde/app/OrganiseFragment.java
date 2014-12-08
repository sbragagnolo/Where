package es.com.donde.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import es.com.donde.app.components.selector.ReactiveEditText;
import es.com.donde.app.components.selector.ReactiveTextView;
import es.com.donde.app.components.selector.day.DaySelector;
import es.com.donde.app.components.selector.mode.ModeSelector;
import es.com.donde.app.components.selector.privacy.PrivacySelector;
import es.com.donde.app.components.selector.time.HourSelector;
import es.com.donde.app.model.Game;
import es.com.donde.app.model.Place;
import es.com.donde.app.model.Privacy;
import es.com.donde.app.security.User;

/**
 * Created by santiago on 5/23/14.
 */


public class OrganiseFragment extends Fragment {
    View rootView;
    EditText lacks;
    Game game ;
    User currentUser = new User("Current", "Current", "Current");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_organise, container, false);
        ModeSelector selector = (ModeSelector) rootView.findViewById(R.id.mode);
        lacks = (ReactiveEditText) rootView.findViewById(R.id.lacks);
        lacks.getText();
        selector.setOnChoiceListener(new ModeSelector.OnChoiceListener() {
            @Override
            public void onChoice(ModeSelector selector) {
                lacks.setText(Integer.toString(selector.getChoiceSize()));
            }
        });


        Button btn = (Button) rootView.findViewById(R.id.organiseButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrganiseFragment.this.game.persist();
                OrganiseFragment.this.setGame (new Game());

            }
        });
        this.wireUpGame();
        this.setGame(new Game());
        this.game.setOrganizer(currentUser);

        return rootView;
    }

    private ReactiveEditText locationSelector () {
        return (ReactiveEditText) rootView.findViewById(R.id.where);
    }
    private ReactiveEditText lacksSelector () {
        return (ReactiveEditText) rootView.findViewById(R.id.lacks);
    }

    private HourSelector hourSelector () {
        return (HourSelector) rootView.findViewById(R.id.whenHour);
    }
    private DaySelector daySelector () {
        return (DaySelector) rootView.findViewById(R.id.whenDate);
    }
    private PrivacySelector privacySelector () {
        return (PrivacySelector) rootView.findViewById(R.id.privacy);
    }

    public void setGame (Game game) {
          this.game = game;
          this.locationSelector().silentSetText(game.getWhere().getAddress());

          this.privacySelector().silentSetText(game.getPrivacy().getName());
          this.daySelector().silentSetDay(game.getWhen());
          this.hourSelector().silentSetHour(game.getWhen());
          this.lacksSelector().silentSetText(game.getItLacks().toString());

    }

    private void wireUpGame() {

        this.locationSelector().setOnTextChangeListener(new ReactiveEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(ReactiveEditText view) {
                OrganiseFragment.this.game.setWhere(Place.resolve(view.getText().toString()));
                game.printOnOut();
            }
        });
        this.lacksSelector().setOnTextChangeListener(new ReactiveEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(ReactiveEditText view) {
                OrganiseFragment.this.game.setItLacks(Integer.parseInt(view.getText().toString()));
                game.printOnOut();
            }
        });
        this.hourSelector().setOnTextChangeListener(new ReactiveTextView.OnTextChangeListener() {
            @Override
            public void onTextChange(ReactiveTextView view) {
                Date when = OrganiseFragment.this.game.getWhen();
                Date input = OrganiseFragment.this.hourSelector().getPickedHour();

                when.setHours(input.getHours());
                when.setMinutes(input.getMinutes());
                OrganiseFragment.this.game.setWhen(when);
                game.printOnOut();
            }
        });
        this.daySelector().setOnTextChangeListener(new ReactiveTextView.OnTextChangeListener() {
            @Override
            public void onTextChange(ReactiveTextView view) {
                Date when = OrganiseFragment.this.game.getWhen();
                Date input = OrganiseFragment.this.daySelector().getPickedDay();
                when.setDate(input.getDate());
                when.setMonth(input.getMonth());
                when.setYear(input.getYear());
                OrganiseFragment.this.game.setWhen(when);
                game.printOnOut();
            }
        });
        this.privacySelector().setOnTextChangeListener(new ReactiveTextView.OnTextChangeListener() {
            @Override
            public void onTextChange(ReactiveTextView view) {
                game.setPrivacy(Privacy.fromString(view.getText().toString()));
                game.printOnOut();
            }
        });

    }
}















