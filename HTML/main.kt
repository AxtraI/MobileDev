import java.io.File

data class Message(var address: String?, var topic: String?, var body: String?, var closing: String?, var sender: String?) {
    init {
        address = address?.let {Br(it)}
        topic = topic?.let {Br(it)}
        body = body?.let {Br(it)}
        closing = closing?.let {Br(it)}
        sender = sender?.let {Br(it)}
    }
    companion object {
        private fun Br(letter: String): String {
            return letter.replace("\n", "<br>")
        }
    }
    fun toHTML(): String {
        return  "<style>" +
                "@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap');" +
                "body{font-family: 'Montserrat', sans-serif;}" +
                "td{padding: 10px;}" +
                "</style>" +
                "<table bordercolor=\"blue\" border=\"1px\" cellspacing\n=\"1px\">" +
                (sender?.let { "<tr><td bgcolor= \"#f1faee\">Отправитель: </td><td bgcolor= \"#a8dadc\">$it</td></tr> \n" }?: "") +
                (address?.let { "<tr><td bgcolor= \"#f1faee\">Адрес отправителя: </td><td bgcolor= \"#a8dadc\">$it</td></tr> \n" }?: "") +
                (topic?.let { "<tr><td bgcolor= \"#f1faee\">Тема: </td><td bgcolor= \"#a8dadc\">$it</td></tr> \n" }?: "") +
                (body?.let { "<tr><td bgcolor= \"#f1faee\">Сообщение: </td><td bgcolor= \"#a8dadc\"> $it" + (closing?.let {"<br><br>$it"}?:" ")   + "</td></tr> \n" }?: "") +
                "</table>"
    }
}

fun main() {
    val messages = arrayOf(
        Message("bki.forlabs.ru", "Учебный долг",
            "Сдайте долги по Веб-Дизайну",
            "Алексей, Создатель одноименного сайта forlabs \n\"Forlabs\"\n123456, г. Иркутск, Лермонтово 124, аудитория 409",
            "Шабалин Алексей Сергеевич"
        )
    )
    for (i in messages.indices){
        File("letter$i.html").writeText(messages[i].toHTML())
    }
}
