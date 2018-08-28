package com.microsoft.azure.sdk.iot.device;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.Pair;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.Property;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.PropertyCallBack;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.TwinPropertyCallBack;

public interface AbstractDeviceMethods extends Closeable {

	void open() throws IOException;
	void close() throws IOException;
	void closeNow() throws IOException;
	
	void sendEventAsync(Message message, IotHubEventCallback callback, Object callbackContext);
	
	void subscribeToDesiredProperties(Map<Property, Pair<PropertyCallBack<String, Object>, Object>> onDesiredPropertyChange) throws IOException;
	void subscribeToTwinDesiredProperties(Map<Property, Pair<TwinPropertyCallBack, Object>> onDesiredPropertyChange) throws IOException;
	void sendReportedProperties(Set<Property> reportedProperties) throws IOException, IllegalArgumentException;
	void sendReportedProperties(Set<Property> reportedProperties, int version) throws IOException, IllegalArgumentException;
}
