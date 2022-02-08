package app.el_even.jcdecaux.data.remote.dto

import app.el_even.jcdecaux.domain.model.Position
import app.el_even.jcdecaux.domain.model.Station

data class StationDto(
    val address: String,
    val available_bike_stands: Int,
    val available_bikes: Int,
    val banking: Boolean,
    val bike_stands: Int,
    val bonus: Boolean,
    val contract_name: String,
    val last_update: Long,
    val name: String,
    val number: Int,
    val position: Position,
    val status: String
)

fun StationDto.toStation() = Station(
    address = address,
    available_bike_stands = available_bike_stands,
    available_bikes = available_bikes,
    bike_stands = bike_stands,
    contract_name = contract_name,
    last_update = last_update,
    name = name,
    number = number,
    position = position,
    status = status
)