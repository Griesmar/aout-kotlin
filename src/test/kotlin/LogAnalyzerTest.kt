import org.junit.jupiter.api.Assertions.*

import at.mgriesser.LogAnalyzer.LogAnalyzer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException


class LogAnalyzerTest {

    @Test
    fun isValidLogFileName_BadExtension_ReturnFalse() {
        val analyzer = makeAnalyter()

        val result = analyzer.isValidLogFileName("DateiMitUngueltigenErweiterung.foo")

        assertFalse(result)
    }

    @ParameterizedTest(name = "Method should return true for {0}")
    @ValueSource(strings = ["DateiMitGueltigerErweiterung.slf", "DateiMitGueltigerErweiterung.SLF"])

    fun isValidLogFileName_ValidExtensions_ReturnsTrue( fileName: String) {
        val analyzer = makeAnalyter()

        val result = analyzer.isValidLogFileName(fileName)

        assertTrue(result)
    }

    @Test
    fun isValidFileName_emptyFileName_Trows() {
        val analyzer = makeAnalyter()

        // using of assertTrows
        val ex = assertThrows<IllegalArgumentException> ("Sollte eine Exception werfen") {
            analyzer.isValidLogFileName("")
        }

        assertEquals("Dateiname muss angegeben werden!", ex.message )
    }

    private fun makeAnalyter() : LogAnalyzer {
        return LogAnalyzer()
    }
}