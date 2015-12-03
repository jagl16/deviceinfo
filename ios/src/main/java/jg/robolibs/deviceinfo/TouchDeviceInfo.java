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

import org.robovm.apple.coretelephony.CTTelephonyNetworkInfo;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.uikit.UIDevice;

import java.util.Calendar;
import java.util.TimeZone;

public class TouchDeviceInfo implements IDeviceInfo {
    String mobileClientId;
    String mobileClientVersion;
    String carrier;
    String timezone;

    public TouchDeviceInfo() {
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        timezone = tz.getDisplayName();

        CTTelephonyNetworkInfo info = new CTTelephonyNetworkInfo();
        carrier = info.getSubscriberCellularProvider() != null ? info.getSubscriberCellularProvider().getCarrierName() : "Unknown";

        NSBundle mainBundle = NSBundle.getMainBundle();
        NSDictionary infoDict = mainBundle.getInfoDictionary();

        mobileClientId = infoDict.getString("CFBundleIdentifier");
        mobileClientVersion = infoDict.getString("CFBundleShortVersionString");
    }

    @Override
    public String carrier() {
        return carrier;
    }

    @Override
    public String deviceId() {
        return UIDevice.getCurrentDevice().getIdentifierForVendor().asString();
    }

    @Override
    public String manufacturer() {
        return "Apple";
    }

    @Override
    public String model() {
        return UIDevice.getCurrentDevice().getModel();
    }

    @Override
    public String osVersion() {
        return UIDevice.getCurrentDevice().getSystemVersion();
    }

    @Override
    public String osName() {
        return "IOS";
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
