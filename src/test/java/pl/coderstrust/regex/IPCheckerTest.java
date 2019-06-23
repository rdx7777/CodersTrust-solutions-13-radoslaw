package pl.coderstrust.regex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IPCheckerTest {

    @Disabled
    @Test
    public void shouldCheckEveryIPCombination() {
        StringBuilder validIPAddress = new StringBuilder();
        StringBuilder firstBuilder = new StringBuilder();
        StringBuilder secondBuilder = new StringBuilder();
        StringBuilder thirdBuilder = new StringBuilder();
        StringBuilder fourthBuilder = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            firstBuilder.setLength(0);
            firstBuilder.append(i).append(".");
            for (int j = 0; j < 256; j++) {
                secondBuilder.setLength(0);
                secondBuilder.append(j).append(".");
                for (int k = 0; k < 256; k++) {
                    thirdBuilder.setLength(0);
                    thirdBuilder.append(k).append(".");
                    for (int l = 0; l < 256; l++) {
                        fourthBuilder.setLength(0);
                        fourthBuilder.append(l);
                        validIPAddress.setLength(0);
                        validIPAddress.append(firstBuilder).append(secondBuilder).append(thirdBuilder).append(fourthBuilder);
                        assertTrue(IPChecker.isIPAddress(validIPAddress.toString()));
                    }
                }
            }
        }
    }

    @Test
    public void shouldCheckIPAddressForEachPosition() {
        StringBuilder validIPAddress1 = new StringBuilder();
        StringBuilder validIPAddress2 = new StringBuilder();
        StringBuilder validIPAddress3 = new StringBuilder();
        StringBuilder validIPAddress4 = new StringBuilder();
        StringBuilder positionBuilder = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            positionBuilder.append(i);
            validIPAddress1.append(positionBuilder).append(".1.1.1");
            validIPAddress2.append("1.").append(positionBuilder).append(".1.1");
            validIPAddress3.append("1.1.").append(positionBuilder).append(".1");
            validIPAddress4.append("1.1.1.").append(positionBuilder);
            assertTrue(IPChecker.isIPAddress(validIPAddress1.toString()));
            assertTrue(IPChecker.isIPAddress(validIPAddress2.toString()));
            assertTrue(IPChecker.isIPAddress(validIPAddress3.toString()));
            assertTrue(IPChecker.isIPAddress(validIPAddress4.toString()));
            positionBuilder.setLength(0);
            validIPAddress1.setLength(0);
            validIPAddress2.setLength(0);
            validIPAddress3.setLength(0);
            validIPAddress4.setLength(0);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "", "0.0.0.000", "o.1.1f. ", "12.1f.1.0", "1.1.00.1"})
    void shouldReturnFalseWhileCheckingInvalidString(String input) {
        assertFalse(IPChecker.isIPAddress(input));
    }
}
