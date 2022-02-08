package app.el_even.jcdecaux.domain.repository

import app.el_even.jcdecaux.data.remote.dto.StationDto

interface AppRepository {

	suspend fun getStations(): List<StationDto>

	suspend fun getStation(number: Int, contract: String): StationDto
}