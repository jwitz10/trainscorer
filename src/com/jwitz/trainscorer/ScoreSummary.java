package com.jwitz.trainscorer;

import java.util.ArrayList;
import java.util.List;

public class ScoreSummary {

    public int getTrainScore() {
        return _trainScore;
    }
    
    public int getTicketScore() {
        return _ticketScore;
    }
    
    public int getBonusScore() {
        return _globeTrotter + _longestRoute + _trainStations;
    }
    
    public int getTotalScore() {
        return getTrainScore() + getTicketScore() + getBonusScore();
    }
    
    public void updateTrains(int i) {
        switch(i) {
        case 1: _trains1++; _trainScore+= 1; break;
        case 2: _trains2++; _trainScore+= 2; break;
        case 3: _trains3++; _trainScore+= 4; break;
        case 4: _trains4++; _trainScore+= 7; break;
        case 5: _trains5++; _trainScore+= 10; break;
        case 6: _trains6++; _trainScore+= 15; break;
        case 7: _trains7++; _trainScore+= 18; break;
        case 8: _trains8++; _trainScore+= 21; break;
        case 9: _trains9++; _trainScore+= 27; break;
        case -1: _trains1--; _trainScore-= 1; break;
        case -2: _trains2--; _trainScore-= 2; break;
        case -3: _trains3--; _trainScore-= 4; break;
        case -4: _trains4--; _trainScore-= 7; break;
        case -5: _trains5--; _trainScore-= 10; break;
        case -6: _trains6--; _trainScore-= 15; break;
        case -7: _trains7--; _trainScore-= 18; break;
        case -8: _trains8--; _trainScore-= 21; break;
        case -9: _trains9--; _trainScore-= 27; break;
        }
    }
    
    public void updateTickets(int i) {
        _ticketScore += i;
        if(i > 0) {
            _positiveTickets.add(i);
        }else {
            _negativeTickets.add(i);
        }
    }
    
    public void addGlobeTrotter() {
        _globeTrotter += 10;
    }
    
    public void addLongestRoute() {
        _longestRoute += 10;
    }
    
    public void addTrainStations() {
        _trainStations += 4;
    }
    
    public List<Integer> getPositiveTickets() {
        return _positiveTickets;
    }
    
    public List<Integer> getNegativeTickets() {
        return _negativeTickets;
    }
    
    public int getTrains(int i) {
        switch(i) {
        case 1: return _trains1;
        case 2: return _trains2;
        case 3: return _trains3;
        case 4: return _trains4;
        case 5: return _trains5;
        case 6: return _trains6;
        case 7: return _trains7;
        case 8: return _trains8;
        case 9: return _trains9;
        }
        return 0;
    }
    
    private int _trainScore;
    private int _trains1;
    private int _trains2;
    private int _trains3;
    private int _trains4;
    private int _trains5;
    private int _trains6;
    private int _trains7;
    private int _trains8;
    private int _trains9;
    private int _ticketScore;
    private int _globeTrotter;
    private int _longestRoute;
    private int _trainStations;
    private List<Integer> _positiveTickets = new ArrayList<Integer>();
    private List<Integer> _negativeTickets = new ArrayList<Integer>();
}
