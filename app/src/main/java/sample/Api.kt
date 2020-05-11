package sample

import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val client = HttpClient {
    install(JsonFeature) {
        serializer = GsonSerializer {
            serializeNulls()
            disableHtmlEscaping()
        }
    }
}

fun getFacts(callback: (Facts)->Unit) {
    GlobalScope.launch {
        val result = client.get<Facts> {
            url("https://cat-fact.herokuapp.com/facts")
        }
        callback(result)
    }
}

class Facts(val all: List<Fact>)
class Fact(val text: String)