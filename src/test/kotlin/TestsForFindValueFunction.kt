import kotlin.test.*

internal class TestFindValue{

    @Test
    fun testForStandardFindValue() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        assertEquals("value1", findValue("key1", hashMap))
    }

    @Test
    fun testFindValueForEmptyFile() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        assertEquals(null, findValue("key3", hashMap))
    }

    @Test
    fun testFindValueForNonExistentValue() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        assertEquals(null, findValue("hamburge", hashMap))
    }

    @Test
    fun testStandardFindValue() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        assertEquals("animal", findValue("shark", hashMap))
    }
}