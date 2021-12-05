package at.mgriesser.LogAnalyzer

class LogAnalyzer {

    public fun isValidLogFileName(fileName: String): Boolean {
        return fileName.endsWith(
            ".SLF",
            ignoreCase = true,
        )
    }
}