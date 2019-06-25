package pl.coderstrust.regex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IpAddressValidatorTest {

    @Disabled
    @Test
    public void shouldReturnTrueForAllCombinationsOfIpAddresses() {
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        assertTrue(IpAddressValidator.isIpAddress(String.format("%d.%d.%d.%d", i, j, k, l)));
                    }
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"%d.1.1.1", "1.%d.1.1", "1.1.%d.1", "1.1.1.%d"})
    void smartTestForValidIpAddress(String ipAddressTemplate) {
        for (int i = 0; i < 256; i++) {
            assertTrue(IpAddressValidator.isIpAddress(String.format(ipAddressTemplate, i)));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.1.2.3", "100.255.5.0", "0.0.0.0", "192.234.100.1", "169.254.98.200", "192.168.1.4"})
    void shouldReturnTrueForValidIpAddress(String ipAddress) {
        assertTrue(IpAddressValidator.isIpAddress(ipAddress));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "", "0.0.0.000", "o.1.1f. ", "12.1f.1.0", "1.1.00.1"})
    void shouldReturnFalseForInvalidIpAddress(String ipAddress) {
        assertFalse(IpAddressValidator.isIpAddress(ipAddress));
    }

    @Test
    public void shouldThrowExceptionNullAsIpAddress() {
        assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(null));
    }
}
