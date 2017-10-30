package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.CustomLogger;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.MessageType;
import org.apache.qpid.proton.engine.SslDomain;
import org.apache.qpid.proton.engine.Transport;

import java.io.IOException;

public class AmqpsDeviceAuthenticationX509 extends AmqpsDeviceAuthentication
{
    private final DeviceClientConfig deviceClientConfig;
    private CustomLogger logger;

    /**
     * This constructor creates an instance of AmqpsDeviceAuthenticationSAS class and initializes member variables
     */
    public AmqpsDeviceAuthenticationX509(DeviceClientConfig deviceClientConfig) throws IllegalArgumentException
    {
        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_001: [The constructor shall throw IllegalArgumentException if the  deviceClientConfig parameter is null.]
        if (deviceClientConfig == null)
        {
            throw new IllegalArgumentException("The deviceClientConfig cannot be null.");
        }

        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_002: [The constructor shall save the deviceClientConfig parameter value to a member variable.]
        this.deviceClientConfig = deviceClientConfig;

        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_003: [The constructor shall set both the sender and the receiver link state to OPENED.]
        this.amqpsSendLinkState = AmqpsDeviceOperationLinkState.OPENED;
        this.amqpsRecvLinkState = AmqpsDeviceOperationLinkState.OPENED;

        this.logger = new CustomLogger(this.getClass());
    }

    /**
     * Do nothing in SAS case.
     */
    @Override
    protected AmqpsSendReturnValue sendMessageAndGetDeliveryHash(MessageType messageType, byte[] msgData, int offset, int length, byte[] deliveryTag) throws IllegalStateException, IllegalArgumentException
    {
        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_004: [The function shall override the default behaviour and return null.]
        return null;
    }

    /**
     * Do nothing in SAS case.
     */
    @Override
    protected AmqpsMessage getMessageFromReceiverLink(String linkName) throws IllegalArgumentException, IOException
    {
        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_005: [The function shall override the default behaviour and return null.]
        return null;
    }

    /**
     * Set authentication mode to PLAIN for SAS.
     *
     * @param transport The transport to set the SSL context to
     */
    @Override
    protected void setSslDomain(Transport transport)
    {
        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_006: [The function shall throw IllegalArgumentException if any of the input parameter is null.]
        if (transport == null)
        {
            throw new IllegalArgumentException("Input parameter transport cannot be null.");
        }

//        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_006: [The function shall throw IllegalArgumentException if any of the input parameter is null.]
//        if (sslContext == null)
//        {
//            throw new IllegalArgumentException("Input parameter sslContext cannot be null.");
//        }


        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_010: [The function shall call the prototype class makeDomain function with the sslContext.]
        SslDomain domain = null;
        try
        {
            domain = makeDomain(this.deviceClientConfig.getX509Authentication().getSSLContext());
        }
        catch (IOException e)
        {
            logger.LogDebug("setSslDomain has thrown exception: %s", e.getMessage());
        }

        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_011: [The function shall set the domain on the transport.]
        transport.ssl(domain);
    }

    /**
     * Fodun the link by name.
     *
     * @param linkName
     * @return true if link found, false otherwise.
     */
    @Override
    protected Boolean isLinkFound(String linkName)
    {
        // Codes_SRS_AMQPSDEVICEAUTHENTICATIONSAS_12_012: [The function shall override the default behaviour and return null.]
        return true;
    }

}
