import kotlin.test.*

internal class TestReplaceValue {

    @Test
    fun testForStandardReplaceValue() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        replaceValue("key1", "value2",hashMap)
        assertEquals("value2", findValue("key1", hashMap))
    }

    @Test
    fun testReplaceValueForEmptyFile() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        replaceValue("key3", "value", hashMap)
        assertEquals(null, findValue("key3", hashMap))
    }

    @Test
    fun testReplaceValueForNonExistentValue() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        replaceValue("hamburge", "value", hashMap)
        assertEquals(null, findValue("hamburge", hashMap))
    }

    @Test
    fun testStandardReplaceValue() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        replaceValue("shark", "vvv", hashMap)
        assertEquals("vvv", findValue("shark", hashMap))
    }
}