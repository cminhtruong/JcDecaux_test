package app.el_even.jcdecaux.domain.model

data class Station(
	val address: String,
	val available_bike_stands: Int,
	val available_bikes: Int,
	val bike_stands: Int,
	val contract_name: String,
	val last_update: Long,
	val name: String,
	val number: Int,
	val position: Position,
	val status: String
)
