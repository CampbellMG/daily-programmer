import com.google.gson.Gson
import java.io.File
import java.io.InputStream
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.system.exitProcess

if (args.isEmpty() || args[0].isEmpty()) {
    println("Missing output path")
    exitProcess(1)
}

val API_URI = "https://www.matthewproctor.com/Content/postcodes/australian_postcodes.json"
val outputPath = args[0]

val gson = Gson()
val suburbList = getSuburbs()

println("Found ${suburbList.size} suburbs")

val requiredSuburbData = suburbList
        .groupBy({ it.postcode }, { it.locality })

File(outputPath).writeText(gson.toJson(requiredSuburbData))


fun getSuburbs(): Set<Suburb> {
    Scanner(openInputStream(), StandardCharsets.UTF_8.toString())
            .use {
                it.useDelimiter("\\A")
                val jsonString = if (it.hasNext()) it.next() else ""
                return gson.fromJson(jsonString, Array<Suburb>::class.java).toSet()
            }
}

fun openInputStream(): InputStream {
    val connection = URL(API_URI).openConnection()
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")
    connection.connect()
    return connection.getInputStream()
}

data class Suburb(
        val postcode: String,
        val locality: String,
        val State: String,
        val long: String,
        val lat: String,
        val id: String,
        val dc: String,
        val type: String,
        val status: String
)