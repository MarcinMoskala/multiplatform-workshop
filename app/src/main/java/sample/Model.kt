package sample

import kotlinx.serialization.Serializable

@Serializable
class Facts(val all: List<Fact>)

@Serializable
class Fact(val text: String)