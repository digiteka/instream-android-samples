package com.digiteka.digiteka_sdk_mobile;

import android.app.Application;
import android.util.Log;
import com.quantcast.choicemobile.ChoiceCmp;
import com.quantcast.choicemobile.ChoiceCmpCallback;
import com.quantcast.choicemobile.core.model.ACData;
import com.quantcast.choicemobile.core.model.TCData;
import com.quantcast.choicemobile.model.ChoiceError;
import com.quantcast.choicemobile.model.NonIABData;
import com.quantcast.choicemobile.model.PingReturn;

/*import kotlin.jvm.internal.Intrinsics;*/

public class DemoCmp extends Application implements ChoiceCmpCallback {

    public String consentString;

    public DemoCmp() {

    }

    public void setConsentString(String consentString) {
        this.consentString = consentString;
    }

    public void onCreate() {
        super.onCreate();
        ChoiceCmp.INSTANCE.startChoice(this, "com.digiteka.digiteka_sdk_mobile", "p-D9_vrdHX3Dtfh", this);
    }

    @Override
    public void onCmpError(ChoiceError error) {

    }

    @Override
    public void onCmpLoaded(PingReturn info) {

    }

    @Override
    public void onCmpUIShown(PingReturn info) {

    }

    @Override
    public void onGoogleVendorConsentGiven(ACData acData) {

    }

    @Override
    public void onIABVendorConsentGiven(TCData tcData) {
        Log.e("TAG ", "onIABVendorConsentGiven");
        Log.e("TAG ", "TCData =" + tcData.getTcString());
        setConsentString(tcData.getTcString());

        /*if (Intrinsics.areEqual(tcData.getGdprApplies(), false) || Intrinsics.areEqual((Boolean)tcData.getVendor().getConsents().get("200"), true)) {
            Log.e("TAG ", "tcData.gdprApplies == false");
        }*/
        /*else {
            Log.e("TAG ", "tcData.gdprApplies == true");
        }*/

    }


    @Override
    public void onNonIABVendorConsentGiven(NonIABData nonIABData) {
        Log.e("TAG ", "onNonIABVendorConsentGiven");
        if (!nonIABData.getGdprApplies()) {

        }

    }


}

