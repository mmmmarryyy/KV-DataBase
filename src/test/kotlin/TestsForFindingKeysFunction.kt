import kotlin.test.*

internal class TestFindKeys {

    @Test
    fun testForStandardFindKeys() {
        val hashMap = readingFromBase("filesForTests/StandardDataBase.txt")
        assertEquals(setOf("key1"), findKeys("value1", hashMap))
    }

    @Test
    fun testFindKeysForEmptyFile() {
        val hashMap = readingFromBase("filesForTests/EmptyDataBase.txt")
        assertEquals(emptySet(), findKeys("key3", hashMap))
    }

    @Test
    fun testFindKeysForNonExistentValue() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        assertEquals(emptySet(), findKeys("hamburge", hashMap))
    }

    @Test
    fun testFindMoreThanOneKeys() {
        val hashMap = readingFromBase("filesForTests/TestDataBase.txt")
        assertEquals(setOf("genshin", "sims", "xera", "gta", "minecraft"), findKeys("game", hashMap))
    }
}