package com.jwitz.trainscorer;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

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
        int[] ids = {R.id.longestRouteButton, R.id.globeTrotterButton, R.id.trainStationButton, R.id.clearButton};
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
            button.setBackground(getResources().getDrawable(R.drawable.green_button));
        }else {
            newText = text.replace("+", "-");
            button.setBackground(getResources().getDrawable(R.drawable.red_button));
        }
        button.setText(newText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        _playerSelected.setBackground(shape);
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
        _lastPlayerSelected.setBackground(shape);
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
            _playerScore = _playerScoreMap.get(_playerSelected);
            if(_playerScore == null) {
                _playerScore = 0;
            }           
            updateSelectedButton(_playerSelected.getId());
            if(_lastPlayerSelected != null && _playerSelected != _lastPlayerSelected) {
                updateUnSelectedButton(_lastPlayerSelected.getId());
            }
            _lastPlayerSelected = _playerSelected;
            break;
        case R.id.trains1Button:
            if(!_subtractionMode) { _playerScore += 1; } else { _playerScore -= 1; }
            break;
        case R.id.trains2Button:
            if(!_subtractionMode) { _playerScore += 2; } else { _playerScore -= 2; }
            break;
        case R.id.trains3Button:
            if(!_subtractionMode) { _playerScore += 3; } else { _playerScore -= 3; }
            break;
        case R.id.trains4Button:
            if(!_subtractionMode) { _playerScore += 7; } else { _playerScore -= 7; }
            break;
        case R.id.trains5Button:
            if(!_subtractionMode) { _playerScore += 10; } else { _playerScore -= 10; }
            break;
        case R.id.trains6Button:
            if(!_subtractionMode) { _playerScore += 15; } else { _playerScore -= 15; }
            break;
        case R.id.trains8Button:
            if(!_subtractionMode) { _playerScore += 21; } else { _playerScore -= 21; }
            break;
        case R.id.trains9Button:
            if(!_subtractionMode) { _playerScore += 27; } else { _playerScore -= 27; }
            break;
        case R.id.ticket1Button:
            if(!_subtractionMode) { _playerScore += 1; } else { _playerScore -= 1; }
            break;
        case R.id.ticket2Button:
            if(!_subtractionMode) { _playerScore += 2; } else { _playerScore -= 2; }
            break;
        case R.id.ticket3Button:
            if(!_subtractionMode) { _playerScore += 3; } else { _playerScore -= 3; }
            break;
        case R.id.ticket4Button:
            if(!_subtractionMode) { _playerScore += 4; } else { _playerScore -= 4; }
            break;
        case R.id.ticket5Button:
            if(!_subtractionMode) { _playerScore += 5; } else { _playerScore -= 5; }
            break;
        case R.id.ticket6Button:
            if(!_subtractionMode) { _playerScore += 6; } else { _playerScore -= 6; }
            break;
        case R.id.ticket7Button:
            if(!_subtractionMode) { _playerScore += 7; } else { _playerScore -= 7; }
            break;
        case R.id.ticket8Button:
            if(!_subtractionMode) { _playerScore += 8; } else { _playerScore -= 8; }
            break;
        case R.id.ticket9Button:
            if(!_subtractionMode) { _playerScore += 9; } else { _playerScore -= 9; }
            break;
        case R.id.ticket10Button:
            if(!_subtractionMode) { _playerScore += 10; } else { _playerScore -= 10; }
            break;
        case R.id.ticket11Button:
            if(!_subtractionMode) { _playerScore += 11; } else { _playerScore -= 11; }
            break;
        case R.id.ticket12Button:
            if(!_subtractionMode) { _playerScore += 12; } else { _playerScore -= 12; }
            break;
        case R.id.ticket13Button:
            if(!_subtractionMode) { _playerScore += 13; } else { _playerScore -= 13; }
            break;
        case R.id.ticket14Button:
            if(!_subtractionMode) { _playerScore += 14; } else { _playerScore -= 14; }
            break;
        case R.id.ticket15Button:
            if(!_subtractionMode) { _playerScore += 15; } else { _playerScore -= 15; }
            break;
        case R.id.ticket16Button:
            if(!_subtractionMode) { _playerScore += 16; } else { _playerScore -= 16; }
            break;
        case R.id.ticket17Button:
            if(!_subtractionMode) { _playerScore += 17; } else { _playerScore -= 17; }
            break;
        case R.id.ticket18Button:
            if(!_subtractionMode) { _playerScore += 18; } else { _playerScore -= 18; }
            break;
        case R.id.ticket19Button:
            if(!_subtractionMode) { _playerScore += 19; } else { _playerScore -= 19; }
            break;
        case R.id.ticket20Button:
            if(!_subtractionMode) { _playerScore += 20; } else { _playerScore -= 20; }
            break;
        case R.id.ticket21Button:
            if(!_subtractionMode) { _playerScore += 21; } else { _playerScore -= 21; }
            break;
        case R.id.ticket22Button:
            if(!_subtractionMode) { _playerScore += 22; } else { _playerScore -= 22; }
            break;
        case R.id.manualButton:
            AlertDialog.Builder ticketScoreAlert = new AlertDialog.Builder(this);
            ticketScoreAlert.setMessage("Ticket Score");
            
            final EditText input = new EditText(this);
            //input.setInputType(type);
            ticketScoreAlert.setView(input);
            ticketScoreAlert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String value = input.getText().toString();
                    int additionValue = Integer.parseInt(value);
                    if(!_subtractionMode) { _playerScore += additionValue; } else { _playerScore -= additionValue; }
                    updateScores();
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // do nothing
                }
            }).show();
            break;
        case R.id.globeTrotterButton:
            _playerScore += 10;
            break;
        case R.id.longestRouteButton:
            _playerScore += 10;
            break;
        case R.id.trainStationButton:
            _playerScore += 4;
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
                        _playerScoreMap = new HashMap<Button, Integer>();
                        _playerScore = 0;
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
        }
        
        updateScores();
    }
    
    private void updateScores() {
        if(_playerSelected != null) {
            _playerSelected.setText(String.valueOf(_playerScore));
            _playerScoreMap.put(_playerSelected, _playerScore);
        }
    }

    private boolean _subtractionMode = false;
    private Button _playerSelected = null;
    private Button _lastPlayerSelected = null;
    private Integer _playerScore = 0;
    private Map<Button, Integer> _playerScoreMap = new HashMap<Button, Integer>();
}
