import kotlin.test.*

internal class TestDeleteValue{

    @Test
    fun testForDeleteValue() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        deleteValue("key1", hashMap)
        assertEquals(false, hashMap.contains("key1"))
    }

    @Test
    fun testForDeleteNonExistenceValue() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        assertEquals(null, deleteValue("key", hashMap))
    }

    @Test
    fun testForDeleteValueFromEmptyDataBase() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        assertEquals(null, deleteValue("hamburger", hashMap))
    }

    @Test
    fun testStandardDeleteValue() {
        val hashMap = readingFromBase("FilesForTests/TestDataBase.txt")
        assertEquals("done", deleteValue("shark", hashMap))
    }
}