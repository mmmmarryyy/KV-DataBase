import java.io.*

fun main() {
    val nameOfBase = "DataBase.txt"
    val hashMap: HashMap<String, String> = readingFromBase(nameOfBase)
    beforeOptions(hashMap)
    callingOptions(hashMap)
    fillingTheBase(nameOfBase, hashMap)
}

/** функция считывает из базы данных пары ключ-значение и преобразует их в hashmap */
fun readingFromBase(basename: String): HashMap<String, String> {
    val hashMap: HashMap<String, String> = HashMap()
    val database = File(basename).readLines()
    for (i in database) {
        val splittedString = i.split(";")
        hashMap.put(splittedString[0], splittedString[1])
    }
    return hashMap
}

/**
функция спрашивает у пользователя, хочет ли он просмотреть содержимое уже имеющейся базы данных
или удалить его, и позже делает это, если пользователь ответил да
 */
fun beforeOptions(hashmap: HashMap<String, String>) {
    println(
        "хотите ли вы просмотреть содержимое уже имеющейся базы данных?\n" +
                "(нажмите y или n соответственно выбранному варианту):"
    )
    var firstChoice = readLine()
    while (firstChoice != "y" && firstChoice != "n") {
        println(
            "выбранный вариант не был указан или был указан неправильно, попробуйте еще раз"
        )
        firstChoice = readLine()
    }
    when (firstChoice) {
        "y" -> hashmap.forEach { (key, value) -> println("$key,$value") }
        "n" -> println()
    }
    println(
        "хотите ли вы отчистить содержимое уже имеющейся базы данных?\n" +
                "(нажмите y или n соответственно выбранному варианту):"
    )
    var secondChoice = readLine()
    while (secondChoice != "y" && secondChoice != "n") {
        println(
            "выбранный вариант не был указан или был указан неправильноб попробуйте еще раз"
        )
        secondChoice = readLine()
    }
    when (secondChoice) {
        "y" -> hashmap.clear()
        "n" -> println()
    }
}

/**
 * Функция в зависимости от того какие функции пользователь выбрал ранее,
 * запрашивает необходимые значения для опций и перенаправляет в функции, выполняющие эти опции
 */
fun callingOptions(hashMap: HashMap<String, String>) {
    println(
        "есть 6 опции:\n" +
                "1. поиск значения по ключу\n" +
                "2. добавить новую пару ключ-значение\n" +
                "3. удалить пару ключ-значение по ключу\n" +
                "4. заменить значение для уже существующей пары ключ-значение\n" +
                "5. поиск ключей по значению\n" +
                "6. узнать размер базы данных\n"  +
                "выберите, какую опцию вы хотите использовать и введите соответствующий номер\n" +
                "(если вы закончили работу с базой данных, введите 'n' (без кавычек)"
    )
    var choice = readLine()
    while (choice != "n") {
        when (choice) {
            "1" -> findingValue(hashMap)
            "2" -> addNewKeyValuePair(hashMap)
            "3" -> deleteKeyValuePair(hashMap)
            "4" -> replacingValue(hashMap)
            "5" -> findingKeys(hashMap)
            "6" -> sizeOfDatabase(hashMap)
            else -> println(
                "выбранный вариант не был указан или был указан неправильно"
            )
        }
        println(
            "выберите, какую опцию вы хотите использовать и введите соответствующий номер\n" +
                    "(1.поиск значения по ключу; 2.добавить новую пару ключ-значение; 3.удалить пару ключ-значение\n" +
                    "4.заменить значение для уже существующей пары ключ-значение; 5.поиск ключей по значению\n" +
                    "6.узнать размер базы данных\n" +
                    "если вы закончили работу с базой данных, введите 'n' (без кавычек))"
        )
        choice = readLine()
    }
}

/**
 * Опция поиска значения
 * принимает входные данные у пользователя, вызывает функцию, производящую поиск, и выводит результат
 */
