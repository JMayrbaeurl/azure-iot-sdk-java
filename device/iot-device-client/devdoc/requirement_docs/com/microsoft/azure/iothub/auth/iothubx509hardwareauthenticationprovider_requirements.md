# IotHubX509HardwareAuthenticationProvider Requirements

## Overview

This class holds all the authentication information needed for a device to connect to a Iot Hub using x509 authentication from a Security provider instance

## References

## Exposed API

```java
public class IotHubX509HardwareAuthenticationProvider
{
    public IotHubX509HardwareAuthenticationProvider(SecurityProvider securityProvider);
    public SSLContext getSSLContext() throws IOException;   
}
```

### IotHubX509HardwareAuthenticationProvider
```java
public IotHubX509HardwareAuthenticationProvider(SecurityProvider securityProvider);
```

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_001: [**This function shall save the provided security provider.**]**

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_002: [**If the provided security provider is not an instance of SecurityProviderX509, an IllegalArgumentException shall be thrown.**]**


### getSSLContext
```java
public SSLContext getSSLContext();
```

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_003: [**If this object's ssl context has not been generated yet, this function shall generate it from the saved security provider.**]**

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_004: [**If the security provider throws a SecurityClientException while generating an SSLContext, this function shall throw an IOException.**]**

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_005: [**This function shall return the saved IotHubSSLContext.**]**


### setPathToCert
```java
public void setPathToIotHubTrustedCert(String pathToCertificate);
```

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_006: [**This function shall throw an UnsupportedOperationException.**]**


### setUserCertificateString
```java
public void setIotHubTrustedCert(String certificate);
```

**SRS_IOTHUBX509HARDWAREAUTHENTICATION_34_007: [**This function shall throw an UnsupportedOperationException.**]**
