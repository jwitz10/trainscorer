package com.jwitz.trainscorer;

import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class ReviewActivity extends Activity {;

    TextView overallReview;       
    TextView trainReview;                
    TextView ticketReview;             
    TextView bonusReview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    
        Map<Button, ScoreSummary> playerScoreMap = MainActivity.getPlayerScoreMap();
        for(Button button : playerScoreMap.keySet()) {
            ScoreSummary scoreSummary = playerScoreMap.get(button);  
    
            if(scoreSummary.getPlayerNumber() == R.id.firstPlayerButton){
                
                overallReview = (TextView) findViewById(R.id.redReview);                
                trainReview = (TextView) findViewById(R.id.redTrainReview);                
                ticketReview = (TextView) findViewById(R.id.redTicketReview);                
                bonusReview = (TextView) findViewById(R.id.redBonusReview);          
                
            }else if(scoreSummary.getPlayerNumber() == R.id.secondPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.greenReview);                
                trainReview = (TextView) findViewById(R.id.greenTrainReview);                
                ticketReview = (TextView) findViewById(R.id.greenTicketReview);                
                bonusReview = (TextView) findViewById(R.id.greenBonusReview);  
                
            }else if(scoreSummary.getPlayerNumber() == R.id.thirdPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blueReview);                
                trainReview = (TextView) findViewById(R.id.blueTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blueTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blueBonusReview);  
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fourthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.yellowReview);                
                trainReview = (TextView) findViewById(R.id.yellowTrainReview);                
                ticketReview = (TextView) findViewById(R.id.yellowTicketReview);                
                bonusReview = (TextView) findViewById(R.id.yellowBonusReview);  
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fifthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.purpleReview);                
                trainReview = (TextView) findViewById(R.id.purpleTrainReview);                
                ticketReview = (TextView) findViewById(R.id.purpleTicketReview);                
                bonusReview = (TextView) findViewById(R.id.purpleBonusReview);  
                
            }else if(scoreSummary.getPlayerNumber() == R.id.sixthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blackReview);
                trainReview = (TextView) findViewById(R.id.blackTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blackTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blackBonusReview);  
            }
            
            updateScores(scoreSummary);
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.review, menu);
        return true;
    }
    
    public void updateScores(ScoreSummary scoreSummary) {
        overallReview.setText(String.valueOf(scoreSummary.getTotalScore()));
        trainReview.setText(String.valueOf(scoreSummary.getTrainScore()));
        ticketReview.setText(String.valueOf(scoreSummary.getTicketScore()));
        bonusReview.setText(String.valueOf(scoreSummary.getBonusScore()));        
    }

}
