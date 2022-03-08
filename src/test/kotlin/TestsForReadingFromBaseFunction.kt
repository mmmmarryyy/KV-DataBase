import kotlin.test.*

internal class TestReadingFromBase {

    @Test
    fun testStandardReadingFromBase() {
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("key1","value1")
        hashMap.put("key2","value2")
        hashMap.put("key3","value3")
        assertEquals(hashMap, readingFromBase("filesForTests/StandardDataBase.txt"))
    }

    @Test
    fun testReadingFromEmptyBase() {
        val hashMap: HashMap<String, String> = HashMap()
        assertEquals(hashMap, readingFromBase("filesForTests/EmptyDataBase.txt"))
    }
}
