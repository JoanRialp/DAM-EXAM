package cat.udl.tidic.amd.dam_tips.viewmodels;

import android.util.Log;

import cat.udl.tidic.amd.dam_tips.preferences.PreferencesProvider;

public class MainActivityViewModel {


    public MainActivityViewModel() {
    }

    public Boolean isCurrentLogIn(){
        String token = PreferencesProvider.providePreferences().getString("token", "");
        Log.d("MainViewModel",  "Ha rebut el token:  " + token);
        return !token.equals("");
    }



}


