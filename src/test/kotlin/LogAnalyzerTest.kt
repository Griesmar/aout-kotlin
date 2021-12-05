import org.junit.jupiter.api.Assertions.*

import at.mgriesser.LogAnalyzer.LogAnalyzer
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LogAnalyzerTest {

    @Test
    fun isValidLogFileName_BadExtension_ReturnFalse() {
        val analyzer = LogAnalyzer()

        val result = analyzer.isValidLogFileName("DateiMitUngueltigenErweiterung.foo")

        assertFalse(result)
    }

    @ParameterizedTest(name = "Method should return true for {0}")
    @ValueSource(strings = ["DateiMitGueltigerErweiterung.slf", "DateiMitGueltigerErweiterung.SLF"])

    fun isValidLogFileName_ValidExtensions_ReturnsTrue( fileName: String) {
        val analyzer = LogAnalyzer()

        val result = analyzer.isValidLogFileName(fileName)

        assertTrue(result)
    }
}