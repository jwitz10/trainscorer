package com.jwitz.trainscorer;

import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReviewActivity extends Activity {;

    TextView overallReview;       
    TextView trainReview;                
    TextView ticketReview;             
    TextView bonusReview;
    boolean redFilledIn;
    boolean greenFilledIn;
    boolean blueFilledIn;
    boolean yellowFilledIn;
    boolean purpleFilledIn;
    boolean blackFilledIn;
    
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
                redFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.secondPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.greenReview);                
                trainReview = (TextView) findViewById(R.id.greenTrainReview);                
                ticketReview = (TextView) findViewById(R.id.greenTicketReview);                
                bonusReview = (TextView) findViewById(R.id.greenBonusReview);
                greenFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.thirdPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blueReview);                
                trainReview = (TextView) findViewById(R.id.blueTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blueTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blueBonusReview);
                blueFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fourthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.yellowReview);                
                trainReview = (TextView) findViewById(R.id.yellowTrainReview);                
                ticketReview = (TextView) findViewById(R.id.yellowTicketReview);                
                bonusReview = (TextView) findViewById(R.id.yellowBonusReview);
                yellowFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fifthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.purpleReview);                
                trainReview = (TextView) findViewById(R.id.purpleTrainReview);                
                ticketReview = (TextView) findViewById(R.id.purpleTicketReview);                
                bonusReview = (TextView) findViewById(R.id.purpleBonusReview);
                purpleFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.sixthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blackReview);
                trainReview = (TextView) findViewById(R.id.blackTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blackTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blackBonusReview);
                blackFilledIn = true;
            }
            
            updateScores(scoreSummary);
        }       

        hideSummaryWithNoScores();
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
    
    public void hideSummaryWithNoScores() {
        TextView overallReview;       
        TextView trainReview;                
        TextView ticketReview;             
        TextView bonusReview;
        
        if(!redFilledIn) {
            overallReview = (TextView) findViewById(R.id.redReview);                
            trainReview = (TextView) findViewById(R.id.redTrainReview);                
            ticketReview = (TextView) findViewById(R.id.redTicketReview);                
            bonusReview = (TextView) findViewById(R.id.redBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
        
        if(!greenFilledIn) {
            overallReview = (TextView) findViewById(R.id.greenReview);                
            trainReview = (TextView) findViewById(R.id.greenTrainReview);                
            ticketReview = (TextView) findViewById(R.id.greenTicketReview);                
            bonusReview = (TextView) findViewById(R.id.greenBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
        
        if(!blueFilledIn) {
            overallReview = (TextView) findViewById(R.id.blueReview);                
            trainReview = (TextView) findViewById(R.id.blueTrainReview);                
            ticketReview = (TextView) findViewById(R.id.blueTicketReview);                
            bonusReview = (TextView) findViewById(R.id.blueBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
        
        if(!yellowFilledIn) {
            overallReview = (TextView) findViewById(R.id.yellowReview);                
            trainReview = (TextView) findViewById(R.id.yellowTrainReview);                
            ticketReview = (TextView) findViewById(R.id.yellowTicketReview);                
            bonusReview = (TextView) findViewById(R.id.yellowBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
        
        if(!purpleFilledIn) {
            overallReview = (TextView) findViewById(R.id.purpleReview);                
            trainReview = (TextView) findViewById(R.id.purpleTrainReview);                
            ticketReview = (TextView) findViewById(R.id.purpleTicketReview);                
            bonusReview = (TextView) findViewById(R.id.purpleBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
        
        if(!blackFilledIn) {
            overallReview = (TextView) findViewById(R.id.blackReview);                
            trainReview = (TextView) findViewById(R.id.blackTrainReview);                
            ticketReview = (TextView) findViewById(R.id.blackTicketReview);                
            bonusReview = (TextView) findViewById(R.id.blackBonusReview);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview});
        }
    }
    
    public void hideViews(TextView[] views) {
        for(TextView view : views) {
            view.setVisibility(View.GONE);
        }
    }
}