fun findingValue(hashMap: HashMap<String, String>) {
    println(
        "вы выбрали поиск значения по ключу, как желаемую опцию\n" +
                "если вы закончили пользоваться опцией,\n" +
                "введите ';' (без кавычек) в качестве имени запрашиваемого ключа"
    )
    println(
        "введите текстовый ключ для поиска значения:\n" +
                "введенный текст не должно содержать символ ';'"
    )
    var key = readLine()
    while (key != ";") {
        while (key?.contains(";") == true) {
            println(
                "Error: Введенное значение содержит ';'\n" +
                        "введите текстовый ключ для поиска значения заново:\n" +
                        "введенный текст не должно содержать символ ';'"
            )
            key = readLine()
        }
        val value = findValue(key.toString(), hashMap) //функция findValue не работает с типом String?
        when (value) {
            null -> println("Значение для ключа $key не найдено")
            else -> println("Значение для ключа $key: $value\n")
        }
        println(
            "введите текстовый ключ для поиска значения:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        key = readLine()
    }
}

/**
 * Опция добавления новой пары ключ-значение
 * принимает входные данные у пользователя, вызывает функцию, добавляющую новую пару, и выводит результат
 */
fun addNewKeyValuePair(hashMap: HashMap<String, String>) {
    println(
        "вы выбрали добавить новое значение, как желаемую опцию\n" +
                "если вы закончили пользоваться опцией,\n" +
                "введите ';' (без кавычек) в качестве имени запрашиваемого ключа\n"
    )
    println(
        "введите текстовый ключ для значения:\n" +
                "введенный текст не должно содержать символ ';'\n"
    )
    var key = readLine()
    while (key != ";") {
        while (key?.contains(";") == true) {
            println(
                "Error: Введенное значение содержит ';'\n" +
                        "введите текстовый ключ заново:\n" +
                        "введенный текст не должно содержать символ ';'"
            )
            key = readLine()
        }
        println(
            "введите само значение:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        val value = readLine()
        putValue(key.toString(), value.toString(), hashMap) //функция putValue не работает с типом String?
        println(
            "Новая пара ключ-значение добавлена"
        )
        println(
            "введите текстовый ключ для значения:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        key = readLine()
    }
}

/**
 * Опция удаления пары ключ-значение
 * принимает входные данные у пользователя, вызывает функцию, удаляющую пару, и выводит результат
 */
fun deleteKeyValuePair(hashMap: HashMap<String, String>) {
    println(
        "вы выбрали удалить пару ключ-значение, как желаемую опцию\n" +
                "если вы закончили пользоваться опцией,\n" +
                "введите ';' (без кавычек) в качестве имени запрашиваемого ключа"
    )
    println(
        "введите текстовый ключ для поиска значения, которое хотите удалить:\n" +
                "введенный текст не должно содержать символ ';'"
    )
    var key = readLine()
    while (key != ";") {
        while (key?.contains(";") == true) {
            println(
                "Error: Введенное значение содержит ';'\n" +
                        "введите текстовый ключ заново:\n" +
                        "введенный текст не должно содержать символ ';'"
            )
            key = readLine()
        }
        val result = deleteValue(key.toString(), hashMap) //функция deleteValue не работает с типом String?
        when (result) {
            "done" -> println("Пара ключ-значение для ключа $key удалена")
            null -> println("Значение для ключа $key не найдено")
        }
        println(
            "введите текстовый ключ для поиска значения, которое хотите удалить:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        key = readLine()
    }
}

/**
 * Опция узнать размер базы данных
 * вызывает функцию, узнающую размер, и выводит результат
 */
fun sizeOfDatabase(hashMap: HashMap<String, String>){
    val size = databaseSize(hashMap)
    println("вы выбрали узнать размер базы данных, как желаемую опцию\n" +
            "размер вашей базы данных: $size")
}

/**
 * Опция замены значения
 * принимает входные данные у пользователя, вызывает функцию, производящую замену, и выводит результат
 */
fun replacingValue(hashMap: HashMap<String, String>) {
    println(
        "вы выбрали замену значения, как желаемую опцию\n" +
                "если вы закончили пользоваться опцией,\n" +
                "введите ';' (без кавычек) в качестве имени запрашиваемого ключа"
    )
    println(
        "введите текстовый ключ для поиска значения:\n" +
                "введенный текст не должно содержать символ ';'"
    )
    var key = readLine()
    while (key != ";") {
        while (key?.contains(";") == true) {
            println(
                "Error: Введенное значение содержит ';'\n" +
                        "введите текстовый ключ для поиска значения заново:\n" +
                        "введенный текст не должно содержать символ ';'"
            )
            key = readLine()
        }
        println(
            "введите само значение:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        val value = readLine()
        val result = replaceValue(key.toString(), value.toString(), hashMap)
        //функция replaceValue не работает с типом String?
        when (result) {
            null -> println("Значение для ключа $key не найдено")
            else -> println("Значение для ключа $key заменено на $value")
        }
        println(
            "введите текстовый ключ для поиска значения:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        key = readLine()
    }
}

/**
 * Опция поиска ключей
 * принимает входные данные у пользователя, вызывает функцию, производящую поиск, и выводит результат
 */
fun findingKeys(hashMap: HashMap<String, String>) {
    println(
        "вы выбрали поиск ключей по значению, как желаемую опцию\n" +
                "если вы закончили пользоваться опцией,\n" +
                "введите ';' (без кавычек) в качестве имени запрашиваемого значения"
    )
    println(
        "введите текстовое значение для поиска ключей:\n" +
                "введенный текст не должно содержать символ ';'"
    )
    var value = readLine()
    while (value != ";") {
        while (value?.contains(";") == true) {
            println(
                "Error: Введенное значение содержит ';'\n" +
                        "введите текстовый ключ для поиска значения заново:\n" +
                        "введенный текст не должно содержать символ ';'"
            )
            value = readLine()
        }
        val keys = findKeys(value.toString(), hashMap) //функция findKeys не работает с типом String?
        when (keys) {
            emptySet<String>() -> println("Ключи для значения $value не найдены")
            else -> println("Ключи для значения $value: $keys")
        }
        println(
            "введите текстовый ключ для поиска значения:\n" +
                    "введенный текст не должно содержать символ ';'"
        )
        value = readLine()
    }
}

/** Узнать размер базы данных */
fun databaseSize(hashMap: HashMap<String, String>): Int{
    return hashMap.size
}

/** Заменить значение у ключа */
fun replaceValue(key: String, value: String, hashMap: HashMap<String, String>): String? {
    return if (findValue(key, hashMap) == null) {
        null
    } else {
        hashMap.replace(key,value)
        "done"
    }
}

/** Удалить пару ключ-значение */
fun deleteValue(key: String, hashMap: HashMap<String, String>): String? {
    return if (findValue(key, hashMap) == null) {
        null
    } else {
        hashMap.remove(key)
        "done"
    }
}

/** Поиск значения по ключу */
fun findValue(key: String, hashMap: HashMap<String, String>): String? {
    return hashMap[key]
}

/** Добавить новую пару ключ-значение */
fun putValue(key: String, value: String, hashMap: HashMap<String, String>): String? {
    return hashMap.put(key, value)
}

/** Поиск ключей по значению */
fun findKeys(value: String, hashMap: HashMap<String, String>): Set<String>{
    return hashMap.filterValues { it==value }.keys
}

/** Функция заменяет предыдущий файл на новый и записывает в него измененный hashMap */
fun fillingTheBase(basename: String, hashMap: HashMap<String, String>) {
    File(basename).delete()
    File(basename).createNewFile()
    val file = File(basename)
    var numberOfString = 1
    for (i in hashMap) {
        file.appendText("${i.key};${i.value}")
        if (numberOfString != hashMap.size) {
            file.appendText("\n")
        }
        numberOfString += 1
    }
}