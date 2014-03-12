package com.jwitz.trainscorer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        preferences.registerOnSharedPreferenceChangeListener(this);
        
        Preference pref = findPreference("pref_key_game_type");
        ListPreference listPref = (ListPreference) pref;
        pref.setSummary(listPref.getEntry());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("pref_key_game_type")) {
            Preference pref = findPreference(key);
            ListPreference listPref = (ListPreference) pref;
            pref.setSummary(listPref.getEntry());
        }
    }
}
