package at.mgriesser.LogAnalyzer

class LogAnalyzer {

    fun isValidLogFileName(fileName: String): Boolean {

        if (fileName.isEmpty())
            throw IllegalArgumentException("Dateiname muss angegeben werden!")

        return fileName.endsWith(
            ".SLF",
            ignoreCase = true,
        )
    }
}