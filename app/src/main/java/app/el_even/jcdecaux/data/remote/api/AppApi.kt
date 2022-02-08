package app.el_even.jcdecaux.data.remote.api

import app.el_even.jcdecaux.common.Constant.API_KEY
import app.el_even.jcdecaux.data.remote.dto.StationDto
import app.el_even.jcdecaux.domain.model.Station
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {

	@GET("stations?apiKey=$API_KEY")
	suspend fun getStations(): List<StationDto>

	@GET("stations/{station_number}")
	suspend fun getStation(
		@Path("station_number") number: Int,
		@Query("contract") contract: String,
		@Query("apiKey") apiKey: String = API_KEY
	): StationDto
}