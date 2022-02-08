package app.el_even.jcdecaux.presentation.station_list

import app.el_even.jcdecaux.domain.model.Station

data class StationListState(
	val isLoading: Boolean = false,
	val stations: List<Station> = emptyList(),
	val error: String = ""
)
