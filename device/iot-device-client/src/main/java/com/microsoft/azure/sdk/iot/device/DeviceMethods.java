package com.microsoft.azure.sdk.iot.device;

import java.io.IOException;
import java.io.InputStream;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;

public interface DeviceMethods extends AbstractDeviceMethods {

	DeviceClient setMessageCallback(MessageCallback callback, Object context) throws IllegalArgumentException;
	void subscribeToDeviceMethod(DeviceMethodCallback deviceMethodCallback, Object deviceMethodCallbackContext,
            IotHubEventCallback deviceMethodStatusCallback, Object deviceMethodStatusCallbackContext) throws IOException, IllegalArgumentException;
	
	void getDeviceTwin() throws IOException;
	void startDeviceTwin(IotHubEventCallback deviceTwinStatusCallback, Object deviceTwinStatusCallbackContext,
            PropertyCallBack genericPropertyCallBack, Object genericPropertyCallBackContext) throws IOException, IllegalArgumentException, UnsupportedOperationException;
	void startDeviceTwin(IotHubEventCallback deviceTwinStatusCallback, Object deviceTwinStatusCallbackContext,
            TwinPropertyCallBack genericPropertyCallBack, Object genericPropertyCallBackContext) throws IOException, IllegalArgumentException, UnsupportedOperationException;
	
	void uploadToBlobAsync(String destinationBlobName, InputStream inputStream, long streamLength,
            IotHubEventCallback callback, Object callbackContext) throws IllegalArgumentException, IOException, UnsupportedOperationException;
	//void closeFileUpload() throws IOException;
}
