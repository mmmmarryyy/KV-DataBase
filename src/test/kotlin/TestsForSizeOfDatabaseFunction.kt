import kotlin.test.*

internal class TestSizeOfDatabase {

    @Test
    fun testForStandardDataBase() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        assertEquals(3, databaseSize(hashMap))
    }

    @Test
    fun testForEmptyDatabase() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        assertEquals(0, databaseSize(hashMap))
    }

    @Test
    fun testForAnotherDataBase() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        assertEquals(22, databaseSize(hashMap))
    }
}