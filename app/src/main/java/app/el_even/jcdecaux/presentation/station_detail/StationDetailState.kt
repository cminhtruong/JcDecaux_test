package app.el_even.jcdecaux.presentation.station_detail

import app.el_even.jcdecaux.domain.model.Station

data class StationDetailState(
	val isLoading: Boolean = false,
	val station: Station? = null,
	val error: String = ""
)
