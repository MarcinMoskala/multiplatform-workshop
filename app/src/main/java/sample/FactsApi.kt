package sample

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpStatement
import io.ktor.client.statement.readText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class FactsApi {
    private val client = HttpClient {}

    fun getFacts(onSuccess: (Facts) -> Unit) {
        CoroutineScope(Dispatchers.Unconfined).launch {
            val data = getFacts()
            onSuccess.invoke(data)
        }
    }

    suspend fun getFacts(): Facts {
        val result = client.get<HttpStatement> {
            url("https://cat-fact.herokuapp.com/facts")
        }.execute()
        return Json.nonstrict.parse(Facts.serializer(), result.readText())
    }
}