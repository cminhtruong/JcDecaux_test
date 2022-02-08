package app.el_even.jcdecaux.data.repository

import app.el_even.jcdecaux.data.remote.api.AppApi
import app.el_even.jcdecaux.data.remote.dto.StationDto
import app.el_even.jcdecaux.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
	private val appApi: AppApi
) : AppRepository {
	override suspend fun getStations(): List<StationDto> = appApi.getStations()

	override suspend fun getStation(number: Int, contract: String): StationDto =
		appApi.getStation(number, contract)
}