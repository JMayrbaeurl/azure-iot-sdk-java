package com.microsoft.azure.sdk.iot.device;

import java.io.IOException;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;
import com.microsoft.azure.sdk.iot.device.edge.MethodRequest;
import com.microsoft.azure.sdk.iot.device.edge.MethodResult;
import com.microsoft.azure.sdk.iot.device.exceptions.ModuleClientException;

public interface ModuleMethods extends AbstractDeviceMethods {
	
	void sendEventAsync(Message message, IotHubEventCallback callback, Object callbackContext, String outputName) throws IllegalArgumentException;
	
	ModuleClient setMessageCallback(MessageCallback callback, Object context);
	ModuleClient setMessageCallback(String inputName, MessageCallback callback, Object context);
	
	MethodResult invokeMethod(String deviceId, MethodRequest methodRequest) throws ModuleClientException, IllegalArgumentException;
	MethodResult invokeMethod(String deviceId, String moduleId, MethodRequest methodRequest) throws ModuleClientException, IllegalArgumentException;
	
	void subscribeToMethod(DeviceMethodCallback methodCallback, Object methodCallbackContext,
            IotHubEventCallback methodStatusCallback, Object methodStatusCallbackContext) throws IOException, IllegalArgumentException;

	void getTwin() throws IOException;
	void startTwin(IotHubEventCallback deviceTwinStatusCallback, Object deviceTwinStatusCallbackContext,
            PropertyCallBack genericPropertyCallBack, Object genericPropertyCallBackContext) throws IOException, IllegalArgumentException, UnsupportedOperationException;
	void startTwin(IotHubEventCallback deviceTwinStatusCallback, Object deviceTwinStatusCallbackContext,
            TwinPropertyCallBack genericPropertyCallBack, Object genericPropertyCallBackContext) throws IOException, IllegalArgumentException, UnsupportedOperationException;
}
