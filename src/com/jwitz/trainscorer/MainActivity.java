package com.jwitz.trainscorer;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up click listeners for all the buttons
        setupListenersForPlayerButtons();
        setupListenersForTrains();
        setupListenersForTickets();
        setupListenersForBonuses();
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {        
        switch (item.getItemId()) {
        case R.id.action_settings:
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            break;
        }
 
        return true;
    }
    
    public void onResume() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        Map<String, ?> prefs = preferences.getAll();
        for(String key : prefs.keySet()) {
            if(key.contains("color")) {
                boolean visible = preferences.getBoolean(key, true);
                View v = null;
                if(key.equals("pref_key_red_color")) {
                    v = findViewById(R.id.firstPlayerButton);
                }else if(key.equals("pref_key_green_color")) {
                    v = findViewById(R.id.secondPlayerButton);
                }else if(key.equals("pref_key_blue_color")) {
                    v = findViewById(R.id.thirdPlayerButton);
                }else if(key.equals("pref_key_yellow_color")) {
                    v = findViewById(R.id.fourthPlayerButton);
                }else if(key.equals("pref_key_purple_color")) {
                    v = findViewById(R.id.fifthPlayerButton);
                }else if(key.equals("pref_key_black_color")) {
                    v = findViewById(R.id.sixthPlayerButton);
                }
                if(v != null) {
                    if(visible) {
                        v.setVisibility(View.VISIBLE);
                    }else {
                        v.setVisibility(View.INVISIBLE);
                    }
                }
            }
            if(key.equals("pref_key_game_type")) {
                //configure bonuses
                String value = preferences.getString(key, null);
                Button globeTrotter = (Button) findViewById(R.id.globeTrotterButton);
                Button longestRoute = (Button) findViewById(R.id.longestRouteButton);
                Button trainStation = (Button) findViewById(R.id.trainStationButton);
                if(value.equals("USA")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                }else if(value.equals("USA 1910")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    globeTrotter.setText(R.string.globetrotter15);
                    _globeTrotterValue = 15;
                }else if(value.equals("Europe")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.VISIBLE);;
                }else if(value.equals("Europe 1912")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.VISIBLE);
                }else if(value.equals("Marklin")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    globeTrotter.setText(R.string.globetrotter);
                    _globeTrotterValue = 10;
                }else if(value.equals("Nordic")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    globeTrotter.setText(R.string.globetrotter);
                    _globeTrotterValue = 10;
                }else if(value.equals("Team Asia")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    globeTrotter.setText(R.string.globetrotter);
                    _globeTrotterValue = 10;
                }else if(value.equals("Legendary Asia")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                }else if(value.equals("India")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    //grand tour of india
                    //http://cdn1.daysofwonder.com/tickettoride/en/img/tt_india_rules.pdf
                }else if(value.equals("Switzerland")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                }else if(value.equals("Africa")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    globeTrotter.setText(R.string.globetrotter);
                    _globeTrotterValue = 10;
                }else if(value.equals("Nederland")) {
                    globeTrotter.setVisibility(View.INVISIBLE);
                    longestRoute.setVisibility(View.INVISIBLE);
                    trainStation.setVisibility(View.INVISIBLE);
                    //bridge tokens bonus
                    //http://cdn0.daysofwonder.com/tickettoride/en/img/tt_nederland_rules.pdf
                }else if(value.equals("Custom")) {
                    globeTrotter.setVisibility(View.VISIBLE);
                    longestRoute.setVisibility(View.VISIBLE);
                    trainStation.setVisibility(View.VISIBLE);
                    globeTrotter.setText(R.string.globetrotter);
                    _globeTrotterValue = 10;
                }
            }
        }
        super.onResume();
    }

    private void setupListenersForTrains() {
        int[] ids = {R.id.trains1Button, R.id.trains2Button, R.id.trains3Button, R.id.trains4Button, R.id.trains5Button, R.id.trains6Button, R.id.trains8Button, R.id.trains9Button};
        for(int i = 0; i<ids.length; i++) {
            View v = findViewById(ids[i]);
            v.setOnClickListener(this);
        }
    }

    private void setupListenersForPlayerButtons() {
        int[] ids = {R.id.firstPlayerButton, R.id.secondPlayerButton, R.id.thirdPlayerButton, R.id.fourthPlayerButton, R.id.fifthPlayerButton, R.id.sixthPlayerButton};
        for(int i = 0; i<ids.length; i++) {
            View v = findViewById(ids[i]);
            v.setOnClickListener(this);
        }
    }

    private void setupListenersForBonuses() {
        int[] ids = {R.id.longestRouteButton, R.id.globeTrotterButton, R.id.trainStationButton, R.id.clearButton, R.id.reviewButton};
        for(int i = 0; i<ids.length; i++) {
            View v = findViewById(ids[i]);
            v.setOnClickListener(this);
        }
    }

    private void setupListenersForTickets() {
        int[] ids = {R.id.ticket1Button, R.id.ticket2Button, R.id.ticket3Button, R.id.ticket4Button, R.id.ticket5Button, R.id.ticket6Button, R.id.ticket7Button, R.id.ticket8Button, R.id.ticket9Button,
                R.id.ticket10Button, R.id.ticket11Button, R.id.ticket12Button, R.id.ticket13Button, R.id.ticket14Button, R.id.ticket15Button, R.id.ticket16Button, R.id.ticket17Button,
                R.id.ticket18Button, R.id.ticket19Button, R.id.ticket20Button, R.id.ticket21Button, R.id.ticket22Button, R.id.minusButton, R.id.manualButton};
        for(int i = 0; i<ids.length; i++) {
            View v = findViewById(ids[i]);
            v.setOnClickListener(this);
        }
    }

    private void convertSignage(boolean minus) {
        int[] ids = {R.id.ticket1Button, R.id.ticket2Button, R.id.ticket3Button, R.id.ticket4Button, R.id.ticket5Button, R.id.ticket6Button, R.id.ticket7Button, R.id.ticket8Button, R.id.ticket9Button,
                R.id.ticket10Button, R.id.ticket11Button, R.id.ticket12Button, R.id.ticket13Button, R.id.ticket14Button, R.id.ticket15Button, R.id.ticket16Button, R.id.ticket17Button,
                R.id.ticket18Button, R.id.ticket19Button, R.id.ticket20Button, R.id.ticket21Button, R.id.ticket22Button, R.id.manualButton,
                R.id.trains1Button, R.id.trains2Button, R.id.trains3Button, R.id.trains4Button, R.id.trains5Button, R.id.trains6Button, R.id.trains8Button, R.id.trains9Button};
        for(int i = 0; i<ids.length; i++) {
            Button button = (Button) findViewById(ids[i]);
            String text = button.getText().toString();
            String newText;
            if(minus){
                newText = text.replace("+", "-");
                button.setTextColor(getResources().getColor(R.color.red));
            }else {
                newText = text.replace("-", "+");
                button.setTextColor(getResources().getColor(R.color.white));
            }
            button.setText(newText);
        }

        //minus needs to go from red -> green and minus -> plus to indicate to switch back
        Button button = (Button) findViewById(R.id.minusButton);
        convertButton(button, minus);
    }

    private void convertButton(Button button, boolean minus) {
        String text = button.getText().toString();
        String newText;
        if(minus){
            newText = text.replace("-", "+");
            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_button));
        }else {
            newText = text.replace("+", "-");
            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_button));
        }
        button.setText(newText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    private void updateSelectedButton(int viewID) {    
        Drawable shape = null;
        switch(viewID) {
        case R.id.firstPlayerButton:
            shape = getResources().getDrawable(R.drawable.red_button_selected);
            break;
        case R.id.secondPlayerButton:
            shape = getResources().getDrawable(R.drawable.green_button_selected);
            break;
        case R.id.thirdPlayerButton:
            shape = getResources().getDrawable(R.drawable.blue_button_selected);
            break;
        case R.id.fourthPlayerButton:
            shape = getResources().getDrawable(R.drawable.yellow_button_selected);
            break;
        case R.id.fifthPlayerButton:
            shape = getResources().getDrawable(R.drawable.purple_button_selected);
            break;
        case R.id.sixthPlayerButton:
            shape = getResources().getDrawable(R.drawable.black_button_selected);
            break;
        }
        _playerSelected.setBackgroundDrawable(shape);
    }

    private void updateUnSelectedButton(int viewID) {
        Drawable shape = null;
        switch(viewID) {
        case R.id.firstPlayerButton:
            shape = getResources().getDrawable(R.drawable.red_button);
            break;
        case R.id.secondPlayerButton:
            shape = getResources().getDrawable(R.drawable.green_button);
            break;
        case R.id.thirdPlayerButton:
            shape = getResources().getDrawable(R.drawable.blue_button);
            break;
        case R.id.fourthPlayerButton:
            shape = getResources().getDrawable(R.drawable.yellow_button);
            break;
        case R.id.fifthPlayerButton:
            shape = getResources().getDrawable(R.drawable.purple_button);
            break;
        case R.id.sixthPlayerButton:
            shape = getResources().getDrawable(R.drawable.black_button);
            break;
        }
        _lastPlayerSelected.setBackgroundDrawable(shape);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.firstPlayerButton:
        case R.id.secondPlayerButton:
        case R.id.thirdPlayerButton:
        case R.id.fourthPlayerButton:
        case R.id.fifthPlayerButton:
        case R.id.sixthPlayerButton:
            _playerSelected = (Button) findViewById(v.getId());
            _scoreSummary = _playerScoreMap.get(_playerSelected);
            if(_scoreSummary == null) {
                _scoreSummary = new ScoreSummary(v.getId());
            }      
            updateSelectedButton(_playerSelected.getId());
            if(_lastPlayerSelected != null && _playerSelected != _lastPlayerSelected) {
                updateUnSelectedButton(_lastPlayerSelected.getId());
            }
            _lastPlayerSelected = _playerSelected;
            break;
        case R.id.trains1Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(1); } else { _scoreSummary.updateTrains(-1); }
            break;
        case R.id.trains2Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(2); } else { _scoreSummary.updateTrains(-2); }
            break;
        case R.id.trains3Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(3); } else { _scoreSummary.updateTrains(-3); }
            break;
        case R.id.trains4Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(4); } else { _scoreSummary.updateTrains(-4); }
            break;
        case R.id.trains5Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(5); } else { _scoreSummary.updateTrains(-5); }
            break;
        case R.id.trains6Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(6); } else { _scoreSummary.updateTrains(-6); }
            break;
        case R.id.trains8Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(8); } else { _scoreSummary.updateTrains(-8); }
            break;
        case R.id.trains9Button:
            if(!_subtractionMode) { _scoreSummary.updateTrains(9); } else { _scoreSummary.updateTrains(-9); }
            break;
        case R.id.ticket1Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(1); } else { _scoreSummary.updateTickets(-1); }
            break;
        case R.id.ticket2Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(2); } else { _scoreSummary.updateTickets(-2); }
            break;
        case R.id.ticket3Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(3); } else { _scoreSummary.updateTickets(-3); }
            break;
        case R.id.ticket4Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(4); } else { _scoreSummary.updateTickets(-4); }
            break;
        case R.id.ticket5Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(5); } else { _scoreSummary.updateTickets(-5); }
            break;
        case R.id.ticket6Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(6); } else { _scoreSummary.updateTickets(-6); }
            break;
        case R.id.ticket7Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(7); } else { _scoreSummary.updateTickets(-7); }
            break;
        case R.id.ticket8Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(8); } else { _scoreSummary.updateTickets(-8); }
            break;
        case R.id.ticket9Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(9); } else { _scoreSummary.updateTickets(-9); }
            break;
        case R.id.ticket10Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(10); } else { _scoreSummary.updateTickets(-10); }
            break;
        case R.id.ticket11Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(11); } else { _scoreSummary.updateTickets(-11); }
            break;
        case R.id.ticket12Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(12); } else { _scoreSummary.updateTickets(-12); }
            break;
        case R.id.ticket13Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(13); } else { _scoreSummary.updateTickets(-13); }
            break;
        case R.id.ticket14Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(14); } else { _scoreSummary.updateTickets(-14); }
            break;
        case R.id.ticket15Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(15); } else { _scoreSummary.updateTickets(-15); }
            break;
        case R.id.ticket16Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(16); } else { _scoreSummary.updateTickets(-16); }
            break;
        case R.id.ticket17Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(17); } else { _scoreSummary.updateTickets(-17); }
            break;
        case R.id.ticket18Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(18); } else { _scoreSummary.updateTickets(-18); }
            break;
        case R.id.ticket19Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(19); } else { _scoreSummary.updateTickets(-19); }
            break;
        case R.id.ticket20Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(20); } else { _scoreSummary.updateTickets(-20); }
            break;
        case R.id.ticket21Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(21); } else { _scoreSummary.updateTickets(-21); }
            break;
        case R.id.ticket22Button:
            if(!_subtractionMode) { _scoreSummary.updateTickets(22); } else { _scoreSummary.updateTickets(-22); }
            break;
        case R.id.manualButton:
            AlertDialog.Builder ticketScoreAlert = new AlertDialog.Builder(this);
            ticketScoreAlert.setMessage("Ticket Score");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            input.setFocusableInTouchMode(true);
            input.setFocusable(true);
            input.requestFocus();
            ticketScoreAlert.setView(input);
            
            final AlertDialog alert = ticketScoreAlert.create();

            // done button on numberpad means the same thing as on the alert
            input.setOnEditorActionListener(
                    new EditText.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                                String value = input.getText().toString();
                                if(!value.isEmpty()) {
                                    int additionValue = Integer.parseInt(value);
                                    if(!_subtractionMode) { _scoreSummary.updateTickets(additionValue); } else { _scoreSummary.updateTickets(-additionValue); }
                                }
                                updateScores();
                                alert.dismiss();
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
                                return true; // consume.
                            }
                            return false; // pass on to other listeners. 
                        }
                    });

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

            alert.show();
            break;
        case R.id.globeTrotterButton:
            _scoreSummary.addGlobeTrotter(_globeTrotterValue);
            break;
        case R.id.longestRouteButton:
            _scoreSummary.addLongestRoute();
            break;
        case R.id.trainStationButton:
            _scoreSummary.addTrainStations();
            break;
        case R.id.minusButton:
            if(!_subtractionMode) {
                _subtractionMode = true;
                //set all the values to negatives
                convertSignage(true);
            }else {
                _subtractionMode = false;
                //set all the values back to original values
                convertSignage(false);
            }
            break;
        case R.id.clearButton:
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        for(Button player : _playerScoreMap.keySet()) {
                            player.setText(String.valueOf(0));
                        }
                        if(_playerSelected != null) {
                            updateUnSelectedButton(_playerSelected.getId());
                        }
                        if(_lastPlayerSelected != null) {
                            updateUnSelectedButton(_lastPlayerSelected.getId());
                        }
                        _playerScoreMap = new HashMap<Button, ScoreSummary>();
                        _playerSelected = null;
                        _lastPlayerSelected = null;
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();
            break;
        case R.id.reviewButton:
            Intent i = new Intent(this, ReviewActivity.class);
            startActivity(i);
            break;
        }

        updateScores();
    }

    private void updateScores() {
        if(_playerSelected != null) {
            _playerSelected.setText(String.valueOf(_scoreSummary.getTotalScore()));
            _playerScoreMap.put(_playerSelected, _scoreSummary);
        }
    }
    
    public static Map<Button, ScoreSummary> getPlayerScoreMap() {
        return _playerScoreMap;
    }
    
    public boolean hasUniqueCharacters(String str){
        String seenChars = null;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(seenChars.indexOf(c) > 0) {
               return false; 
            }else {
                seenChars += c;
            }
        }
        return true;
    }

    private boolean _subtractionMode = false;
    private Button _playerSelected = null;
    private Button _lastPlayerSelected = null;
    private ScoreSummary _scoreSummary = new ScoreSummary(0);
    private int _globeTrotterValue = 10;
    private static Map<Button, ScoreSummary> _playerScoreMap = new HashMap<Button, ScoreSummary>();
}
