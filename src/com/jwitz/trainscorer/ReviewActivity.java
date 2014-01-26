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
    TextView train1Review;
    TextView train2Review;
    TextView train3Review;
    TextView train4Review;
    TextView train5Review;
    TextView train6Review;
    TextView train7Review;
    TextView train8Review;
    TextView train9Review;
    
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
                train1Review = (TextView) findViewById(R.id.redTrain1Review);
                train2Review = (TextView) findViewById(R.id.redTrain2Review);
                train3Review = (TextView) findViewById(R.id.redTrain3Review);
                train4Review = (TextView) findViewById(R.id.redTrain4Review);
                train5Review = (TextView) findViewById(R.id.redTrain5Review);
                train6Review = (TextView) findViewById(R.id.redTrain6Review);
                train7Review = (TextView) findViewById(R.id.redTrain7Review);
                train8Review = (TextView) findViewById(R.id.redTrain8Review);
                train9Review = (TextView) findViewById(R.id.redTrain9Review);
                redFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.secondPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.greenReview);                
                trainReview = (TextView) findViewById(R.id.greenTrainReview);                
                ticketReview = (TextView) findViewById(R.id.greenTicketReview);                
                bonusReview = (TextView) findViewById(R.id.greenBonusReview);
                train1Review = (TextView) findViewById(R.id.greenTrain1Review);
                train2Review = (TextView) findViewById(R.id.greenTrain2Review);
                train3Review = (TextView) findViewById(R.id.greenTrain3Review);
                train4Review = (TextView) findViewById(R.id.greenTrain4Review);
                train5Review = (TextView) findViewById(R.id.greenTrain5Review);
                train6Review = (TextView) findViewById(R.id.greenTrain6Review);
                train7Review = (TextView) findViewById(R.id.greenTrain7Review);
                train8Review = (TextView) findViewById(R.id.greenTrain8Review);
                train9Review = (TextView) findViewById(R.id.greenTrain9Review);
                greenFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.thirdPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blueReview);                
                trainReview = (TextView) findViewById(R.id.blueTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blueTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blueBonusReview);
                train1Review = (TextView) findViewById(R.id.blueTrain1Review);
                train2Review = (TextView) findViewById(R.id.blueTrain2Review);
                train3Review = (TextView) findViewById(R.id.blueTrain3Review);
                train4Review = (TextView) findViewById(R.id.blueTrain4Review);
                train5Review = (TextView) findViewById(R.id.blueTrain5Review);
                train6Review = (TextView) findViewById(R.id.blueTrain6Review);
                train7Review = (TextView) findViewById(R.id.blueTrain7Review);
                train8Review = (TextView) findViewById(R.id.blueTrain8Review);
                train9Review = (TextView) findViewById(R.id.blueTrain9Review);
                blueFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fourthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.yellowReview);                
                trainReview = (TextView) findViewById(R.id.yellowTrainReview);                
                ticketReview = (TextView) findViewById(R.id.yellowTicketReview);                
                bonusReview = (TextView) findViewById(R.id.yellowBonusReview);
                train1Review = (TextView) findViewById(R.id.yellowTrain1Review);
                train2Review = (TextView) findViewById(R.id.yellowTrain2Review);
                train3Review = (TextView) findViewById(R.id.yellowTrain3Review);
                train4Review = (TextView) findViewById(R.id.yellowTrain4Review);
                train5Review = (TextView) findViewById(R.id.yellowTrain5Review);
                train6Review = (TextView) findViewById(R.id.yellowTrain6Review);
                train7Review = (TextView) findViewById(R.id.yellowTrain7Review);
                train8Review = (TextView) findViewById(R.id.yellowTrain8Review);
                train9Review = (TextView) findViewById(R.id.yellowTrain9Review);
                yellowFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.fifthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.purpleReview);                
                trainReview = (TextView) findViewById(R.id.purpleTrainReview);                
                ticketReview = (TextView) findViewById(R.id.purpleTicketReview);                
                bonusReview = (TextView) findViewById(R.id.purpleBonusReview);
                train1Review = (TextView) findViewById(R.id.purpleTrain1Review);
                train2Review = (TextView) findViewById(R.id.purpleTrain2Review);
                train3Review = (TextView) findViewById(R.id.purpleTrain3Review);
                train4Review = (TextView) findViewById(R.id.purpleTrain4Review);
                train5Review = (TextView) findViewById(R.id.purpleTrain5Review);
                train6Review = (TextView) findViewById(R.id.purpleTrain6Review);
                train7Review = (TextView) findViewById(R.id.purpleTrain7Review);
                train8Review = (TextView) findViewById(R.id.purpleTrain8Review);
                train9Review = (TextView) findViewById(R.id.purpleTrain9Review);
                purpleFilledIn = true;
                
            }else if(scoreSummary.getPlayerNumber() == R.id.sixthPlayerButton) {
                
                overallReview = (TextView) findViewById(R.id.blackReview);
                trainReview = (TextView) findViewById(R.id.blackTrainReview);                
                ticketReview = (TextView) findViewById(R.id.blackTicketReview);                
                bonusReview = (TextView) findViewById(R.id.blackBonusReview);
                train1Review = (TextView) findViewById(R.id.blackTrain1Review);
                train2Review = (TextView) findViewById(R.id.blackTrain2Review);
                train3Review = (TextView) findViewById(R.id.blackTrain3Review);
                train4Review = (TextView) findViewById(R.id.blackTrain4Review);
                train5Review = (TextView) findViewById(R.id.blackTrain5Review);
                train6Review = (TextView) findViewById(R.id.blackTrain6Review);
                train7Review = (TextView) findViewById(R.id.blackTrain7Review);
                train8Review = (TextView) findViewById(R.id.blackTrain8Review);
                train9Review = (TextView) findViewById(R.id.blackTrain9Review);
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
        train1Review.setText(String.valueOf(scoreSummary.getTrains(1)));
        train2Review.setText(String.valueOf(scoreSummary.getTrains(2)));
        train3Review.setText(String.valueOf(scoreSummary.getTrains(3)));
        train4Review.setText(String.valueOf(scoreSummary.getTrains(4)));
        train5Review.setText(String.valueOf(scoreSummary.getTrains(5)));
        train6Review.setText(String.valueOf(scoreSummary.getTrains(6)));
        train7Review.setText(String.valueOf(scoreSummary.getTrains(7)));
        train8Review.setText(String.valueOf(scoreSummary.getTrains(8)));
        train9Review.setText(String.valueOf(scoreSummary.getTrains(9)));
    }
    
    public void hideSummaryWithNoScores() {
        TextView overallReview;       
        TextView trainReview;                
        TextView ticketReview;             
        TextView bonusReview;
        TextView train1Review;
        TextView train2Review;
        TextView train3Review;
        TextView train4Review;
        TextView train5Review;
        TextView train6Review;
        TextView train7Review;
        TextView train8Review;
        TextView train9Review;
        
        if(!redFilledIn) {
            overallReview = (TextView) findViewById(R.id.redReview);                
            trainReview = (TextView) findViewById(R.id.redTrainReview);                
            ticketReview = (TextView) findViewById(R.id.redTicketReview);                
            bonusReview = (TextView) findViewById(R.id.redBonusReview);
            train1Review = (TextView) findViewById(R.id.redTrain1Review);
            train2Review = (TextView) findViewById(R.id.redTrain2Review);
            train3Review = (TextView) findViewById(R.id.redTrain3Review);
            train4Review = (TextView) findViewById(R.id.redTrain4Review);
            train5Review = (TextView) findViewById(R.id.redTrain5Review);
            train6Review = (TextView) findViewById(R.id.redTrain6Review);
            train7Review = (TextView) findViewById(R.id.redTrain7Review);
            train8Review = (TextView) findViewById(R.id.redTrain8Review);
            train9Review = (TextView) findViewById(R.id.redTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
        
        if(!greenFilledIn) {
            overallReview = (TextView) findViewById(R.id.greenReview);                
            trainReview = (TextView) findViewById(R.id.greenTrainReview);                
            ticketReview = (TextView) findViewById(R.id.greenTicketReview);                
            bonusReview = (TextView) findViewById(R.id.greenBonusReview);
            train1Review = (TextView) findViewById(R.id.greenTrain1Review);
            train2Review = (TextView) findViewById(R.id.greenTrain2Review);
            train3Review = (TextView) findViewById(R.id.greenTrain3Review);
            train4Review = (TextView) findViewById(R.id.greenTrain4Review);
            train5Review = (TextView) findViewById(R.id.greenTrain5Review);
            train6Review = (TextView) findViewById(R.id.greenTrain6Review);
            train7Review = (TextView) findViewById(R.id.greenTrain7Review);
            train8Review = (TextView) findViewById(R.id.greenTrain8Review);
            train9Review = (TextView) findViewById(R.id.greenTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
        
        if(!blueFilledIn) {
            overallReview = (TextView) findViewById(R.id.blueReview);                
            trainReview = (TextView) findViewById(R.id.blueTrainReview);                
            ticketReview = (TextView) findViewById(R.id.blueTicketReview);                
            bonusReview = (TextView) findViewById(R.id.blueBonusReview);
            train1Review = (TextView) findViewById(R.id.blueTrain1Review);
            train2Review = (TextView) findViewById(R.id.blueTrain2Review);
            train3Review = (TextView) findViewById(R.id.blueTrain3Review);
            train4Review = (TextView) findViewById(R.id.blueTrain4Review);
            train5Review = (TextView) findViewById(R.id.blueTrain5Review);
            train6Review = (TextView) findViewById(R.id.blueTrain6Review);
            train7Review = (TextView) findViewById(R.id.blueTrain7Review);
            train8Review = (TextView) findViewById(R.id.blueTrain8Review);
            train9Review = (TextView) findViewById(R.id.blueTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
        
        if(!yellowFilledIn) {
            overallReview = (TextView) findViewById(R.id.yellowReview);                
            trainReview = (TextView) findViewById(R.id.yellowTrainReview);                
            ticketReview = (TextView) findViewById(R.id.yellowTicketReview);                
            bonusReview = (TextView) findViewById(R.id.yellowBonusReview);
            train1Review = (TextView) findViewById(R.id.yellowTrain1Review);
            train2Review = (TextView) findViewById(R.id.yellowTrain2Review);
            train3Review = (TextView) findViewById(R.id.yellowTrain3Review);
            train4Review = (TextView) findViewById(R.id.yellowTrain4Review);
            train5Review = (TextView) findViewById(R.id.yellowTrain5Review);
            train6Review = (TextView) findViewById(R.id.yellowTrain6Review);
            train7Review = (TextView) findViewById(R.id.yellowTrain7Review);
            train8Review = (TextView) findViewById(R.id.yellowTrain8Review);
            train9Review = (TextView) findViewById(R.id.yellowTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
        
        if(!purpleFilledIn) {
            overallReview = (TextView) findViewById(R.id.purpleReview);                
            trainReview = (TextView) findViewById(R.id.purpleTrainReview);                
            ticketReview = (TextView) findViewById(R.id.purpleTicketReview);                
            bonusReview = (TextView) findViewById(R.id.purpleBonusReview);
            train1Review = (TextView) findViewById(R.id.purpleTrain1Review);
            train2Review = (TextView) findViewById(R.id.purpleTrain2Review);
            train3Review = (TextView) findViewById(R.id.purpleTrain3Review);
            train4Review = (TextView) findViewById(R.id.purpleTrain4Review);
            train5Review = (TextView) findViewById(R.id.purpleTrain5Review);
            train6Review = (TextView) findViewById(R.id.purpleTrain6Review);
            train7Review = (TextView) findViewById(R.id.purpleTrain7Review);
            train8Review = (TextView) findViewById(R.id.purpleTrain8Review);
            train9Review = (TextView) findViewById(R.id.purpleTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
        
        if(!blackFilledIn) {
            overallReview = (TextView) findViewById(R.id.blackReview);
            trainReview = (TextView) findViewById(R.id.blackTrainReview);                
            ticketReview = (TextView) findViewById(R.id.blackTicketReview);                
            bonusReview = (TextView) findViewById(R.id.blackBonusReview);
            train1Review = (TextView) findViewById(R.id.blackTrain1Review);
            train2Review = (TextView) findViewById(R.id.blackTrain2Review);
            train3Review = (TextView) findViewById(R.id.blackTrain3Review);
            train4Review = (TextView) findViewById(R.id.blackTrain4Review);
            train5Review = (TextView) findViewById(R.id.blackTrain5Review);
            train6Review = (TextView) findViewById(R.id.blackTrain6Review);
            train7Review = (TextView) findViewById(R.id.blackTrain7Review);
            train8Review = (TextView) findViewById(R.id.blackTrain8Review);
            train9Review = (TextView) findViewById(R.id.blackTrain9Review);
            hideViews(new TextView[]{overallReview, trainReview, ticketReview, bonusReview,
                    train1Review, train2Review, train3Review, train4Review, train5Review, train6Review, train7Review, train8Review, train9Review});
        }
    }
    
    public void hideViews(TextView[] views) {
        for(TextView view : views) {
            view.setVisibility(View.GONE);
        }
    }
}
