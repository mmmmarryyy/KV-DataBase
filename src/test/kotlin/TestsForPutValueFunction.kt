import kotlin.test.*

internal class TestPutValue{

    @Test
    fun testForPutValue() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        hashMap.put("key1", "value1")
        assertEquals("value1", findValue("key1", hashMap))
    }

    @Test
    fun testForPutValueInEmptyDataBase() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        hashMap.put("key3", "value3")
        assertEquals("value3", findValue("key3", hashMap))
    }
}