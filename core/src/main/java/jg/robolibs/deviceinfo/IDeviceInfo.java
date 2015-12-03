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

public interface IDeviceInfo {
    /**
     * Returns the carrier of the phone
     *
     * @return Returns the carrier of the phone
     */
    String carrier();

    /**
     * Returns the device ID. (This is not the IMEI, is the build ID)
     *
     * @return Returns the device ID.
     */
    String deviceId();

    /**
     * Returns the manufacturer's name
     *
     * @return Returns the manufacturer's name
     */
    String manufacturer();

    /**
     * Returns the model of the phone
     *
     * @return Returns the model of the phone
     */
    String model();

    /**
     * Returns the OS version
     *
     * @return Returns the OS version
     */
    String osVersion();

    /**
     * Returns the OS name
     *
     * @return Returns the OS name
     */
    String osName();

    /**
     * Returns the current timezone
     *
     * @return Returns the current timezone
     */
    String timezone();

    /**
     * Returns the package name of the app.
     *
     * @return Returns the package name of the app.
     */
    String mobileClientId();

    /**
     * Returns the version code of the application package.
     *
     * @return Returns the version code of the application package.
     */
    String mobileClientVersion();
}
