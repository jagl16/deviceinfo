/*
 * Copyright (C) 2015 Jesus Garcia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jg.robolibs.deviceinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.util.Calendar;
import java.util.TimeZone;

public class DroidDeviceInfo implements IDeviceInfo {
    String carrier;
    String mobileClientId;
    String mobileClientVersion;
    String timezone;

    public DroidDeviceInfo(Context context) {
        TelephonyManager mngr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        carrier = mngr.getNetworkOperatorName();
        try {
            mobileClientId = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            mobileClientId = "1.0";
        }
        try {
            mobileClientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        timezone = tz.getDisplayName();
    }

    @Override
    public String carrier() {
        return carrier;
    }

    @Override
    public String deviceId() {
        return Build.ID;
    }

    @Override
    public String manufacturer() {
        return Build.MANUFACTURER;
    }

    @Override
    public String model() {
        return Build.MODEL;
    }

    @Override
    public String osVersion() {
        return Build.VERSION.RELEASE;
    }

    @Override
    public String osName() {
        return "ANDROID";
    }

    @Override
    public String timezone() {
        return timezone;
    }

    @Override
    public String mobileClientId() {
        return mobileClientId;
    }

    @Override
    public String mobileClientVersion() {
        return mobileClientVersion;
    }
}
