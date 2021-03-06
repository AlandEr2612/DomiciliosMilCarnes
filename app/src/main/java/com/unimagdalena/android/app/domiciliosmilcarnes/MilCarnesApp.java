package com.unimagdalena.android.app.domiciliosmilcarnes;

import android.app.Application;
import android.content.Context;

import com.shawnlin.preferencesmanager.PreferencesManager;
import com.unimagdalena.android.app.domiciliosmilcarnes.model.entity.Plate;

import java.util.ArrayList;
import java.util.HashMap;


public class MilCarnesApp extends Application {

    public static String PACKAGE_NAME;

    public static String SETTINGS_PREFERENCES;

    private PreferencesManager preferencesManager;

    public static MilCarnesApp milCarnesApp;

    private ArrayList<Plate> plates;

    @Override
    public void onCreate() {
        super.onCreate();

        milCarnesApp = this;

        PACKAGE_NAME = getPackageName().toUpperCase();

        SETTINGS_PREFERENCES = PACKAGE_NAME + ".SETTINGS";

        preferencesManager = new PreferencesManager(this);
        setPreferencesManager(SETTINGS_PREFERENCES);

        plates = new ArrayList<>();
    }

    public String getIP() {
        return PreferencesManager.getString("ip", "172.16.6.194");
    }

    public String getPORT() {
        return PreferencesManager.getString("port", "8077");
    }

    public String GET_USER() {
        return "http://" + getIP() + ":" + getPORT() + "/DomiciliosMilCarnes/services/iniciarSesion.php";
    }

    public String INSERT() {
        return "http://" + getIP() + ":" + getPORT() + "/DomiciliosMilCarnes/services/registrarUsuario.php";
    }

    public String UPDATE_USER() {
        return "http://" + getIP() + ":" + getPORT() + "/DomiciliosMilCarnes/services/actualizarUsuario.php";
    }

    public String GET_EDITED_USER() {
        return "http://" + getIP() + ":" + getPORT() + "/DomiciliosMilCarnes/services/obtenerUsuario.php";
    }

    public String GET_PLATES() {
        return "http://" + getIP() + ":" + getPORT() + "/DomiciliosMilCarnes/services/obtenerPlatos.php";
    }

    public void setPreferencesManager(String name) {
        preferencesManager.setName(name);
        preferencesManager.setMode(Context.MODE_PRIVATE);
        preferencesManager.init();
    }

    public void addPlate(Plate plate) {
        plates.add(plate);
    }

    public ArrayList<Plate> getPlates() {
        return plates;
    }
}