package view.manualpick

object ManualPickCountParser {
    fun parse(input: String): Int {
        val parsedInt = input.toIntOrNull() ?: return 0

        return parsedInt.coerceAtLeast(0)
    }
}
